package birt.smoreno.dwes06.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

/**
 * {@code CategoryEntity} es una clase que representa la entidad de categoría en la base de datos.
 * <p>
 * Esta clase contiene cinco propiedades principales: {@code id}, {@code nombre}, {@code descripcion},
 * {@code createdAt} y {@code updatedAt}. Estas propiedades representan los atributos de una categoría
 * en el sistema.
 * </p>
 *
 * @param id          Identificador único de la categoría.
 * @param name        Nombre de la categoría.
 * @param description Descripción de la categoría.
 * @param createdAt   Fecha y hora de creación de la categoría.
 * @param updatedAt   Fecha y hora de la última actualización de la categoría.
 */
@Entity
@Table(name = "categorias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity {

    @Id
    @Column(name = "id_categoria")
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false)
    private String name;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // Relaciones. Una categoria tiene muchos productos
    @OneToMany(mappedBy = "category")
    private List<ProductEntity> products;
}
