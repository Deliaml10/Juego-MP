import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestModificador {
    @Test
    public void testModificador() {
        String nombre = "Fortaleza";
        Integer valor = 10;
        boolean activado = true;

        Modificador modificador = new Modificador(nombre, valor, activado);

        assertEquals(nombre, modificador.getNombre());
        assertEquals(10, modificador.getValorModificador());
        assertEquals(activado, modificador.getActivado());
    }
}
