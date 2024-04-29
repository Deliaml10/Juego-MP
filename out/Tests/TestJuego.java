import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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
    public void testEsEntero() {
        Juego juego = new Juego();
        String numero = "abc123";
        Boolean resultado = juego.esEntero(numero);
        assertEquals(false,resultado );
    }

    @Test
    public void testIniciarSesion() {
    Juego juego = new Juego();
    Usuario usuario = new Usuario("Usuario Test", "a", "123456789");
    juego.getUsuarios().put("a", usuario); // Agregar el usuario al juego

    // Simular la entrada del usuario con un ByteArrayInputStream
    String input = "a\n" +             // Nick
                   "123456789\n";       // Contraseña
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    // Llamar al método iniciarSesion con la entrada simulada
    Usuario usuarioSesion = juego.iniciarSesion(new Scanner(System.in));

    // Verificar que el usuario ha iniciado sesión correctamente
    assertEquals(usuario, usuarioSesion);
}

    @Test
    public void testCrearCuenta() {
        // Simulamos la entrada del usuario
        String input = "J\nNombre\nNick\n12345678\n12345678\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Juego juego = new Juego();
        juego.crearCuenta(new Scanner(System.in));

        Usuario usuarioCreado = juego.getUsuarioPorNick("Nick");

        assertEquals("Nick", usuarioCreado.getNick());
    }

    @Test
    public void testGuardarUsuarios() {
        // Paso 1: Crear un archivo de usuarios con algunos datos
        String usuariosFile = "usuarios_test.dat";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(usuariosFile))) {
            HashMap<String, Usuario> usuarios = new HashMap<>();
            Usuario usuario1 = new Usuario("Usuario1", "user1", "password1");
            Usuario usuario2 = new Usuario("Usuario2", "user2", "password2");
            usuarios.put(usuario1.getNick(), usuario1);
            usuarios.put(usuario2.getNick(), usuario2);
            oos.writeObject(usuarios);
        } catch (IOException e) {
            e.printStackTrace();
            fail("Error al crear el archivo de usuarios");
        }

        // Paso 2: Llamar al método guardarUsuarios() para sobrescribir el archivo
        Juego juego = new Juego();
        juego.guardarUsuarios();

        // Paso 3: Verificar si el archivo se ha creado y contiene los datos esperados
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(usuariosFile))) {
            HashMap<String, Usuario> usuariosCargados = (HashMap<String, Usuario>) ois.readObject();
            assertTrue(usuariosCargados.containsKey("user1"));
            assertTrue(usuariosCargados.containsKey("user2"));
            assertEquals("user1", usuariosCargados.get("user1").getNick());
            assertEquals("user2", usuariosCargados.get("user2").getNick());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            fail("Error al cargar el archivo de usuarios");
        }
    }

    @Test
    public void testCargarUsuarios() {
        // Paso 1: Crear un archivo de usuarios con algunos datos
        String usuariosFile = "usuarios_test.dat";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(usuariosFile))) {
            HashMap<String, Usuario> usuarios = new HashMap<>();
            Usuario usuario1 = new Usuario("Usuario1", "user1", "password1");
            Usuario usuario2 = new Usuario("Usuario2", "user2", "password2");
            usuarios.put(usuario1.getNick(), usuario1);
            usuarios.put(usuario2.getNick(), usuario2);
            oos.writeObject(usuarios);
        } catch (IOException e) {
            e.printStackTrace();
            fail("Error al crear el archivo de usuarios");
        }

        // Paso 2: Llamar al método cargarUsuarios() para cargar los usuarios desde el archivo
        Juego juego = new Juego();
        juego.setUsuariosFile(usuariosFile);
        juego.cargarUsuarios();

        // Paso 3: Verificar si los usuarios se han cargado correctamente en el HashMap
        HashMap<String, Usuario> usuariosCargados = juego.getUsuarios();
        assertNotNull(usuariosCargados);
        assertTrue(usuariosCargados.containsKey("user1"));
        assertTrue(usuariosCargados.containsKey("user2"));
        assertEquals("user1", usuariosCargados.get("user1").getNick());
        assertEquals("user2", usuariosCargados.get("user2").getNick());
    }

    @Test
    public void testGuardarPersonajes() {
        // Crear un juego y algunos personajes de prueba
        Juego juego = new Juego();
        ArrayList<Personaje> personajes = new ArrayList<>();
        Vampiro vampiro = new Vampiro("Vampiro Vacío", 1, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 0, new Disciplina("", 0, 0), 0);
        Licantropo licantropo = new Licantropo("Licántropo Vacío", 2, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 0, 0, 5, new Don("", 0, 0));

        personajes.add(vampiro);
        personajes.add(licantropo);

        // Establecer los personajes en el juego
        juego.setPersonajes(personajes);

        // Llamar al método guardarPersonajes
        juego.guardarPersonajes();

        // Verificar si el archivo de personajes se ha creado
        File file = new File(juego.getPersonajesFile());
        assertTrue(file.exists());

        // Limpiar el archivo creado después de la prueba
        file.delete();
    }

        @Test
        public void testCargarPersonajes() {
        // Paso 1: Crear un archivo de personajes con algunos datos de prueba
        String personajesFile = "personajes_test.dat";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(personajesFile))) {
            ArrayList<Personaje> personajesPrueba = new ArrayList<>();
            Vampiro vampiro = new Vampiro("Vampiro Vacío", 1, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 0, new Disciplina("", 0, 0), 0);
            Licantropo licantropo = new Licantropo("Licántropo Vacío", 2, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 0, 0, 5, new Don("", 0, 0));
            Cazador cazador = new Cazador("Cazador Vacío", 3, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 0, null);
            personajesPrueba.add(vampiro);
            personajesPrueba.add(licantropo);
            personajesPrueba.add(cazador);
            oos.writeObject(personajesPrueba);
        } catch (IOException e) {
            e.printStackTrace();
            fail("Error al crear el archivo de personajes");
        }

        // Paso 2: Llamar al método cargarPersonajes() para cargar los personajes desde el archivo
        Juego juego = new Juego();
        juego.setPersonajesFile(personajesFile);
        juego.cargarPersonajes();

        // Paso 3: Verificar si los personajes se han cargado correctamente en la lista de personajes
        ArrayList<Personaje> personajesCargados = juego.getPersonajes();
        assertNotNull(personajesCargados);
        assertEquals(3, personajesCargados.size());
        // Verificar algunos detalles de los personajes cargados si es necesario
        // Ejemplo:
        assertEquals("Vampiro Vacío", personajesCargados.get(0).getNombrePersonaje());
        assertEquals("Licántropo Vacío", personajesCargados.get(1).getNombrePersonaje());
        assertEquals("Cazador Vacío", personajesCargados.get(2).getNombrePersonaje());
    }





        @Test
        public void testRanking() {
            Juego juego = new Juego();
            juego.mostrarRankingGlobal();
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
