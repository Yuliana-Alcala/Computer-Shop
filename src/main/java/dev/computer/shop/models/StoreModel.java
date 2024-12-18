package dev.computer.shop.models;

import dev.computer.shop.dtos.StoreDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "stores")
public class StoreModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;
    private String storeName;
    private String storeOwner;
    
    
    public StoreModel() {
          
       
        
    }
    public StoreModel(StoreDto dto) {
          
        this.storeName = dto.storeName();
        this.storeOwner= dto.storeOwner();
        
    }

    public String getStorName() {
        return storeName;
    }
    public void setStorName(String storName) {
        this.storeName = storName;
    }
    public String getStoreowner() {
        return storeOwner;
    }
    public void setStoreowner(String storeOwner) {
        this.storeOwner = storeOwner;
    }
    public Long getStoreId() {
        return storeId;
    }
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }    

}
