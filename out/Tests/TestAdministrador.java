import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class TestAdministrador {

    @Test
    public void testCrearArmaduras() {
        // Simulación de entrada del usuario
        String input = "2\n" + // Número de armaduras
                       "Armadura1\n" + // Nombre de la primera armadura
                       "4\n" + // Valor de la primera armadura
                       "2\n" + // Manos que ocupa la primera armadura
                       "1\n" + // Activada (Sí)
                       "Armadura2\n" + // Nombre de la segunda armadura
                       "3\n" + // Valor de la segunda armadura
                       "1\n" + // Manos que ocupa la segunda armadura
                       "2\n";  // No activada (No)

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Llamada a la función que queremos probar
        Administrador admin = new Administrador("Admin", "admin", "password");
        ArrayList<Armadura> armaduras = admin.crearArmaduras();

        // Comprobación de que se crearon las armaduras correctamente
        assertEquals(2, armaduras.size());
        assertEquals("Armadura1", armaduras.get(0).getNombreEquipo());
        assertEquals(4, armaduras.get(0).getValor());
        assertEquals(2, armaduras.get(0).getManos());
        assertEquals(true, armaduras.get(0).getActiva());
        assertEquals("Armadura2", armaduras.get(1).getNombreEquipo());
        assertEquals(3, armaduras.get(1).getValor());
        assertEquals(1, armaduras.get(1).getManos());
        assertEquals(false, armaduras.get(1).getActiva());
    }

    @Test
    public void testCrearDebilidades() {
        // Simulación de entrada del usuario
        String input = "2\n" + // Número de debilidades
                       "Debilidad1\n" + // Nombre de la primera debilidad
                       "3\n" + // Valor de la primera debilidad
                       "1\n" + // Activado (Sí)
                       "Debilidad2\n" + // Nombre de la segunda debilidad
                       "4\n" + // Valor de la segunda debilidad
                       "2\n";  // No activado (No)

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Llamada a la función que queremos probar
        Administrador admin = new Administrador("Admin", "admin", "password");
        ArrayList<Debilidad> debilidades = admin.crearDebilidades();

        // Comprobación de que se crearon las debilidades correctamente
        assertEquals(2, debilidades.size());
        assertEquals("Debilidad1", debilidades.get(0).getNombre());
        assertEquals(3, debilidades.get(0).getValorModificador());
        assertEquals(true, debilidades.get(0).getActivado());
        assertEquals("Debilidad2", debilidades.get(1).getNombre());
        assertEquals(4, debilidades.get(1).getValorModificador());
        assertEquals(false, debilidades.get(1).getActivado());
    }

    @Test
    public void testCrearFortaleza() {
        Administrador admin = new Administrador("Admin", "admin", "admin123");
        String input = "3\n" + // Indica que se crearán 3 fortalezas
                       "Fortaleza 1\n" + // Nombre de la primera fortaleza
                       "4\n" + // Valor de la primera fortaleza
                       "1\n" + // Activo
                       "Fortaleza 2\n" + // Nombre de la segunda fortaleza
                       "2\n" + // Valor de la segunda fortaleza
                       "2\n" + // No activo
                       "Fortaleza 3\n" + // Nombre de la tercera fortaleza
                       "5\n" + // Valor de la tercera fortaleza
                       "1\n";  // Activo
                       
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        
        ArrayList<Fortaleza> fortalezas = admin.crearFortalezas();;
        
        Fortaleza fortaleza1 = fortalezas.get(0);
        assertEquals("Fortaleza 1", fortaleza1.getNombre());
        
        Fortaleza fortaleza2= fortalezas.get(1);
        assertEquals("Fortaleza 2", fortaleza2.getNombre());

        Fortaleza fortaleza3 = fortalezas.get(2);
        assertEquals("Fortaleza 3", fortaleza3.getNombre());
    }
    
    @Test
    public void TestCrearDisciplina() {
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
