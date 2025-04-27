package birt.smoreno.dwes06.services;

import java.util.List;
import java.util.Optional;

import birt.smoreno.dwes06.dto.CategoryResponseDTO;
import birt.smoreno.dwes06.entities.CategoryEntity;

/**
 * {@code CategoryService} es una interfaz que define los métodos necesarios
 * para gestionar la lógica de negocio relacionada con las categorías en la
 * aplicación.
 * <p>
 * Esta interfaz proporciona métodos para realizar operaciones CRUD (Crear,
 * Leer, Actualizar, Eliminar) sobre las categorías.
 * </p>
 */
public interface CategoryService {

	/**
	 * Obtiene todas las categorías.
	 * 
	 * @return Una lista de {@link CategoryResponseDTO} que representan todas las
	 *         categorías.
	 */
	List<CategoryResponseDTO> getAllCategories();

	/**
	 * Obtiene una categoría por su ID.
	 * 
	 * @param id El ID de la categoría que se desea obtener.
	 * @return Un {@link CategoryResponseDTO} que representa la categoría.
	 */
	Optional<CategoryResponseDTO> getCategoryById(int id);

	/**
	 * Crea una nueva categoría.
	 * 
	 * @param category Un objeto {@link CategoryEntity} que contiene los datos de la
	 *                 categoría a crear.
	 * @return Un {@link CategoryResponseDTO} que representa la categoría creada.
	 */
	CategoryResponseDTO createCategory(CategoryEntity category);

	/**
	 * Actualiza una categoría existente.
	 * 
	 * @param id       El ID de la categoría que se desea actualizar.
	 * @param category Un objeto {@link CategoryEntity} con los nuevos datos de la
	 *                 categoría.
	 * @return Un {@link CategoryResponseDTO} que representa la categoría
	 *         actualizada.
	 */
	Optional<CategoryResponseDTO> updateCategory(int id, CategoryEntity category);

	/**
	 * Elimina una categoría existente.
	 * 
	 * @param id El ID de la categoría que se desea eliminar.
	 * @return Un {@link CategoryResponseDTO} que representa la categoría eliminada.
	 */
	Optional<CategoryResponseDTO> deleteCategory(int id);
}