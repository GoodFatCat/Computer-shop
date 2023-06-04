package com.github.goodfatcat.computershop.controller;

import com.github.goodfatcat.computershop.DTO.HardDriveDTO;
import com.github.goodfatcat.computershop.service.ProductService;
import com.github.goodfatcat.computershop.util.ErrorsUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/add/drive")
public class HardDriveController {
    private ProductService productService;
    private final String globalPath = "/api/add/drive";

    @Autowired
    public HardDriveController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("")
    public ResponseEntity<?> saveHardDrive(@RequestBody @Valid HardDriveDTO hardDriveDTO, Errors errors) {
        if (errors.hasErrors()) {
            return ErrorsUtil.getResponseEntity(HttpStatus.BAD_REQUEST, globalPath, ErrorsUtil.showErrors(errors));
        }

        productService.save(hardDriveDTO);

        return new ResponseEntity<>("Hard drive saved successfully", HttpStatus.CREATED);
    }
}
