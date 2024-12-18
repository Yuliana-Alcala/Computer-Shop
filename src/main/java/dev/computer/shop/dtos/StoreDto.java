package dev.computer.shop.dtos;

import dev.computer.shop.models.StoreModel;
public record StoreDto(
    Long storeId,
    String storeName,
    String storeOwner
) {
     // Constructor explícito si quieres crear StoreDto desde StoreModel
     public StoreDto(StoreModel storeModel) {
        this(storeModel.getStoreId(), storeModel.getStoreName(), storeModel.getStoreOwner());
    }

    // Constructor con parámetros explícitos
    public StoreDto(String storeName, String storeOwner) {
        this(null, storeName, storeOwner); // Si no se pasa storeId, lo dejamos como null
    }
    
}
