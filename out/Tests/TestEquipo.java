import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestEquipo {
    @Test
    public void TestEquipo(){
        Equipo equipo = new Equipo("Martillo", 1, 3, true);
        assertEquals("Martillo", equipo.getNombreEquipo());
        assertEquals(1, equipo.getManos());
        assertEquals(3, equipo.getValor());
        assertTrue(equipo.getActiva());
    }
}
