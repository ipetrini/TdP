package PowerUps;

import javax.swing.JLabel;

import Graficos.PowerUpGrafico;
import Personajes.Bomberman;

/**
 * Clase abstracta que representa los power ups del juego.
 * @author Tom�s Perotti - Iv�n Petrini.
 *
 */
public abstract class PowerUp {
	
	//Atributos
	protected PowerUpGrafico grafico;
		
	/**
	 * M�todo que retorna el grafico del Power Up
	 * @return grafico
	 */
	public JLabel getGrafico(){
		return grafico.getGrafico();
	}
	
	/**
	 * M�todo que activa el Power Up.
	 * @param bomberman
	 */
	public abstract void activar(Bomberman b);
}
