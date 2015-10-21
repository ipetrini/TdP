package Graficos;

import javax.swing.ImageIcon;
/**
 * Clase que representa la gr�fica del enemigo Rugulo.
 * @author Tom�s Perotti - Iv�n Petrini
 *
 */
public class RuguloGrafico extends EntidadGrafica {
	/**
	 * Constructor que inicializa al Rugulo con su posici�n y velocidad
	 * @param p�sicion x 
	 * @param posici�n y
	 * @param velocidad
	 */
	public RuguloGrafico(int x, int y, int v) {
		super(x, y, v);
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/RuguloImagenes/normal.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/RuguloImagenes/normal.png"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/RuguloImagenes/normal.png"));
		this.imagen[3] = new ImageIcon(this.getClass().getResource("/RuguloImagenes/normal.png"));
		this.movimiento[0] = new ImageIcon(this.getClass().getResource("/RuguloImagenes/normal.png"));
		this.movimiento[1] = new ImageIcon(this.getClass().getResource("/RuguloImagenes/normal.png"));
		this.movimiento[2] = new ImageIcon(this.getClass().getResource("/RuguloImagenes/normal.png"));
		this.movimiento[3] = new ImageIcon(this.getClass().getResource("/RuguloImagenes/normal.png"));
	}

}
