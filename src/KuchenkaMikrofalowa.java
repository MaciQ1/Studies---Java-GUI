class KuchenkaMikrofalowa {
    public void gotujPotrawe(Potrawa potrawa) {
        potrawa.gotuj();
        if (potrawa instanceof PotrawaRozmrazanie) {
            PotrawaRozmrazanie potrawaRozmrazanie = (PotrawaRozmrazanie) potrawa;
            if (!potrawaRozmrazanie.nadajeSieDoRozmrazania()) {
                System.out.println("Potrawa nie nadaje się do rozmrożenia");
            }
        }
    }
}