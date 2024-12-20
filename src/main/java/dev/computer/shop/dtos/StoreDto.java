package dev.computer.shop.dtos;

import dev.computer.shop.models.StoreModel;

public record StoreDto(
        Long storeId,
        String storeName,
        String storeOwner) {
    
    public StoreDto(StoreModel storeModel) {
        this(storeModel.getStoreId(), storeModel.getStoreName(), storeModel.getStoreOwner());
    }

    
    public StoreDto(String storeName, String storeOwner) {
        this(null, storeName, storeOwner); 
    }

}
