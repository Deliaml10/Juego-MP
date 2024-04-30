import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;
public class TestPersonaje {
    @Test
    public void testConstructorPersonaje() {
        // Crear datos de prueba
        String nombre = "Personaje de Prueba";
        int tipo = 1;
        ArrayList<Habilidad> habilidades = new ArrayList<>();
        ArrayList<Arma> armas = new ArrayList<>();
        ArrayList<Armadura> armaduras = new ArrayList<>();
        ArrayList<Esbirro> esbirros = new ArrayList<>();
        ArrayList<Debilidad> debilidades = new ArrayList<>();
        ArrayList<Fortaleza> fortalezas = new ArrayList<>();

        // Crear el personaje
        Personaje personaje = new Personaje(nombre, tipo, habilidades, armas, armaduras, esbirros, debilidades, fortalezas);

        // Verificar que los atributos se inicializan correctamente
        assertEquals(nombre, personaje.getNombrePersonaje());
        assertEquals(tipo, personaje.getTipoPersonaje());
        assertEquals(100, personaje.getOro());
        assertEquals(5, personaje.getSalud());
        assertEquals(5, personaje.getPoder());
        assertEquals(0, personaje.getArmas().size());
        assertEquals(0, personaje.getArmaduras().size());
        assertEquals(0, personaje.getManosOcupadas());
        assertEquals(0, personaje.getEsbirros().size());
        assertEquals(0, personaje.getDebilidades().size());
        assertEquals(0, personaje.getFortalezas().size());
        assertFalse(personaje.getOcupado());
    }

    @Test
    public void testIncrementarOroGanado() {
        // Crear un personaje de prueba
        Personaje personaje = new Personaje("Personaje de Prueba", 1, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        // Incrementar el oro ganado
        int cantidad = 50;
        personaje.incrementarOroGanado(cantidad);

        // Verificar que el oro ganado se ha incrementado correctamente
        assertEquals(cantidad, personaje.getOroGanado());
    }

    @Test
    public void testIncrementarOroPerdido() {
        // Crear un personaje de prueba
        Personaje personaje = new Personaje("Personaje de Prueba", 1, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        // Incrementar el oro perdido
        int cantidad = 30;
        personaje.incrementarOroPerdido(cantidad);

        // Verificar que el oro perdido se ha incrementado correctamente
        assertEquals(cantidad, personaje.getOroPerdido());
    }

    @Test
    public void testRestarOro() {
        // Crear un personaje de prueba
        Personaje personaje = new Personaje("Personaje de Prueba", 1, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        int oroInicial = 100;

        // Restar una cantidad de oro
        int cantidad = 30;
        personaje.restarOro(cantidad);

        // Verificar que el oro se ha restado correctamente
        assertEquals(oroInicial - cantidad, personaje.getOro());
    }

    @Test
    public void testIncrementarOro() {
        // Crear un personaje de prueba
        Personaje personaje = new Personaje("Personaje de Prueba", 1, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        int oroInicial = 100;

        // Incrementar el oro
        int cantidad = 50;
        personaje.incrementarOro(cantidad);

        // Verificar que el oro se ha incrementado correctamente
        assertEquals(oroInicial + cantidad, personaje.getOro());
    }

    @Test
    public void testSumarArmasActivas() {
        // Crear un personaje de prueba
        Personaje personaje = new Personaje("Personaje de Prueba", 1, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        
        // Asegurar que inicialmente no hay armas activas
        assertEquals(0, personaje.getArmasActivas());

        // Llamar al método para sumar armas activas
        personaje.sumarArmasActivas();

        // Verificar que se ha sumado una arma activa
        assertEquals(1, personaje.getArmasActivas());
    }

    @Test
    public void testRestarArmasActivas() {
        // Crear un personaje de prueba con una cantidad inicial de armas activas
        Personaje personaje = new Personaje("Personaje de Prueba", 1, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        personaje.sumarArmasActivas();
        personaje.sumarArmasActivas();

        // Asegurar que hay 2 armas activas inicialmente
        assertEquals(2, personaje.getArmasActivas());

        // Llamar al método para restar armas activas
        personaje.restarArmasActivas();

        // Verificar que se ha restado una arma activa
        assertEquals(1, personaje.getArmasActivas());
    }

    @Test
    public void testSumarArmadurasActivas() {
        // Crear un personaje de prueba con una cantidad inicial de armas activas
        Personaje personaje = new Personaje("Personaje de Prueba", 1, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        // Comprobamos que el valor inicial de armadurasActivas sea 0
        assertEquals(0, personaje.getArmadurasActivas());

        // Llamamos al método para sumar una armadura activa
        personaje.sumarArmadurasActivas();

        // Comprobamos que armadurasActivas se haya incrementado a 1
        assertEquals(1, personaje.getArmadurasActivas());
    }

    @Test
    public void testRestarArmadurasActivas() {
        // Crear un personaje de prueba con una cantidad inicial de armas activas
        Personaje personaje = new Personaje("Personaje de Prueba", 1, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        // Establecemos un valor inicial de armadurasActivas diferente de cero para el test
        personaje.sumarArmadurasActivas();
        personaje.sumarArmadurasActivas();

        // Comprobamos que el valor inicial de armadurasActivas sea 2
        assertEquals(2, personaje.getArmadurasActivas());

        // Llamamos al método para restar una armadura activa
        personaje.restarArmadurasActivas();

        // Comprobamos que armadurasActivas se haya decrementado a 1
        assertEquals(1, personaje.getArmadurasActivas());
    }
}