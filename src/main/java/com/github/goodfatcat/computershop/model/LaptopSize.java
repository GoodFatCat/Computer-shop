package com.github.goodfatcat.computershop.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum LaptopSize {
    SIZE13(13.0),
    SIZE14(14.0),
    SIZE15(15.0),
    SIZE17(17.0);

    private final Double size;

    LaptopSize(Double size) {
        this.size = size;
    }

    @JsonValue
    public double getSize() {
        return size;
    }
}
