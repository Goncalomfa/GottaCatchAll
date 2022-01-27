package pokemonV1;


public class CatchEmAll {

	private Ash ash;
	private Integer iterator = null;

	public CatchEmAll(Ash ash) {
		this.ash = ash;
	}

	public void movement(String move) {
		int pos_x = ash.getPosition_x();
		int pos_y = ash.getPosition_y();

		switch (move) {
		case "N":
		case "n": {

			ash.setPosition_y(pos_y + 1);
			for(int i: ash.getPosAnt().keySet()) {
				iterator = null;
				for(int j: ash.getPosAnt().get(i)) 

					if(iterator==null)	iterator=j;

					else 
						if(iterator == ash.getPosition_x() && j == ash.getPosition_y()) {
							storePokemon(false);
							break;
						}
			}

			storePokemon(true);
			break;
		}
		
		case "S": 
		case "s": {

			ash.setPosition_y(pos_y - 1);
			for(int i: ash.getPosAnt().keySet()) {
				iterator = null;
				for(int j: ash.getPosAnt().get(i)) 

					if(iterator== null)	iterator=j;

					else 
						if(iterator == ash.getPosition_x() && j == ash.getPosition_y()) {
							storePokemon(false);
							break;
						}
			}
			
			storePokemon(true);
			break;
		}
		
		case "E": 
		case "e": {

			ash.setPosition_x(pos_x + 1);
			for(int i: ash.getPosAnt().keySet()) {
				iterator = null;
				for(int j: ash.getPosAnt().get(i)) 

					if(iterator==null)	iterator=j;

					else 
						if(iterator == ash.getPosition_x() && j == ash.getPosition_y()) {
							storePokemon(false);
							break;
						}
			}
			
			storePokemon(true);
			break;

		}
		
		case "O": 
		case "o": {

			ash.setPosition_x(pos_x - 1);
			for(int i: ash.getPosAnt().keySet()) {
				iterator = null;
				for(int j: ash.getPosAnt().get(i)) 

					if(iterator==null)	iterator=j;

					else 
						if(iterator == ash.getPosition_x() && j == ash.getPosition_y()) {
							storePokemon(false);
							break;
						}
			}
			
			storePokemon(true);
			break;
		}

		default:
			System.out.println("direction not available");
		}
	}

	public void storePokemon(boolean adiciona) {
		
		if(!adiciona) return;
		else {
			ash.addPokemon(ash.getPosition_x(), ash.getPosition_y());
			System.out.println("ADDDDDD " + ash.getPosition_x() + " " + ash.getPosition_y());
		}
	}
	
}
