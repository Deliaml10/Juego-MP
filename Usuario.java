import java.io.Serializable;
import java.util.HashMap;

public class Usuario implements Serializable  {
    private String nombre;
    private String nick;
    private String contrasena;

    public Usuario(String nombre, String nick, String contrasena) {
        this.nombre = nombre;
        this.nick = nick;
        this.contrasena = contrasena;
    }



    // Getters y setters
    public String getNombreUsuario() {
        return nombre;
    }

    public String getNick() {
        return nick;
    }

    public String getContrasena() {
        return contrasena;
    }

}