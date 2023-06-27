// Klasa główna programu
public class Main {
    public static void main(String[] args) {
        KuchenkaMikrofalowa kuchenka = new KuchenkaMikrofalowa();

        // Przykład gotowania pizzy
        Potrawa pizza = new Pizza(200, 5);
        kuchenka.gotujPotrawe(pizza);

        System.out.println();

        // Przykład gotowania zupy
        Potrawa zupa = new Zupa(100, 6);
        kuchenka.gotujPotrawe(zupa);
    }
}
