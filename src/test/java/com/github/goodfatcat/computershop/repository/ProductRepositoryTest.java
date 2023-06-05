package com.github.goodfatcat.computershop.repository;

import com.github.goodfatcat.computershop.model.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Test
    public void findAllByClassTest() {
        ComputerEntity entity1 = new ComputerEntity();
        ComputerEntity entity2 = new ComputerEntity();
        ComputerEntity entity3 = new ComputerEntity();
        LaptopEntity entity4 = new LaptopEntity();
        entity1.setForm(ComputerForm.DESKTOP);
        entity2.setForm(ComputerForm.NETTOP);
        entity3.setForm(ComputerForm.MONOBLOCK);
        entity4.setLaptopSize(LaptopSize.SIZE17);
        entity1.setProductCount(1);
        entity2.setProductCount(2);
        entity3.setProductCount(3);
        entity4.setProductCount(4);
        entity1.setProducer(new ProducerEntity("producer1"));
        entity2.setProducer(new ProducerEntity("producer2"));
        entity3.setProducer(new ProducerEntity("producer1"));
        entity4.setProducer(new ProducerEntity("producer3"));
        entity1.setPrice(1);
        entity2.setPrice(2);
        entity3.setPrice(3);
        entity4.setPrice(4);
        entity1.setSeriesNumber("series1");
        entity2.setSeriesNumber("series2");
        entity3.setSeriesNumber("series3");
        entity4.setSeriesNumber("series4");
        List<ProductEntity> list = List.of(entity1, entity2, entity3, entity4);
        repository.saveAll(list);

        List<ComputerEntity> allComputers = repository.findAllByClass(ComputerEntity.class);

        assertEquals(3, allComputers.size());
        assertEquals(entity1, allComputers.get(0));

        log.debug(allComputers.toString());
    }
}