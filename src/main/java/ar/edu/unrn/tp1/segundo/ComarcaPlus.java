package ar.edu.unrn.tp1.segundo;

import java.time.LocalDateTime;

public class ComarcaPlus extends Tarjeta {
    private static final float DESCUENTO = 0.02f;

    public ComarcaPlus(String nombre, long numero, LocalDateTime fechaVencimiento, int cvc) {
        super(nombre, numero, fechaVencimiento, cvc);
    }

    @Override
    public float calcularDescuento(float precioPlatos, float precioBebidas) {
        float precio = precioBebidas + precioPlatos;
        return precio - (precio * DESCUENTO);
    }

}
