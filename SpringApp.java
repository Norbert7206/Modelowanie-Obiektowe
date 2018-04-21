
import java.awt.*;
import javax.swing.*;

import java.util.Timer;

public SpringApp(double w,double s) {
        super("Model");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300, 200);
        setSize(300, 300);
        setResizable(false);
        setVisible(true);
        // SE = new SimEngine(10.0,2.0,3.0,4.0, new Vector2D(0,0) ,new Vector2D(4,5), new Vector2D(6,9),new Vector2D(0,10));
        //   ST  = new SimTask(this,SE,5.0);
        // T  = new Timer();
        //  T.scheduleAtFixedRate(ST,0,(long) ST.getKrok());


public void paint(Graphics g) { //podwojne buforowanie
        buf = createImage((int)getHeight(),(int)getWidth());
        bufG = buf.getGraphics();
        paintComponent(bufG);
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(buf , 0 , 0 , null);
        }


public void paintComponent(Graphics g) { //rysowanie
        Vector2D pozM = SE.getpozM();
        Vector2D pozUtw = SE.getpozUtw();
        g.clearRect(0, 0, getWidth(), getHeight());
        g.drawLine( (int) pozUtw.x, (int)pozUtw.y, (int)pozM.x, (int) pozM.y );
        g.drawOval((int)pozM.x-10,(int) pozM.y-10,20,20);
        }

public static void  main(String[] args) {
        SpringApp okno = new SpringApp(400,600);
        SE = new SimEngine(10.0,2.0,3.0,4.0, new Vector2D(0,0) ,new Vector2D(4,5), new Vector2D(6,9),new Vector2D(0,10));
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setVisible(true);
        ST  = new SimTask(okno,SE,5.0);
        T = new Timer();
        T.scheduleAtFixedRate(ST,0,(long) ST.getKrok());



        }
}