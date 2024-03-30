import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Usuario {
    private String nombre;
    private String nick;
    private String contrasena;

    public Usuario(String nombre, String nick, String contrasena) {
        this.nombre = nombre;
        this.nick = nick;
        this.contrasena = contrasena;
    }



    public void borrarUsuario(HashMap<String, Usuario> usuarios, String nick) {
        if (usuarios.containsKey(nick)){
            Usuario usuario = usuarios.get(nick);
            usuarios.remove(usuario);
            System.out.println("Usuario '" + nick + "' eliminado correctamente.");
            return;
        }else {
            System.out.println("No se encontró ningún usuario con el nick '" + nick + "'.");
        }
    }


    // Getters y setters
    public String getNombreUsuario() {
        return nombre;
    }

    public void setNombreUsuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}