package PowerUps;

import Personajes.Bomberman;
/**
 * Clase que representa el power up Speed Up.
 * @author Tom�s Perotti - Iv�n Petrini.
 *
 */
public class SpeedUp extends PowerUp {

	public void activar(Bomberman b) {
		b.velocidad2X();
	}
	

}
