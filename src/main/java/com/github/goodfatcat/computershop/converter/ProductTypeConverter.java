package com.github.goodfatcat.computershop.converter;

import com.github.goodfatcat.computershop.model.ProductType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class ProductTypeConverter implements AttributeConverter<ProductType, String> {
    @Override
    public String convertToDatabaseColumn(ProductType productType) {
        return productType.getCode();
    }

    @Override
    public ProductType convertToEntityAttribute(String s) {
        return Stream.of(ProductType.values())
                .filter(productType -> productType.getCode().equals(s))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No such type:" + s));
    }
}
