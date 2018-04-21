import java.util.TimerTask;		//<-- Zaimportowanie potrzebnej biblioteki

public class SimTask extends TimerTask {


    private SimEngine SE;
    private SpringApp SA;
    private double krok;
    /*Konstruktor z parametrami pozwalajšcy na przypisanie do pól klasy obiektu klasy
    SimEngine, obiektu klasy SpringApp i odstępu czasowego pomiędzy kolejnymi
    krokami symulacji*/
    public SimTask(SpringApp a, SimEngine e, double krok) {
        SA = a;
        SE = e;
        this.krok = krok;
    }

    public double getkrok() {
        return krok;
    }
    public void setkrok(double krok) {
        this.krok = krok;
    }

    public void run() {

        SE.Sim(krok);
        SA.repaint();
    }
}
