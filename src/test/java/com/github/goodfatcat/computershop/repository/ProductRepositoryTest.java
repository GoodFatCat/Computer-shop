package com.github.goodfatcat.computershop.repository;

import com.github.goodfatcat.computershop.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Test
    public void saveTest() {
        Product product = new Product();
        product.setId(1);
        product.setType(ProductType.COMPUTER);
        product.setSeriesNumber("some-45898654");
        product.setPrice(1354);
        product.setProductCount(1);
        product.setProducer(new ProductProducer(1, "Producer"));
        product.setComputerForm(ComputerForm.NETTOP);
        product.setLaptopSize(LaptopSize.SIZE15);
        product.setMonitorSize(new MonitorSize(1, 24.1));
        product.setHardDriveCapacity(new HardDriveCapacity(1, 500));

        repository.save(product);

        System.out.println(repository.findById(1L));
    }
}