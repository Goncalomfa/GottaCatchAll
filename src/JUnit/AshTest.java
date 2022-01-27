package JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pokemonV2.Ash;

class AshTest {

	Ash ash;

	@BeforeEach
	void setUp() throws Exception {
		this.ash = new Ash(0, 0);
	}
	
	@Test
	void testSetPokemonStored() {
		ash.setPokemonStored(1, "bulbasaur");
		assertTrue(ash.getPokemonStored().containsKey(1) && ash.getPokemonStored().get(1) != null);
	}

}
