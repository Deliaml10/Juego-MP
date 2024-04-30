import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestHabilidad {
    @Test
    public void TestHabilidad(){
        Habilidad habilidad = new Habilidad("Saltar");

        assertEquals("Saltar", habilidad.getNombre());
    }

}
