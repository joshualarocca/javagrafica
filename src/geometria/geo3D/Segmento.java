package geometria.geo3D;

public class Segmento {
    //attr
    protected Punto p1;
    protected Punto p2;
    //costruttore
    //costruttore base, come da richiesta
    public Segmento(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
    //costruttore con coordinate dei punti
    public Segmento(double x1, double y1, double z1, double x2, double y2, double z2){ this(new Punto(x1,y1,z1), new Punto(x2, y2, z2)); }
    //metodi
    public void setP1(Punto p1) { this.p1 = p1; }
    public void setP2(Punto p2) { this.p2 = p2; }
    public Punto p1() { return p1; }
    public Punto p2() { return p2; }
    public Double lunghezza(){ return p1.distanza(p2); }
}