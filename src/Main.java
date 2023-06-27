import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        KuchenkaMikrofalowa kuchenka = new KuchenkaMikrofalowa();

        BazaDanych bazaDanych = new BazaDanych("BazaDoProjektuZPO.txt");
        List<Potrawa> potrawy = bazaDanych.wczytajPotrawyZPliku();

        Scanner scanner = new Scanner(System.in);

        System.out.println("-------- MENU --------");
        System.out.println("Wybierz potrawę do gotowania:");

        for (int i = 0; i < potrawy.size(); i++) {
            Potrawa potrawa = potrawy.get(i);
            System.out.println((i + 1) + ". " + potrawa.getNazwa());
        }

        System.out.println("0. Wyjście");
        System.out.println("----------------------");
        System.out.print("Wybór: ");

        int wybor = scanner.nextInt();
        scanner.nextLine(); // Pobierz znak nowej linii

        while (wybor != 0) {
            if (wybor >= 1 && wybor <= potrawy.size()) {
                Potrawa wybranaPotrawa = potrawy.get(wybor - 1);
                kuchenka.gotujPotrawe(wybranaPotrawa);
                System.out.println();
            } else {
                System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }

            System.out.println("-------- MENU --------");
            System.out.println("Wybierz potrawę do gotowania:");

            for (int i = 0; i < potrawy.size(); i++) {
                Potrawa potrawa = potrawy.get(i);
                System.out.println((i + 1) + ". " + potrawa.getNazwa());
            }

            System.out.println("0. Wyjście");
            System.out.println("----------------------");
            System.out.print("Wybór: ");

            wybor = scanner.nextInt();
            scanner.nextLine(); // Pobierz znak nowej linii
        }

        System.out.println("Zamykanie programu...");
        scanner.close();
    }
}
