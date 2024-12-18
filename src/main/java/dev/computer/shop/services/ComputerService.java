package dev.computer.shop.services;


import java.util.List;

import org.springframework.stereotype.Service;
import dev.computer.shop.dtos.ComputerDto;
import dev.computer.shop.models.ComputerModel;
import dev.computer.shop.repository.ComputerRepository;
import jakarta.transaction.Transactional;

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

    public List<ComputerModel> findByBrand(String brand) {
        List<ComputerModel> computers = computeRepository.findByBrand(brand);
        if (computers.isEmpty()) {
            throw new RuntimeException("Brand not found");
        }
        return computers;
    }
    

    public List<ComputerModel> getAllComputers() {
        return computeRepository.findAll();
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
