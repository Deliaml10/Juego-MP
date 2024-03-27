import java.util.ArrayList;

public class Vampiro extends Personaje{
    private Integer puntosSangre;
    private ArrayList<Disciplina> disciplinas = new ArrayList<>();
    private Integer edad;

    public Vampiro(String nombre, String habilidades, Arma arma, Armadura armadura, Esbirro esbirro, Debilidad debilidad, Fortaleza fortaleza, Integer puntosSangre, Disciplina disciplina, Integer edad) {
        super(nombre, habilidades, arma, armadura, esbirro, debilidad, fortaleza);
        this.puntosSangre = puntosSangre;
        this.disciplinas.add(disciplina);
        this.edad = edad;
    }
}
