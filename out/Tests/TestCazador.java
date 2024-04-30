import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class TestCazador {

    @Test
    public void testCazador() {
        String nombre = "Cazador";
        int tipo = 3;
        ArrayList<Habilidad> habilidades = new ArrayList<>();
        ArrayList<Arma> armas = new ArrayList<>();
        ArrayList<Armadura> armaduras = new ArrayList<>();
        ArrayList<Esbirro> esbirros = new ArrayList<>();
        ArrayList<Debilidad> debilidades = new ArrayList<>();
        ArrayList<Fortaleza> fortalezas = new ArrayList<>();
        int puntosVoluntad = 50;
        Talento talento = new Talento("Sigilo");

        Cazador cazador = new Cazador(nombre, tipo, habilidades, armas, armaduras, esbirros, debilidades, fortalezas, puntosVoluntad, talento);

        assertEquals(nombre, cazador.getNombrePersonaje());
        assertEquals("3", cazador.getTipoPersonaje());
        assertEquals(habilidades, cazador.getHabilidades());
        assertEquals(armas, cazador.getArmas());
        assertEquals(armaduras, cazador.getArmaduras());
        assertEquals(esbirros, cazador.getEsbirros());
        assertEquals(debilidades, cazador.getDebilidades());
        assertEquals(fortalezas, cazador.getFortalezas());
        assertEquals(puntosVoluntad, cazador.getPuntosVoluntad());
        assertEquals(talento, cazador.getTalento());
    }
}
