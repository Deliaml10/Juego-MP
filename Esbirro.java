import java.util.ArrayList;
import java.util.Scanner;

public class Esbirro {
    private String nombre;
    private int salud;

    public Esbirro(String nombre, int salud){
        this.nombre = nombre;
        this.salud = salud;
    }

}


// Clase Humano
class Humano extends Esbirro {
    private String[] tipoLealtad = {"baja", "media", "alta"};
    private int lealtad;

    public Humano(String nombre, int salud, int lealtad){
        super(nombre, salud);
        this.lealtad = lealtad;
    }
}

// Clase Ghoul
class Ghoul extends Esbirro {
    private int dependencia;

    public Ghoul(String nombre, int salud, int dependencia){
        super(nombre, salud);
        this.dependencia = dependencia;
    }
}

// Clase Demonio
class Demonio extends Esbirro{
    private String pacto;
    private ArrayList<Esbirro> esbirros = new ArrayList<>();

    public Demonio(String nombre, int salud, String pacto, ArrayList<Esbirro> esbirros){
        super(nombre, salud);
        this.pacto = pacto;
        this.esbirros = esbirros;
    }
}
