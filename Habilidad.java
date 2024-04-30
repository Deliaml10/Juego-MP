import java.io.Serializable;

public class Habilidad implements Serializable {
    private String nombre;

    public Habilidad(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

class Disciplina extends Habilidad {
    private int valor;
    private int sangreNecesaria;

    public Disciplina(String nombre, int valor, int sangreNecesaria){
        super(nombre);
        this.valor = valor;
        this.sangreNecesaria = sangreNecesaria;
    }
    public int getSangreNecesaria(){
        return this.sangreNecesaria;
    }

    public int getValorDisciplina(){
        return this.valor;
    }
}

class Don extends Habilidad{
    private Integer valor;
    private Integer rabiaNecesaria;

    public Don(String nombre, int valor, int rabiaNecesaria){
        super(nombre);
        this.valor = valor;
        this.rabiaNecesaria = rabiaNecesaria;
    }

    public int getRabia(){
        return this.rabiaNecesaria;
    }
    public int getValorDon(){
        return this.valor;
    }

    public int getRabiaNecesaria() {
        return this.rabiaNecesaria;
    }
}

class Talento extends Habilidad{

    public Talento(String nombre){
        super(nombre);
    }



}