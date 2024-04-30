import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestDemonio {
    @Test
    public void TestDemonio(){
        ArrayList<Esbirro> esbirros = new ArrayList<>();
        Demonio demonio = new Demonio("Demon", 3, "Pacto", esbirros );
        assertEquals("Demon", demonio.getNombreDemonio());
        assertEquals(3, demonio.getSaludDemonio());
        assertEquals("Pacto", demonio.getPacto());
        assertEquals(0, demonio.getEsbirros().size());


    }
}
