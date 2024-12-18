package dev.computer.shop.controllers;



import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.computer.shop.dtos.ComputerDto;
import dev.computer.shop.dtos.StoreDto;
import dev.computer.shop.models.ComputerModel;
import dev.computer.shop.models.StoreModel;
import dev.computer.shop.services.ComputerService;
import dev.computer.shop.services.StoreService;



@RestController
@RequestMapping(path="${api-endpoint}/stores")
public class StoreController {
    
    private StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    
    @PostMapping("")
    public ResponseEntity<StoreModel>  addStore(@RequestBody StoreDto entity){
        StoreModel store =  storeService.save(entity);
        if (store == null) {
            ResponseEntity.badRequest();
            
        }

        return ResponseEntity.status(201).body(store);
    }

    @GetMapping("/{id}")    
    public ResponseEntity<?> getStoreId(@PathVariable Long id){
        try {
            StoreModel store = storeService.findById(id);
        return ResponseEntity.ok(store);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
        
   }

    @GetMapping("")
    public List<StoreModel> getAllStores(){
        return storeService.getAllStores();
    }


}
