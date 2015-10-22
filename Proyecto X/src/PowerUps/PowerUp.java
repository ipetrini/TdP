package PowerUps;

import javax.swing.JLabel;

import Graficos.PowerUpGrafico;
import Personajes.Bomberman;

/**
 * Clase abstracta que representa los power ups del juego.
 * @author Tomás Perotti - Iván Petrini.
 *
 */
public abstract class PowerUp {
	
	//Atributos
	protected PowerUpGrafico grafico;
		
	/**
	 * Método que retorna el grafico del Power Up
	 * @return grafico
	 */
	public JLabel getGrafico(){
		return grafico.getGrafico();
	}
	
	/**
	 * Método que activa el Power Up.
	 * @param bomberman
	 */
	public abstract void activar(Bomberman b);
}
