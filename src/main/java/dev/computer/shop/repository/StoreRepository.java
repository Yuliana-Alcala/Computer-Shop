package dev.computer.shop.repository;


import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository<StoreModel> extends JpaRepository<StoreModel, Long> {

    

}
