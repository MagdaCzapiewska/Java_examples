package napisy;

public class Wycinek extends Efektywny {

	private final Napis całość;
	
	private int start;
	
	private int długość;
	
	Wycinek(Napis całość, int start, int długość) {
		this.całość = całość;
		this.start = start;
		this.długość = długość;
	}
	
	public int długość() {
		return długość;
	}
	
	@Override
	public void appendTo(StringBuilder stringBuilder) {
		String string = całość.toString();
		stringBuilder.append(string.substring(start, start + długość));
	}
}
