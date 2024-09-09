package com.example.springmongodb.api;

import com.example.springmongodb.model.request.SearchRequest;
import com.example.springmongodb.model.response.ResponseObject;
import com.example.springmongodb.model.response.ResponseStatus;
import com.example.springmongodb.service.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

public abstract class BaseController<T>{

    protected abstract BaseService<T> getBaseService();

    @PostMapping(path = "/create")
    public ResponseEntity<?> create(@RequestBody T request){
        ResponseObject<T> response = new ResponseObject<>(true, ResponseStatus.DO_SERVICE_SUCCESSFUL);
        response.setData(getBaseService().create(request));
        return ResponseEntity.ok(response);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> update(@RequestParam("id") String id, @RequestBody T request){
        ResponseObject<T> response = new ResponseObject<>(true, ResponseStatus.DO_SERVICE_SUCCESSFUL);
        response.setData(getBaseService().update(id, request));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<?> delete(@RequestParam("id") String id){
        ResponseObject<T> response = new ResponseObject<>(true, ResponseStatus.DO_SERVICE_SUCCESSFUL, "Success");
        getBaseService().delete(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/findById")
    public ResponseEntity<?> findById(@RequestParam("id") String id){
        ResponseObject<T> response = new ResponseObject<>(true, ResponseStatus.DO_SERVICE_SUCCESSFUL);
        response.setData(getBaseService().getById(id));
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/search")
    public ResponseEntity<?> search(SearchRequest request) throws UnsupportedEncodingException {
        ResponseObject<Object> response = new ResponseObject<>(true, ResponseStatus.DO_SERVICE_SUCCESSFUL);
        response.setData(getBaseService().search(request));
        return ResponseEntity.ok(response);
    }
}
