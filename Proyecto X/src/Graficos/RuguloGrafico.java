package Graficos;

import javax.swing.ImageIcon;

/**
 * Clase utilizada para representar la gr�fica del Rugulo.
 * @author Tomas Perotti - Iv�n Petrini
 *
 */
public class RuguloGrafico extends EntidadGrafica {

	/**
	 * Constructor que inicializa el Rugulo con su posici�n y su velocidad.
	 * @param posici�n x
	 * @param posici�n y
	 */
	public RuguloGrafico(int x, int y, int v) {
		super(x, y, v);
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/RuguloImagenes/normal.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/RuguloImagenes/normal.png"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/RuguloImagenes/normal.png"));
		this.imagen[3] = new ImageIcon(this.getClass().getResource("/RuguloImagenes/normal.png"));
		this.movimiento[0] = new ImageIcon(this.getClass().getResource("/RuguloImagenes/RuguloMovimiento.gif"));
		this.movimiento[1] = new ImageIcon(this.getClass().getResource("/RuguloImagenes/RuguloMovimiento.gif"));
		this.movimiento[2] = new ImageIcon(this.getClass().getResource("/RuguloImagenes/RuguloMovimiento.gif"));
		this.movimiento[3] = new ImageIcon(this.getClass().getResource("/RuguloImagenes/RuguloMovimiento.gif"));
		this.morir[0] = new ImageIcon(this.getClass().getResource("/RuguloImagenes/Morir1.png"));
		this.morir[1] = new ImageIcon(this.getClass().getResource("/RuguloImagenes/Morir2.png"));
		this.morir[2] = new ImageIcon(this.getClass().getResource("/RuguloImagenes/Morir3.png"));
		this.morir[3] = new ImageIcon(this.getClass().getResource("/RuguloImagenes/Morir4.png"));
		this.morir[4] = new ImageIcon(this.getClass().getResource("/RuguloImagenes/Morir5.png"));


	}

}
