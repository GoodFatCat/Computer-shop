package com.github.goodfatcat.computershop.converter;

import com.github.goodfatcat.computershop.model.ProductType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeConverter implements Converter<String, ProductType> {
    @Override
    public ProductType convert(String source) {
        return ProductType.valueOf(source.toUpperCase());
    }
}
