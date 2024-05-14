package geometria;

import java.util.ArrayList;
import java.util.HashMap;

import geometria.geo3D.Punto;
import geometria.geo3D.Segmento;

public class Spezzata {
    //attr
    protected Punto origine; //origine della spezzata
    protected Punto fine;
    //variabili di Classe
    protected int numero;
    protected HashMap<Integer, Segmento> segmenti;

    protected ArrayList<Punto> punti;

    //costruttori
    public Spezzata(){}
    //come da richiesta 
    public Spezzata(Punto origine) {
        this.punti = new ArrayList<>();
        /* con HashMap 
        this.numero=0;
        this.origine = origine;
        this.fine = origine;
        this.segmenti = new HashMap<>();
        */
    }
    //metodi
    //aggiunge un Punto e quindi un segmento come da richiesta
    public void aggiungiPunto(Punto p){
        this.punti.add(p);
        /* con HashMap 
        Segmento nuovo = new Segmento(fine, p); //creo il segmento
        this.fine = p;
        segmenti.put(numero,nuovo);
        numero++;
        */
    }

    public void aggiungiPunto(geometria.geo2D.Punto p){
        punti.add(new Punto(p.x(), p.y(), 0));
    }

    public void chiudi(){ 
        this.punti.add(punti.get(0));
        /* con HashMap 
        segmenti.put(numero,new Segmento(fine, origine)); 
        */
    }

    public int quanti(){
        return punti.size()-1;
        //return segmenti.size(); 
    }

    public double lunghezza(){
        double lunghezza=0;
        for (int i = 0; i < punti.size()-1; i++) {
            lunghezza+=(new Segmento(punti.get(i), punti.get(i+1)).lunghezza());
        }
        /* con HashMap
        for (Segmento segmento : segmenti.values()) {
            lunghezza+=segmento.lunghezza();
        };
        */
        return lunghezza;
    }
    
    @Override
    public String toString() {
        StringBuilder elementi = new StringBuilder();
        for (int i = 0; i < punti.size()-1; i++) {
            elementi.append("Segmento: ")
            .append(i+1).append(" da p1:")
            .append(punti.get(i).toString())
            .append(" |---| p2:")
            .append(punti.get(i+1).toString())
            .append("\n"); 
        }

        /* con HashMap
            segmenti.forEach((numero, segmento) -> {
            elementi.append("Segmento: ")
            .append(numero).append(" da p1:")
            .append(segmento.p1().toString())
            .append(" |---| p2:")
            .append(segmento.p2().toString())
            .append("\n");    
        });
        */
        return elementi.toString();
    }
}