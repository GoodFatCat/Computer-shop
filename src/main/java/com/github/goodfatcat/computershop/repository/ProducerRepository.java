package com.github.goodfatcat.computershop.repository;

import com.github.goodfatcat.computershop.model.ProductProducer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProducerRepository extends JpaRepository<ProductProducer, Long> {
    Optional<ProductProducer> findByName(String name);
}
