package PowerUps;

import Graficos.MasacralityGrafico;
import Nivel.Celda;
import Personajes.Bomberman;

/**
 * Clase que representa el power up Masacrality.
 * @author Tomás Perotti - Iván Petrini.
 *
 */
public class Masacrality extends PowerUp {
	
	/**
	 * Constructor del Power Up Masacrality que setea su posicion.
	 * @param Celda
	 */
	public Masacrality(Celda c){
		grafico = new MasacralityGrafico(c.getX(), c.getY());
		c.setPowerUp(this);
	}

	/**
	 * Método que activa el Power Up.
	 * @param Bomberman
	 */
	public void activar(Bomberman b) {
		b.setDios(true);
		System.out.println("Agarré Power Up - Masacrality");
		grafico.desaparecer();
	}

}
