package napisy;

public abstract class Efektywny implements Napis {
	
	@Override
	public Napis doklej(Napis napis) {
		return new Sklejenie(this, napis);
	}
	
	@Override 
	public Napis powtórz(int ile) {
		return new Zwielokrotnienie(this, ile);
	}
	
	@Override 
	public Napis fragment(int start, int długość) {
		return new Wycinek(this, start, długość);
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		this.appendTo(stringBuilder);
		
		return stringBuilder.toString();
	}
	
}
