class PotrawaRozmrazanie extends Potrawa {
    private boolean mrozone;

    public PotrawaRozmrazanie(String nazwa, int temperaturaMin, int temperaturaMax, int czasMin, int czasMax, boolean mrozone) {
        super(nazwa, temperaturaMin, temperaturaMax, czasMin, czasMax);
        this.mrozone = mrozone;
    }

    public boolean nadajeSieDoRozmrozenia() {
        return mrozone;
    }

    @Override
    public void gotuj() {
        System.out.println("Rozmrażanie potrawy: " + nazwa);
        System.out.println("Temperatura: " + temperaturaMin + "-" + temperaturaMax);
        System.out.println("Czas rozmrażania: " + czasMin + "-" + czasMax);
    }
}