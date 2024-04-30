import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestHumano {
    @Test
    public void TestHumano(){
        Humano humano = new Humano("Humano", 5, 4);
        assertEquals("Humano", humano.getNombreHumano());
        assertEquals(5, humano.getSaludHumano());
        assertEquals(4, humano.getLealtad());
    }
}
