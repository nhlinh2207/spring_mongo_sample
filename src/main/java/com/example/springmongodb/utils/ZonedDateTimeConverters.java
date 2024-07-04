//package com.example.springmongodb.utils;
//
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.data.convert.ReadingConverter;
//import org.springframework.data.convert.WritingConverter;
//import org.springframework.stereotype.Component;
//
//import java.time.ZoneId;
//import java.time.ZonedDateTime;
//import java.util.Date;
//
//@Component
//public class ZonedDateTimeConverters {
//
//    @ReadingConverter
//    public static class DateToZonedDateTimeConverter implements Converter<Date, ZonedDateTime> {
//        @Override
//        public ZonedDateTime convert(Date source) {
//            return source == null ? null : ZonedDateTime.ofInstant(source.toInstant(), ZoneId.systemDefault());
//        }
//    }
//
//    @WritingConverter
//    public static class ZonedDateTimeToDateConverter implements Converter<ZonedDateTime, Date> {
//        @Override
//        public Date convert(ZonedDateTime source) {
//            return source == null ? null : Date.from(source.withNano(0).toInstant());
//        }
//    }
//}
