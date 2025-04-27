package birt.smoreno.dwes06.services;

import java.util.List;

import birt.smoreno.dwes06.dto.ProductResponseDTO;
import birt.smoreno.dwes06.entities.ProductEntity;
import birt.smoreno.dwes06.exceptions.CustomException;

/**
 * {@code ProductService} es una interfaz que define los métodos necesarios para
 * gestionar la lógica de negocio relacionada con los productos en la
 * aplicación.
 * <p>
 * Esta interfaz proporciona métodos para realizar operaciones CRUD (Crear,
 * Leer, Actualizar, Eliminar) sobre los productos. Además, permite obtener
 * productos específicos bajo ciertas condiciones, como aquellos con bajo stock.
 * </p>
 */
public interface ProductService {

	/**
	 * Obtiene todos los productos.
	 * 
	 * @return Una lista de {@link ProductResponseDTO} que representan todos los
	 *         productos.
	 */
	List<ProductResponseDTO> getAllProducts();

	/**
	 * Obtiene un producto por su ID.
	 * 
	 * @param id El ID del producto que se desea obtener.
	 * @return Un {@link ProductResponseDTO} que representa el producto.
	 * @throws CustomException Si el producto no existe o ocurre algún error al
	 *                         buscar el producto.
	 */
	ProductResponseDTO getProductById(int id) throws CustomException;

	/**
	 * Crea un nuevo producto.
	 * 
	 * @param product Un objeto {@link ProductEntity} que contiene los datos del
	 *                producto a crear.
	 * @return Un {@link ProductResponseDTO} que representa el producto creado.
	 */
	ProductResponseDTO createProduct(ProductEntity product);

	/**
	 * Actualiza un producto existente.
	 * 
	 * @param id      El ID del producto que se desea actualizar.
	 * @param product Un objeto {@link ProductEntity} con los nuevos datos del
	 *                producto.
	 * @return Un {@link ProductResponseDTO} que representa el producto actualizado.
	 * @throws CustomException Si el producto no existe o ocurre algún error al
	 *                         actualizarlo.
	 */
	ProductResponseDTO updateProduct(int id, ProductEntity product) throws CustomException;

	/**
	 * Elimina un producto por su ID.
	 * 
	 * @param id El ID del producto que se desea eliminar.
	 * @return Un {@link ProductResponseDTO} que representa el producto eliminado.
	 * @throws CustomException Si el producto no existe o ocurre algún error al
	 *                         eliminarlo.
	 */
	ProductResponseDTO deleteProduct(int id) throws CustomException;

	/**
	 * Obtiene una lista de productos cuyo stock está por debajo de un nivel mínimo
	 * predefinido.
	 * 
	 * @return Una lista de {@link ProductResponseDTO} que representan los productos
	 *         con bajo stock.
	 */
	List<ProductResponseDTO> getProductsUnderStock();
}
