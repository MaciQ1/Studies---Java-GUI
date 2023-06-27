class PotrawaTemperatura extends Potrawa {
    public PotrawaTemperatura(String nazwa, int temperaturaMin, int temperaturaMax, int czasMin, int czasMax) {
        super(nazwa, temperaturaMin, temperaturaMax, czasMin, czasMax);
    }

    @Override
    public void gotuj() {
        System.out.println("Gotowanie potrawy: " + nazwa);
        System.out.println("Temperatura: " + temperaturaMin + "-" + temperaturaMax);
        System.out.println("Czas gotowania: " + czasMin + "-" + czasMax);

        if (!czyTemperaturaWlasciwa()) {
            System.out.println("Za mała lub za duża temperatura. Potrawa nie będzie gotowa.");
        }
    }
}