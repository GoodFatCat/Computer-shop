package com.github.goodfatcat.computershop.repository;

import com.github.goodfatcat.computershop.model.HardDriveCapacity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HardDriveCapacityRepository extends JpaRepository<HardDriveCapacity, Long> {
    Optional<HardDriveCapacity> findByCapacity(int capacity);
}
