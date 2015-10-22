package Graficos;

import javax.swing.ImageIcon;


/**
 * Clase utilizada para representar la gráfica del Power Up Masacrality.
 * @author Tomas Perotti - Iván Petrini
 *
 */


public class MasacralityGrafico extends PowerUpGrafico {

	/**
	 * Constructor que inicializa el Power Up Masacrality con su posición.
	 * @param posición x
	 * @param posición y
	 */
	public MasacralityGrafico(int x, int y) {
		super(x, y);
		normal = new ImageIcon(this.getClass().getResource("/PowerUpImagenes/Masacrality.png"));
	}

}
