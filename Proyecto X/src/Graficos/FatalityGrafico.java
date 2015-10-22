package Graficos;

import javax.swing.ImageIcon;

/**
 * Clase utilizada para representar la gráfica del Power Up Bombality.
 * @author Tomas Perotti - Iván Petrini
 *
 */

public class FatalityGrafico extends PowerUpGrafico {

	//Constructor
	/**
	 * Constructor que inicializa el Power Up fatality con su posición.
	 * @param posición x
	 * @param posición y
	 */
	public FatalityGrafico(int x, int y) {
		super(x, y);
		normal = new ImageIcon(this.getClass().getResource("/PowerUpImagenes/Fatality.png"));
	}
	
	

}
