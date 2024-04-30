import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGhoul {
    @Test
    public void TestGhoul(){
        Ghoul ghoul = new Ghoul("Nom", 3, 3);
        assertEquals("Nom", ghoul.getNombre());
        assertEquals(3, ghoul.getSalud());
        assertEquals(3, ghoul.getDependenciaGhoul());
    }
}
