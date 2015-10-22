package Graficos;

import javax.swing.ImageIcon;

/**
 * Clase utilizada para representar la gr�fica del Power Up SpeedUp.
 * @author Tomas Perotti - Iv�n Petrini
 
 */

public class SpeedUpGrafico extends PowerUpGrafico {

	/**
	 * Constructor que inicializa el Power Up Speed Up con su posici�n.
	 * @param posici�n x
	 * @param posici�n y
	 */
	public SpeedUpGrafico(int x, int y) {
		super(x, y);
		normal = new ImageIcon(this.getClass().getResource("/PowerUpImagenes/SpeedUp.png"));
	}

}
