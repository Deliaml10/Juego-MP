import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDisciplina {
    @Test
    public void TestDesciplina(){
        Disciplina disciplina = new Disciplina("Lucha", 3, 2);
        assertEquals("Lucha", disciplina.getNombre());
        assertEquals(3, disciplina.getValorDisciplina());
        assertEquals(2, disciplina.getSangreNecesaria());
    }
}
