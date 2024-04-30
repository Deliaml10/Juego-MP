import java.lang.reflect.Array;
import java.util.ArrayList;

public class Vampiro extends Personaje{
    private int puntosSangre;
    private Disciplina disciplina;
    private int edad;

    public Vampiro(String nombre, int tipo, ArrayList<Habilidad> habilidades, ArrayList<Arma> armas, ArrayList<Armadura> armaduras, ArrayList<Esbirro> esbirros, ArrayList<Debilidad> debilidades, ArrayList<Fortaleza> fortalezas, Integer puntosSangre, Disciplina disciplina, Integer edad) {
        super(nombre, tipo, habilidades, armas, armaduras, esbirros, debilidades, fortalezas);
        this.puntosSangre = puntosSangre;
        this.disciplina = disciplina;
        this.edad = edad;
    }

    public Disciplina getDisciplina(){
        return this.disciplina;
    }

    public int getSangre() {
        return this.puntosSangre;
    }

}
