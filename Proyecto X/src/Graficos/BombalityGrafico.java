package Graficos;

import javax.swing.ImageIcon;

/**
 * Clase utilizada para representar la gráfica del Power Up Bombality.
 * @author Tomas Perotti - Iván Petrini
 *
 */

public class BombalityGrafico extends PowerUpGrafico {

	//Constructor
	/**
	 * Constructor que inicializa el Power Up Bombality con su posición.
	 * @param posición x
	 * @param posición y
	 */
	public BombalityGrafico(int x, int y) {
		super(x, y);
		normal = new ImageIcon(this.getClass().getResource("/PowerUpImagenes/Bombality.png"));
	}
	

}
