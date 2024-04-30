import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestEsbirro {
    @Test
    public void testEsbirro(){
        Esbirro esbirro = new Esbirro("Esbirro", 3);
        assertEquals("Esbirro", esbirro.getNombre());
        assertEquals(3, esbirro.getSalud());
    }
}
