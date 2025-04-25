package birt.smoreno.dwes06.utils;

/**
 * {@code AppConstants} es una clase que contiene constantes utilizadas en la aplicación.
 */
public class AppConstants {
    public static final String STATUS_SUCCESS = "success";
    public static final String STATUS_ERROR = "error";
    
    /**
     * Constructor privado para evitar la instanciación de la clase {@code AppConstants}.
     * 
     * Dado que {@code AppConstants} solo contiene constantes estáticas, no es necesario instanciarla.
     */
    private AppConstants() {
        // Previene la creación de instancias de esta clase
        throw new UnsupportedOperationException("No se puede instanciar la clase AppConstants.");
    }
}
