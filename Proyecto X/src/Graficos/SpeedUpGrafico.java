package Graficos;

import javax.swing.ImageIcon;

/**
 * Clase utilizada para representar la gráfica del Power Up SpeedUp.
 * @author Tomas Perotti - Iván Petrini
 
 */

public class SpeedUpGrafico extends PowerUpGrafico {

	/**
	 * Constructor que inicializa el Power Up Speed Up con su posición.
	 * @param posición x
	 * @param posición y
	 */
	public SpeedUpGrafico(int x, int y) {
		super(x, y);
		normal = new ImageIcon(this.getClass().getResource("/PowerUpImagenes/SpeedUp.png"));
	}

}
