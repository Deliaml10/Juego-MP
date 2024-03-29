import java.util.ArrayList;

public class Personaje {
    private String nombre;
    private String habilidades;
    private ArrayList<Arma> armas = new ArrayList<>();
    private ArrayList<Armadura> armaduras = new ArrayList<>();
    private int armasActivas;
    private int armadurasActivas;
    private ArrayList<Esbirro> esbirros = new ArrayList<>();
    private int oro;
    private int salud;
    private int poder;
    private ArrayList<Debilidad> debilidades = new ArrayList<>();
    private ArrayList<Fortaleza> fortalezas = new ArrayList<>();


    public Personaje (String nombre, String habilidades, ArrayList<Arma> armas, ArrayList<Armadura> armaduras, ArrayList<Esbirro> esbirros, ArrayList<Debilidad> debilidades, ArrayList<Fortaleza> fortalezas){
        this.nombre = nombre;
        this.oro = 100;
        this.salud = 5;
        this.poder = 5;
        this.armas = armas;
        this.armaduras = armaduras;
        this.esbirros= esbirros;
        this.armasActivas = 1;
        this.armadurasActivas = 1;
        this.debilidades= debilidades;
        this.fortalezas = fortalezas;
    }

    public String getNombrePersonaje(){
        return this.nombre;
    }
    public void setNombrePersonaje(String nombre){
        this.nombre = nombre;
    }

    public void setHabilidades(String habilidades){

    }

    public void setArmas(ArrayList<Arma> armas) {
        this.armas.addAll(armas);
    }

    public void setArmaduras(ArrayList<Armadura> armaduras) {
        this.armaduras.addAll(armaduras);
    }

    public void setEsbirros(ArrayList<Esbirro> esbirros) {
        this.esbirros.addAll(esbirros);
    }
}
