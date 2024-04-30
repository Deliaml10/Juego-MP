import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestTalento {

    @Test
    public void testTalento() {
        String nombre = "Destreza";

        Talento talento = new Talento(nombre);

        assertEquals(nombre, talento.getNombre());
    }
}
