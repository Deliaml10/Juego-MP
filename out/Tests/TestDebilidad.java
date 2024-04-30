import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestDebilidad {

    @Test
    public void testDebilidad() {
        String nombre = "Debilidad";
        int valor = -10;
        boolean activado = true;

        Debilidad debilidad = new Debilidad(nombre, valor, activado);

        assertEquals(nombre, debilidad.getNombre());
        assertEquals(valor, debilidad.getValorModificador());
        assertEquals(activado, debilidad.getActivado());
    }
}
