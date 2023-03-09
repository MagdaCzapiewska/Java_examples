package stosGeneryczny;

public interface InterfejsStosu<T> {
	
	boolean pusty();
	
	void dodaj(T wartość);
	
	T zdejmij() throws NieZnajdujęElementu;
	
}
