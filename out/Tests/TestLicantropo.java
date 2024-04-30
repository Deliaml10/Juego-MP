import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class TestLicantropo {

    @Test
    public void testConstructorLicantropo() {
        String nombre = "Licántropo";
        int tipo = 2;
        ArrayList<Habilidad> habilidades = new ArrayList<>();
        ArrayList<Arma> armas = new ArrayList<>();
        ArrayList<Armadura> armaduras = new ArrayList<>();
        ArrayList<Esbirro> esbirros = new ArrayList<>();
        ArrayList<Debilidad> debilidades = new ArrayList<>();
        ArrayList<Fortaleza> fortalezas = new ArrayList<>();
        int estatura = 180;
        int peso = 80;
        int rabia = 100;
        Don don = new Don("Transformación", 10, 2);

        Licantropo licantropo = new Licantropo(nombre, tipo, habilidades, armas, armaduras, esbirros, debilidades, fortalezas, estatura, peso, rabia, don);

        assertEquals(nombre, licantropo.getNombrePersonaje());
        assertEquals(2, licantropo.getTipoPersonaje());
        assertEquals(habilidades, licantropo.getHabilidades());
        assertEquals(armas, licantropo.getArmas());
        assertEquals(armaduras, licantropo.getArmaduras());
        assertEquals(esbirros, licantropo.getEsbirros());
        assertEquals(debilidades, licantropo.getDebilidades());
        assertEquals(fortalezas, licantropo.getFortalezas());
        assertEquals(estatura, licantropo.getEstatura());
        assertEquals(peso, licantropo.getPeso());
        assertEquals(rabia, licantropo.getRabia());
        assertEquals(don, licantropo.getDon());
    }
}
