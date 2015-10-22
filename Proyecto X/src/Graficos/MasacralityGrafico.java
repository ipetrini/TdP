package Graficos;

import javax.swing.ImageIcon;


/**
 * Clase utilizada para representar la gr�fica del Power Up Masacrality.
 * @author Tomas Perotti - Iv�n Petrini
 *
 */


public class MasacralityGrafico extends PowerUpGrafico {

	/**
	 * Constructor que inicializa el Power Up Masacrality con su posici�n.
	 * @param posici�n x
	 * @param posici�n y
	 */
	public MasacralityGrafico(int x, int y) {
		super(x, y);
		normal = new ImageIcon(this.getClass().getResource("/PowerUpImagenes/Masacrality.png"));
	}

}
