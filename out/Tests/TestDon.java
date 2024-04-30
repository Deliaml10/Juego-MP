import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDon {
    @Test
    public void TestDon(){
        Don don = new Don("Cantar", 3, 3);
        assertEquals("Cantar", don.getNombre());
        assertEquals(3, don.getValorDon());
        assertEquals(3, don.getRabia());
    }
}
