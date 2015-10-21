package PowerUps;

import Personajes.Bomberman;
/**
 * Clase abstracta que representa los power ups del juego.
 * @author Tomás Perotti - Iván Petrini.
 *
 */
public abstract class PowerUp {
	/**
	 * Método que permite la activación de un power up en el Bomberman.
	 * @param bomberman
	 */
	public abstract void activar(Bomberman b);
}
