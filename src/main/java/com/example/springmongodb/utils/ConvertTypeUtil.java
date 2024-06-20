package com.example.springmongodb.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ConvertTypeUtil {

    public static Object convert(String value) throws UnsupportedEncodingException {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            // Not an integer, try next type
        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            return dateFormat.parse(value);
        } catch (ParseException e) {
            // Not a date, return as string
        }

        try {
            return Float.parseFloat(value);
        } catch (NumberFormatException e) {
            // Not an integer, try next type
        }

        return URLDecoder.decode(value, "UTF-8");

    }
}
