import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Esbirro implements Serializable  {
    @SuppressWarnings("unused")
    private String nombre;
    @SuppressWarnings("unused")
    private int salud;

    public Esbirro(String nombre, int salud){
        this.nombre = nombre;
        this.salud = salud;
    }
    public String getNombre(){
        return nombre;
    }
    public int getSalud(){
        return salud;
    }

}


// Clase Humano
class Humano extends Esbirro {
    @SuppressWarnings("unused")
    private String[] tipoLealtad = {"baja", "media", "alta"};
    @SuppressWarnings("unused")
    private int lealtad;

    public Humano(String nombre, int salud, int lealtad){
        super(nombre, salud);
        this.lealtad = lealtad;
        switch (lealtad){
            case 1:
                tipoLealtad = new String[]{"baja"};
            case 2:
                tipoLealtad = new String[]{"media"};
            case 3:
                tipoLealtad = new String[]{"alta"};
        }
    }
    public String getNombreHumano(){
        return getNombre();
    }
    public int getSaludHumano(){
        return getSalud();
    }
    public int getLealtad(){
        return lealtad;
    }
}

// Clase Ghoul
class Ghoul extends Esbirro {
    @SuppressWarnings("unused")
    private int dependencia;

    public Ghoul(String nombre, int salud, int dependencia){
        super(nombre, salud);
        this.dependencia = dependencia;
    }
    public int getDependenciaGhoul(){
        return dependencia;
    }
}

// Clase Demonio
class Demonio extends Esbirro{
    @SuppressWarnings("unused")
    private String pacto;
    private ArrayList<Esbirro> esbirros = new ArrayList<>();

    public Demonio(String nombre, int salud, String pacto, ArrayList<Esbirro> esbirros){
        super(nombre, salud);
        this.pacto = pacto;
        this.esbirros = esbirros;
    }
    public String getNombreDemonio(){
        return getNombre();
    }

    public int getSaludDemonio(){
        return getSalud();
    }

    public String getPacto(){
        return pacto;
    }

    public ArrayList<Esbirro> getEsbirros(){
        return esbirros;
    }
}
