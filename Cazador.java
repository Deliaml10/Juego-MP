import java.util.ArrayList;

public class Cazador extends Personaje{
    private Integer puntosVoluntad;
    private ArrayList<Talento> talentos = new ArrayList<>();
    public Cazador(String nombre, int tipo, ArrayList<Habilidad> habilidades, ArrayList<Arma> armas, ArrayList<Armadura> armaduras, ArrayList<Esbirro> esbirros, ArrayList<Debilidad> debilidades, ArrayList<Fortaleza> fortalezas, Integer puntosVoluntad, Talento talento) {
        super(nombre, tipo, habilidades, armas, armaduras, esbirros, debilidades, fortalezas);
        this.puntosVoluntad = puntosVoluntad;
        this.talentos.add(talento);
    }
}
