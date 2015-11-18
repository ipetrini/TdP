package Graficos;

import javax.swing.ImageIcon;

import Nivel.Celda;
import Nivel.Nivel;

/**
 * Clase utilizada para representar la gr�fica del Altair.
 * @author Tomas Perotti - Iv�n Petrini
 *
 */
public class SiriusGrafico extends EntidadGrafica {

	/**
	 * Constructor que inicializa el Sirius con su posici�n y su velocidad.
	 * @param posici�n x
	 * @param posici�n y
	 */
	public SiriusGrafico(int x, int y, int v, Nivel n) {
		super(x, y, v, n);
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/SiriusImagenes/Sirius.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/SiriusImagenes/Sirius.png"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/SiriusImagenes/Sirius.png"));
		this.imagen[3] = new ImageIcon(this.getClass().getResource("/SiriusImagenes/Sirius.png"));
		this.movimiento[0] = new ImageIcon(this.getClass().getResource("/SiriusImagenes/Sirius.png"));
		this.movimiento[1] = new ImageIcon(this.getClass().getResource("/SiriusImagenes/Sirius.png"));
		this.movimiento[2] = new ImageIcon(this.getClass().getResource("/SiriusImagenes/Sirius.png"));
		this.movimiento[3] = new ImageIcon(this.getClass().getResource("/SiriusImagenes/Sirius.png"));
		this.morir[0] = new ImageIcon(this.getClass().getResource("/SiriusImagenes/Sirius.png"));
		this.morir[1] = new ImageIcon(this.getClass().getResource("/SiriusImagenes/Sirius.png"));
		this.morir[2] = new ImageIcon(this.getClass().getResource("/SiriusImagenes/Sirius.png"));
		this.morir[3] = new ImageIcon(this.getClass().getResource("/SiriusImagenes/Sirius.png"));
		this.morir[4] = new ImageIcon(this.getClass().getResource("/SiriusImagenes/Sirius.png"));
	}
	
	public void mover(int dir){
		if(grafico != null){
			cambiarMovimiento(dir);
			
			try {
				switch (dir){
					case Celda.UP :
						for(int i = 0; i < alto; i+=velocidad){
							grafico.setBounds(posicion.x, posicion.y -= velocidad, ancho, alto);
						//	colision();
							Thread.sleep(100);
						}
						
						break;
					case Celda.DOWN : 
						for(int i = 0; i < alto; i+=velocidad){
							grafico.setBounds(posicion.x, posicion.y += velocidad, ancho, alto);
							//colision();
							Thread.sleep(100);
						}
						break;
					case Celda.RIGHT :
						for(int i = 0; i < ancho; i+=velocidad){
							grafico.setBounds(posicion.x += velocidad, posicion.y, ancho, alto);
							//colision();
							Thread.sleep(100);
						}
						break;
					case Celda.LEFT :
						for(int i = 0; i < ancho; i+= velocidad){
							grafico.setBounds(posicion.x -= velocidad, posicion.y, ancho, alto);
							//colision();
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