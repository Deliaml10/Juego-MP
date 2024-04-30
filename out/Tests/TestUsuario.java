import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class TestUsuario {

    @Test
    public void testConstructor() {
        Usuario usuario = new Usuario("Nombre", "Nick", "Contraseña");
        // Comprobamos que los valores se han asignado correctamente en el constructor
        assertEquals("Nombre", usuario.getNombreUsuario());
        assertEquals("Nick", usuario.getNick());
        assertEquals("Contraseña", usuario.getContrasena());
    }
}
