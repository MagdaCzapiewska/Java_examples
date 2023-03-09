package stosGeneryczny;

public class WęzełListy<T> {
	
	private T wartość;
	
	private WęzełListy<T> poprzedni;
									
	public WęzełListy(T wartość, WęzełListy<T> poprzedni) {
		this.wartość = wartość;
		this.poprzedni = poprzedni;
	}
	
	public WęzełListy<T> dajPoprzedniego() {
		return poprzedni;
	}
	
	public T pokażWartość() {
		return wartość;
	}
	
	public String toString() {
		return wartość.toString();
	}
	
}
