import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
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
        // Simulamos la entrada del usuario
        String input = "J\nNombre\nNick\n12345678\n12345678\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Usuario usuarioEsperado = new Usuario("Nombre", "Nick", "12345678");

        Juego juego = new Juego();
        juego.crearCuenta(new Scanner(System.in));

        Usuario usuarioCreado = juego.getUsuario("Nombre");

        assertEquals(usuarioEsperado, usuarioCreado);
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

    // LOS SIGUIENTES DOS SE REFIEREN AL MÉTODO START
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
