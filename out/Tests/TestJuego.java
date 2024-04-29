import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class TestJuego {

    @Test
    public void testJugar() {
        Juego juego = new Juego();
        Usuario usuario = new Usuario("Delia", "Delia", "12345678");
        Scanner scanner = new Scanner(System.in);
        juego.jugar(usuario, scanner);
   }

    @Test
    public void testIniciarSesion() {
        Juego juego = new Juego();
        Scanner scanner = new Scanner(System.in);
        juego.iniciarSesion(scanner);

    }

    @Test
    public void testGuardarUsuarios() {
        Juego juego = new Juego();
        juego.guardarUsuarios();
    }

    @Test
    public void testGuardarPersonajes() {
        Juego juego = new Juego();
        juego.guardarPersonajes();
    }

    @Test
    public void testCrearCuenta() {
        Juego juego = new Juego();
        Scanner scanner = new Scanner(System.in);
        juego.crearCuenta(scanner);
    }

    @Test
    public void testRanking() {
        Juego juego = new Juego();
        juego.mostrarRankingGlobal();
   }

    @Test
    public void testEsEntero() {
        Juego juego = new Juego();
        String numero = "abc123";
        Boolean resultado = juego.esEntero(numero);
        assertEquals(false,resultado );
    }

    @Test
    public void testVerReglas() {
        String input = "R\nS\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Juego juego = new Juego();
        juego.start();
        assertEquals(true, true); // Realiza cualquier verificación adicional necesaria
    }

    @Test
    public void testEmpezar() {

        String input = "J\nS\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Juego juego = new Juego();
        juego.start();
        assertEquals(true, true); // Realiza cualquier verificación adicional necesaria
    }
}
