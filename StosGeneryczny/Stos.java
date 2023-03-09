package stosGeneryczny;

import java.lang.StringBuilder;

public class Stos<T> implements InterfejsStosu<T> {
	
	private WęzełListy<T> naGórzeStosu = null;
	
	private int długośćListy = 0;

	@Override
	public boolean pusty() {
		if (długośćListy == 0) {
			return true;
		}
		return false;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public void dodaj(Object wartość) {
		WęzełListy<T> nowy = new WęzełListy<>((T)wartość, naGórzeStosu);
		naGórzeStosu = nowy;
		++długośćListy;
	}
	
	@Override
	public T zdejmij() throws NieZnajdujęElementu {
		if (pusty()) {
			throw new NieZnajdujęElementu();
		}
		else {
			T pamiętaj = naGórzeStosu.pokażWartość();
			naGórzeStosu = naGórzeStosu.dajPoprzedniego();
			--długośćListy;
			return pamiętaj;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder wynik = new StringBuilder();
		wynik.append("[ ");
		
		WęzełListy<T> pomocniczy = naGórzeStosu;
		while(pomocniczy != null) {
			wynik.append(pomocniczy.toString());
			wynik.append(" ");
			pomocniczy = pomocniczy.dajPoprzedniego();
		}
		wynik.append("]");
		return wynik.toString();
	}
	
}
