package dev.computer.shop.services;

import java.util.List;
import org.springframework.stereotype.Service;
import dev.computer.shop.dtos.StoreDto;
import dev.computer.shop.models.StoreModel;
import dev.computer.shop.repository.StoreRepository;
import jakarta.transaction.Transactional;

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

    public StoreModel findById(Long id) {
        return storeRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Store not found"));
    }

    public List<StoreModel> getAllStores() {
        return storeRepository.findAll();
    }

    @Transactional
    public void deleteStore(Long id) {
        if (!storeRepository.findById(id).isPresent()) {
            throw new RuntimeException("Store not found");
        }
        
        storeRepository.deleteById(id);
    }

}
