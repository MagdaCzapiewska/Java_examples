package napisy;

public class Sklejenie extends Efektywny{

	private final Napis lewy;
	
	private final Napis prawy;
	
	private final int długość;
	
	Sklejenie(Napis lewy, Napis prawy) {
		this.lewy = lewy;
		this.prawy = prawy;
		this.długość = lewy.długość() + prawy.długość();
	}
	
	public int długość() {
		return długość;
	}
	
	@Override
	public void appendTo(StringBuilder stringBuilder) {
		lewy.appendTo(stringBuilder);
		prawy.appendTo(stringBuilder);
	}
	
}
