package com.github.goodfatcat.computershop.service;

import com.github.goodfatcat.computershop.DTO.AbstractProductDTO;
import com.github.goodfatcat.computershop.DTO.LaptopDTO;
import com.github.goodfatcat.computershop.model.LaptopSize;
import com.github.goodfatcat.computershop.model.ProducerEntity;
import com.github.goodfatcat.computershop.repository.ProducerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProducerServiceTest {
    private final ProducerRepository producerRepository = Mockito.mock(ProducerRepository.class);
    private final ProducerService producerService = new ProducerServiceImpl(producerRepository);

    @Test
    void shouldFindProducer() {
        ProducerEntity expected = new ProducerEntity("Producer1");

        Mockito.when(producerRepository.findByName("Producer1")).thenReturn(Optional.of(expected));

        AbstractProductDTO laptopDTO = new LaptopDTO("series", 123, 1, "Producer1", LaptopSize.SIZE17);

        ProducerEntity actual = producerService.getProducerOrCreateNew(laptopDTO);

        assertEquals(expected, actual);
        Mockito.verify(producerRepository).findByName("Producer1");
    }
}