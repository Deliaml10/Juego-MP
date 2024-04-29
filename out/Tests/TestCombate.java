import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.ArrayList;

public class TestCombate {
    
    @Test
    public void testConstructorCombate() {
        // Crear jugadores
    Jugador jugador1 = new Jugador("Jugador1", "jugador1", "contrasena1");
    Jugador jugador2 = new Jugador("Jugador2", "jugador2", "contrasena2");

    // Crear personajes para los jugadores
    Habilidad habilidad1 = new Disciplina("Disciplina", 5, 10);
    Habilidad habilidad2 = new Don("Don", 8, 15);

    // Crear una lista de habilidades
    ArrayList<Habilidad> habilidades1 = new ArrayList<>();
    ArrayList<Habilidad> habilidades2 = new ArrayList<>();
    habilidades1.add(habilidad1);
    habilidades2.add(habilidad2);

    // Crear armas
    Arma arma = new Arma("Espada", 1, 2, true);

    // Crear armaduras
    Armadura armadura = new Armadura("Escudo", 1, 4, true);

    // Crear listas de armas y armaduras
    ArrayList<Arma> armas = new ArrayList<>();
    armas.add(arma);

    ArrayList<Armadura> armaduras = new ArrayList<>();
    armaduras.add(armadura);

    // Crear esbirros
    Esbirro esbirro1 = new Humano("Sir Lancelot", 5, 2);
    Esbirro esbirro2 = new Ghoul("Fang", 5, 3);
    Esbirro esbirro3 = new Demonio("Azazel", 5, "Pacto oscuro", new ArrayList<>());

    // Crear lista de esbirros
    ArrayList<Esbirro> esbirros = new ArrayList<>();
    esbirros.add(esbirro1);
    esbirros.add(esbirro2);
    esbirros.add(esbirro3);

    // Crear debilidades y fortalezas
    Debilidad debilidad1 = new Debilidad("Miedo a la oscuridad", 2, true);
    Debilidad debilidad2 = new Debilidad("Fobia a los insectos", 3, false);
    Fortaleza fortaleza1 = new Fortaleza("Gran resistencia física", 3, true);
    Fortaleza fortaleza2 = new Fortaleza("Gran inteligencia", 2, true);

    // Crear lista de debilidades y fortalezas
    ArrayList<Debilidad> debilidades = new ArrayList<>();
    debilidades.add(debilidad1);
    debilidades.add(debilidad2);

    ArrayList<Fortaleza> fortalezas = new ArrayList<>();
    fortalezas.add(fortaleza1);
    fortalezas.add(fortaleza2);

    // Crear un objeto Personaje
    Personaje personaje1 = new Personaje("Personaje1", 1, habilidades1, armas, armaduras, esbirros, debilidades, fortalezas);
    Personaje personaje2 = new Personaje("Personaje2", 1, habilidades2, armas, armaduras, esbirros, debilidades, fortalezas);
    
    // Asignar personajes a los jugadores
    jugador1.registrarPersonaje(personaje1);
    jugador2.registrarPersonaje(personaje2);
        
    // Crear combate
    int oroApostado = 50;
    Combate combate = new Combate(jugador1, jugador2, oroApostado);

    // Verificar que los atributos se inicializan correctamente
    assertEquals(jugador1, combate.getDesafiante());
    assertEquals(jugador2, combate.getDesafiado());
    assertEquals(oroApostado, combate.getOroApostado());
    assertTrue(combate.getRondas().isEmpty());
    assertFalse(combate.isValidado());
    assertFalse(combate.getVisto());

}

