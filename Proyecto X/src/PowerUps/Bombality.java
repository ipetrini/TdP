package PowerUps;

import Personajes.Bomberman;
/**
 * Clase que representa el power up Bombality.
 * @author Tomás Perotti - Iván Petrini.
 *
 */
public class Bombality extends PowerUp {

	public void activar(Bomberman b) {
		b.aumentarBombas();
	}

}
