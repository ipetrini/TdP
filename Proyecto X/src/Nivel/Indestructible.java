package Nivel;

import Graficos.IndestructibleGrafica;
import Personajes.Bomberman;
import Personajes.Enemigo;

/**
 * Clase que representa la lógica de una pared indestructible.
 * @author Tomás Perotti - Iván Petrini
 *
 */
public class Indestructible extends Pared{

	/**
	 * Constructor que inicializa la pared indestructible en su celda.
	 * @param celda
	 */
	public Indestructible(Celda c){
		grafico = new IndestructibleGrafica(c.getX(), c.getY());
	}
	
	
	public boolean recibirEnemigo(Enemigo e, int dir) {
		return false;
	}

	
	public boolean recibirBomberman(Bomberman b, int dir) {
		return false;
	}

	
	public boolean destruir() {
		return false;
	}

	public boolean puedePowerUp() {
		return false;
	}

}
