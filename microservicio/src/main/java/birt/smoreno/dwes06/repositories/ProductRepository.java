package birt.smoreno.dwes06.repositories;

import birt.smoreno.dwes06.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * {@code ProductRepository} es una interfaz que extiende {@link JpaRepository} para realizar operaciones CRUD
 * en la entidad {@link ProductEntity}.
 * <p>
 * Esta interfaz proporciona métodos para acceder, manipular y consultar los datos de los productos almacenados
 * en la base de datos. Al extender {@code JpaRepository}, hereda operaciones comunes como {@code save}, {@code findById},
 * {@code deleteById}, entre otras.
 * </p>
 * <p>
 * Además, incluye una consulta personalizada usando JPQL (Java Persistence Query Language) para obtener productos
 * cuyo stock actual es inferior al stock mínimo, lo cual puede ser útil para mantener un control sobre los productos
 * con bajo inventario.
 * </p>
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    // Obtener productos bajo stock
    // Query con JPQL (Java Persistence Query Language)
    @Query(value = "SELECT p FROM ProductEntity p WHERE p.currentStock < p.minStock")
    List<ProductEntity> findProductUnderStock();
}
