package Graficos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Clase utilizada para representar la gr�fica de la pared destructible.
 * @author Tomas Perotti - Iv�n Petrini
 *
 */

public class DestructibleGrafica extends ParedGrafica {

	//Constructor
	/**
	 * Constructor que inicializa la pared Destructible con su posici�n.
	 * @param posici�n x
	 * @param posici�n y
	 */
	public DestructibleGrafica(int x, int y){
		super(x, y);
		this.normal = new ImageIcon(this.getClass().getResource("/ParedImagenes/Destructible.png"));
		this.explosion = new ImageIcon(this.getClass().getResource("/ParedImagenes/ExplosionPared.gif"));
		
	}
	
	/**
	 * M�todo que retorna la imagen de la pared destructible.
	 */
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(normal);
			this.grafico.setBounds(posicion.x, posicion.y, ancho, alto);
		}
		return this.grafico;
	}
	
	/**
	 * M�todo utilizado para explotar la pared destructible.
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
