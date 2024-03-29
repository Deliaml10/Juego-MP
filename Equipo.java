public class Equipo {
    private String nombre;
    private int manos;
    private int valor;

    private boolean activa;

    public Equipo(String nombre, int manos, int valor, boolean activa){
        this.nombre = nombre;
        this.manos = manos;
        this.valor = valor;
        this.activa = activa;
    }
}

class Arma extends Equipo{

    public Arma(String nombre, int manos, int valor, boolean activa){
        super(nombre, manos, valor, activa);
    }

}

class Armadura extends Equipo{

    public Armadura(String nombre, int manos, int valor, boolean activa){
        super(nombre, manos, valor, activa);
    }
}
