package ar.edu.unrn.tp1.primero;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Concurso {
    private LocalDateTime fecha_inicio;
    private LocalDateTime fecha_cierre;
    private ArrayList<Inscripcion> inscripciones;

    public Concurso(LocalDateTime fecha_inicio, LocalDateTime fecha_cierre, ArrayList<Inscripcion> inscripciones) {
        this.fecha_inicio = fecha_inicio;
        this.fecha_cierre = fecha_cierre;
        this.inscripciones = inscripciones;
    }

    public boolean estaInscripto(Participante participante) {
        return inscripciones.stream()
                .anyMatch(inscripcion -> inscripcion.esElParticipante(participante));
    }


    public void inscribir(Inscripcion nuevaInscripcion) throws RuntimeException {
        if (nuevaInscripcion.estaEnFecha(fecha_inicio, fecha_cierre)) {
            inscripciones.add(nuevaInscripcion);
            nuevaInscripcion.esMismaFecha(fecha_inicio);
        } else {
            throw new RuntimeException("El plazo de inscripción ya finalizó.");
        }
    }
    
}
