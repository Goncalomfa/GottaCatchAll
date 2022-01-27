package pokemonV1;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	private static HashMap<Integer, ArrayList<Integer>> posAnt = new HashMap<Integer,ArrayList<Integer>>();

	public static void main(String[] args) throws FileNotFoundException {

		//situar ash
		Ash ash = new Ash(0,0);

		//primeiro pokemon
		posAnt.put(1, (new ArrayList<Integer>() ));
		posAnt.get(1).add(1); posAnt.get(1).add(1);
		System.out.println("ADD 1");


		//movimento e catch'em all
		CatchEmAll catchall = new CatchEmAll(ash);
		for(int numMovs = 0; numMovs < args[0].length(); numMovs++) {
			String move = args[0].substring(numMovs, numMovs+1);
			catchall.movement(move); //e storePokemon
		}

		//output
		int max = ash.maxElement();
		System.out.println("Pokemons apanhados : " + (max+1));
	}

}
