package dev.computer.shop.models;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "COMPUTERS")
public class ComputerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long computerId;
    private BigDecimal price;
    private String brand;
    private int amountOfMemory;
    private String charactericsProcessor;
    private String operatingSystem;

    @ManyToMany
    @JoinTable(
            name = "STORE_COMPUTERS",
            joinColumns = @JoinColumn(name = "computer_id"),
            inverseJoinColumns = @JoinColumn(name = "store_id")
    )
    private List<StoreModel> stores;

    
    public ComputerModel(BigDecimal price, StoreModel store, String brand, int amountOfMemory, String charactericsProcessor, String operatingSystem) {
        this.price = price;
        this.brand = brand;
        this.amountOfMemory = amountOfMemory;
        this.charactericsProcessor = charactericsProcessor;
        this.operatingSystem = operatingSystem;
        this.stores = List.of(store); 
    }
    public ComputerModel() {
    }
    
    public Long getComputerId() {
        return computerId;
    }

    public void setComputerId(Long computerId) {
        this.computerId = computerId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getAmountOfMemory() {
        return amountOfMemory;
    }

    public void setAmountOfMemory(int amountOfMemory) {
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

    public List<StoreModel> getStores() {
        return stores;
    }

    public void setStores(List<StoreModel> stores) {
        this.stores = stores;
    }
}
