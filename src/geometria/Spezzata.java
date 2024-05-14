package geometria;

import java.util.ArrayList;

import geometria.geo3D.Punto;
import geometria.geo3D.Segmento;

public class Spezzata {

    protected ArrayList<Punto> punti;

    //costruttori
    public Spezzata(){}
    //come da richiesta 
    public Spezzata(Punto origine) {
        this.punti = new ArrayList<>();
    }
    //metodi
    //aggiunge un Punto e quindi un segmento come da richiesta
    public void aggiungiPunto(Punto p){ this.punti.add(p); }

    public void aggiungiPunto(geometria.geo2D.Punto p){ punti.add(new Punto(p.x(), p.y(), 0)); }

    public void chiudi(){ this.punti.add(punti.get(0)); }

    public int quanti(){ return punti.size()-1; }

    public double lunghezza(){
        double lunghezza=0;
        for (int i = 0; i < punti.size()-1; i++) {
            lunghezza+=(new Segmento(punti.get(i), punti.get(i+1)).lunghezza());
        }
        return lunghezza;
    }
    
    public Punto eliminaP(Punto P){
        if (punti.size()<3) return null; // meno di 3 segmenti, rimarebbe un solo segmento
        //per iniziare uso la distanza tra P e il primo punto della spezzata
        int quale = 0;
        double distanza = (new Segmento(punti.get(0), P)).lunghezza();
        for (int i = 1; i < punti.size(); i++) {
            double d = (new Segmento(punti.get(i), P)).lunghezza();
            if (d<distanza) {
                quale = i;
                distanza = d;
            }
        }
        Punto eliminato = punti.remove(quale);
        return eliminato;
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
        return elementi.toString();
    }
}