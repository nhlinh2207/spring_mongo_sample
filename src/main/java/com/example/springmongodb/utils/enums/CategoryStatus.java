package com.example.springmongodb.utils.enums;

public enum CategoryStatus {

    ACTIVE("ACTIVE", "Hoạt động"),
    INACTIVE("INACTIVE", "Không hoạt động");

    public String code;
    public String message;

    CategoryStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }
}

