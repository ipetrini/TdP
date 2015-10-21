package Graficos;

import javax.swing.ImageIcon;
/**
 * Clase que representa la gráfica del enemigo Rugulo.
 * @author Tomás Perotti - Iván Petrini
 *
 */
public class RuguloGrafico extends EntidadGrafica {
	/**
	 * Constructor que inicializa al Rugulo con su posición y velocidad
	 * @param pósicion x 
	 * @param posición y
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
