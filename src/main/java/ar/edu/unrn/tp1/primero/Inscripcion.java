package ar.edu.unrn.tp1.primero;

import java.time.LocalDateTime;

public class Inscripcion {
    private LocalDateTime fecha;
    private Participante inscripto;

    public Inscripcion(LocalDateTime fecha, Participante inscripto) {
        this.fecha = fecha;
        this.inscripto = inscripto;
    }

    public boolean estaEnFecha(LocalDateTime fechaCierreConcurso) {
        return this.fecha.isBefore(fechaCierreConcurso);
    }


}
