import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class TestJugador {
    @Test

    public void testCrearNumeroRegistro() {
        Jugador jugador = new Jugador("Nombre", "Contraseña", "Nick");
        String numeroRegistro = jugador.crearNumeroRegistro();

        assertEquals("La longitud del número de registro es incorrecta", 5, numeroRegistro.length());

        assertTrue("El primer carácter del número de registro no es una letra", Character.isLetter(numeroRegistro.charAt(0)));

        assertTrue("Los siguientes dos caracteres no son dígitos", Character.isDigit(numeroRegistro.charAt(1)));
        assertTrue("Los siguientes dos caracteres no son dígitos", Character.isDigit(numeroRegistro.charAt(2)));

        assertTrue("Los últimos dos caracteres no son letras", Character.isLetter(numeroRegistro.charAt(3)));
        assertTrue("Los últimos dos caracteres no son letras", Character.isLetter(numeroRegistro.charAt(4)));

        System.out.println("Las pruebas para el método crearNumeroRegistro han pasado correctamente.");

    }
    
    @Test
    public void testConsultarOro() {
        // Crear dos jugadores y sus personajes
        Jugador jugador1 = new Jugador("Jugador1", "Contraseña1", "Nick1");
        Jugador jugador2 = new Jugador("Jugador2", "Contraseña2", "Nick2");
        Personaje personaje1 = new Personaje("Personaje1", 1, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Personaje personaje2 = new Personaje("Personaje2", 1, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        jugador1.registrarPersonaje(personaje1);
        jugador2.registrarPersonaje(personaje2);

        Combate combate = new Combate(jugador1, jugador2, 30);

        int resultadoJugador1 = 1;
        int resultadoJugador2 = 0;

        if (resultadoJugador1 == 1) {
            // Jugador 1 ganó el combate
            personaje1.incrementarOroGanado(30);
            personaje2.incrementarOroPerdido(30);
            personaje1.incrementarOroPerdido(0);
            personaje2.incrementarOroGanado(0);
        }

        jugador1.consultarOro();
        jugador2.consultarOro();

        assertEquals(30, personaje1.getOroGanado());
        assertEquals(0, personaje1.getOroPerdido());
        assertEquals(0, personaje2.getOroGanado());
        assertEquals(30, personaje2.getOroPerdido());

        System.out.println("Las pruebas para el método consultarOro han pasado correctamente.");
    }

    @Test
    public void testRegistrarPersonaje() {
        Jugador jugador = new Jugador("Nombre", "Contraseña", "Nick");
        Personaje personaje = new Personaje("NombrePersonaje", 1, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        jugador.registrarPersonaje(personaje);
        assertEquals(personaje, jugador.getPersonaje());
    }

    @Test
    public void testEquipar() {
        Jugador jugador = new Jugador("Nombre", "Contraseña", "Nick");
        Arma arma = new Arma("Espada", 1, 1, true);
        Arma arma2 = new Arma("Daga", 1, 3, true);

        ArrayList<Arma> armas = new ArrayList<>();
        ArrayList<Armadura> armaduras = new ArrayList<>();

        armas.add(arma);
        armas.add(arma2);
        arma.setEquipada(true);
        arma2.setEquipada(true);

        Personaje personaje = new Personaje("NombrePersonaje", 1, new ArrayList<>(), armas, armaduras, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        jugador.registrarPersonaje(personaje);

        ByteArrayInputStream in = new ByteArrayInputStream("1\n1\nEspada\n2\n2\n3\n3\n".getBytes());
        System.setIn(in);

        jugador.equipar(personaje);


        assertTrue(arma.getEquipada());
        assertTrue(arma2.getEquipada());

    }

}

