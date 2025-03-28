package ar.edu.unrn.tp1.segundo;

import java.time.LocalDateTime;

public abstract class Tarjeta {
    private String nombre;
    private long numero;
    private LocalDateTime fechaVencimiento;
    private int cvc;

    public Tarjeta(String nombre, long numero, LocalDateTime fechaVencimiento, int cvc) {
        validarNombre(nombre);
        validarCVC(cvc);
        validarNumero(numero);
        validarFechaVencimiento(fechaVencimiento);
        this.nombre = nombre;
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
        this.cvc = cvc;
    }

    private void validarNumero(long numero) {
        String numeroStr = Long.toString(numero); // Convertir el número a String
        int longitud = numeroStr.length();

        if (longitud < 13 || longitud > 19) {
            throw new IllegalArgumentException("El número de tarjeta debe tener entre 13 y 19 dígitos.");
        }
    }

    private void validarFechaVencimiento(LocalDateTime fechaVencimiento) {
        if (fechaVencimiento.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("La tarjeta está vencida.");
        }
    }

    private void validarCVC(int cvc) {
        if (cvc < 100 || cvc > 999) {
            throw new IllegalArgumentException("El CVC debe ser un número de 3 dígitos.");
        }
    }

    private void validarNombre(String nombre) {
        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
    }

    public abstract float calcularDescuento(float precioPlatos, float precioBebidas);

}
