package dev.computer.shop.dtos;

import java.math.BigDecimal;
import java.util.List;

public record ComputerDto(
    BigDecimal price,
    List<StoreDto> stores, // Incluimos la lista de StoreDto en lugar de solo storeId
    String brand,
    int amountOfMemory,
    String charactericsProcessor,
    String operatingSystem
) {
    
}
