package Graficos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Clase utilizada para representar la gráfica de la pared destructible.
 * @author Tomas Perotti - Iván Petrini
 *
 */

public class DestructibleGrafica extends ParedGrafica {

	//Constructor
	/**
	 * Constructor que inicializa la pared Destructible con su posición.
	 * @param posición x
	 * @param posición y
	 */
	public DestructibleGrafica(int x, int y){
		super(x, y);
		this.normal = new ImageIcon(this.getClass().getResource("/ParedImagenes/Destructible.png"));
		this.explosion = new ImageIcon(this.getClass().getResource("/ParedImagenes/ExplosionPared.gif"));
		
	}
	
	/**
	 * Método que retorna la imagen de la pared destructible.
	 */
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(normal);
			this.grafico.setBounds(posicion.x, posicion.y, ancho, alto);
		}
		return this.grafico;
	}
	
	/**
	 * Método utilizado para explotar la pared destructible.
	 */
	public void explotar(){
		this.grafico.setIcon(explosion);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	

}
