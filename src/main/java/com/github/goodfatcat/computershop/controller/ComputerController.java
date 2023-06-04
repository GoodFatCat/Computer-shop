package com.github.goodfatcat.computershop.controller;

import com.github.goodfatcat.computershop.DTO.ComputerDTO;
import com.github.goodfatcat.computershop.service.ProductService;
import com.github.goodfatcat.computershop.util.ErrorsUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/add/computer")
public class ComputerController {
    private ProductService productService;
    private final String globalPath = "/api/add/computer";

    @Autowired
    public ComputerController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("")
    public ResponseEntity<?> saveComputer(@RequestBody @Valid ComputerDTO computerDTO, Errors errors) {
        if (errors.hasErrors()) {
            return ErrorsUtil.getResponseEntity(HttpStatus.BAD_REQUEST, globalPath, ErrorsUtil.showErrors(errors));
        }

        productService.save(computerDTO);

        return ResponseEntity.ok("Computer saved successfully");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleJsonParseException(HttpMessageNotReadableException ex) {
       return ErrorsUtil.getResponseEntity(HttpStatus.BAD_REQUEST, globalPath,
               List.of(ex.getMessage()));
    }
}
