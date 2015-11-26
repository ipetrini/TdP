package Graficos;

import javax.swing.ImageIcon;

import Nivel.Celda;
import Nivel.Nivel;

/**
 * Clase utilizada para representar la gráfica del Altair.
 * @author Tomas Perotti - Iván Petrini
 *
 */
public class SiriusGrafico extends EntidadGrafica {

	/**
	 * Constructor que inicializa el Sirius con su posición y su velocidad.
	 * @param posición x
	 * @param posición y
	 */
	public SiriusGrafico(int x, int y, int v, Nivel n) {
		super(x, y, v, n);
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/SiriusImagenes/Arriba.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/SiriusImagenes/Abajo.png"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/SiriusImagenes/Izquierda.png"));
		this.imagen[3] = new ImageIcon(this.getClass().getResource("/SiriusImagenes/Derecha.png"));
		this.movimiento[0] = new ImageIcon(this.getClass().getResource("/SiriusImagenes/GifArriba.gif"));
		this.movimiento[1] = new ImageIcon(this.getClass().getResource("/SiriusImagenes/GifAbajo.gif"));
		this.movimiento[2] = new ImageIcon(this.getClass().getResource("/SiriusImagenes/GifIzquierda.gif"));
		this.movimiento[3] = new ImageIcon(this.getClass().getResource("/SiriusImagenes/GifDerecha.gif"));
		this.morir[0] = new ImageIcon(this.getClass().getResource("/SiriusImagenes/Morir1.png"));
		this.morir[1] = new ImageIcon(this.getClass().getResource("/SiriusImagenes/Morir2.png"));
		this.morir[2] = new ImageIcon(this.getClass().getResource("/SiriusImagenes/Morir3.png"));
		this.morir[3] = new ImageIcon(this.getClass().getResource("/SiriusImagenes/Morir4.png"));
		this.morir[4] = new ImageIcon(this.getClass().getResource("/SiriusImagenes/Morir5.png"));
	}
	
	public void mover(int dir){
		if(grafico != null){
			cambiarMovimiento(dir);
			
			try {
				switch (dir){
					case Celda.UP :
						for(int i = 0; i < alto; i++){
							grafico.setBounds(posicion.x, posicion.y -= 1, ancho, alto);
							colision();
							Thread.sleep(velocidad/2);
						}
						
						break;
					case Celda.DOWN : 
						for(int i = 0; i < alto; i++){
							grafico.setBounds(posicion.x, posicion.y +=1 , ancho, alto);
							colision();
							Thread.sleep(velocidad/2);
						}
						break;
					case Celda.RIGHT :
						for(int i = 0; i < ancho; i++){
							grafico.setBounds(posicion.x += 1, posicion.y, ancho, alto);
							colision();
							Thread.sleep(velocidad/2);
						}
						break;
					case Celda.LEFT :
						for(int i = 0; i < ancho; i++){
							grafico.setBounds(posicion.x -= 1, posicion.y, ancho, alto);
							colision();
							Thread.sleep(velocidad/2);
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