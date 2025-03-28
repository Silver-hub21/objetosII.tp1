package ar.edu.unrn.tp1.segundo;

import java.util.ArrayList;

public class Mesa {
    private int numero;
    private ArrayList<ItemMenu> comida = new ArrayList<ItemMenu>();
    private ArrayList<ItemMenu> bebida = new ArrayList<ItemMenu>();

    public Mesa(int numero, ArrayList<ItemMenu> comida, ArrayList<ItemMenu> bebida) {
        validarNumero(numero);
        this.numero = numero;
        this.comida = comida;
        this.bebida = bebida;
    }

    public void agregarBebida(ItemMenu bebida) {
        this.bebida.add(bebida);
    }

    public void agregarComida(ItemMenu comida) {
        this.comida.add(comida);
    }

    public float precioTotalSinDescuento() {
        return this.totalComida() + this.totalBebida();
    }

    public float precioFinal(Tarjeta tarjeta, Propina propina) {
        float precioFinal = tarjeta.calcularDescuento(this.totalComida(), this.totalBebida());
        return precioFinal + (precioFinal * propina.porcentaje());
    }

    private float totalComida() {
        return comida.stream().map(ItemMenu::consultarPrecio).reduce(0f, Float::sum);
    }

    private float totalBebida() {
        return bebida.stream().map(ItemMenu::consultarPrecio).reduce(0f, Float::sum);
    }

    private void validarNumero(int numero) {
        if (numero < 1) {
            throw new IllegalArgumentException("El número de mesa no puede ser menor a 1");
        }
    }

}
