package pokemonV1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Ash {

	private int position_y;
	private int position_x;
	private HashMap<Integer, ArrayList<Integer>> posAnt = new HashMap<Integer,ArrayList<Integer>>();

	public Ash(int position_y, int position_x) {
		this.position_y = position_y;
		this.position_x = position_x;
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

	public HashMap<Integer, ArrayList<Integer>> getPosAnt() {
		return posAnt;
	}

	public void setPosAnt(HashMap<Integer, ArrayList<Integer>> posAnt) {
		this.posAnt = posAnt;
	}

	public void addPokemon(int x, int y) {
		int max = maxElement();
		this.posAnt.put(max+1, new ArrayList<Integer>());
		this.posAnt.get(max+1).add(x); 
		this.posAnt.get(max+1).add(y);
	}

	public int maxElement() {
		int max = 0;
		for(int i: posAnt.keySet()) {
			if(i>max) 
				max=i;
		}
		return max;
	}
}
