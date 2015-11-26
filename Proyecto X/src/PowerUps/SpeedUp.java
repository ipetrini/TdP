package PowerUps;

import Graficos.SpeedUpGrafico;
import Nivel.Celda;
import Personajes.Bomberman;

/**
 * Clase que representa el power up Speed Up.
 * @author Tomás Perotti - Iván Petrini.
 *
 */
public class SpeedUp extends PowerUp {

	/**
	 * Constructor del Power Up SpeedUp que setea su posicion.
	 * @param Celda
	 */
	public SpeedUp(Celda c){
		grafico = new SpeedUpGrafico(c.getX(), c.getY());
		c.setPowerUp(this);
	}
	
	
	public void activar(Bomberman b) {
		b.velocidad2X();
		System.out.println("Agarré Power Up - Speed Up");
		grafico.desaparecer();
		b.getNivel().getMarcador().aumentarPuntaje(30);
	}
	

}
