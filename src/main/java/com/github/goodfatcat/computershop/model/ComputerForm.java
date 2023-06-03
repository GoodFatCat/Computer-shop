package com.github.goodfatcat.computershop.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ComputerForm {
    DESKTOP("desktop"),
    NETTOP("nettop"),
    MONOBLOCK("monoblock");

    private final String form;

    ComputerForm(String form) {
        this.form = form;
    }

    @JsonValue
    public String getForm() {
        return form;
    }
}
