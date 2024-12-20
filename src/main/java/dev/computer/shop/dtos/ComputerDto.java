package dev.computer.shop.dtos;

import java.math.BigDecimal;
import java.util.List;

public record ComputerDto(
    BigDecimal price,
    List<StoreDto> stores, 
    String brand,
    int amountOfMemory,
    String charactericsProcessor,
    String operatingSystem
) {
    
}
