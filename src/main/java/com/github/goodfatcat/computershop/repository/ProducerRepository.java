package com.github.goodfatcat.computershop.repository;

import com.github.goodfatcat.computershop.model.ProducerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProducerRepository extends JpaRepository<ProducerEntity, Long> {
    Optional<ProducerEntity> findByName(String name);
}
