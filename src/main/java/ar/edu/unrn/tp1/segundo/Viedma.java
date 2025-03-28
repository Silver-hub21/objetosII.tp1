package ar.edu.unrn.tp1.segundo;

import java.time.LocalDateTime;

public class Viedma extends Tarjeta {

    public Viedma(String nombre, long numero, LocalDateTime fechaVencimiento, int cvc) {

        super(nombre, numero, fechaVencimiento, cvc);
    }

    @Override
    public float calcularDescuento(float precioPlatos, float precioBebidas) {
        return precioBebidas + precioPlatos;
    }

}
