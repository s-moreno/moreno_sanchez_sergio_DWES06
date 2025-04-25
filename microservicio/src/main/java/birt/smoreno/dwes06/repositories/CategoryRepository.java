package birt.smoreno.dwes06.repositories;

import birt.smoreno.dwes06.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * {@code CategoryRepository} es una interfaz que extiende {@link JpaRepository} para realizar operaciones
 * CRUD (Crear, Leer, Actualizar, Eliminar) sobre la entidad {@link CategoryEntity}.
 * <p>
 * Al extender {@code JpaRepository}, {@code CategoryRepository} hereda los métodos básicos para manipular los
 * datos de las categorías en la base de datos, como {@code save}, {@code findById}, {@code deleteById}, y otros.
 * </p>
 * <p>
 * Este repositorio permite acceder, modificar y eliminar registros relacionados con categorías dentro de la base
 * de datos, y puede ser utilizado para implementar la lógica de negocio relacionada con las categorías de productos
 * u otros elementos en la aplicación.
 * </p>
 */
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}
