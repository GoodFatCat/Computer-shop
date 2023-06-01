package com.github.goodfatcat.computershop.repository;

import com.github.goodfatcat.computershop.model.MonitorSize;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MonitorSizeRepository extends JpaRepository<MonitorSize, Long> {
    Optional<MonitorSize> findBySize(double size);
}
