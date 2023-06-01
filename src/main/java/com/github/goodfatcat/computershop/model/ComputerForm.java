package com.github.goodfatcat.computershop.model;

public enum ComputerForm {
    DESKTOP("desktop"),
    NETTOP("nettop"),
    MONOBLOCK("monoblock");

    private final String form;

    ComputerForm(String form) {
        this.form = form;
    }

    public String getForm() {
        return form;
    }
}
