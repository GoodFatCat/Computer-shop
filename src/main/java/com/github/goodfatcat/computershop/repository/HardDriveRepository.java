package com.github.goodfatcat.computershop.repository;

import com.github.goodfatcat.computershop.model.HardDriveEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HardDriveRepository extends JpaRepository<HardDriveEntity, Long> {
    Optional<HardDriveEntity> findByCapacity(int capacity);
}
