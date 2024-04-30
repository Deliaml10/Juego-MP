import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestVampiro {
    @Test
    public void TestVampiro(){
        ArrayList<Habilidad> habilidades = new ArrayList<>();
        ArrayList<Arma> armas = new ArrayList<>();
        ArrayList<Armadura> armaduras = new ArrayList<>();
        ArrayList<Esbirro> esbirros = new ArrayList<>();
        ArrayList<Debilidad> debilidades = new ArrayList<>();
        ArrayList<Fortaleza> fortalezas = new ArrayList<>();
        Disciplina disciplina = new Disciplina("Saltar", 3, 2);
        Vampiro vampiro = new Vampiro("Dracula", 1, habilidades,armas, armaduras, esbirros, debilidades, fortalezas, 4, disciplina, 34);

        assertEquals("Dracula", vampiro.getNombrePersonaje());
        assertEquals(1, vampiro.getTipoPersonaje());
        assertEquals(0, habilidades.size());
        assertEquals(0, esbirros.size());
        assertEquals(0, armas.size());
        assertEquals(0, armaduras.size());
        assertEquals(0, debilidades.size());
        assertEquals(0, fortalezas.size());

    }
}
