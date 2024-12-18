package dev.computer.shop.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import dev.computer.shop.dtos.ComputerDto;
import dev.computer.shop.dtos.StoreDto;
import dev.computer.shop.models.ComputerModel;
import dev.computer.shop.models.StoreModel;
import dev.computer.shop.repository.ComputerRepository;
import dev.computer.shop.repository.StoreRepository;
import jakarta.transaction.Transactional;

@Service
public class ComputerService {
    private ComputerRepository computeRepository;
    private final StoreRepository storeRepository;

    public ComputerService(ComputerRepository computeRepository, StoreRepository storeRepository) {
        this.computeRepository = computeRepository;
        this.storeRepository = storeRepository;

    }

    @Transactional
    public ComputerDto save(ComputerDto computerDto) {
        
        if (computerDto.stores() == null || computerDto.stores().isEmpty()) {
            throw new RuntimeException("Store list cannot be empty.");
        }

        
        StoreDto storeDto = computerDto.stores().get(0); 
        StoreModel store = storeRepository.findById(storeDto.storeId())
                .orElseThrow(() -> new RuntimeException("Store not found"));

        
        ComputerModel computerModel = new ComputerModel(
                computerDto.price(),
                store, 
                computerDto.brand(),
                computerDto.amountOfMemory(),
                computerDto.charactericsProcessor(),
                computerDto.operatingSystem());
        
        ComputerModel savedComputer = computeRepository.save(computerModel);
        
        List<StoreDto> storeDtos = savedComputer.getStores().stream()
                .map(s -> new StoreDto(s)) 
                .collect(Collectors.toList());

        return new ComputerDto(
                savedComputer.getPrice(),
                storeDtos, 
                savedComputer.getBrand(),
                savedComputer.getAmountOfMemory(),
                savedComputer.getCharactericsProcessor(),
                savedComputer.getOperatingSystem());
    }

    public List<ComputerModel> findByBrand(String brand) {
        
        List<ComputerModel> computers = computeRepository.findByBrand(brand);        
        
        if (computers == null || computers.isEmpty()) {
           
            throw new RuntimeException("No computers found for the brand: " + brand);
        }       
        
        return computers;
    }
    

    public List<ComputerModel> getAllComputers() {
        List<ComputerModel> computers = computeRepository.findAll();
    
        if (computers.isEmpty()) {
            
            throw new RuntimeException("No computers found");
        }
        
        return computers;
    }

    @Transactional
    public void deleteComputersByBrand(String brand) {
        List<ComputerModel> computers = computeRepository.findByBrand(brand);
        if (computers.isEmpty()) {
            throw new RuntimeException("Brand " + brand + " not found");
        }
        computeRepository.deleteAllByBrand(brand);
    }

}
