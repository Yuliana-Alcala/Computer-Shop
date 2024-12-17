package dev.computer.shop.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.computer.shop.dtos.StoreDto;
import dev.computer.shop.models.StoreModel;
import dev.computer.shop.repository.StoreRepository;

@Service
public class StoreService {
    private StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public StoreModel save(StoreDto storeDto) {
               
        StoreModel storeModel = new StoreModel(storeDto);
        storeRepository.save(storeModel);
        return storeModel;
    }

    public Optional<StoreModel> findById(String id) {
        return storeRepository.findById(id);
    }

}
