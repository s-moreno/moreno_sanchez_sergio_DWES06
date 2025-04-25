package birt.smoreno.dwes06.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * {@code CategoryRequestDTO} es una clase que representa la estructura de datos para la solicitud de creación o actualización de una categoría.
 * <p>
 * Esta clase contiene cuatro propiedades principales: {@code nombre}, {@code stock_actual}, {@code stock_minimo} y {@code id_categoria}, que
 * representan los atributos básicos de un producto.
 * </p>
 *
 * @param nombre      Nombre de la categoría.
 * @param descripcion Descripción de la categoría.	
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductRequestDTO {
        @NotBlank(message = "El nombre es obligatorio")
        @Size(max = 255, message = "El nombre no puede superar los 255 caracteres")
        String nombre;
        @NotNull(message = "El stock actual es obligatorio")
        @Min(value = 0, message = "El stock actual debe ser mayor o igual a cero")
        Integer stock_actual;
        @NotNull(message = "El stock mínimo es obligatorio")
        @Min(value = 1, message = "El stock mínimo debe ser mayor que cero")
        Integer stock_minimo;
        @Min(value = 1, message = "La categoría debe ser mayor que cero")
        Integer id_categoria;
}
