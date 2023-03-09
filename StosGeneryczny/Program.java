package stosGeneryczny;

public class Program {
	
	private static final int ILE = 5;

	public static void main(String[] args) throws NieZnajdujęElementu {
		
		Stos<Integer> s = new Stos<>();
		System.out.println(s.toString());
		
		for(int i = 0; i < ILE; ++i) {
			s.dodaj(i);
			System.out.println(s.toString());
		}
		
		while (!s.pusty()) {
			System.out.print(Integer.toString(s.zdejmij()));
			System.out.print(" ");
			System.out.println(s.toString());
		}
		
	}
	
}
