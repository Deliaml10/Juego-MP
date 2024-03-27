import java.util.ArrayList;

public class Licantropo extends Personaje{
    private Integer estatura;
    private Integer peso;
    private Integer rabia;
    private ArrayList<Don> dones = new ArrayList<>();

    public Licantropo(String nombre, String habilidades, Arma arma, Armadura armadura, Esbirro esbirro, Debilidad debilidad, Fortaleza fortaleza, Integer estatura, Integer peso, Integer rabia, Don don) {
        super(nombre, habilidades, arma, armadura, esbirro, debilidad, fortaleza);
        this.estatura = estatura;
        this.peso = peso;
        this.rabia = rabia;
        this.dones.add(don);
    }
}
