import java.util.ArrayList;

public class Licantropo extends Personaje{
    private Integer estatura;
    private Integer peso;
    private Integer rabia;
    private ArrayList<Don> dones = new ArrayList<>();

    public Licantropo(String nombre, int tipo, ArrayList<Habilidad> habilidades, ArrayList<Arma> armas, ArrayList<Armadura> armaduras, ArrayList<Esbirro> esbirros, ArrayList<Debilidad> debilidades, ArrayList<Fortaleza> fortalezas, Integer estatura, Integer peso, Integer rabia, Don don) {
        super(nombre, tipo, habilidades, armas, armaduras, esbirros, debilidades, fortalezas);
        this.estatura = estatura;
        this.peso = peso;
        this.rabia = rabia;
        this.dones.add(don);
    }
}
