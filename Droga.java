import greenfoot.*;

/**
 * Write a description of class Droga here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Droga extends World
{

    /**
     * Constructor for objects of class Droga.
     * 
     */
    public Droga() {    
        // Stwórz nowy świat o rozmiarze 600x400 punktów o rozmiarze 1x1 piksela.
        super(800, 600, 1); 
        // Wywołanie metody przygotujSwiat, która doda nam obiekt radiowozu do świata.
        przygotujSwiat();
    }
    
    public void przygotujSwiat() {
        // Stworzenie obiektu o nazwie policja o typie Radiowoz.
        Radiowoz policja = new Radiowoz();
        // Dodanie obiektu o nazwie policja do świata pod współrzędne 70x100.
        // Dzięki wywołaniu metody addObject samochod pojawi się na drodzę.
        addObject(policja, 70, 100);                        
        // Dodanie wyświetlacza do świata.
        addObject(policja.wyswietlacz, 400, 20); 
    }
    
    // Liczba ustalająca jak często wylosowany samochód pojawi się na drodze.
    public int pokazSamochod = 5;
    
    public Samochod zwrocLosowySamochod() {
        // Losujemy liczbę od 0 do 2.
        int wylosowanaLiczba = Greenfoot.getRandomNumber(3);
        // Tworzymy zmienną na wylosowany samochód.
        Samochod wylosowanySamochod = null;
        if (wylosowanaLiczba == 0) {
            wylosowanySamochod = new Sedan();
        } else if (wylosowanaLiczba == 1) {
            wylosowanySamochod = new Ciezarowka();
        } else if (wylosowanaLiczba == 2) {
            wylosowanySamochod = new Wyscigowka();
        }     
        // Zwracamy wylosowany samochód.
        return wylosowanySamochod;
    }   
    
    public void act() {
        // Losuje liczbę od 0 do 999.
        int prawdopodobienstoSamochodu = Greenfoot.getRandomNumber(1000);
        if (prawdopodobienstoSamochodu >= pokazSamochod) {
            // Nie dodawaj samochodu do drogi.
            return;
        } else {
            // Pobierz wylosowany samochód.
            Samochod wylosowany = zwrocLosowySamochod();
            // Chcemy aby samochód pojawiał się po prawej 
            // stronie (pobieramy szerokość świata).
            int wspolrzednaX = getWidth();
            // Losujemy współrzędną Y, pobierając wysokość świata.
            int wspolrzednaY = Greenfoot.getRandomNumber(getHeight()) + 1;
            // Dodaj wylosowany samochód.
            addObject(wylosowany, wspolrzednaX, wspolrzednaY);
            
        }    
    }    
}
