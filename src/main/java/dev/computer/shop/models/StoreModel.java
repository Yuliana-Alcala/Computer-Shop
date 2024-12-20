package dev.computer.shop.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import dev.computer.shop.dtos.StoreDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "STORES")
public class StoreModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;
    private String storeName;
    private String storeOwner;

    @ManyToMany
    @JoinTable(
        name = "STORE_COMPUTERS",
        joinColumns = @JoinColumn(name = "store_id" ),
        inverseJoinColumns = @JoinColumn(name="computer_id")
    )   
    @JsonBackReference
 
    private List<ComputerModel> computers;
    
    public StoreModel() {
              
    }


    public StoreModel(StoreDto dto) {
          
        this.storeName = dto.storeName();
        this.storeOwner= dto.storeOwner();
        
    }

    
    public String getStoreName() {
        return storeName;
    }
    public void setStoreName(String storName) {
        this.storeName = storName;
    }
    public String getStoreOwner() {
        return storeOwner;
    }
    public void setStoreOwner(String storeOwner) {
        this.storeOwner = storeOwner;
    }
    public Long getStoreId() {
        return storeId;
    }
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }    

}
