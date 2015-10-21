package PowerUps;

import Personajes.Bomberman;
/**
 * Clase que representa el power up Masacrality.
 * @author Tomás Perotti - Iván Petrini.
 *
 */
public class Masacrality extends PowerUp {

	public void activar(Bomberman b) {
		b.setDios(true);
	}

}
