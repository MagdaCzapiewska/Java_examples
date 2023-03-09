package napisy;

public class Fabryka {

	public static Napis zwykły(String string) {
        return new Zwykły(string);
    }
	
	public static Napis efektywny(String string) {
		return new Pojedynczy(string);
	}
	
}
