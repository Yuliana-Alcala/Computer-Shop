package dev.computer.shop.dtos;

import java.math.BigDecimal;

public record ComputerDto(
    
    BigDecimal price,
    Long storeId,
    String brand, 
    int amountOfMemory, 
    String charactericsProcessor, 
    String operatingSystem

) {}
