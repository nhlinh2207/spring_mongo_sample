package com.example.springmongodb.service.impl;

import com.example.springmongodb.utils.ConvertTypeUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import com.example.springmongodb.exception.UnSuccessException;
import com.example.springmongodb.model.request.SearchRequest;
import com.example.springmongodb.repo.BaseRepo;
import com.example.springmongodb.service.BaseService;
import com.example.springmongodb.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

    protected abstract BaseRepo<T> getBaseRepo();

    private final SimpleDateFormat smf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    @Autowired
    protected MongoTemplate mongoTemplate;

    @Override
    public void createAll(List<T> ts) {
        getBaseRepo().saveAll(ts);
    }

    @Override
    public T getById(String id) throws UnSuccessException {
        return getBaseRepo().findById(id).orElseThrow(
                () -> new UnSuccessException("Can not find entity by Id: "+id)
        );
    }

    @Override
    public T create(T t) {
        return getBaseRepo().save(t);
    }

    @Override
    public T update(String id, T t) {
        T entity = getBaseRepo().findById(id).orElseThrow(
                () -> new UnSuccessException("Can not find entity by Id: "+id)
        );
        ObjectMapperUtils.map(t, entity);
        return getBaseRepo().save(entity);

    }

    @Override
    public void delete(String id) {
        getBaseRepo().deleteById(id);
    }

    @Override
    public Page<T> search(Class<T> clazz, SearchRequest req) throws UnsupportedEncodingException {
        Query query = new Query();
        List<Criteria> criteriaList = new ArrayList<>();
        String regex = "(==|<=|>=|<|>)";
        Pattern pattern = Pattern.compile(regex);
        String[] filters = req.getFilter().split(";");
        for (String filter : filters){
            Criteria singleCriteria = new Criteria();
            Matcher matcher = pattern.matcher(filter);
            matcher.find();
            String delimiter = matcher.group(1);
            String[] keyValue = filter.split(Pattern.quote(delimiter));
            String key = keyValue[0];
            String value = keyValue[1];
            Object parseValue = ConvertTypeUtil.convert(value);
            switch (delimiter){
                case "==" : {
                    if (value.startsWith("*") && value.endsWith("*")){
                        String subValue = value.substring(1, value.length() - 1);
                        singleCriteria = Criteria.where(key).regex(".*"+ URLDecoder.decode(subValue, "UTF-8")+".*", "i");
                    }
                    else{
                        singleCriteria = Criteria.where(key).is(parseValue);
                    }
                    break;
                }
                case "<":{
                    singleCriteria = Criteria.where(key).lt(parseValue);
                    break;
                }
                case  ">" :{
                    singleCriteria = Criteria.where(key).gt(parseValue);
                    break;
                }
                case "<=":{
                    singleCriteria = Criteria.where(key).lte(parseValue);
                    break;
                }
                case  ">=" :{
                    singleCriteria = Criteria.where(key).gte(parseValue);
                    break;
                }
            }
            criteriaList.add(singleCriteria);
        }
        query.addCriteria(new Criteria().andOperator(criteriaList.toArray(new Criteria[0])));
        String[] sortParams = req.getSort().split(",");
        Sort.Direction direction = sortParams[1].equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(req.getPage(), req.getSize(), Sort.by(direction, sortParams[0]));
        long count = mongoTemplate.count(query, clazz);
        query.with(pageable);
        List<T> list = mongoTemplate.find(query, clazz);
        return new org.springframework.data.domain.PageImpl<T>(list, pageable, count);
    }

    @Override
    public List<T> getByIds(List<String> ids) {
        return StreamSupport.stream(getBaseRepo().findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }

    private boolean checkDate(String pattern){
        try{
            smf.parse(pattern);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
