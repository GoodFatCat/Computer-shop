package com.github.goodfatcat.computershop.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ProductType {
    COMPUTER("computer"),
    LAPTOP("laptop"),
    MONITOR("monitor"),
    HARD_DRIVE("hard_drive");

    private final String code;

    ProductType(String code) {
        this.code = code;
    }

    @JsonValue
    public String getCode() {
        return code;
    }
}
