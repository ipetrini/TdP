package Nivel;

import javax.swing.JLabel;

import Graficos.ParedGrafica;
import Personajes.Bomberman;
import Personajes.Enemigo;

/**
 * Clase abstracta que representa una pared.
 * @author Tom�s Perotti - Iv�n Petrini
 *
 */
public abstract class Pared {
	
	
	protected ParedGrafica grafico;
	protected Celda miCelda;
	/**
	 * M�todo que permite recibir a un enemigo en una pared.
	 * @param enemigo
	 * @param direccion
	 * @return true si puede recibir al enemigo, false en caso contrario.
	 */
	public abstract boolean recibirEnemigo(Enemigo e, int dir);
	/**
	 * M�todo que permite recibir al bomberman en una pared.
	 * @param bomberman
	 * @param direccion
	 * @return true si puede recibir al bomberman, false en caso contrario.
	 */
	public abstract boolean recibirBomberman(Bomberman b, int dir);
	/**
	 * M�todo utilizado para destruir una pared.
	 * @return true si puede destruirla, false en caso contrario.
	 */
	public abstract boolean destruir();
	/**
	 * M�todo que retorna el gr�fico de una pared.
	 * @return JLabel
	 */
	public JLabel getGrafico(){
		return grafico.getGrafico();
	}
	/**
	 * M�todo que determina si puede o no tener un power up.
	 * @return true si puede tener un power up, false en caso contrario.
	 */
	public abstract boolean puedePowerUp();
	

}
