import java.util.ArrayList;

public class Personaje {
    private String nombre;
    private String habilidades;
    private ArrayList<Arma> armas = new ArrayList<>();
    private ArrayList<Armadura> armaduras = new ArrayList<>();
    private Integer armasActivas;
    private Integer armadurasActivas;
    private ArrayList<Esbirro> esbirros = new ArrayList<>();
    private Integer oro;
    private Integer salud;
    private Integer poder;
    private ArrayList<Debilidad> debilidades = new ArrayList<>();
    private ArrayList<Fortaleza> fortalezas = new ArrayList<>();


    public Personaje (String nombre, String habilidades, Arma arma, Armadura armadura, Esbirro esbirro, Debilidad debilidad, Fortaleza fortaleza){
        this.nombre = nombre;
        this.oro = 100;
        this.salud = 5;
        this.poder = 5;
        this.armas.add(arma);
        this.armaduras.add(armadura);
        this.esbirros.add(esbirro);
        this.armasActivas = 1;
        this.armadurasActivas = 1;
        this.debilidades.add(debilidad);
        this.fortalezas.add(fortaleza);
    }
}
