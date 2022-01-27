package pokemonV3;
import java.util.HashMap;

public class Ash {

	private int position_y;
	private int position_x;
	private HashMap<Integer, String> pokemonStored;

	public Ash(int position_y, int position_x) {
		this.position_y = position_y;
		this.position_x = position_x;
		this.pokemonStored = new HashMap<Integer, String>();
	}

	public int getPosition_y() {
		return position_y;
	}

	public void setPosition_y(int position_y) {
		this.position_y = position_y;
	}
	
	public int getPosition_x() {
		return position_x;
	}

	public void setPosition_x(int position_x) {
		this.position_x = position_x;
	}

	public HashMap<Integer, String> getPokemonStored() {
		return pokemonStored;
	}

	public void setPokemonStored(int num, String newPokemon) {
		this.pokemonStored.put(num, newPokemon);
	}

}
