package pokemonV2;

import java.util.ArrayList;
import java.util.HashMap;

public class CatchEmAll {

	private Ash ash;
	private Kanto kanto;
	private Object pokemon;
	private Object rarePokemon = null;
	private ArrayList<String> rareCaught = new ArrayList<String>();
	private int indexRare;

	public CatchEmAll(Ash ash, Kanto kanto) {
		this.ash = ash;
		this.kanto = kanto;
		this.indexRare = 144;
	}

	public void movement(String move) {
		int pos_x = ash.getPosition_x();
		int pos_y = ash.getPosition_y();
		Object[][] region = kanto.getRegion();

		switch (move) {
		case "N": {

			if(pos_y + 1 <= region.length) {
				pokemon = region[pos_y + 1][pos_x];
				region[pos_y][pos_x] = null;
				region[pos_y + 1][pos_x] = ash;
				ash.setPosition_y(pos_y + 1);
			}
			break;
		}
		case "S": {

			if(pos_y - 1 <= region.length) {
				pokemon = region[pos_y - 1][pos_x];
				region[pos_y][pos_x] = null;
				region[pos_y - 1][pos_x] = ash;
				ash.setPosition_y(pos_y - 1);
			}
			break;
		}
		case "E": {

			if(pos_x + 1 <= region[0].length) {
				pokemon = region[pos_y][pos_x + 1];
				region[pos_y][pos_x] = null;
				region[pos_y][pos_x + 1] = ash;
				ash.setPosition_x(pos_x + 1);
			}
			break;
		}
		case "O": {

			if(pos_x - 1 <= region[0].length) {
				pokemon = region[pos_y][pos_x - 1]; 
				region[pos_y][pos_x] = null;
				region[pos_y][pos_x - 1] = ash;
				ash.setPosition_x(pos_x - 1);
			}
			break;
		}
		
		default:
			System.out.println("direction not available");
		}

		//legendary pokemon or aerodactyl and store
		if( (move.equals("N") || move.equals("S") || move.equals("E") || move.equals("O")) ) { //pokemon != null
			double rare = Math.random();
			if(rare < 0.1) {
				double whoIsThisPokemon = Math.random();
				if(whoIsThisPokemon >0 && whoIsThisPokemon < 0.15) rarePokemon = "mew";
				if(whoIsThisPokemon > 0.15 && whoIsThisPokemon < 0.3) rarePokemon = "mewtwo";
				if(whoIsThisPokemon >0.3 && whoIsThisPokemon < 0.45) rarePokemon = "zapdos";
				if(whoIsThisPokemon >0.45 && whoIsThisPokemon < 0.6) rarePokemon = "moltres";
				if(whoIsThisPokemon >0.6 && whoIsThisPokemon < 0.75) rarePokemon = "articuno";
				if(whoIsThisPokemon >0.75 && whoIsThisPokemon < 1) rarePokemon = "aerodactyl";
			}
			storePokemon();
		}


	}

	public void storePokemon() {
		HashMap<Integer, String> pokemonList = kanto.getPokemons();

		if(pokemon != null) {
			Integer poke = ((Integer) pokemon).intValue();
			ash.setPokemonStored(poke, pokemonList.get(poke));
			pokemon = null;
		} 


		if(rarePokemon != null) {
			boolean alreadyCaught = false;
			String namePokemon = (String) rarePokemon;
			for(String poke: rareCaught) {
				if(poke.equals(rarePokemon))
					alreadyCaught = true;
			}

			if(!alreadyCaught) {
				ash.setPokemonStored(indexRare, namePokemon);
				rarePokemon = null;
				indexRare++;
			}
		}


	}
}
