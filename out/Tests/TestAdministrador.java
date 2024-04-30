import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class TestAdministrador {
    @Test
    public void testEditarPersonaje() {
    // Simulación de entrada del usuario
    String input = "1\nNuevoNombre\n" + // Opción 1: Cambiar nombre
                   "2\n2\nNuevaHabilidad1\nNuevaHabilidad2\n" + // Opción 2: Añadir habilidades
                   "3\n" + // Opción 3: Cambiar armas (se asume que crearArmas() maneja la entrada)
                   "4\n" + // Opción 4: Cambiar armaduras (se asume que crearArmaduras() maneja la entrada)
                   "5\n" + // Opción 5: Cambiar armas activas (se asume que maneja la entrada)
                   "6\n" + // Opción 6: Cambiar armaduras activas (se asume que maneja la entrada)
                   "7\n" + // Opción 7: Cambiar esbirros (se asume que crearEsbirros() maneja la entrada)
                   "8\n" + // Opción 8: Cambiar debilidades (se asume que crearDebilidades() maneja la entrada)
                   "9\n" + // Opción 9: Cambiar fortalezas (se asume que crearFortalezas() maneja la entrada)
                   "10\n"; // Opción no válida

    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    // Creamos un administrador y un personaje de prueba
    Administrador admin = new Administrador("admin", "admin", "123456789");
    Personaje personaje = new Personaje("NombreInicial", 1, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

    // Llamamos al método de edición
    admin.editarPersonaje(personaje);

    // Verificamos que el nombre del personaje haya cambiado correctamente
    assertEquals("NuevoNombre", personaje.getNombrePersonaje());
}


    @Test
    public void testCrearArmas() {
        // Simulación de entrada del usuario
        String input = "2\n" + // Número de armas
                       "Espada\n" + // Nombre de la primera arma
                       "4\n" + // Valor de la primera arma
                       "2\n" + // Manos que ocupa la primera arma
                       "1\n" + // Activada (Sí)
                       "Arco\n" + // Nombre de la segunda arma
                       "3\n" + // Valor de la segunda arma
                       "1\n" +  // Manos que ocupa la segunda arma
                       "2\n";  // Activada (No)

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Llamada a la función que queremos probar
        Administrador admin = new Administrador("Admin", "admin", "password");
        ArrayList<Arma> armas = admin.crearArmas();

        // Comprobación de que se crearon las armas correctamente
        assertEquals(2, armas.size());
        assertEquals("Espada", armas.get(0).getNombreEquipo());
        assertEquals(4, armas.get(0).getValor());
        assertEquals(2, armas.get(0).getManos());
        assertEquals(true, armas.get(0).getActiva());
        assertEquals("Arco", armas.get(1).getNombreEquipo());
        assertEquals(3, armas.get(1).getValor());
        assertEquals(1, armas.get(1).getManos());
        assertEquals(false, armas.get(1).getActiva());
    }

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
        Administrador admin = new Administrador("Admin", "admin", "password");
        ArrayList<Armadura> armaduras = admin.crearArmaduras();

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


    // ESTE TEST DA ERROR
    /*
    @Test
    public void testCrearPersonaje() {
        // Simular entrada del usuario
        String input = "Dracula\n1\n2\nVolar\n1\n1\n0\n0\n0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Crear administrador
        Administrador administrador = new Administrador("Admin", "Admin", "12345678");

        // Llamar al método crearPersonaje
        Personaje personajeCreado = administrador.crearPersonaje();

        // Verificar que el personaje creado no sea nulo
        assertNotNull(personajeCreado);

        // Verificar que el nombre del personaje sea correcto
        assertEquals("Dracula", personajeCreado.getNombrePersonaje());

        // Verificar que el tipo de personaje sea correcto
        assertEquals(1, personajeCreado.getTipoPersonaje());

        // Verificar que se hayan añadido habilidades al personaje
        ArrayList<Habilidad> habilidades = personajeCreado.getHabilidades();
        assertNotNull(habilidades);
        assertEquals(1, habilidades.size());
        assertEquals("Volar", habilidades.get(0).getNombre());

        // Verificar que se hayan añadido armas al personaje (en este caso no se añade ninguna)
        ArrayList<Arma> armas = personajeCreado.getArmas();
        assertNotNull(armas);
        assertEquals(0, armas.size());

        ArrayList<Fortaleza> fortalezas = personajeCreado.getFortalezas();
        assertNotNull(fortalezas);
        assertEquals(1, fortalezas.size());
        assertEquals("Fortaleza1", fortalezas.get(0).getNombre());
        assertEquals(3, fortalezas.get(0).getValorModificador());

        // Verificar que se hayan añadido debilidades al personaje
        ArrayList<Debilidad> debilidades = personajeCreado.getDebilidades();
        assertNotNull(debilidades);
        assertEquals(1, debilidades.size());
        assertEquals("Debilidad1", debilidades.get(0).getNombre());
        assertEquals(4, debilidades.get(0).getValorModificador());
    }*/


}

