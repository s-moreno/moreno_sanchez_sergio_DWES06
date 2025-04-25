package birt.smoreno.dwes06.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * {@code ProductEntity} es una clase que representa la entidad de producto en la base de datos.
 * <p>
 * Esta clase contiene cinco propiedades principales: {@code id}, {@code nombre}, {@code stock_actual},
 * {@code stock_minimo} y {@code id_categoria}. Estas propiedades representan los atributos de un producto
 * en el sistema.
 * </p>
 * 
 * @param id           Identificador único del producto.
 * @param name         Nombre del producto.
 * @param currentStock Cantidad actual de unidades disponibles del producto.
 * @param minStock     Cantidad mínima de unidades que deben estar disponibles del producto.
 * @param createdAt    Fecha y hora de creación del producto.
 * @param updatedAt    Fecha y hora de la última actualización del producto.
 * @param category     {@link CategoryEntity} a la que pertenece el producto.
 * 
 */
@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

    @Id
    @Column(name = "id_producto")
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false)
    private String name;

    @Column(name = "stock_actual", nullable = false)
    private int currentStock;

    @Column(name = "stock_minimo", nullable = false)
    private int minStock;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // Relaciones. Muchos productos pertenecen a una categoria
    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private CategoryEntity category;
}
