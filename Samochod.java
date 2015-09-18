import greenfoot.*;

public class Samochod extends Actor {
    
    // Zmienna odpowiedzialna za prędkość poruszania się.     
    public int predkoscPoruszaniaSie = 1;
    // Wartosc współrzędnej X mówiąca nam kiedy usunąć samochód.
    public int kiedyUsunac = 5;
    
    /**
     * Act - do whatever the Samochod wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
       // Pobieramy aktualne współrzędne samochodu. 
       int wspolrzednaX = getX();
       int wspolrzednaY = getY();
       // Ustawiamy nowe współrzędne samochodu
       // biorąc pod uwagę przesunięcie.
       setLocation(wspolrzednaX - predkoscPoruszaniaSie , wspolrzednaY); 
       // Wywołujemy metodę do usuwania samochodów.
       usunSamochod();
       // Wywołanie metody, która usunie samochód w wypadku 
       obsluzZderzenie();
    }    
    
    public void usunSamochod() {
        int wspolrzednaX = getX();
        if (wspolrzednaX < kiedyUsunac) {
            // Pobieramy świat i usuwamy z niego dany obiekt.
            getWorld().removeObject(this);
        }    
    }   
    
    public void obsluzZderzenie() {
        // Pobieramy świat.
        World droga = getWorld();
        // Sprawdzamy czy samochód należy do świata (droga != null)
        // Wywołujemy metodę z Greenfoot'a, która zwróci wartość true
        // jeśli obiekty klasy Samochod się zetkną.         
        if (droga != null && isTouching(Samochod.class)) {
            // Usuwamy samochód.
            droga.removeObject(this);
        }
    }
}
