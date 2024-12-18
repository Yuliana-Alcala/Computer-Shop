package dev.computer.shop.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import dev.computer.shop.dtos.ComputerDto;
import dev.computer.shop.dtos.StoreDto;
import dev.computer.shop.models.ComputerModel;
import dev.computer.shop.models.StoreModel;
import dev.computer.shop.repository.ComputerRepository;
import dev.computer.shop.repository.StoreRepository;
import jakarta.transaction.Transactional;

@Service
public class ComputerService {
    private ComputerRepository computeRepository;
    private final StoreRepository storeRepository;

    public ComputerService(ComputerRepository computeRepository, StoreRepository storeRepository) {
        this.computeRepository = computeRepository;
        this.storeRepository = storeRepository;

    }
    /*
     * @Transactional
     * public ComputerDto save(ComputerDto computerDto) {
     * 
     * // Obtener la tienda utilizando el storeId del DTO
     * StoreModel store = storeRepository.findById(computerDto.storeId())
     * .orElseThrow(() -> new RuntimeException("Store not found"));
     * 
     * // Crear un nuevo ComputerModel y asociar la tienda
     * ComputerModel computerModel = new ComputerModel(computerDto, List.of(store));
     * 
     * // Guardar el nuevo ordenador
     * ComputerModel savedComputer = computeRepository.save(computerModel);
     * 
     * // Verificar si el computador tiene tiendas asociadas y obtener el storeId de
     * la
     * // primera tienda
     * Long storeId = null;
     * if (!savedComputer.getStores().isEmpty()) {
     * storeId = savedComputer.getStores().get(0).getStoreId(); // Obtener el
     * storeId de la primera tienda asociada
     * }
     * 
     * // Convertir el modelo de la computadora guardada en un DTO
     * ComputerDto dto = new ComputerDto(
     * computerDto.price(),
     * computerDto.brand(),
     * computerDto.amountOfMemory(),
     * computerDto.charactericsProcessor(),
     * computerDto.operatingSystem(),
     * computerDto.storeId()
     * 
     * 
     * );
     * return dto;
     * }
     */

     @Transactional
public ComputerDto save(ComputerDto computerDto) {
    // Verifica que al menos una tienda esté en la lista
    if (computerDto.stores() == null || computerDto.stores().isEmpty()) {
        throw new RuntimeException("Store list cannot be empty.");
    }

    // Obtenemos la tienda utilizando storeId del primer StoreDto
    StoreDto storeDto = computerDto.stores().get(0); // Asumimos que la primera tienda es la que se usa
    StoreModel store = storeRepository.findById(storeDto.storeId())
            .orElseThrow(() -> new RuntimeException("Store not found"));

    // Crear un nuevo ComputerModel y asociar la tienda
    ComputerModel computerModel = new ComputerModel(
            computerDto.price(),
            store, // Asociamos el StoreModel
            computerDto.brand(),
            computerDto.amountOfMemory(),
            computerDto.charactericsProcessor(),
            computerDto.operatingSystem()
    );

    // Guardamos el nuevo ordenador
    ComputerModel savedComputer = computeRepository.save(computerModel);

    // Convertir las tiendas asociadas a StoreDto para la respuesta
    List<StoreDto> storeDtos = savedComputer.getStores().stream()
        .map(s -> new StoreDto(s)) // Convertimos StoreModel a StoreDto
        .collect(Collectors.toList());

    // Creamos y devolvemos el ComputerDto con las tiendas asociadas
    return new ComputerDto(
            savedComputer.getPrice(),
            storeDtos, // Pasamos la lista de StoreDto
            savedComputer.getBrand(),
            savedComputer.getAmountOfMemory(),
            savedComputer.getCharactericsProcessor(),
            savedComputer.getOperatingSystem()
    );
}

     

    public List<ComputerModel> findByBrand(String brand) {
        List<ComputerModel> computers = computeRepository.findByBrand(brand);
        if (computers.isEmpty()) {
            throw new RuntimeException("Brand not found");
        }
        return computers;
    }

    public List<ComputerModel> getAllComputers() {
        return computeRepository.findAll();
    }

    @Transactional
    public void deleteComputersByBrand(String brand) {
        List<ComputerModel> computers = computeRepository.findByBrand(brand);
        if (computers.isEmpty()) {
            throw new RuntimeException("Brand " + brand + " not found");
        }
        computeRepository.deleteAllByBrand(brand);
    }

}
