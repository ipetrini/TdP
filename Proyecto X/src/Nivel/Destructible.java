package Nivel;

import Graficos.DestructibleGrafica;
import Personajes.Bomberman;
import Personajes.Enemigo;

/**
 * Clase que representa la lógica de una pared destructible.
 * @author Tomás Perotti - Iván Petrini
 *
 */
public class Destructible extends Pared {

	/**
	 * Constructor que inicializa la pared destructible en su celda.
	 * @param celda
	 */
	public Destructible(Celda c){
		miCelda = c;
		grafico = new DestructibleGrafica(c.getX(), c.getY());
	}
	
	/**
	 * Método que determina si un enemigo puede atravesar o no la pared.
	 * @param enemigo
	 * @return true si lo puede recibir, false en caso contrario.
	 */
	public boolean recibirEnemigo(Enemigo e, int dir) {
		if (e.esDios()){
			miCelda.agregarEnemigo(e);
			e.moverGrafico(dir);
			return true;
		}
		return false;
	}

	/**
	 * Método que determina si el Bomberman puede atravesar o no la pared.
	 * @param enemigo
	 * @return true si lo puede recibir, false en caso contrario.
	 */
	public boolean recibirBomberman(Bomberman b) {
		if (b.esDios()){
			miCelda.setBomberman(b);
			return true;
		}
		return false;
	}

	/**
	 * Método que determina si la pared se puede destruir o no.
	 * @return true si lo puede recibir, false en caso contrario.
	 */
	public boolean destruir() {
		grafico.explotar();
		miCelda.getMapa().getMarcador().aumentarPuntaje(10);
		miCelda.getMapa().celdaDestruida();
		return true;
	}

	@Override
	public boolean puedePowerUp() {
		return true;
	}

}
