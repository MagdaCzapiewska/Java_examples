package napisy;

public interface Napis {

	Napis doklej(Napis napis);

    Napis powtórz(int ile);

    Napis fragment(int start, int długość);

    int długość();

    default void appendTo(StringBuilder stringBuilder) {
        stringBuilder.append(this);
    }
	
}
