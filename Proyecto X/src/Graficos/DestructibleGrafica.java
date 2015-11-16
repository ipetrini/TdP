package Graficos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Threads.ThreadDestructible;

/**
 * Clase utilizada para representar la gr�fica de la pared destructible.
 * @author Tomas Perotti - Iv�n Petrini
 *
 */

public class DestructibleGrafica extends ParedGrafica {
	
	protected ThreadDestructible thread;
	
	//Constructor
	/**
	 * Constructor que inicializa la pared Destructible con su posici�n.
	 * @param posici�n x
	 * @param posici�n y
	 */
	public DestructibleGrafica(int x, int y){
		super(x, y);
		this.normal = new ImageIcon(this.getClass().getResource("/ParedImagenes/Destructible.png"));
		this.explosion[0] = new ImageIcon(this.getClass().getResource("/ParedImagenes/1.png"));
		this.explosion[1] = new ImageIcon(this.getClass().getResource("/ParedImagenes/2.png"));
		this.explosion[2] = new ImageIcon(this.getClass().getResource("/ParedImagenes/3.png"));
		this.explosion[3] = new ImageIcon(this.getClass().getResource("/ParedImagenes/4.png"));
		this.explosion[4] = new ImageIcon(this.getClass().getResource("/ParedImagenes/5.png"));
		this.explosion[5] = new ImageIcon(this.getClass().getResource("/ParedImagenes/6.png"));
		this.explosion[6] = new ImageIcon(this.getClass().getResource("/ParedImagenes/7.png"));

		
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
		thread = new ThreadDestructible(this);
		thread.start();
	}
	
	public void cambiarExplosion(int i){
		grafico.setIcon(explosion[i]);
	}
	

}
