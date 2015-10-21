package PowerUps;

import Personajes.Bomberman;
/**
 * Clase abstracta que representa los power ups del juego.
 * @author Tom�s Perotti - Iv�n Petrini.
 *
 */
public abstract class PowerUp {
	/**
	 * M�todo que permite la activaci�n de un power up en el Bomberman.
	 * @param bomberman
	 */
	public abstract void activar(Bomberman b);
}
