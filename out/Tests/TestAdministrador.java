import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class TestAdministrador {

    @Test
    public void TestCrearTalento() {
        String input = "2\n3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Administrador administrador = new Administrador("Nombre", "Nombre", "12345678");
        administrador.crearTalento("Pelea");
        Talento talento = new Talento("Pelea");

        assertEquals("Pelea", "Pelea");

    }

    @Test
    public void TestCrearDon() {
        String input = "2\n3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Administrador administrador = new Administrador("Nombre", "Nombre", "12345678");
        administrador.crearDon("Volar");
        Don don = new Don("Volar", 2, 3);
        assertEquals("Volar", "Volar");
        assertEquals(2, don.getValorDon());
        assertEquals(3, don.getRabia());
    }


    @Test
    public void testCrearDisciplina() {

        String input = "1\n2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Administrador administrador = new Administrador("Nombre", "Nombre", "12345678");
        Disciplina disciplina = administrador.crearDisciplina("Correr");

        assertEquals("Correr", "Correr");
        assertEquals(1, disciplina.getValorDisciplina());
        assertEquals(2, disciplina.getSangreNecesaria());
    }

    @Test
    public void TestBloquearUsuario(){
        Administrador administrador = new Administrador("Nombre", "Nombre", "12345678");
        Jugador jugador = new Jugador("Nombres", "12345678" ,"Nombres");
        administrador.bloquearUsuario(jugador);
        assertTrue(jugador.getBloqueado());
    }

    @Test
    public void testDesbloquearUsuario(){
        Administrador administrador = new Administrador("Nombre", "Nombre", "12345678");
        Jugador jugador = new Jugador("Nombres", "12345678" ,"Nombres");
        jugador.setBloqueado(true);
        administrador.desbloquearUsuario(jugador);
        assertFalse(jugador.getBloqueado());
    }
    @Test
    public void testAddDesafioPendienteComun() {
        Jugador jugador1 = new Jugador("Nombre1", "12345678", "Nombre1");
        Jugador jugador2 = new Jugador("Nombre2", "12345678", "Nombre2");

        Combate combate = new Combate(jugador1, jugador2, 30);

        Administrador.addDesafioPendienteComun(combate);

        ArrayList<Combate> desafiosPendientesComunes = new Administrador("admin", "admin", "admin").getDesafiosPendientesComunes();

        assertEquals(true, desafiosPendientesComunes.contains(combate));
    }



}
