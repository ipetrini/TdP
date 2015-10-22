package Graficos;

import javax.swing.ImageIcon;

/**
 * Clase utilizada para representar la gr�fica del Power Up Bombality.
 * @author Tomas Perotti - Iv�n Petrini
 *
 */

public class FatalityGrafico extends PowerUpGrafico {

	//Constructor
	/**
	 * Constructor que inicializa el Power Up fatality con su posici�n.
	 * @param posici�n x
	 * @param posici�n y
	 */
	public FatalityGrafico(int x, int y) {
		super(x, y);
		normal = new ImageIcon(this.getClass().getResource("/PowerUpImagenes/Fatality.png"));
	}
	
	

}
