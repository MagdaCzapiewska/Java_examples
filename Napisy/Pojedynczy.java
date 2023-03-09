package napisy;

public class Pojedynczy extends Efektywny {

	private final String zawartość;
	
	Pojedynczy(String zawartość) {
		this.zawartość = zawartość;
	}
	
	@Override 
	public int długość() {
		return zawartość.length();
	}
	
	@Override
	public void appendTo(StringBuilder stringBuilder) {
		stringBuilder.append(zawartość);
	}
	
}
