package Graficos;

import javax.swing.ImageIcon;

public class RuguloGrafico extends EntidadGrafica {

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
