package Nivel;

import javax.swing.JLabel;

import Graficos.ParedGrafica;
import Personajes.Bomberman;
import Personajes.Enemigo;

/**
 * Clase abstracta que representa una pared.
 * @author Tomás Perotti - Iván Petrini
 *
 */
public abstract class Pared {
	
	
	protected ParedGrafica grafico;
	protected Celda miCelda;
	/**
	 * Método que permite recibir a un enemigo en una pared.
	 * @param enemigo
	 * @param direccion
	 * @return true si puede recibir al enemigo, false en caso contrario.
	 */
	public abstract boolean recibirEnemigo(Enemigo e, int dir);
	/**
	 * Método que permite recibir al bomberman en una pared.
	 * @param bomberman
	 * @param direccion
	 * @return true si puede recibir al bomberman, false en caso contrario.
	 */
	public abstract boolean recibirBomberman(Bomberman b, int dir);
	/**
	 * Método utilizado para destruir una pared.
	 * @return true si puede destruirla, false en caso contrario.
	 */
	public abstract boolean destruir();
	/**
	 * Método que retorna el gráfico de una pared.
	 * @return JLabel
	 */
	public JLabel getGrafico(){
		return grafico.getGrafico();
	}
	/**
	 * Método que determina si puede o no tener un power up.
	 * @return true si puede tener un power up, false en caso contrario.
	 */
	public abstract boolean puedePowerUp();
	

}
