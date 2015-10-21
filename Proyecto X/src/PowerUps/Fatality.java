package PowerUps;

import Personajes.Bomberman;
/**
 * Clase que representa el power up Fatality.
 * @author Tomás Perotti - Iván Petrini.
 *
 */
public class Fatality extends PowerUp{

	
	public void activar(Bomberman b) {
		b.duplicarAlcance();
	}

}
