package ar.edu.unrn.tp1.primero;

import java.time.LocalDateTime;

public class Inscripcion {
    private LocalDateTime fecha;
    private Participante inscripto;

    public Inscripcion(LocalDateTime fecha, Participante inscripto) {
        this.fecha = fecha;
        this.inscripto = inscripto;
    }

    public boolean estaEnFecha(LocalDateTime fechaInicioConcurso, LocalDateTime fechaCierreConcurso) {
        return this.fecha.isBefore(fechaCierreConcurso) && (this.fecha.isEqual(fechaInicioConcurso) || (this.fecha.isAfter(fechaInicioConcurso)));
    }


    public boolean esElParticipante(Participante participante) {
        return this.inscripto.equals(participante);
    }

    public void esMismaFecha(LocalDateTime fechaInicio) {
        if (this.fecha.toLocalDate().atStartOfDay().equals(fechaInicio.toLocalDate().atStartOfDay())) {
            inscripto.sumarPuntos(10);
        }
    }

}
