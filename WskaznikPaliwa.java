import greenfoot.*;
// Pamiętajmy o dopisaniu tej intrukcji!
import java.awt.Color;

public class WskaznikPaliwa extends Actor
{
    // Zmienna reprezentująca początkowy stan wyświetlacza.
    public double wyswietlaczPaliwa = 0.0;
    
    public void act() {
        // Stworzenie obiektu obrazka.
        GreenfootImage wyswietlacz = new GreenfootImage("Paliwo: " + wyswietlaczPaliwa, 40,
        Color.GREEN, Color.BLACK);
        // Ustawienie obrazka dla klasy WskaznikPaliwa.
        setImage(wyswietlacz);
    }    
}
