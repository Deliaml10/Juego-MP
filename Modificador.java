import java.io.Serializable;

public class Modificador implements Serializable  {
    private String nombre;
    private int valor;

    private boolean activado;

    public Modificador(String nombre, Integer valor, boolean activado){
        this.nombre = nombre;
        this.valor = valor;
        this.activado = activado;
    }

    public int getValorModificador(){
        return this.valor;
    }
    public boolean getActivado(){
        return this.activado;
    }
}

class Debilidad extends Modificador{

    public Debilidad(String nombre, int valor, boolean activado){
        super(nombre, valor, activado);
    }

}

class Fortaleza extends Modificador{

    public Fortaleza(String nombre, int valor, boolean activado){
        super(nombre, valor, activado);
    }

}
