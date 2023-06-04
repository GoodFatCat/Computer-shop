package com.github.goodfatcat.computershop.controller;

import com.github.goodfatcat.computershop.DTO.MonitorDTO;
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
@RequestMapping("api/add/monitor")
public class MonitorController {
    private ProductService productService;
    private final String path = "api/add/monitor";

    @Autowired
    public MonitorController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("")
    public ResponseEntity<?> saveMonitor(@RequestBody @Valid MonitorDTO monitorDTO, Errors errors) {
        if (errors.hasErrors()) {
            return ErrorsUtil.getResponseEntity(HttpStatus.BAD_REQUEST, path, ErrorsUtil.showErrors(errors));
        }

        productService.save(monitorDTO);

        return new ResponseEntity<>("Monitor saved successfully", HttpStatus.CREATED);
    }
}
