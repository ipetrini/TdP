package Graficos;

import javax.swing.ImageIcon;

import Nivel.Celda;
import Nivel.Nivel;

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
	public AltairGrafico(int x, int y, int v, Nivel n) {
		super(x, y, v, n);
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/AltairImagenes/normal.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/AltairImagenes/normal.png"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/AltairImagenes/normal.png"));
		this.imagen[3] = new ImageIcon(this.getClass().getResource("/AltairImagenes/normal.png"));
		this.movimiento[0] = new ImageIcon(this.getClass().getResource("/AltairImagenes/AltairMovimiento.gif"));
		this.movimiento[1] = new ImageIcon(this.getClass().getResource("/AltairImagenes/AltairMovimiento.gif"));
		this.movimiento[2] = new ImageIcon(this.getClass().getResource("/AltairImagenes/AltairMovimiento.gif"));
		this.movimiento[3] = new ImageIcon(this.getClass().getResource("/AltairImagenes/AltairMovimiento.gif"));
		this.morir[0] = new ImageIcon(this.getClass().getResource("/AltairImagenes/Morir1.png"));
		this.morir[1] = new ImageIcon(this.getClass().getResource("/AltairImagenes/Morir2.png"));
		this.morir[2] = new ImageIcon(this.getClass().getResource("/AltairImagenes/Morir3.png"));
		this.morir[3] = new ImageIcon(this.getClass().getResource("/AltairImagenes/Morir4.png"));
		this.morir[4] = new ImageIcon(this.getClass().getResource("/AltairImagenes/Morir5.png"));
	}
	
	public void mover(int dir){
		if(grafico != null){
			cambiarMovimiento(dir);
			
			try {
				switch (dir){
					case Celda.UP :
						for(int i = 0; i < alto; i+=velocidad){
							grafico.setBounds(posicion.x, posicion.y -= velocidad, ancho, alto);
							colision();
							Thread.sleep(100);
						}
						
						break;
					case Celda.DOWN : 
						for(int i = 0; i < alto; i+=velocidad){
							grafico.setBounds(posicion.x, posicion.y += velocidad, ancho, alto);
							colision();
							Thread.sleep(100);
						}
						break;
					case Celda.RIGHT :
						for(int i = 0; i < ancho; i+=velocidad){
							grafico.setBounds(posicion.x += velocidad, posicion.y, ancho, alto);
							colision();
							Thread.sleep(100);
						}
						break;
					case Celda.LEFT :
						for(int i = 0; i < ancho; i+= velocidad){
							grafico.setBounds(posicion.x -= velocidad, posicion.y, ancho, alto);
							colision();
							Thread.sleep(100);
						}
						break;
				}
				
			} catch (InterruptedException e) {
			}
		cambiarIcono(dir);	
		}
	}
	
	
	public void colision(){
		if (nivel.getBomberman().getEntidad().getBounds().intersects(this.getBounds()))
			nivel.destruirBomberman();
	}
	

}
