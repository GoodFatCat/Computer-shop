package com.github.goodfatcat.computershop.controller;

import com.github.goodfatcat.computershop.DTO.AbstractProductDTO;
import com.github.goodfatcat.computershop.DTO.LaptopDTO;
import com.github.goodfatcat.computershop.model.LaptopEntity;
import com.github.goodfatcat.computershop.model.ProducerEntity;
import com.github.goodfatcat.computershop.model.ProductEntity;
import com.github.goodfatcat.computershop.service.ProducerService;
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
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/products/laptop")
public class LaptopController {
    private ProductService productService;
    private ProducerService producerService;
    private final String globalPath = "/api/products/laptop";

    @Autowired
    public LaptopController(ProductService productService, ProducerService producerService) {
        this.productService = productService;
        this.producerService = producerService;
    }

    @PostMapping("")
    public ResponseEntity<?> saveLaptop(@RequestBody @Valid LaptopDTO laptopDTO, Errors errors) {
        if (errors.hasErrors()) {
            return ErrorsUtil.getResponseEntity(HttpStatus.BAD_REQUEST, globalPath, ErrorsUtil.showErrors(errors));
        }

        productService.save(laptopDTO);

        return new ResponseEntity<>("Laptop saved successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateLaptop(
            @PathVariable long id, @Valid @RequestBody LaptopDTO laptop, Errors errors) {
        String path = globalPath + "/" + id;

        if (errors.hasErrors()) {
            return ErrorsUtil.getResponseEntity(HttpStatus.BAD_REQUEST, path, ErrorsUtil.showErrors(errors));
        }

        try {
            LaptopEntity entity = (LaptopEntity) productService.findById(id).orElseThrow(NoSuchElementException::new);
            initMainData(laptop, entity);

            entity.setLaptopSize(laptop.getLaptopSize());

            productService.save(entity);
            return ResponseEntity.ok("Laptop updated successfully");
        } catch (NoSuchElementException e) {
            return ErrorsUtil.getResponseEntity(HttpStatus.NOT_FOUND, path,
                    List.of("No such product with id=" + id));
        } catch (ClassCastException e) {
            return ErrorsUtil.getResponseEntity(HttpStatus.BAD_REQUEST, path,
                    List.of("Product with id=" + id + " isn't a laptop"));
        }
    }

    private void initMainData(AbstractProductDTO productDTO, ProductEntity entity) {
        entity.setSeriesNumber(productDTO.getSeriesNumber());
        entity.setProductCount(productDTO.getCount());
        entity.setPrice(productDTO.getPrice());

        ProducerEntity producer = producerService.getProducerOrCreateNew(productDTO);
        entity.setProducer(producer);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleJsonParseException(HttpMessageNotReadableException ex) {
        return ErrorsUtil.getResponseEntity(HttpStatus.BAD_REQUEST, globalPath,
                List.of(ex.getMessage()));
    }
}
