package birt.smoreno.dwes06.mappers;

import birt.smoreno.dwes06.dto.CategoryRequestDTO;
import birt.smoreno.dwes06.dto.CategoryResponseDTO;
import birt.smoreno.dwes06.entities.CategoryEntity;
import org.springframework.stereotype.Component;

/**
 * {@code CategoryMapper} es una clase que se encarga de realizar el mapeo entre las entidades de categoría
 * y los DTOs utilizados en la API.
 * <p>
 * Esta clase contiene métodos para convertir entre diferentes representaciones de la categoría:
 * <ul>
 * <li>{@code CategoryRequestDTO} a {@code CategoryEntity}, para la creación o actualización de categorías.</li>
 * <li>{@code CategoryEntity} a {@code CategoryResponseDTO}, para devolver una representación de la categoría en las respuestas.</li>
 * </ul>
 * </p>
 */
@Component
public class CategoryMapper {

    // Convertir RequestDTO a Entity
    public CategoryEntity toEntity(CategoryRequestDTO categoryRequestDTO) {
        return new CategoryEntity(
                0, // ID se asigna automáticamente
                categoryRequestDTO.getNombre(),
                categoryRequestDTO.getDescripcion(),
                null, // createdAt se asigna automáticamente
                null, // updatedAt se asigna automáticamente
                null // products se asigna automáticamente
        );
    }

    // Convertir Entity a ResponseDTO
    public CategoryResponseDTO toResponseDTO(CategoryEntity categoryEntity) {
        return new CategoryResponseDTO(
                categoryEntity.getId(),
                categoryEntity.getName(),
                categoryEntity.getDescription()
        );
    }
}
