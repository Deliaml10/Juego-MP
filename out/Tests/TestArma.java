import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestArma {
    @Test
    public void TestArma(){
        Arma arma = new Arma("Espada", 2, 2, true);
        assertEquals("Espada", arma.getNombreEquipo());
        assertEquals(2, arma.getManos());
        assertEquals(2, arma.getValor());
        assertEquals(true, arma.getActivaArma());
    }
}
