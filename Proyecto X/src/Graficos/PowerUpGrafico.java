package Graficos;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;

/**
 * Clase abstracta que representa un Power Up.
 * @author Tom�s Perotti - Iv�n Petrini
 *
 */
public abstract class PowerUpGrafico {
	
	//Atributos
	protected JLabel grafico;
	protected Icon normal;
	protected Point posicion;
	protected final int ancho = 32;
	protected final int alto = 32;	
	
	/**
	 * Constructor que inicializa el Power Up con su posici�n.
	 * @param posici�n x
	 * @param posici�n y
	 */
	public PowerUpGrafico(int x, int y){
		grafico = null;
		posicion = new Point(x * ancho, y * alto);
	}
	
	/**
	 * M�todo que retorna la posici�n de la pared.
	 * @return posici�n
	 */
	public Point getPosicion(){
		return posicion;
	}
	
	/**
	 * M�todo que retorna la imagen de la pared.
	 * @return imagen del grafico.
	 */
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(normal);
			this.grafico.setBounds(posicion.x, posicion.y, ancho, alto);
		}
		return this.grafico;
	}
	
	/**
	 * M�todo que hace desaparecer el grafico del Power Up.
	 * @return imagen del grafico.
	 */
	public void desaparecer(){
		this.grafico.setIcon(null);
	}
	
}
