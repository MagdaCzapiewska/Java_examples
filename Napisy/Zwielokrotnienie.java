package napisy;

public class Zwielokrotnienie extends Efektywny {

	private final Napis człon;
	
	private final int mnożnik;
	
	private final int długość;
	
	Zwielokrotnienie(Napis człon, int mnożnik) {
		this.człon = człon;
		this.mnożnik = mnożnik;
		this.długość = człon.długość() * mnożnik;
	}
	
	public int długość() {
		return długość;
	}
	
	@Override
	public void appendTo(StringBuilder stringBuilder) {
		for (int i = 0; i < mnożnik; ++i) {
			człon.appendTo(stringBuilder);
		}
	}

}
