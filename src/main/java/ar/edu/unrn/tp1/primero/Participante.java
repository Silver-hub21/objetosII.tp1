package ar.edu.unrn.tp1.primero;

public class Participante {
    private String nombre;
    private String apellido;
    private double puntaje;

    public Participante(String nombre, String apellido, double puntaje) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.puntaje = 0;
    }

    public void sumarPuntos(double puntos) {
        this.puntaje += puntos;
    }

    public void restarPuntos(double puntos) {
        this.puntaje -= puntos;
    }


}
