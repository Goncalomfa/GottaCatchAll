package JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pokemonV2.Ash;
import pokemonV2.CatchEmAll;
import pokemonV2.Kanto;

class CatchEmAllTest {

	CatchEmAll catchem;
	Kanto kanto;
	Ash ash;

	@BeforeEach
	void setUp() throws Exception {
		kanto = new Kanto();
		this.ash = new Ash(2, 2);
		catchem = new CatchEmAll(ash, kanto);
	}


	@Test
	void testMovementS() {
		catchem.movement("S");
		assertEquals(ash.getPosition_y(), 1);
	}

	@Test
	void testMovementN() {
		catchem.movement("N");
		assertEquals(ash.getPosition_y(), 3);
	}

	@Test
	void testMovementE() {
		catchem.movement("E");
		assertEquals(ash.getPosition_x(), 3);
	}

	@Test
	void testMovementO() {
		catchem.movement("O");
		assertEquals(ash.getPosition_x(), 1);
	}
	
	@Test
	void testStorePokemon() {
		catchem.storePokemon();
	}
}
