package JUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pokemonV2.Kanto;

class KantoTest {

	Kanto kanto;
	
	@BeforeEach
	void setUp() throws Exception {
		kanto = new Kanto();
	}

	@Test
	void testPokedex() {
		try {
			HashMap<Integer, String> lista = kanto.pokedex();
			assertTrue(lista.containsKey(0));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testMapRegion() {	
		Object[][] lista = kanto.mapRegion();
		Object[] um = lista[0];
		Object[] dois = lista[0];
		assertTrue(Arrays.deepEquals(um, dois));
		
	}

}
