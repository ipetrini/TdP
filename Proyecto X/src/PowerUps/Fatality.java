package PowerUps;

import Personajes.Bomberman;
/**
 * Clase que representa el power up Fatality.
 * @author Tom�s Perotti - Iv�n Petrini.
 *
 */
public class Fatality extends PowerUp{

	
	public void activar(Bomberman b) {
		b.duplicarAlcance();
	}

}
