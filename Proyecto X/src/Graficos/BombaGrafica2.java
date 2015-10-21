package Graficos;

import javax.swing.ImageIcon;
/**
 * Clase utilizada para representar la gr�fica de la bomba.
 * @author Tom�s Perotti - Iv�n Petrini
 *
 */
public class BombaGrafica2 extends EntidadGrafica{
	/**
	 * Constructor que inicializa la bomba gr�fica.
	 * @param posicion x
	 * @param posicion y
	 */
	public BombaGrafica2(int x, int y) {
		super(x, y, 0);
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/BombaImagenes/exploto.jpg"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/BombaImagenes/bomba.png"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/BombermanImagenes/izquierda.png"));
		this.imagen[3] = new ImageIcon(this.getClass().getResource("/BombermanImagenes/derecha.png"));
		this.movimiento[0] = new ImageIcon(this.getClass().getResource("/BombermanImagenes/GifArriba.gif"));
		this.movimiento[1] = new ImageIcon(this.getClass().getResource("/BombermanImagenes/GifAbajo.gif"));
		this.movimiento[2] = new ImageIcon(this.getClass().getResource("/BombermanImagenes/GifIzquierda.gif"));
		this.movimiento[3] = new ImageIcon(this.getClass().getResource("/BombermanImagenes/GifDerecha.gif"));
		morir = new ImageIcon(this.getClass().getResource("/BombermanImagenes/GifMorir.gif"));
	}
	/**
	 * M�todo utilizado para hacer explotar gr�ficamente la bomba.
	 */
	public void explotar () {
		grafico.setIcon(imagen[0]);
		grafico.setBounds(posicion.x, posicion.y, ancho, alto);
	}
	/**
	 * M�todo utilizado para hacer desaparecer gr�ficamente la bomba.
	 */
	public void desaparecer () {
		grafico.setIcon(null);
	}

}
