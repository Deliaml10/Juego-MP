import java.util.ArrayList;

public class Licantropo extends Personaje{
    private int estatura;
    private int peso;
    private int rabia;
    private Don don;

    public Licantropo(String nombre, int tipo, ArrayList<Habilidad> habilidades, ArrayList<Arma> armas, ArrayList<Armadura> armaduras, ArrayList<Esbirro> esbirros, ArrayList<Debilidad> debilidades, ArrayList<Fortaleza> fortalezas, int estatura, int peso, int rabia, Don don) {
        super(nombre, tipo, habilidades, armas, armaduras, esbirros, debilidades, fortalezas);
        this.estatura = estatura;
        this.peso = peso;
        this.rabia = rabia;
        this.don = don;
    }

    public Don getDon() {
        return this.don;
    }

    public void incrementarRabia(int incremento){
        this.rabia += incremento;
    }

    public int getRabia() {
        return rabia;
    }

    public int getEstatura(){
        return estatura;
    }

    public int getPeso(){
        return peso;
    }
}
