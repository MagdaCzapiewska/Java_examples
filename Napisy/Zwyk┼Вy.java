package napisy;

public class Zwykły implements Napis {

    private final String zawartość;

    Zwykły(String zawartość) {
        this.zawartość = zawartość;
    }

    @Override
    public Napis doklej(Napis napis) {
        return new Zwykły(toString() + napis);
    }

    @Override
    public Napis powtórz(int ile) {
        return new Zwykły(zawartość.repeat(ile));
    }

    @Override
    public Napis fragment(int start, int długość) {
        return new Zwykły(zawartość.substring(start, start + długość));
    }

    @Override
    public int długość() {
        return zawartość.length();
    }

    @Override
    public String toString() {
        return zawartość;
    }

}
