package ar.edu.unrn.tp1.segundo;

import java.time.LocalDateTime;

public class Visa extends Tarjeta {

    private static final float DESCUENTO = 0.03f;

    public Visa(String nombre, long numero, LocalDateTime fechaVencimiento, int cvc) {
        super(nombre, numero, fechaVencimiento, cvc);
    }

    @Override
    public float calcularDescuento(float precioPlatos, float precioBebidas) {
        float precio = precioBebidas + precioPlatos;
        return precio - (precioBebidas * DESCUENTO);
    }


}
