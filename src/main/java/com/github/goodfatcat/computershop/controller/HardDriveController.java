package com.github.goodfatcat.computershop.controller;

import com.github.goodfatcat.computershop.DTO.HardDrive;
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
    private String path = "/api/add/drive";

    @Autowired
    public HardDriveController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("")
    public ResponseEntity<?> saveHardDrive(@RequestBody @Valid HardDrive hardDrive, Errors errors) {
        if (errors.hasErrors()) {
            return ErrorsUtil.getResponseEntity(HttpStatus.BAD_REQUEST, path, ErrorsUtil.showErrors(errors));
        }

        productService.save(hardDrive);

        return ResponseEntity.ok("Hard drive saved successfully");
    }
}
