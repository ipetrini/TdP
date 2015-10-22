package PowerUps;

import Graficos.FatalityGrafico;
import Nivel.Celda;
import Personajes.Bomberman;

/**
 * Clase que representa el power up Fatality.
 * @author Tomás Perotti - Iván Petrini.
 *
 */
public class Fatality extends PowerUp{	
	
	/**
	 * Constructor del Power Up Fatality que setea su posicion.
	 * @param Celda
	 */
	public Fatality(Celda c) {
		grafico = new FatalityGrafico(c.getX(), c.getY());
		c.setPowerUp(this);
	}

	/**
	 * Método que activa el Power Up.
	 * @param Bomberman
	 */
	public void activar(Bomberman b) {
		b.duplicarAlcance();
		System.out.println("Agarré Power Up - Fatality");
		grafico.desaparecer();
	}

}
