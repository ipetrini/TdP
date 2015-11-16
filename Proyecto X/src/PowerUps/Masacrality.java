package PowerUps;

import Graficos.MasacralityGrafico;
import Nivel.Celda;
import Personajes.Bomberman;
import Threads.ThreadMasacrality;

/**
 * Clase que representa el power up Masacrality.
 * @author Tomás Perotti - Iván Petrini.
 *
 */
public class Masacrality extends PowerUp {
	
	protected ThreadMasacrality thread;
	
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
		thread = new ThreadMasacrality(b);
		thread.start();		
		System.out.println("Agarré Power Up - Masacrality");
		grafico.desaparecer();
		b.getNivel().getMarcador().aumentarPuntaje(50);

		
	}

}
