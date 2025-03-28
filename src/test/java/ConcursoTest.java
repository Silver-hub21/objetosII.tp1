import ar.edu.unrn.tp1.primero.Concurso;
import ar.edu.unrn.tp1.primero.Inscripcion;
import ar.edu.unrn.tp1.primero.Participante;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ConcursoTest {
    @Test
    public void participanteInvalido() {
        var exception = assertThrows(IllegalArgumentException.class, () -> new Participante("", "", 0));
        assertEquals("El nombre y/o apellido no pueden estar vacíos", exception.getMessage());

    }

    @Test
    public void verificarInscripcion() {
        var primerParticipante = new Participante("Tomas", "Acosta", 0);
        var inscripcion = new Inscripcion(LocalDateTime.now(), primerParticipante);

        LocalDateTime haceCincoDias = LocalDateTime.now().minusDays(5);
        LocalDateTime dentroDeDiezDias = LocalDateTime.now().plusDays(10);

        var inscripciones = new ArrayList<Inscripcion>();
        Concurso unConcurso = new Concurso(haceCincoDias, dentroDeDiezDias, inscripciones);

        unConcurso.inscribir(inscripcion);
        assertTrue(unConcurso.estaInscripto(primerParticipante));
    }

    @Test
    public void inscripcionInvalida() {
        LocalDateTime haceCincoDias = LocalDateTime.now().minusDays(5);
        LocalDateTime dentroDeDiezDias = LocalDateTime.now().plusDays(10);

        var primerParticipante = new Participante("Tomas", "Acosta", 0);
        var inscripcion = new Inscripcion(LocalDateTime.now().plusDays(15), primerParticipante);

        var inscripciones = new ArrayList<Inscripcion>();
        Concurso unConcurso = new Concurso(haceCincoDias, dentroDeDiezDias, inscripciones);

        var exception = assertThrows(RuntimeException.class, () -> unConcurso.inscribir(inscripcion));
        assertEquals("El plazo de inscripción ya finalizó.", exception.getMessage());
    }

    @Test
    public void inscripcionPrimerDia() {
        LocalDateTime dentroDeTreintaDiaz = LocalDateTime.now().plusDays(30);
        var inscripciones = new ArrayList<Inscripcion>();
        Concurso unConcurso = new Concurso(LocalDateTime.now(), dentroDeTreintaDiaz, inscripciones);

        var primerParticipante = new Participante("Tomas", "Acosta", 0);
        var inscripcion = new Inscripcion(LocalDateTime.now(), primerParticipante);

        unConcurso.inscribir(inscripcion);
        assertTrue(unConcurso.estaInscripto(primerParticipante));
        assertEquals(10, primerParticipante.puntaje());
    }

}
