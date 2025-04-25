package birt.smoreno.dwes06.controllers;

import birt.smoreno.dwes06.dto.ApiResponseDTO;
import birt.smoreno.dwes06.dto.ProductRequestDTO;
import birt.smoreno.dwes06.dto.ProductResponseDTO;
import birt.smoreno.dwes06.entities.ProductEntity;
import birt.smoreno.dwes06.exceptions.CustomException;
import birt.smoreno.dwes06.mappers.ProductMapper;
import birt.smoreno.dwes06.services.ProductService;
import birt.smoreno.dwes06.utils.AppConstants;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * {@code ProductController} es un controlador REST que gestiona las operaciones CRUD
 * para la entidad {@link ProductEntity}.
 * <p>
 * Proporciona endpoints para crear, leer, actualizar, eliminar productos y obtener todos los productos que están por debajo de su mínimo.
 * </p>
 <ul>
 *   <li>{@link #getAllProducts()}: Obtiene todos los productos.</li>
 *   <li>{@link #getProductById(Long)}: Obtiene un producto por su ID.</li>
 *   <li>{@link #createProduct(ProductRequestDTO)}: Crea un nuevo producto.</li>
 *   <li>{@link #updateProduct(Long, ProductRequestDTO)}: Actualiza un producto existente.</li>
 *   <li>{@link #deleteProduct(Long)}: Elimina un producto por su ID.</li>
 *   <li>{@link #getProductsUnderStock()}: Obtiene los productos cuyo stock está por debajo del mínimo.</li>
 * </ul>
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
	this.productService = productService;
	this.productMapper = productMapper;
    }

    // CRUD básico: Create, Read, Update, Delete

    // Obtener todos los productos
    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<ProductResponseDTO>>> getAllProducts() {
	List<ProductResponseDTO> products = productService.getAllProducts();
	return ResponseEntity.ok(new ApiResponseDTO<>(AppConstants.STATUS_SUCCESS, HttpStatus.OK.value(),
		"Productos obtenidos correctamente", products));
    }

    // Obtener un producto por su ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<ProductResponseDTO>> getProductById(@PathVariable int id) {
	try {
	    ProductResponseDTO product = productService.getProductById(id);
	    return ResponseEntity.ok(new ApiResponseDTO<>(AppConstants.STATUS_SUCCESS, HttpStatus.OK.value(),
		    "Producto encontrado", product));
	} catch (CustomException e) {
	    return ResponseEntity.status(e.getHttpStatusCode())
		    .body(new ApiResponseDTO<>(AppConstants.STATUS_ERROR, e.getHttpStatusCode(), e.getMessage(), null));
	}
    }

    // Crear un nuevo producto
    @PostMapping
    public ResponseEntity<ApiResponseDTO<ProductResponseDTO>> createProduct(
	    @Valid @RequestBody ProductRequestDTO productDTO) {

	// Convertir ProductRequestDTO a ProductEntity
	ProductEntity product = productMapper.toEntity(productDTO);
	// Crear el producto
	ProductResponseDTO createdProduct = productService.createProduct(product);
	return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponseDTO<>(AppConstants.STATUS_SUCCESS,
		HttpStatus.CREATED.value(), "Producto creado correctamente", createdProduct));
    }

    // Actualizar un producto existente
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<ProductResponseDTO>> updateProduct(@PathVariable int id,
	    @Valid @RequestBody ProductRequestDTO productDTO) {
	try {
	    ProductEntity product = productMapper.toEntity(productDTO);
	    ProductResponseDTO updatedProduct = productService.updateProduct(id, product);
	    return ResponseEntity.ok(new ApiResponseDTO<>(AppConstants.STATUS_SUCCESS, HttpStatus.OK.value(),
		    "Producto actualizado correctamente", updatedProduct));
	} catch (CustomException e) {
	    return ResponseEntity.status(e.getHttpStatusCode())
		    .body(new ApiResponseDTO<>(AppConstants.STATUS_ERROR, e.getHttpStatusCode(), e.getMessage(), null));
	}
    }

    // Eliminar un producto por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<ProductResponseDTO>> deleteProduct(@PathVariable int id) {
	try {
	    ProductResponseDTO deletedProduct = productService.deleteProduct(id);
	    return ResponseEntity.ok(new ApiResponseDTO<>(AppConstants.STATUS_SUCCESS, HttpStatus.OK.value(),
		    "Producto eliminado correctamente", deletedProduct));
	} catch (CustomException e) {
	    return ResponseEntity.status(e.getHttpStatusCode())
		    .body(new ApiResponseDTO<>(AppConstants.STATUS_ERROR, e.getHttpStatusCode(), e.getMessage(), null));
	}
    }

    // Obtener productos por debajo de su stock mínimo
    @GetMapping("/min")
    public ResponseEntity<ApiResponseDTO<List<ProductResponseDTO>>> getProductsUnderStock() {
	List<ProductResponseDTO> productsUnderStock = productService.getProductsUnderStock();
	return ResponseEntity.ok(new ApiResponseDTO<>(AppConstants.STATUS_SUCCESS, HttpStatus.OK.value(),
		"Productos que están por debajo de su stock mínimo establecido", productsUnderStock));
    }
}
