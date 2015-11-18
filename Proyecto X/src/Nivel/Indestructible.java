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
	
	/**
	 * Método que determina si un enemigo puede atravesar o no la pared.
	 * @param enemigo
	 * @return true si lo puede recibir, false en caso contrario.
	 */
	public boolean recibirEnemigo(Enemigo e, int dir) {
		return false;
	}

	/**
	 * Método que determina si el Bomberman puede atravesar o no la pared.
	 * @param enemigo
	 * @return true si lo puede recibir, false en caso contrario.
	 */
	public boolean recibirBomberman(Bomberman b, int dir) {
		return false;
	}

	/**
	 * Método que determina si la pared se puede destruir o no.
	 * @return true si lo puede recibir, false en caso contrario.
	 */
	public boolean destruir() {
		return false;
	}

	public boolean puedePowerUp() {
		return false;
	}

}
