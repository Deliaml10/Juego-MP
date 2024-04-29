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

}
