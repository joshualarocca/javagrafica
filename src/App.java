import java.util.Random;

import geometria.geo3D.Punto;

public class App {
    public static void main(String[] args) throws Exception {
        // istanzio il generatore di numeri pseudocasuali
        Random miaRandom = new Random();
        // istanzio la spezzata di punti nello spazio
        Punto mioPunto = 
            new Punto(miaRandom.nextDouble()*100,miaRandom.nextDouble()*100);
        geometria.Spezzata miaSpezzata = new geometria.Spezzata(mioPunto);
        for (int i = 0; i < miaRandom.nextInt(10)+3; i++) { //aggiungo altri 4 vertici
            miaSpezzata.aggiungiPunto(new geometria.geo2D.Punto(miaRandom.nextDouble()*100,miaRandom.nextDouble()*100));
        }
        //chiudo la spezzata
        miaSpezzata.chiudi();

        geometria.Spezzata miaSpezzata3D = new geometria.Spezzata(new geometria.geo3D.Punto(miaRandom.nextDouble()*100,miaRandom.nextDouble()*100, miaRandom.nextDouble()*100));
        for (int i = 0; i < miaRandom.nextInt(10)+3; i++) { //aggiungo altri 4 vertici
            miaSpezzata3D.aggiungiPunto(new geometria.geo3D.Punto(miaRandom.nextDouble()*100,miaRandom.nextDouble()*100,miaRandom.nextDouble()*100));    
        }
        //chiudo la spezzata
        miaSpezzata3D.chiudi();
    
        System.out.println("\nSpezzata 2D lunga "+miaSpezzata.lunghezza()+" in " +miaSpezzata.quanti()+" segmenti:\n");
        System.out.println(miaSpezzata.toString());

        System.out.println("\nSpezzata 3D lunga "+miaSpezzata3D.lunghezza()+" in " +miaSpezzata3D.quanti()+" segmenti:\n");
        System.out.println(miaSpezzata3D.toString());

        Punto daEliminare = new geometria.geo3D.Punto(miaRandom.nextDouble()*100,miaRandom.nextDouble()*100,miaRandom.nextDouble()*100);

        System.out.println("Ho eliminato il Punto più vicino a " 
            + daEliminare.toString()
            + " ed era "+
            miaSpezzata3D.eliminaP(daEliminare));

        System.out.println("\nSpezzata 3D lunga "+miaSpezzata3D.lunghezza()+" in " +miaSpezzata3D.quanti()+" segmenti:\n");
        System.out.println(miaSpezzata3D.toString());

    }
}