    @Test
    public void iniciarCombate() {
    // Crear jugadores
    Jugador jugador1 = new Jugador("Jugador1", "jugador1", "contrasena1");
    Jugador jugador2 = new Jugador("Jugador2", "jugador2", "contrasena2");

    // Crear personajes para los jugadores
    Habilidad habilidad1 = new Disciplina("Disciplina", 5, 10);
    Habilidad habilidad2 = new Don("Don", 8, 15);

    // Crear una lista de habilidades
    ArrayList<Habilidad> habilidades1 = new ArrayList<>();
    ArrayList<Habilidad> habilidades2 = new ArrayList<>();
    habilidades1.add(habilidad1);
    habilidades2.add(habilidad2);

    // Crear armas
    Arma arma = new Arma("Espada", 1, 2, true);

    // Crear armaduras
    Armadura armadura = new Armadura("Escudo", 1, 4, true);

    // Crear listas de armas y armaduras
    ArrayList<Arma> armas = new ArrayList<>();
    armas.add(arma);

    ArrayList<Armadura> armaduras = new ArrayList<>();
    armaduras.add(armadura);

    // Crear esbirros
    Esbirro esbirro1 = new Humano("Sir Lancelot", 5, 2);
    Esbirro esbirro2 = new Ghoul("Fang", 5, 3);
    Esbirro esbirro3 = new Demonio("Azazel", 5, "Pacto oscuro", new ArrayList<>());

    // Crear lista de esbirros
    ArrayList<Esbirro> esbirros = new ArrayList<>();
    esbirros.add(esbirro1);
    esbirros.add(esbirro2);
    esbirros.add(esbirro3);

    // Crear debilidades y fortalezas
    Debilidad debilidad1 = new Debilidad("Miedo a la oscuridad", 2, true);
    Debilidad debilidad2 = new Debilidad("Fobia a los insectos", 3, false);
    Fortaleza fortaleza1 = new Fortaleza("Gran resistencia física", 3, true);
    Fortaleza fortaleza2 = new Fortaleza("Gran inteligencia", 2, true);

    // Crear lista de debilidades y fortalezas
    ArrayList<Debilidad> debilidades = new ArrayList<>();
    debilidades.add(debilidad1);
    debilidades.add(debilidad2);

    ArrayList<Fortaleza> fortalezas = new ArrayList<>();
    fortalezas.add(fortaleza1);
    fortalezas.add(fortaleza2);

    // Crear un objeto Personaje
    Personaje personaje1 = new Personaje("Personaje1", 1, habilidades1, armas, armaduras, esbirros, debilidades, fortalezas);
    Personaje personaje2 = new Personaje("Personaje2", 1, habilidades2, armas, armaduras, esbirros, debilidades, fortalezas);
    
    // Asignar personajes a los jugadores
    jugador1.registrarPersonaje(personaje1);
    jugador2.registrarPersonaje(personaje2);

    // Crear un combate entre los jugadores con un límite de 50 rondas
    Combate combate = new Combate(jugador1, jugador2, 50);
    combate.iniciarCombate();
        // Verificar que el vencedor recibe la cantidad correcta de oro (50 o 150)
        if (combate.getVencedor().equals(jugador1)) {
            Assert.assertEquals(150, jugador1.getPersonaje().getOro());
            Assert.assertEquals(50, jugador2.getPersonaje().getOro());
        } else if (combate.getVencedor().equals(jugador2)) {
            Assert.assertEquals(150, jugador2.getPersonaje().getOro());
            Assert.assertEquals(50, jugador1.getPersonaje().getOro());
        } else {
            Assert.assertEquals(100, jugador1.getPersonaje().getOro());
            Assert.assertEquals(100, jugador2.getPersonaje().getOro());
        }
    }

    @Test
    public void testGuardarRonda() {
        // Crear jugadores
        Jugador jugador1 = new Jugador("Jugador1", "jugador1", "contrasena1");
        Jugador jugador2 = new Jugador("Jugador2", "jugador2", "contrasena2");

        // Crear personajes para los jugadores
        Habilidad habilidad1 = new Disciplina("Disciplina", 5, 10);
        Habilidad habilidad2 = new Don("Don", 8, 15);

        // Crear una lista de habilidades
        ArrayList<Habilidad> habilidades1 = new ArrayList<>();
        ArrayList<Habilidad> habilidades2 = new ArrayList<>();
        habilidades1.add(habilidad1);
        habilidades2.add(habilidad2);

        // Crear armas
        Arma arma = new Arma("Espada", 1, 2, true);

        // Crear armaduras
        Armadura armadura = new Armadura("Escudo", 1, 4, true);

        // Crear listas de armas y armaduras
        ArrayList<Arma> armas = new ArrayList<>();
        armas.add(arma);

        ArrayList<Armadura> armaduras = new ArrayList<>();
        armaduras.add(armadura);

        // Crear esbirros
        Esbirro esbirro1 = new Humano("Sir Lancelot", 5, 2);
        Esbirro esbirro2 = new Ghoul("Fang", 5, 3);
        Esbirro esbirro3 = new Demonio("Azazel", 5, "Pacto oscuro", new ArrayList<>());

        // Crear lista de esbirros
        ArrayList<Esbirro> esbirros = new ArrayList<>();
        esbirros.add(esbirro1);
        esbirros.add(esbirro2);
        esbirros.add(esbirro3);

        // Crear debilidades y fortalezas
        Debilidad debilidad1 = new Debilidad("Miedo a la oscuridad", 2, true);
        Debilidad debilidad2 = new Debilidad("Fobia a los insectos", 3, false);
        Fortaleza fortaleza1 = new Fortaleza("Gran resistencia física", 3, true);
        Fortaleza fortaleza2 = new Fortaleza("Gran inteligencia", 2, true);

        // Crear lista de debilidades y fortalezas
        ArrayList<Debilidad> debilidades = new ArrayList<>();
        debilidades.add(debilidad1);
        debilidades.add(debilidad2);

        ArrayList<Fortaleza> fortalezas = new ArrayList<>();
        fortalezas.add(fortaleza1);
        fortalezas.add(fortaleza2);

        // Crear un objeto Personaje
        Personaje personaje1 = new Personaje("Personaje1", 1, habilidades1, armas, armaduras, esbirros, debilidades, fortalezas);
        Personaje personaje2 = new Personaje("Personaje2", 1, habilidades2, armas, armaduras, esbirros, debilidades, fortalezas);
        
        // Asignar personajes a los jugadores
        jugador1.registrarPersonaje(personaje1);
        jugador2.registrarPersonaje(personaje2);

        // Crear un combate entre los jugadores
        Combate combate = new Combate(jugador1, jugador2, 50);

        // Crear una ronda
        Ronda ronda = new Ronda(personaje1, personaje2);

        // Guardar la ronda
        combate.guardarRonda(ronda);

        // Obtener el array de rondas del combate
        ArrayList<Ronda> rondas = combate.getRondas();

        // Verificar si la ronda se ha guardado correctamente
        assertEquals(1, rondas.size());
        assertEquals(ronda, rondas.get(0));
    }
}
