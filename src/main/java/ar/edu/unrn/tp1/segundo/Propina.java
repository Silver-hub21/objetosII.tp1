package ar.edu.unrn.tp1.segundo;

public enum Propina {
    BAJO(0.02f),
    MEDIO(0.03f),
    ALTO(0.05f);

    private final float porcentajeDelPrecio;

    Propina(float porcentaje) {
        this.porcentajeDelPrecio = porcentaje;
    }

    public float porcentaje() {
        return porcentajeDelPrecio;
    }
    
}
