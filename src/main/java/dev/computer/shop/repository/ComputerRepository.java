package dev.computer.shop.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.computer.shop.models.ComputerModel;

public interface ComputerRepository extends JpaRepository<ComputerModel, Long> {
    
    List<ComputerModel> findByBrand(String brand);

    @Modifying
    @Query("DELETE FROM ComputerModel c WHERE c.brand = :brand")
    void deleteAllByBrand(@Param("brand") String brand);
    

}
