package ar.edu.unrn.tp1.segundo;

public class ItemMenu {
    private String nombre;
    private float precio;
    private String descripcion;

    public ItemMenu(String nombre, float precio, String descripcion) {
        validarDescripcion(descripcion);
        validarNombre(nombre);
        validarPrecio(precio);
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public float consultarPrecio() {
        return this.precio;
    }

    private void validarNombre(String nombre) {
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
    }

    private void validarPrecio(float precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio no puede ser menor o igual a cero");
        }
    }

    private void validarDescripcion(String descripcion) {
        if (descripcion.isBlank()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía");
        }
    }

}
