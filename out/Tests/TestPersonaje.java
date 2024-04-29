import java.util.ArrayList;

public class TestPersonaje {
    public void TestHabilidadesDisicplina(){

    }

        //HABILIDADES (disciplina)
        Disciplina disciplina1 = new Disciplina("disciplina1", 2, 4);
        Disciplina disciplina2 = new Disciplina("disciplina2", 1, 2) ;
        ArrayList<Habilidad> habilidades1 = new ArrayList<>();
        habilidades1.add(disciplina1);
        habilidades1.add(disciplina2);

        //ARMAS
        Arma arma1 = new Arma("Espada", 1, 1, false);
        Arma arma2 = new Arma("Arco", 2, 3, false);
        ArrayList<Arma> armas1 = new ArrayList<>();
        armas1.add(arma1);
        armas1.add(arma2);

        //ARMADURAS
        Armadura armadura1 = new Armadura("Escudo", 1, 1, true);
        ArrayList<Armadura> armaduras1 = new ArrayList<>();
        armaduras1.add(armadura1);

        //ESBIRROS
        Humano esbirro1 = new Humano("Humano1", 3, 2);
        ArrayList<Esbirro> esbirros1 = new ArrayList<>();
        esbirros1.add(esbirro1);

        //DEBILIDADES
        Debilidad debilidad1 = new Debilidad("Luz Solar", 3, true);
        Debilidad debilidad2 = new Debilidad("Ajo", 2, true);
        ArrayList<Debilidad> debilidades1 = new ArrayList<>();
        debilidades1.add(debilidad1);
        debilidades1.add(debilidad2);

        //FORTALEZAS
        Fortaleza fortaleza1 = new Fortaleza("Oscuridad", 1, true);
        Fortaleza fortaleza2 = new Fortaleza("Sangre", 2, true);
        ArrayList<Fortaleza> fortalezas1 = new ArrayList<>();
        fortalezas1.add(fortaleza1);
        fortalezas1.add(fortaleza2);

        //CONSTRUCTOR PERSONAJE
        Personaje pepito = new Personaje("Draculaura", 1, habilidades1, armas1, armaduras1, esbirros1, debilidades1, fortalezas1);

        pepito.sumarArmasActivas();
        System.out.println(pepito.getNombrePersonaje());

}