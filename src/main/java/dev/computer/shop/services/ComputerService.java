package dev.computer.shop.services;


import java.util.List;

import org.springframework.stereotype.Service;
import dev.computer.shop.dtos.ComputerDto;
import dev.computer.shop.models.ComputerModel;
import dev.computer.shop.repository.ComputerRepository;

@Service
public class ComputerService {
    private ComputerRepository computeRepository;

    public ComputerService(ComputerRepository computeRepository) {
        this.computeRepository = computeRepository;
    }

    public ComputerModel save(ComputerDto computerDto) {
               
        ComputerModel computerModel = new ComputerModel(computerDto);
        computeRepository.save(computerModel);
        return computerModel;
    }

    public ComputerModel findByBrand(String brand) {
        return computeRepository.findByBrand(brand)
                .orElseThrow(() -> new RuntimeException("Brand not found"));
    }
    

    public List<ComputerModel> getAllComputers() {
        return computeRepository.findAll();
    }

}
