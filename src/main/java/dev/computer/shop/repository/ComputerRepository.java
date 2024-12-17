package dev.computer.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.computer.shop.models.ComputerModel;

public interface ComputerRepository extends JpaRepository<ComputerModel, Long> {
    
    Optional<ComputerModel> findByBrand(String brand);
    

}
