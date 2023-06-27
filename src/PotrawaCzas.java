class PotrawaCzas extends Potrawa {
    public PotrawaCzas(String nazwa, int temperaturaMin, int temperaturaMax, int czasMin, int czasMax) {
        super(nazwa, temperaturaMin, temperaturaMax, czasMin, czasMax);
    }

    @Override
    public void gotuj() {
        System.out.println("Gotowanie potrawy: " + nazwa);
        System.out.println("Temperatura: " + temperaturaMin + "-" + temperaturaMax);
        System.out.println("Czas gotowania: " + czasMin + "-" + czasMax);

        if (!czyCzasWlasciwy()) {
            System.out.println("Za mały lub za duży czas. Potrawa nie będzie gotowa.");
        }
    }
}
