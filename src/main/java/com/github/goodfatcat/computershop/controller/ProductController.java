package com.github.goodfatcat.computershop.controller;

import com.github.goodfatcat.computershop.DTO.AbstractProductDTO;
import com.github.goodfatcat.computershop.model.ProductType;
import com.github.goodfatcat.computershop.service.ProductService;
import com.github.goodfatcat.computershop.util.ErrorsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductService productService;
    private final String globalPath = "/api/products";

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{type}")
    public ResponseEntity<?> getAllProductsByType(@PathVariable ProductType type) {
        List<AbstractProductDTO> allByType = productService.findAllByType(type);
        return ResponseEntity.ok(allByType);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleJsonParseException(MethodArgumentTypeMismatchException ex) {
        return ErrorsUtil.getResponseEntity(HttpStatus.BAD_REQUEST, globalPath,
                List.of(ex.getMessage(), "Available types: " + Arrays.toString(ProductType.values())));
    }
}
