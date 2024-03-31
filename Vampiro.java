import java.lang.reflect.Array;
import java.util.ArrayList;

public class Vampiro extends Personaje{
    private int puntosSangre;
    private ArrayList<Disciplina> disciplinas = new ArrayList<>();
    private int edad;

    public Vampiro(String nombre, int tipo, ArrayList<Habilidad> habilidades, ArrayList<Arma> armas, ArrayList<Armadura> armaduras, ArrayList<Esbirro> esbirros, ArrayList<Debilidad> debilidades, ArrayList<Fortaleza> fortalezas, Integer puntosSangre, Disciplina disciplina, Integer edad) {
        super(nombre, tipo, habilidades, armas, armaduras, esbirros, debilidades, fortalezas);
        this.puntosSangre = puntosSangre;
        this.disciplinas.add(disciplina);
        this.edad = edad;
    }

    public int getValorSangre(){
        int valorSangre = Disciplina.getSangre();
        return valorSangre;
    }
}
