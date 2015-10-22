package Graficos;

import java.awt.Point;
import javax.swing.Icon;
import javax.swing.JLabel;

/**
 * Clase abstracta que representa una pared.
 * @author Tomás Perotti - Iván Petrini
 *
 */

public abstract class ParedGrafica {

	//Atributos
	protected JLabel grafico;
	protected Icon normal;
	protected Icon explosion;
	protected Point posicion;
	protected final int ancho = 32;
	protected final int alto = 32;	
	
	
	/**
	 * Constructor que inicializa la pared con su posición.
	 * @param posición x
	 * @param posición y
	 */
	protected ParedGrafica(int x, int y){
		grafico = null;
		posicion = new Point(x * ancho, y * alto);
	}
	
	/**
	 * Método que retorna la posición de la pared.
	 * @return posición
	 */
	public Point getPosicion(){
		return posicion;
	}
	
	/**
	 * Método que retorna la imagen de la pared.
	 * @return imagen del grafico.
	 */
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(normal);
			this.grafico.setBounds(posicion.x, posicion.y, ancho, alto);
		}
		return this.grafico;
	}
	
	public abstract void explotar();
}
