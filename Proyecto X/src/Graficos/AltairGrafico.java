package Graficos;

import javax.swing.ImageIcon;

/**
 * Clase utilizada para representar la gráfica del Altair.
 * @author Tomas Perotti - Iván Petrini
 *
 */
public class AltairGrafico extends EntidadGrafica {

	/**
	 * Constructor que inicializa el Altair con su posición y su velocidad.
	 * @param posición x
	 * @param posición y
	 */
	public AltairGrafico(int x, int y, int v) {
		super(x, y, v);
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/AltairImagenes/normal.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/AltairImagenes/normal.png"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/AltairImagenes/normal.png"));
		this.imagen[3] = new ImageIcon(this.getClass().getResource("/AltairImagenes/normal.png"));
		this.movimiento[0] = new ImageIcon(this.getClass().getResource("/AltairImagenes/AltairMovimiento.gif"));
		this.movimiento[1] = new ImageIcon(this.getClass().getResource("/AltairImagenes/AltairMovimiento.gif"));
		this.movimiento[2] = new ImageIcon(this.getClass().getResource("/AltairImagenes/AltairMovimiento.gif"));
		this.movimiento[3] = new ImageIcon(this.getClass().getResource("/AltairImagenes/AltairMovimiento.gif"));
	}

}
