package dev.computer.shop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import dev.computer.shop.models.StoreModel;

public interface StoreRepository extends JpaRepository<StoreModel, Long> {

    

}
