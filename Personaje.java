import java.util.ArrayList;

public class Personaje {
    private String nombre;
    private int tipo;
    private ArrayList<Habilidad> habilidades;
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


    public Personaje (String nombre, int tipo, ArrayList<Habilidad> habilidades, ArrayList<Arma> armas, ArrayList<Armadura> armaduras, ArrayList<Esbirro> esbirros, ArrayList<Debilidad> debilidades, ArrayList<Fortaleza> fortalezas){
        this.nombre = nombre;
        this.tipo = tipo;
        this.oro = 100;
        this.salud = 5;
        this.poder = 5;
        this.armas = armas;
        this.armaduras = armaduras;
        this.armasActivas = 0;
        this.armadurasActivas = 0;
        for (Armadura armadura : this.armaduras) {
            if (armadura.getActiva()) {
                this.armadurasActivas += 1;
            }
        }
        for (Arma arma : this.armas) {
            if (arma.getActiva()) {
                this.armasActivas += 1;
            }
        }
        this.esbirros= esbirros;
        this.debilidades= debilidades;
        this.fortalezas = fortalezas;
    }


    public String getNombrePersonaje(){
        return this.nombre;
    }

    public int getTipoPersonaje(){
        return this.tipo;
    }

    public void setNombrePersonaje(String nombre){
        this.nombre = nombre;
    }
    public void setHabilidad(Habilidad habilidad){
        this.habilidades.add(habilidad);
    }
    public void setArmas(ArrayList<Arma> armas) {
        this.armas.addAll(armas);
    }

    public ArrayList<Arma> getArmas(){
        return this.armas;
    }

    public void sumarArmasActivas(){
        this.armasActivas += 1;
    }

    public void restarArmasActivas(){
        this.armasActivas -= 1;
    }

    public void setArmaduras(ArrayList<Armadura> armaduras) {
        this.armaduras.addAll(armaduras);
    }

    public ArrayList<Armadura> getArmaduras(){
        return this.armaduras;
    }

    public void sumarArmadurasActivas(){
        this.armadurasActivas += 1;
    }

    public void restarArmadurasActivas(){
        this.armadurasActivas -= 1;
    }

    public void setEsbirros(ArrayList<Esbirro> esbirros) {
        this.esbirros.addAll(esbirros);
    }
}
