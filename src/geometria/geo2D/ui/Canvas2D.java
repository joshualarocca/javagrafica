package geometria.geo2D.ui;

//librerie grafiche
import geometria.geo2D.Punto;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JPanel;


class Canvas2D extends JPanel {
    // todo: le proporzioni dinamiche
    int xMin, xMax, yMin, yMax; // valore degli estremi del piao cartesiano
    int l = 500, h = 500;// salvo dimensioni della finestra in delle variabili per renderle più facili da
    double propX, propY;
    //static public float a = 30;
    ArrayList<Punto> punti;

    public Canvas2D(ArrayList<Punto> punti, int max, int canvasL, int canvasH) {
        this.punti = punti;
        //imposto i limiti di visualizzazione del piano cartesian

        this.xMin=(int) -(max*1.05); //per stabilire i bordi del piano cartesiano
        this.xMax=(int) (max*1.05); //per stabilire i bordi del piano cartesiano
        this.yMin=xMin;
        this.yMax=xMax;
        this.l = canvasL;
        this.h = canvasH;
       
        //imposto le proporzioni
        propX = (l/2) / max; //es: (500/2) / 50
        propY = (h/2) / max;
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        setBackground(Color.WHITE);
        //intervallo contiene la proporzione tra dimensioni del Canvas e valori da visualizzare
        
        g.setColor(Color.black); //prendo il pennarello nero
        g.drawRect(0, 0, l - 1, h - 1); //disegno il bordo del foglio

        //disegno gli assi
        g.setColor(Color.red); //prendo il pennarello rosso

        g.drawLine(0, h / 2, l, h / 2); //linea delle x

        g.drawLine(l / 2, 0, l / 2, h); //linea delle y

        //e le etichette degli assi
        g.drawString("" + xMin, 5, h / 2 - 5);
        g.drawString("" + xMax, l - 20, h / 2 - 5);
        g.drawString("" + yMax, l / 2 + 5, 15);
        g.drawString("" + yMin, l / 2 + 5, h - 5);

        g.setColor(Color.blue);
        disegnaG(g);
    }

    /*
     * void disegnaG(Graphics g, float x, float y){
     * if (x<xMin || x>xMax || y<yMin || y>yMax ) return;
     * int ix = Math.round((x-xMin)*propX);
     * int iy = h-Math.round((y-yMin)*propy);
     * g.drawLine(ix,iy,ix,iy);
     * }
     */

    void disegnaG(Graphics g){
        //il canvas ha solo coordinate positive, devo compensare i valori dei punti con
        int cx=h/2; //centro x 250
        int cy=l/2; //centro y 250
        String punto;
        DecimalFormat df = new DecimalFormat("0.00");
        for (int i = 1; i < punti.size(); i++) {
            //calcolo le coordinate dei punti sul Canvas rispettando le proporzioni
            int x1 = (int) ( punti.get(i-1).x()*propX); //proporziono x1
            int y1 = (int) ( punti.get(i-1).y()*propY);
            int x2 = (int) ( punti.get(i).x()*propX);
            int y2 = (int) ( punti.get(i).y()*propY);
            punto = "P" + (i-1) + " ("+df.format(punti.get(i-1).x())+" "+df.format(punti.get(i-1).y())+")";
            g.drawString(punto, x1-5+cx,cy-y1-5);
            //disegno il segmento spostando il centro a metà del canvas
            //per poter visualizzare anche i valori negativi
            g.drawLine(cx+x1, cy-y1, cx+x2, cy-y2);
        }
    }
}