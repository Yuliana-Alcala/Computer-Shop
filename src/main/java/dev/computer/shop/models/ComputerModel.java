package dev.computer.shop.models;

//import java.math.BigDecimal;

import dev.computer.shop.dtos.ComputerDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="computers")
public class ComputerModel extends ProductModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long computerId;

    private Long storeId;
  
    private String brand;
  
    private int amountOfMemory;

    private String charactericsProcessor;
   
    private String operatingSystem;
    

    public ComputerModel() {
    }
   /* public ComputerModel(BigDecimal price, String brand, int amountOfMemory, String charactericsProcessor, String operatingSystem) {
        super(price);
        
        this.brand = brand;
        this.amountOfMemory = amountOfMemory;
        this.charactericsProcessor = charactericsProcessor;
        this.operatingSystem = operatingSystem;
    }*/
    
    public ComputerModel(ComputerDto dto) {
        
        super(dto.price());  
        this.brand = dto.brand();
        this.amountOfMemory = dto.amountOfMemory();
        this.charactericsProcessor = dto.charactericsProcessor();
        this.operatingSystem = dto.operatingSystem();
    }
    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getAmountOMemory() {
        return amountOfMemory;
    }

    public void setAmountOfmemory(int amountOfMemory) {
        this.amountOfMemory = amountOfMemory;
    }

    public String getCharactericsProcessor() {
        return charactericsProcessor;
    }

    public void setCharactericsProcessor(String charactericsProcessor) {
        this.charactericsProcessor = charactericsProcessor;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}
