import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestArmadura {
    @Test
    public void TestArmadura(){
        Armadura armadura = new Armadura("Espada", 2, 2, true);
        assertEquals("Espada", armadura.getNombreEquipo());
        assertEquals(2, armadura.getManos());
        assertEquals(2, armadura.getValor());
        assertEquals(true, armadura.getActivaArmadura());
    }
}
