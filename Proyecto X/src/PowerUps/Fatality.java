package PowerUps;

import Personajes.Bomberman;

public class Fatality extends PowerUp{

	
	public void activar(Bomberman b) {
		b.duplicarAlcance();
	}

}
