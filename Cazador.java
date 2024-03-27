import java.util.ArrayList;

public class Cazador extends Personaje{
    private Integer puntosVoluntad;
    private ArrayList<Talento> talentos = new ArrayList<>();
    public Cazador(String nombre, String habilidades, Arma arma, Armadura armadura, Esbirro esbirro, Debilidad debilidad, Fortaleza fortaleza, Integer puntosVoluntad, Talento talento) {
        super(nombre, habilidades, arma, armadura, esbirro, debilidad, fortaleza);
        this.puntosVoluntad = puntosVoluntad;
        this.talentos.add(talento);
    }
}
