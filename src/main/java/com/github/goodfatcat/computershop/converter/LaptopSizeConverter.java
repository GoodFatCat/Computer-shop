package com.github.goodfatcat.computershop.converter;

import com.github.goodfatcat.computershop.model.LaptopSize;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class LaptopSizeConverter implements AttributeConverter<LaptopSize, Double> {
    @Override
    public Double convertToDatabaseColumn(LaptopSize laptopSize) {
        if (laptopSize == null) {
            return null;
        }
        return laptopSize.getSize();
    }

    @Override
    public LaptopSize convertToEntityAttribute(Double size) {
        return Stream.of(LaptopSize.values())
                .filter(laptopSize -> laptopSize.getSize() == size)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No such type"));
    }
}
