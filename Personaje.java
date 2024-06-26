import java.io.Serializable;
import java.util.ArrayList;

public class Personaje implements Serializable   {
    private String nombre;
    private int tipo;
    private ArrayList<Habilidad> habilidades = new ArrayList<>();
    private ArrayList<Arma> armas = new ArrayList<>();
    private ArrayList<Armadura> armaduras = new ArrayList<>();
    private int armasActivas;
    private int armadurasActivas;
    private int manosOcupadas;
    private ArrayList<Esbirro> esbirros = new ArrayList<>();
    private int oro;
    private int oroGanado;
    private int oroPerdido;
    private int salud;
    private int poder;
    private ArrayList<Debilidad> debilidades = new ArrayList<>();
    private ArrayList<Fortaleza> fortalezas = new ArrayList<>();
        private Boolean ocupado;
    public Personaje (String nombre, int tipo, ArrayList<Habilidad> habilidades, ArrayList<Arma> armas, ArrayList<Armadura> armaduras, ArrayList<Esbirro> esbirros, ArrayList<Debilidad> debilidades, ArrayList<Fortaleza> fortalezas){
        this.nombre = nombre;
        this.tipo = tipo;
        this.oro = 100;
        this.salud = 5;
        this.poder = 5;
        this.armas = armas;
        this.armaduras = armaduras;
        this.armasActivas = 0;
        this.armadurasActivas = 0;
        this.oroGanado = 0;
        this.oroPerdido = 0;
        for (Armadura armadura : this.armaduras) {
            if (armadura.getActiva()) {
                this.armadurasActivas += 1;
            }
        }
        for (Arma arma : this.armas) {
            if (arma.getActiva()) {
                this.armasActivas += 1;
            }
        }
        this.manosOcupadas = 0;
        this.esbirros= esbirros;
        this.debilidades= debilidades;
        this.fortalezas = fortalezas;
        this.ocupado = false;
    }


    public String getNombrePersonaje(){
        return this.nombre;
    }

    public int getTipoPersonaje(){
        return this.tipo;
    }

    public void setNombrePersonaje(String nombre){
        this.nombre = nombre;
    }
    public void setHabilidad(Habilidad habilidad){
        this.habilidades.add(habilidad);
    }
    public void setArmas(ArrayList<Arma> armas) {
        this.armas.addAll(armas);
    }

    public ArrayList<Arma> getArmas(){
        return this.armas;
    }

    public void sumarArmasActivas(){
        this.armasActivas += 1;
    }

    public void restarArmasActivas(){
        this.armasActivas -= 1;
    }

    public void setArmaduras(ArrayList<Armadura> armaduras) {
        this.armaduras.addAll(armaduras);
    }

    public ArrayList<Armadura> getArmaduras(){
        return this.armaduras;
    }

    public void sumarArmadurasActivas(){
        this.armadurasActivas += 1;
    }

    public void restarArmadurasActivas(){
        this.armadurasActivas -= 1;
    }
    public int getManosOcupadas(){
        return this.manosOcupadas;
    }

    public void setManosOcupadas(int manosOcupadas){
        this.manosOcupadas = manosOcupadas;
    }

    public void setEsbirros(ArrayList<Esbirro> esbirros) {
        this.esbirros.addAll(esbirros);
    }


    public ArrayList<Fortaleza> getFortalezas(){
        return this.fortalezas;
    }
    public ArrayList<Debilidad> getDebilidades(){
        return this.debilidades;
    }
    public void setDebilidades(ArrayList<Debilidad> debilidades) {
        this.debilidades.addAll(debilidades);
    }

    public void setFortalezas(ArrayList<Fortaleza> fortalezas) {
        this.fortalezas.addAll(fortalezas);
    }

    public void incrementarOroGanado(int cantidad) {
        this.oroGanado += cantidad;
    }

    public void incrementarOroPerdido(int cantidad) {
        this.oroPerdido += cantidad;
    }

    public int getPoder(){
        return this.poder;
    }


    public int getSalud() {
        return this.salud;
    }

    public void setSalud(int salud){
        this.salud = salud;
    }

    public int getOro(){
        return this.oro;
    }

    public void incrementarOro(int cantidad) {
        this.oro = this.oro + cantidad;
    }
    
    public void setOcupado(Boolean valor){
        this.ocupado = valor;
    }

    public boolean getOcupado(){
        return this.ocupado;
    }

    public int getOroGanado() {
        return oroGanado;
    }

    public int getOroPerdido() {
        return oroPerdido;
    }


    public void restarOro(int cantidad) {
        this.oro = this.oro - cantidad;
    }

    public ArrayList<Habilidad> getHabilidades() {
        return habilidades;
    }


    public ArrayList<Esbirro> getEsbirros() {
        return this.esbirros;
    }


    public int getArmasActivas() {
        return this.armasActivas;
    }

    public int getArmadurasActivas() {
        return this.armadurasActivas;
    }
    
    public ArrayList<Arma> getArmasEquipadas() {
        ArrayList<Arma> armasEquipadas = new ArrayList<>();
        for (Arma arma : armas) {
            if (arma.getEquipada()) {
                armasEquipadas.add(arma);
            }
        }
        return armasEquipadas;
    }

    public ArrayList<Armadura> getArmadurasEquipadas() {
        ArrayList<Armadura> armadurasEquipadas = new ArrayList<>();
        for (Armadura armadura : armaduras) {
            if (armadura.getEquipada()) {
                armadurasEquipadas.add(armadura);
            }
        }
        return armadurasEquipadas;
    }

}



