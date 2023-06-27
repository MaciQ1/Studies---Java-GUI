import java.util.List;

// Klasa główna programu
public class Main {
    public static void main(String[] args) {
        KuchenkaMikrofalowa kuchenka = new KuchenkaMikrofalowa();

        BazaDanych bazaDanych = new BazaDanych("BazaDoProjektuZPO.txt");
        List<Potrawa> potrawy = bazaDanych.wczytajPotrawyZPliku();

        for (Potrawa potrawa : potrawy) {
            kuchenka.gotujPotrawe(potrawa);
            System.out.println();
        }
    }
}