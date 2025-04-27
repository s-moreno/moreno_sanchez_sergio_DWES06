package birt.smoreno.dwes06.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import birt.smoreno.dwes06.dto.ProductResponseDTO;
import birt.smoreno.dwes06.entities.ProductEntity;
import birt.smoreno.dwes06.exceptions.CustomException;
import birt.smoreno.dwes06.mappers.ProductMapper;
import birt.smoreno.dwes06.repositories.ProductRepository;

/**
 * {@code ProductServiceImpl} es la implementación concreta de la interfaz
 * {@link ProductService}. Esta clase contiene la lógica de negocio relacionada
 * con los productos, realizando operaciones CRUD (Crear, Leer, Actualizar,
 * Eliminar) y gestionando los productos que tienen un stock bajo.
 * <p>
 * {@code ProductServiceImpl} interactúa con el repositorio
 * {@link ProductRepository} para realizar operaciones sobre la base de datos y
 * con {@link ProductMapper} para convertir entre entidades y DTOs, como
 * {@link ProductResponseDTO}.
 * </p>
 * <p>
 * La clase maneja excepciones específicas mediante la excepción personalizada
 * {@link CustomException} para asegurar que los errores en las operaciones de
 * productos se gestionen adecuadamente.
 * </p>
 */
@Service
public class ProductServiceImpl implements ProductService {

	// Instanciar el repositorio de productos para ser utilizado en los métodos de
	// la clase
	private final ProductRepository productRepository;
	// Instanciar el mapper de productos para ser utilizado en los métodos de la
	// clase
	private final ProductMapper productMapper;

	// Constructor que inyecta el repositorio de productos
	// Se podría usar @Autowired, pero está desaconsejado.
	public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
		this.productRepository = productRepository;
		this.productMapper = productMapper;
	}

	// Obtener todos los productos
	@Override
	public List<ProductResponseDTO> getAllProducts() {
		List<ProductEntity> products = productRepository.findAll();
		return products.stream().map(productMapper::toResponseDTO).toList();
	}

	// Obtener un producto por su ID
	public ProductResponseDTO getProductById(int id) throws CustomException {
		Optional<ProductEntity> productOptional = productRepository.findById(id);

		if (productOptional.isPresent()) {
			ProductEntity product = productOptional.get();
			return productMapper.toResponseDTO(product);
		} else {
			throw new CustomException("Producto no encontrado", HttpStatus.NOT_FOUND.value());
		}

	}

	// Crear un nuevo producto
	@Override
	public ProductResponseDTO createProduct(ProductEntity product) {
		ProductEntity createdProduct = productRepository.save(product);
		return productMapper.toResponseDTO(createdProduct);
	}

	// Actualizar un producto existente
	@Override
	public ProductResponseDTO updateProduct(int id, ProductEntity product) throws CustomException {
		if (productRepository.existsById(id)) {
			product.setId(id);
			ProductEntity updatedProduct = productRepository.save(product);
			return productMapper.toResponseDTO(updatedProduct);
		} else {
			throw new CustomException("Producto no encontrado", HttpStatus.NOT_FOUND.value());
		}
	}

	// Eliminar un producto por su ID
	@Override
	public ProductResponseDTO deleteProduct(int id) throws CustomException {
		Optional<ProductEntity> productOptional = productRepository.findById(id);

		if (productOptional.isPresent()) {
			ProductEntity product = productOptional.get();
			productRepository.delete(product);
			return productMapper.toResponseDTO(product);
		} else {
			throw new CustomException("Producto no encontrado", HttpStatus.NOT_FOUND.value());
		}
	}

	// Obtener productos bajo stock
	@Override
	public List<ProductResponseDTO> getProductsUnderStock() {
		return productRepository.findProductUnderStock().stream().map(productMapper::toResponseDTO).toList();
	}

}
