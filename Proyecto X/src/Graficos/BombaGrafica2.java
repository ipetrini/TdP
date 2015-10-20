package Graficos;

import javax.swing.ImageIcon;

public class BombaGrafica2 extends EntidadGrafica{

	public BombaGrafica2(int x, int y) {
		super(x, y, 0);
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/BombermanImagenes/arriba.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/BombermanImagenes/abajo.png"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/BombermanImagenes/izquierda.png"));
		this.imagen[3] = new ImageIcon(this.getClass().getResource("/BombermanImagenes/derecha.png"));
		this.movimiento[0] = new ImageIcon(this.getClass().getResource("/BombermanImagenes/GifArriba.gif"));
		this.movimiento[1] = new ImageIcon(this.getClass().getResource("/BombermanImagenes/GifAbajo.gif"));
		this.movimiento[2] = new ImageIcon(this.getClass().getResource("/BombermanImagenes/GifIzquierda.gif"));
		this.movimiento[3] = new ImageIcon(this.getClass().getResource("/BombermanImagenes/GifDerecha.gif"));
		morir = new ImageIcon(this.getClass().getResource("/BombermanImagenes/GifMorir.gif"));
	}
	
	public void explotar () {
	System.out.println("QUE ONDA");
	}

}
