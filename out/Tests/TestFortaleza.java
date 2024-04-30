import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFortaleza {

    @Test
    public void testFortaleza() {
        String nombre = "Fortaleza";
        int valor = 10;
        boolean activado = true;

        Fortaleza fortaleza = new Fortaleza(nombre, valor, activado);

        assertEquals(nombre, fortaleza.getNombre());
        assertEquals(valor, fortaleza.getValorModificador());
        assertEquals(activado, fortaleza.getActivado());
    }
}
