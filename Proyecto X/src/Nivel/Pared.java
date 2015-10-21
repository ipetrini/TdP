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
	 * M�todo que permite recibir un enemigo en la celda.
	 * @param enemigo
	 * @return true si se recibio correctamente, falso en caso contrario.
	 */
	public abstract boolean recibirEnemigo(Enemigo e);
	/**
	 * M�todo que permite recibir un bomberman en la celda.
	 * @param bomberman
	 * @return true si se recibio correctamente, falso en caso contrario.
	 */
	public abstract boolean recibirBomberman(Bomberman b);
	/**
	 * M�todo que destruye la pared en la celda.
	 * @return true si se destruyo correctamente, falso en caso contrario.
	 */
	public abstract boolean destruir();
	/**
	 * M�todo que retorna la imagen asociada a la pared.
	 * @return imagen
	 */
	public JLabel getGrafico(){
		return grafico.getGrafico();
	}
	

}
