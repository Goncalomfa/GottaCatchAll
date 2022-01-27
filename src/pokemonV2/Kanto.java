package pokemonV2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Kanto {


	protected static Object[][] region = new Object[12][12];
	private static HashMap<Integer, String> pokemons = new HashMap<>();


	public Kanto() throws FileNotFoundException {
		pokedex();
		mapRegion();
	}

	public HashMap<Integer, String> pokedex() throws FileNotFoundException {

		String s = ""; int countHash = 0;
		Scanner sc = new Scanner(new File("C:/Users/dxgon/eclipse-workspace/Pokemon/src/pokemonkanto.txt"));
		while(sc.hasNext()) {
			s = sc.next();
			pokemons.put(countHash, s);
			countHash++;
		}
		return pokemons;
	}

	public Object[][] mapRegion() {
		int index = 0; int index2 = 143; Random pokemon = new Random();
		for(int x = 0; x<12 ; x++) {
			for(int y = 0; y<12; y++) {
				if(pokemon.nextBoolean()==true) {
					region[x][y] = index;
					index++;
				} else {
					region[x][y] = index2;
					index2--;
				}
			}
		}
		return region;
	}

	public Object[][] getRegion() {
		return region;
	}

	public HashMap<Integer, String> getPokemons() {
		return pokemons;
	}

}
