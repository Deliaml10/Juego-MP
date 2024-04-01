import java.util.ArrayList;

public class Cazador extends Personaje{
    private int puntosVoluntad;
    private Talento talento;
    public Cazador(String nombre, int tipo, ArrayList<Habilidad> habilidades, ArrayList<Arma> armas, ArrayList<Armadura> armaduras, ArrayList<Esbirro> esbirros, ArrayList<Debilidad> debilidades, ArrayList<Fortaleza> fortalezas, int puntosVoluntad, Talento talento) {
        super(nombre, tipo, habilidades, armas, armaduras, esbirros, debilidades, fortalezas);
        this.puntosVoluntad = puntosVoluntad;
        this.talento = talento;
    }

    public int getPuntosVoluntad(){
        return this.puntosVoluntad;
    }

}
