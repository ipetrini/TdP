package PowerUps;

import Graficos.BombalityGrafico;
import Nivel.Celda;
import Personajes.Bomberman;

/**
 * Clase que representa el power up Bombality.
 * @author Tom�s Perotti - Iv�n Petrini.
 *
 */
public class Bombality extends PowerUp {
	
	/**
	 * Constructor del Power Up Bombality que setea su posicion.
	 * @param Celda
	 */
	public Bombality(Celda c){
		grafico = new BombalityGrafico(c.getX(), c.getY());
		c.setPowerUp(this);
	}

	/**
	 * M�todo que activa el Power Up.
	 * @param Bomberman
	 */
	public void activar(Bomberman b) {
		b.aumentarBombas();
		System.out.println("Agarr� Power Up - Bombality");
		grafico.desaparecer();
		b.getNivel().getMarcador().aumentarPuntaje(35);

	}

}
