package com.github.goodfatcat.computershop.repository;

import com.github.goodfatcat.computershop.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    @Query("SELECT p FROM ProductEntity p WHERE TYPE(p) = :entityClass")
    <T extends ProductEntity> List<T> findAllByClass(@Param("entityClass") Class<T> entityClass);
}
