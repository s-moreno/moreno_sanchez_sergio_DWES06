package birt.smoreno.dwes06.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import birt.smoreno.dwes06.dto.CategoryResponseDTO;
import birt.smoreno.dwes06.entities.CategoryEntity;
import birt.smoreno.dwes06.exceptions.CustomException;
import birt.smoreno.dwes06.mappers.CategoryMapper;
import birt.smoreno.dwes06.repositories.CategoryRepository;

/**
 * {@code CategoryServiceImpl} es la implementación concreta de la interfaz
 * {@link CategoryService}. Esta clase contiene la lógica de negocio relacionada
 * con las categorías, realizando operaciones CRUD (Crear, Leer, Actualizar,
 * Eliminar) sobre las categorías.
 * <p>
 * {@code CategoryServiceImpl} interactúa con el repositorio
 * {@link CategoryRepository} para realizar operaciones sobre la base de datos y
 * con {@link CategoryMapper} para convertir entre entidades y DTOs, como
 * {@link CategoryResponseDTO}.
 * </p>
 * <p>
 * La clase maneja excepciones específicas mediante la excepción personalizada
 * {@link CustomException} para asegurar que los errores en las operaciones de
 * categorías se gestionen adecuadamente.
 * </p>
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	// Instanciar el repositorio de categorías para ser utilizado en los métodos de
	// la clase
	private final CategoryRepository categoryRepository;
	// Instanciar el mapper para convertir entre entidades y DTOs
	private final CategoryMapper categoryMapper;

	// Constructor que inyecta el repositorio de categorías y el mapper de
	// categorías. Se podría usar @Autowired, pero está desaconsejado.
	public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
		this.categoryRepository = categoryRepository;
		this.categoryMapper = categoryMapper;
	}

	// Obtener todas las categorías
	@Override
	public List<CategoryResponseDTO> getAllCategories() {
		List<CategoryEntity> categories = categoryRepository.findAll();
		return categories.stream().map(categoryMapper::toResponseDTO) // Convertir cada CategoryEntity a
																		// CategoryResponseDTO
				.toList();
	}

	// Obtener una categoría por su ID
	@Override
	public Optional<CategoryResponseDTO> getCategoryById(int id) {
		return categoryRepository.findById(id).map(categoryMapper::toResponseDTO);
	}

	// Crear una nueva categoría
	@Override
	public CategoryResponseDTO createCategory(CategoryEntity category) {
		CategoryEntity createdCategory = categoryRepository.save(category);
		return categoryMapper.toResponseDTO(createdCategory);
	}

	// Actualizar una categoría existente
	@Override
	public Optional<CategoryResponseDTO> updateCategory(int id, CategoryEntity category) {
		if (categoryRepository.existsById(id)) {
			category.setId(id);
			CategoryEntity updatedCategory = categoryRepository.save(category);
			return Optional.of(categoryMapper.toResponseDTO(updatedCategory));
		}
		return Optional.empty();
	}

	// Eliminar una categoría por su ID
	@Override
	public Optional<CategoryResponseDTO> deleteCategory(int id) {
		Optional<CategoryEntity> deletedCategory = categoryRepository.findById(id);
		if (deletedCategory.isEmpty()) {
			return Optional.empty();
		}
		categoryRepository.deleteById(id);
		return Optional.of(categoryMapper.toResponseDTO(deletedCategory.get()));
	}
}
