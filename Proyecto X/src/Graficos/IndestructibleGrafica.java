package Graficos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Clase utilizada para representar una pared indestructible.
 * @author Tomás Perotti - Iván Petrini
 *
 */

public class IndestructibleGrafica extends ParedGrafica {

	//Constructor
	/**
	 * Constructor que inicializa la pared indestructible con su posición.
	 * @param posición x
	 * @param posición y
	 */
	public IndestructibleGrafica(int x, int y) {
		super(x, y);
		this.normal = new ImageIcon(this.getClass().getResource("/ParedImagenes/Indestructible.png"));
		this.explosion = null;
	}
	
	/**
	 * Método que retorna la imagen de la pared indestructible.	
	 * @return grafico de la pared.
	 */
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(normal);
			this.grafico.setBounds(posicion.x, posicion.y, ancho, alto);
		}
		return this.grafico;
	}
	
	
	public void explotar(){		
	}

}
