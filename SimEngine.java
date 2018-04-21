public class SimEngine {

    // Prywatne pola parametrów symulacji
    private double masa, K, c, lo;
    private Vector2D pozM, pozUtw, predM, G;
    //akcesory
    public double getmasa() {
        return masa;
    }
    public void setmasa(double masa) {
        this.masa = masa;
    }
    public double getk() {
        return K;
    }
    public void setK(double K) {
        this.K = K;
    }
    public double getc() {
        return c;
    }
    public void setc(double c) {
        this.c = c;
    }
    public double getlo() {
        return lo;
    }
    public void setlo(double lo) {
        this.lo = lo;
    }
    public Vector2D getpozM() {
        return pozM;
    }
    public void setpozM(Vector2D pozM) {
        this.pozM = pozM;
    }
    public Vector2D getpozUtw() {
        return pozUtw;
    }
    public void setpozUtw(Vector2D pozUtw) {
        this.pozUtw = pozUtw;
    }
    public Vector2D getpredM() {
        return predM;
    }
    public void setpredM(Vector2D predM) {
        this.predM = predM;
    }
    public Vector2D getG() {
        return G;
    }
    public void setG(Vector2D G) {
        this.G = G;
    }

    SimEngine(double m, double k, double b, double l, Vector2D pol, Vector2D v, Vector2D u, Vector2D g) {

        masa = m;
        K = k;
        c = b;
        lo = l;
        pozM = pol;
        pozUtw = u;
        predM = v;
        G = g;
    }

    public void Sim(double krok){
        Vector2D Fg = G.MnożenieWektora(masa);
        Vector2D F1 = predM.MnożenieWektora(-c);
        Vector2D X = pozUtw.OdejmowanieWektorów(pozM);
        double e = X.GetDlugoscWektora() - lo;
        Vector2D F2 = X.ZnormalizowanyWektor().MnożenieWektora(K*e);
        Vector2D Fw = Fg.DodawanieWektorów(F2).DodawanieWektorów(F1);
        Vector2D a = Fw.MnożenieWektora(1.0/masa);
        Vector2D v1 = a.MnożenieWektora(krok);
        Vector2D v = predM.DodawanieWektorów(v1);
        Vector2D x3 = a.MnożenieWektora(krok*krok/2.0);
        Vector2D x2 = predM.MnożenieWektora(krok);
        Vector2D x1 = x2.DodawanieWektorów(x3);
        Vector2D x = pozM.DodawanieWektorów(x1);
        predM = v;
        pozM = x;
    }

    public void reset() {
        predM = new Vector2D();
    }
}