import greenfoot.*;

/**
 * Write a description of class Radiowoz here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Radiowoz extends Samochod
{
    // Ilość paliwa w baku. Przyjmijmy, iż każdy nowy radiowóz
    // dostanie na starcie 100 litrów paliwa.
    public double iloscPaliwa = 100.0;
    // Wyswietlacz paliwa
    public WskaznikPaliwa wyswietlacz = new WskaznikPaliwa();
    
    // Definiujemy prędkość z jaką będzie poruszał się samochód.
    public int predkoscPoruszaniaSie = 1;       
    
    /**
     * Act - do whatever the Radiowoz wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Wywołujemy metodę przemieszczajSie w metodzie act, 
        //która jest wywoływana cyklicznie przez Greenfoot'a.
        przemieszczajSie();
        // Przypisujemy wartości paliwa na wyświtlaczu ilość paliwa w baku.
        wyswietlacz.wyswietlaczPaliwa = iloscPaliwa;
        // Tankowanie paliwa po naciśnięciu spacji.
        if (Greenfoot.isKeyDown("space")) {
            Ropa diesel = new Ropa();
            tankuj(diesel);
        }    
    }    
    
    public void przemieszczajSie() {                        
        // Poniżej pobieramy aktualne współrzędne radiowozu.
        int wspolrzednaRadiowozuX = getX();
        int wspolrzednaRadiowozuY = getY();
        // If który sprawdzi czy mamy paliwo w baku.
        if (iloscPaliwa > 0.0) {
        
            if (Greenfoot.isKeyDown("up")) {
                // W odpowiedzi na naciśnięcie konkretnego klawisza modyfikujemy współrzędną
                //o prędkość poruszania.
                setLocation(wspolrzednaRadiowozuX, wspolrzednaRadiowozuY - predkoscPoruszaniaSie);
                // Za pomocą tej metody spalamy paliwo w baku.
                spalajPaliwo();
            } else if (Greenfoot.isKeyDown("down")) {
                 setLocation(wspolrzednaRadiowozuX, wspolrzednaRadiowozuY + predkoscPoruszaniaSie);
                 spalajPaliwo();
            } else if (Greenfoot.isKeyDown("left")) {
                 setLocation(wspolrzednaRadiowozuX - predkoscPoruszaniaSie, wspolrzednaRadiowozuY);
                 spalajPaliwo();
            } else if (Greenfoot.isKeyDown("right")) {
                 setLocation(wspolrzednaRadiowozuX + predkoscPoruszaniaSie, wspolrzednaRadiowozuY);
                 spalajPaliwo();
            }      
       }
    }
    
    public void spalajPaliwo() {
        // W taki sposób będziemy za każdym razem zmniejszać ilość paliwa o 1.0.
        iloscPaliwa = iloscPaliwa - 1.0;
        // Ta instrukcja pozwoli nam wyświetlić w specjalnym okienku
        // aktualny stan paliwa.      
        System.out.println(iloscPaliwa);
    }   
    
    public void tankuj(Paliwo paliwo) {
      if (iloscPaliwa < 100) {
          iloscPaliwa = iloscPaliwa + 1;
      }    
    }    
}
