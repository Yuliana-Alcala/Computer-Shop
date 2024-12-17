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
    private String storName;
    private String storeowner;
    


    public StoreModel(StoreDto dto) {
          
        this.storName = dto.storeName();
        this.storeowner= dto.storeOwner();
        
    }

    public String getStorName() {
        return storName;
    }
    public void setStorName(String storName) {
        this.storName = storName;
    }
    public String getStoreowner() {
        return storeowner;
    }
    public void setStoreowner(String storeowner) {
        this.storeowner = storeowner;
    }
    public Long getStoreId() {
        return storeId;
    }
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }    

}
