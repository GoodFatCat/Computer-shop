package com.github.goodfatcat.computershop.controller;

import com.github.goodfatcat.computershop.DTO.AbstractProductDTO;
import com.github.goodfatcat.computershop.DTO.MonitorDTO;
import com.github.goodfatcat.computershop.model.MonitorEntity;
import com.github.goodfatcat.computershop.model.ProducerEntity;
import com.github.goodfatcat.computershop.model.ProductEntity;
import com.github.goodfatcat.computershop.service.ProducerService;
import com.github.goodfatcat.computershop.service.ProductService;
import com.github.goodfatcat.computershop.util.ErrorsUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/products/monitor")
public class MonitorController {
    private ProductService productService;
    private ProducerService producerService;
    private final String globalPath = "api/products/monitor";

    @Autowired
    public MonitorController(ProductService productService, ProducerService producerService) {
        this.productService = productService;
        this.producerService = producerService;
    }

    @PostMapping("")
    public ResponseEntity<?> saveMonitor(@RequestBody @Valid MonitorDTO monitorDTO, Errors errors) {
        if (errors.hasErrors()) {
            return ErrorsUtil.getResponseEntity(HttpStatus.BAD_REQUEST, globalPath, ErrorsUtil.showErrors(errors));
        }

        productService.save(monitorDTO);

        return new ResponseEntity<>("Monitor saved successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMonitor(
            @PathVariable long id, @Valid @RequestBody MonitorDTO monitor, Errors errors) {
        String path = globalPath + "/" + id;

        if (errors.hasErrors()) {
            return ErrorsUtil.getResponseEntity(HttpStatus.BAD_REQUEST, path, ErrorsUtil.showErrors(errors));
        }

        try {
            MonitorEntity entity = (MonitorEntity) productService.findById(id).orElseThrow(NoSuchElementException::new);
            initMainData(monitor, entity);

            entity.setMonitorSize(monitor.getMonitorSize());

            productService.save(entity);
            return ResponseEntity.ok("monitor updated successfully");
        } catch (NoSuchElementException e) {
            return ErrorsUtil.getResponseEntity(HttpStatus.NOT_FOUND, path,
                    List.of("No such product with id=" + id));
        } catch (ClassCastException e) {
            return ErrorsUtil.getResponseEntity(HttpStatus.BAD_REQUEST, path,
                    List.of("Product with id=" + id + " isn't a monitor"));
        }
    }

    private void initMainData(AbstractProductDTO productDTO, ProductEntity entity) {
        entity.setSeriesNumber(productDTO.getSeriesNumber());
        entity.setProductCount(productDTO.getCount());
        entity.setPrice(productDTO.getPrice());

        ProducerEntity producer = producerService.getProducerOrCreateNew(productDTO);
        entity.setProducer(producer);
    }
}
