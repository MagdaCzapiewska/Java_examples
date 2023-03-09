package stosGeneryczny;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StosTest {

	private final int PIERWSZA = 10;
	private final int DRUGA = 11;
	private final int TRZECIA = 12;
	private String napis = "[ 12 11 10 ]";
	private Stos<Integer> stos = new Stos<>();

	@Test
	public void testPustyTrue() {
		assertTrue(stos.pusty());
	}
	
	@Test
	public void testPustyFalse() {
		stos.dodaj(PIERWSZA);
		assertFalse(stos.pusty());
	}
	
	@Test
	public void testZdejmijUdany() throws NieZnajdujęElementu {
		stos.dodaj(DRUGA);
		stos.dodaj(TRZECIA);
		assertEquals(TRZECIA, stos.zdejmij());
	}
	
	@Test
	public void testToString() throws NieZnajdujęElementu {
		stos.dodaj(PIERWSZA);
		stos.dodaj(DRUGA);
		stos.dodaj(TRZECIA);
		assertEquals(napis, stos.toString());
	}
	
	@Test
	public void testNieMogęZdjąć() throws NieZnajdujęElementu {
		stos.dodaj(PIERWSZA);
		stos.dodaj(DRUGA);
		stos.dodaj(TRZECIA);
		int pom = stos.zdejmij();
		pom = stos.zdejmij();
		pom = stos.zdejmij();
		assertThrows(NieZnajdujęElementu.class, () -> {
			int nieUdaSię = stos.zdejmij();
		});
	}

}
