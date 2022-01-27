package pokemonV2;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Random;

public class Main {
	
	private static Object[][] region;
	private static HashMap<Integer, String> pokemonList;

	public static void main(String[] args) throws FileNotFoundException {
		
		//obter infos de kanto
		Kanto kanto = new Kanto();
		region = kanto.getRegion(); 
		pokemonList = kanto.getPokemons();
		
		//meter o ash em Pallet Town
		Ash ash = new Ash(6,4);
		region[6][4] = ash;
		
		//primeiro pokemon
		Random first = new Random();
		int numPoke = first.nextInt(2);
		if(numPoke == 0) ash.setPokemonStored(0, pokemonList.get(0));
		if(numPoke == 1) ash.setPokemonStored(3, pokemonList.get(3));
		if(numPoke == 2) ash.setPokemonStored(6, pokemonList.get(6));
		
			
		//movimento e catch'em all
		CatchEmAll catchall = new CatchEmAll(ash, kanto);
		int limiteConsecutivo = 0; String moveAnterior = null;
		for(int numMovs = 0; numMovs < args[0].length(); numMovs++) {
			String move = args[0].substring(numMovs, numMovs+1);
			
			if(move.equals(moveAnterior))
				limiteConsecutivo++;
			if(limiteConsecutivo == 3) {
				System.out.println("You can't go more " + move);
				limiteConsecutivo = 0;
			} else
				catchall.movement(move); //e storePokemon
			
			moveAnterior = move;
		}
		
		//output1
//		int count = 0;
//		for (int index : ash.getPokemonStored().keySet())
//			count++;			
//		System.out.println("Pokemons apanhados : " + count);
		
		
		//output2
		System.out.println("Pokemons apanhados : ");
		for (int index : ash.getPokemonStored().keySet()) {
			if(index < 144)
				System.out.println(index + " " + ash.getPokemonStored().get(index));
		}
		System.out.println('\n' + "Pokemons !!Lendários!! apanhados : ");
		for (int index : ash.getPokemonStored().keySet())
			if(index >= 144)
				System.out.println(index + " " + ash.getPokemonStored().get(index));
		
	}

}
