package geometria.geo3D;

import java.util.HashMap;

public class Spezzata {
    //attr
    protected Punto origine; //punto 2D
    protected Punto fine; //punto 2D
    //variabili di Classe
    protected int numero;
    protected HashMap<Integer, Segmento> segmenti; //contiene numeri e segmenti 2D
    // costruttori
    //come da richiesta 
    public Spezzata(Punto origine) {
        this.numero = 0;
        this.origine = origine;
        this.fine = origine;
        this.segmenti = new HashMap<>();
    }
    //metodi
    //aggiunge un Punto e quindi un segmento come da richiesta
    public void aggiungiPunto(Punto p){
        Segmento nuovo = new Segmento(fine, p);
        this.fine = p;
        segmenti.put(numero,nuovo);
        numero++;
    }

    public void chiudi(){ segmenti.put(numero,new Segmento(fine, origine)); }
    public int quanti(){ return segmenti.size(); }
    public double lunghezza(){
        double lunghezza=0;
        for (Segmento segmento : segmenti.values()) {
            lunghezza+=segmento.lunghezza();
        };
        return lunghezza;
    }
    
    @Override
    public String toString() {
        StringBuilder elementi = new StringBuilder();
        segmenti.forEach((numero, segmento) -> {
            elementi.append("Segmento: ")
            .append(numero).append(" p1:")
            .append(segmento.p1().toString())
            .append(" |------| p2:")
            .append(segmento.p2().toString())
            .append("\n");    
        });
        return elementi.toString();
    }
}