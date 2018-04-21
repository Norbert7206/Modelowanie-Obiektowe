public class Vector2D {
   public double x,y;
     // public double xDodawanie,yDodawanie;
     // public double xOdejmowanie,yOdejmowanie;
     //public double xMnozenie,yMnozenie;
     // public double dlugoscWektora;
   public double dlugoscWektora;

    public Vector2D()  //deklaracja konstruktora bez parametru
    {
        x=0;
        y=0;

    }
    public Vector2D(double xx,double yy)     //deklaracja konstruktora z parametrem
    {
       x=xx;
       y=yy;

    }
    public Vector2D DodawanieWektorów(Vector2D wd)
    {
       // xDodawanie=xd+x ;
        // yDodawanie=yd+y ;
       return new Vector2D(x+wd.x,y+wd.y);


    }
    public Vector2D OdejmowanieWektorów(Vector2D wo)
    {
        return new Vector2D(x-wo.x, y-wo.y);
    }

    public Vector2D MnożenieWektora(double m )
    {
       return new Vector2D(x*m,y*m);

    }

    public double GetDlugoscWektora()
    {
        dlugoscWektora=Math.sqrt(x*x+y*y);

        return dlugoscWektora;
    }
    public Vector2D ZnormalizowanyWektor()
    {
      return new Vector2D(x/GetDlugoscWektora(),y/GetDlugoscWektora());

    }



}
