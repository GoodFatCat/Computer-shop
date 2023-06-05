package com.github.goodfatcat.computershop.controller;

import com.github.goodfatcat.computershop.DTO.ComputerDTO;
import com.github.goodfatcat.computershop.model.ComputerEntity;
import com.github.goodfatcat.computershop.model.ComputerForm;
import com.github.goodfatcat.computershop.model.ProducerEntity;
import com.github.goodfatcat.computershop.service.ProducerService;
import com.github.goodfatcat.computershop.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ComputerController.class)
class ComputerControllerTest {

    @MockBean
    private ProductService productService;
    @MockBean
    private ProducerService producerService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void saveComputer() throws Exception {
        ComputerDTO computerDTO = initComputers();

        this.mockMvc.perform(post("/api/products/computer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"seriesNumber\": \"Series\",\n" +
                                "    \"price\": 123,\n" +
                                "    \"count\": 123,\n" +
                                "    \"producerName\": \"Producer\",\n" +
                                "    \"computerForm\": \"desktop\"\n" +
                                "}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        Mockito.verify(productService).save(computerDTO);
    }

    private static ComputerDTO initComputers() {
        return new ComputerDTO("Series", 123, 123, "Producer", ComputerForm.DESKTOP);
    }

    @Test
    void updateComputer() throws Exception {
        ComputerDTO computerDTO = initComputers();

        ComputerEntity computerEntity = new ComputerEntity(computerDTO, new ProducerEntity(computerDTO.getProducerName()), computerDTO.getComputerForm());

        Mockito.when(productService.findById(1)).thenReturn(Optional.of(computerEntity));

        this.mockMvc.perform(put("/api/products/computer/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"price\": 54,\n" +
                                "    \"producerName\": \"Somebody\",\n" +
                                "    \"count\": 65676,\n" +
                                "    \"computerForm\": \"nettop\",\n" +
                                "    \"seriesNumber\": \"yo\"\n" +
                                "}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


        Mockito.verify(productService).findById(1);
        Mockito.verify(productService).save(computerEntity);
    }
}