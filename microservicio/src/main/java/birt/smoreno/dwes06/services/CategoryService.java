package birt.smoreno.dwes06.services;

import birt.smoreno.dwes06.dto.CategoryResponseDTO;
import birt.smoreno.dwes06.entities.CategoryEntity;
import birt.smoreno.dwes06.mappers.CategoryMapper;
import birt.smoreno.dwes06.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * {@code CategoryService} es una clase de servicio que gestiona la lógica de negocio relacionada con las categorías
 * en la aplicación.
 * <p>
 * Esta clase proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre las
 * categorías. Utiliza {@link CategoryRepository} para interactuar con la base de datos y realizar las operaciones
 * CRUD sobre la entidad {@link CategoryEntity}.
 * </p>
 * <p>
 * Además, {@code CategoryService} hace uso de {@link CategoryMapper} para convertir entre las entidades {@link CategoryEntity}
 * y los DTOs (Data Transfer Objects) utilizados en la API {@link CategoryResponseDTO}.
 * Esto permite separar la lógica de acceso a datos de la lógica de presentación.
 * </p>
 * <p>
 * En resumen, {@code CategoryService} se encarga de la lógica de negocios para las operaciones relacionadas con las
 * categorías y sirve como intermediario entre el controlador y el repositorio, asegurando que los datos sean manejados
 * correctamente antes de ser enviados a la base de datos o al cliente.
 * </p>
 * 
 */
@Service
public class CategoryService {

    // Instanciar el repositorio de categorías para ser utilizado en los métodos de la clase
    private final CategoryRepository categoryRepository;
    // Instanciar el mapper para convertir entre entidades y DTOs
    private final CategoryMapper productMapper;

    // Constructor que inyecta el repositorio de categorías
    // Se podría usar @Autowired, pero está desaconsejado.
    public CategoryService(CategoryRepository categoryRepository, CategoryMapper productMapper) {
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;
    }

    // Obtener todas las categorías
    public List<CategoryResponseDTO> getAllCategories() {
        List<CategoryEntity> categories = categoryRepository.findAll();
        return categories.stream()
                .map(productMapper::toResponseDTO) // Convertir cada CategoryEntity a CategoryResponseDTO
                .toList();
    }

    // Obtener una categoría por su ID
    public Optional<CategoryResponseDTO> getCategoryById(int id) {
        return categoryRepository.findById(id)
                .map(productMapper::toResponseDTO);
    }

    // Crear una nueva categoría
    public CategoryResponseDTO createCategory(CategoryEntity category) {
        CategoryEntity createdCategory = categoryRepository.save(category);
        return productMapper.toResponseDTO(createdCategory);
    }

    // Actualizar una categoría existente
    public Optional<CategoryResponseDTO> updateCategory(int id, CategoryEntity category) {
        if (categoryRepository.existsById(id)) {
            category.setId(id);
            CategoryEntity updatedCategory = categoryRepository.save(category);
            return Optional.of(productMapper.toResponseDTO(updatedCategory));
        }
        return Optional.empty();
    }

    // Eliminar una categoría por su ID
    public Optional<CategoryResponseDTO> deleteCategory(int id) {
        Optional<CategoryEntity> deletedCategory = categoryRepository.findById(id);
        if (deletedCategory.isEmpty()) {
            return Optional.empty();
        }
        categoryRepository.deleteById(id);
        return Optional.of(productMapper.toResponseDTO(deletedCategory.get()));
    }
}
