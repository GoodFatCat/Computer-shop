package com.github.goodfatcat.computershop.repository;

import com.github.goodfatcat.computershop.model.ProducerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProducerRepositoryTest {
    @Autowired
    private ProducerRepository repository;

    @Test
    public void findByNameTest() {
        ProducerEntity entity1 = new ProducerEntity("Producer1");
        ProducerEntity entity2 = new ProducerEntity("Producer2");

        repository.saveAll(List.of(entity1, entity2));

        Optional<ProducerEntity> requested = repository.findByName("Producer2");

        assertEquals(entity2, requested.orElseThrow(NoSuchElementException::new));
    }
}