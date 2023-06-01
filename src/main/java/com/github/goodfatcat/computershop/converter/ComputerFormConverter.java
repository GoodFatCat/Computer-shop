package com.github.goodfatcat.computershop.converter;

import com.github.goodfatcat.computershop.model.ComputerForm;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class ComputerFormConverter implements AttributeConverter<ComputerForm, String> {
    @Override
    public String convertToDatabaseColumn(ComputerForm computerForm) {
        if (computerForm == null)
            return null;
        return computerForm.getForm();
    }

    @Override
    public ComputerForm convertToEntityAttribute(String s) {
        return Stream.of(ComputerForm.values())
                .filter(computerForm -> computerForm.getForm().equals(s))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No such type"));
    }
}
