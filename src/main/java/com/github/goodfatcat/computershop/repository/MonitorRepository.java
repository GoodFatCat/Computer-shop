package com.github.goodfatcat.computershop.repository;

import com.github.goodfatcat.computershop.model.MonitorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MonitorRepository extends JpaRepository<MonitorEntity, Long> {
    Optional<MonitorEntity> findBySize(double size);
}
