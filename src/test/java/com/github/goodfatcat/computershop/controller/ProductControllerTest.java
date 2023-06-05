package com.github.goodfatcat.computershop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.goodfatcat.computershop.DTO.AbstractProductDTO;
import com.github.goodfatcat.computershop.DTO.ComputerDTO;
import com.github.goodfatcat.computershop.model.ComputerEntity;
import com.github.goodfatcat.computershop.model.ComputerForm;
import com.github.goodfatcat.computershop.model.ProducerEntity;
import com.github.goodfatcat.computershop.model.ProductType;
import com.github.goodfatcat.computershop.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProductService productService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllProductsByType() throws Exception {
        List<AbstractProductDTO> allByTypes = initReturnList();

        Mockito.when(productService.findAllByType(ProductType.COMPUTER)).thenReturn(allByTypes);

        this.mockMvc.perform(get("/api/products/type/computer"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(objectMapper.writeValueAsString(allByTypes))));
    }
    private List<AbstractProductDTO> initReturnList() {
        ComputerDTO computerDTO1 = new ComputerDTO("Series1", 123, 123, "Producer1", ComputerForm.DESKTOP);
        ComputerDTO computerDTO2 = new ComputerDTO("Series2", 123, 123, "Producer2", ComputerForm.DESKTOP);
        ComputerDTO computerDTO3 = new ComputerDTO("Series3", 123, 123, "Producer3", ComputerForm.DESKTOP);

        return List.of(computerDTO1, computerDTO2, computerDTO3);
    }

    @Test
    void getProductById() throws Exception {
        ComputerDTO computerDTO1 = new ComputerDTO("Series1", 123, 123, "Producer1", ComputerForm.DESKTOP);
        ComputerEntity computerEntity = new ComputerEntity(computerDTO1, new ProducerEntity(computerDTO1.getProducerName()), computerDTO1.getComputerForm());

        Mockito.when(productService.findById(1)).thenReturn(Optional.of(computerEntity));

        this.mockMvc.perform(get("/api/products/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(objectMapper.writeValueAsString(computerEntity))));
    }
}