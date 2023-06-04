package com.github.goodfatcat.computershop.controller;

import com.github.goodfatcat.computershop.DTO.AbstractProductDTO;
import com.github.goodfatcat.computershop.model.ProductEntity;
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
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductService productService;
    private final String globalPath = "/api/products";

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<?> getAllProductsByType(@PathVariable ProductType type) {
        List<AbstractProductDTO> allByType = productService.findAllByType(type);
        return ResponseEntity.ok(allByType);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getProductById(@PathVariable long id) {
        String path = globalPath + "/" + id;
        Optional<ProductEntity> optionalProduct = productService.findById(id);
        if (optionalProduct.isEmpty())
            return ErrorsUtil.getResponseEntity(HttpStatus.NOT_FOUND, path,
                    List.of("Not found product with id=" + id));
        return ResponseEntity.ok(optionalProduct.get());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleJsonParseException(MethodArgumentTypeMismatchException ex) {
        return ErrorsUtil.getResponseEntity(HttpStatus.BAD_REQUEST, globalPath,
                List.of(ex.getMessage(), "Available types: " + Arrays.toString(ProductType.values())));
    }
}
