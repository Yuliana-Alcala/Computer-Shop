package dev.computer.shop.controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.computer.shop.dtos.ComputerDto;
import dev.computer.shop.models.ComputerModel;
import dev.computer.shop.services.ComputerService;


@RestController
@RequestMapping(path="${api-endpoint}/computers")
public class ComputerController {
    
    private ComputerService computerService;

    public ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    
    @PostMapping("")
    public ResponseEntity<ComputerModel>  addPatient(@RequestBody ComputerDto entity){
        ComputerModel computer =  computerService.save(entity);
        if (computer == null) {
            ResponseEntity.badRequest();
            
        }

        return ResponseEntity.status(201).body(computer);
    }

    @GetMapping("/{brand}")
    
    public ResponseEntity<ComputerModel> getComputerId(@PathVariable String brand){
        
        Optional<ComputerModel> patient = computerService.findByBrand(brand);
        return ResponseEntity.status(201).body(patient.get());

    }
    




    


}
