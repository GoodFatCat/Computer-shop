package com.github.goodfatcat.computershop.model;

public enum ProductType {
    COMPUTER("computer"),
    LAPTOP("laptop"),
    MONITOR("monitor"),
    HARD_DRIVER("hard drive");

    private final String code;

    ProductType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
