// Klasa abstrakcyjna reprezentująca potrawę
abstract class Potrawa {
    protected int temperatura;
    protected int czasGotowania;

    public Potrawa(int temperatura, int czasGotowania) {
        this.temperatura = temperatura;
        this.czasGotowania = czasGotowania;
    }

    public abstract void gotuj();

    public int getTemperatura() {
        return temperatura;
    }

    public int getCzasGotowania() {
        return czasGotowania;
    }
}