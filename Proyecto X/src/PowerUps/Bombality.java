package PowerUps;

import Personajes.Bomberman;
/**
 * Clase que representa el power up Bombality.
 * @author Tom�s Perotti - Iv�n Petrini.
 *
 */
public class Bombality extends PowerUp {

	public void activar(Bomberman b) {
		b.aumentarBombas();
	}

}
