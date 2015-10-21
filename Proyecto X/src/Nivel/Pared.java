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
	 * Método que permite recibir un enemigo en la celda.
	 * @param enemigo
	 * @return true si se recibio correctamente, falso en caso contrario.
	 */
	public abstract boolean recibirEnemigo(Enemigo e);
	/**
	 * Método que permite recibir un bomberman en la celda.
	 * @param bomberman
	 * @return true si se recibio correctamente, falso en caso contrario.
	 */
	public abstract boolean recibirBomberman(Bomberman b);
	/**
	 * Método que destruye la pared en la celda.
	 * @return true si se destruyo correctamente, falso en caso contrario.
	 */
	public abstract boolean destruir();
	/**
	 * Método que retorna la imagen asociada a la pared.
	 * @return imagen
	 */
	public JLabel getGrafico(){
		return grafico.getGrafico();
	}
	

}
