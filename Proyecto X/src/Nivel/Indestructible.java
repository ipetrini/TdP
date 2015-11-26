package Nivel;

import Graficos.IndestructibleGrafica;
import Personajes.Bomberman;
import Personajes.Enemigo;

/**
 * Clase que representa la l�gica de una pared indestructible.
 * @author Tom�s Perotti - Iv�n Petrini
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
