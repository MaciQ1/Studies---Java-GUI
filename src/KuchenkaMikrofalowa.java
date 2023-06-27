// Klasa reprezentująca kuchenkę mikrofalową
class KuchenkaMikrofalowa {
    public void gotujPotrawe(Potrawa potrawa) {
        if (!potrawa.czyTemperaturaWlasciwa()) {
            System.out.println("Temperatura spoza zakresu. Potrawa spali się.");
        } else if (!potrawa.czyCzasWlasciwy()) {
            System.out.println("Czas spoza zakresu. Potrawa nie będzie gotowa.");
        } else {
            potrawa.gotuj();
            if (potrawa instanceof PotrawaRozmrazanie) {
                PotrawaRozmrazanie potrawaRozmrazanie = (PotrawaRozmrazanie) potrawa;
                if (!potrawaRozmrazanie.nadajeSieDoRozmrozenia()) {
                    System.out.println("Potrawa nie nadaje się do rozmrożenia");
                }
            }
        }
    }
}