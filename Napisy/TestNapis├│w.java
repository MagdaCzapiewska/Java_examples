package napisy;

public class TestNapisów {
	private static void test(Napis napis, Napis dopisek, Napis odgłosRaz) {
		System.out.println(napis.toString());
		
		System.out.println("A teraz napis powstały po sklejeniu z innym: ");
		Napis poSklejeniu = napis.doklej(dopisek);
		System.out.println(poSklejeniu.toString());
		
		System.out.println("Jakie zwierzątka ma dziewczynka? (testowanie metody fragment())");
		Napis zwierzątka = poSklejeniu.fragment(7, 10);
		System.out.println(zwierzątka.toString());
		
		System.out.println("Kot mówi: (testowanie metody powtórz())");
		Napis odgłos = odgłosRaz.powtórz(3);
		System.out.println(odgłos.toString());
		
		System.out.println("Ile liter wypowiedział kot?");
		System.out.println(Integer.toString(odgłos.długość()));
	}

	public static void main(String[] args) {
		Napis pierwszyNapis = Fabryka.zwykły("Ala ma kota ");
		Napis dopisek = Fabryka.zwykły("i psa");
		Napis odgłosRaz = Fabryka.zwykły("Miau");
		System.out.println("To jest pierwszy napis:");
		test(pierwszyNapis, dopisek, odgłosRaz);
		Napis drugiNapis = Fabryka.efektywny("Ola ma kota ");
		Napis drugiDopisek = Fabryka.efektywny("i psa");
		Napis drugiOdgłos = Fabryka.efektywny("Miau");
		System.out.println("To jest drugi napis:");
		test(drugiNapis, drugiDopisek, drugiOdgłos);
		
	}
	
}
