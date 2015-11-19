package Graficos;

import javax.swing.ImageIcon;

import Nivel.Celda;
import Nivel.Nivel;
import Personajes.Enemigo;

/**
 * Clase utilizada para representar la gráfica del Bomberman.
 * @author Tomas Perotti - Iván Petrini
 *
 */

public class BombermanGrafico extends EntidadGrafica {

	//Constructor
	/**
	 * Constructor que inicializa el Bomberman con su posición y su velocidad.
	 * @param posición x
	 * @param posición y
	 */
	public BombermanGrafico(int x, int y, int v, Nivel n) {
		super(x, y, v, n);
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/BombermanImagenes/arriba.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/BombermanImagenes/abajo.png"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/BombermanImagenes/izquierda.png"));
		this.imagen[3] = new ImageIcon(this.getClass().getResource("/BombermanImagenes/derecha.png"));
		this.movimiento[0] = new ImageIcon(this.getClass().getResource("/BombermanImagenes/GifArriba.gif"));
		this.movimiento[1] = new ImageIcon(this.getClass().getResource("/BombermanImagenes/GifAbajo.gif"));
		this.movimiento[2] = new ImageIcon(this.getClass().getResource("/BombermanImagenes/GifIzquierda.gif"));
		this.movimiento[3] = new ImageIcon(this.getClass().getResource("/BombermanImagenes/GifDerecha.gif"));
		morir[0] = new ImageIcon(this.getClass().getResource("/BombermanImagenes/Morir1.png"));
		morir[1] = new ImageIcon(this.getClass().getResource("/BombermanImagenes/Morir2.png"));
		morir[2] = new ImageIcon(this.getClass().getResource("/BombermanImagenes/Morir3.png"));
		morir[3] = new ImageIcon(this.getClass().getResource("/BombermanImagenes/Morir4.png"));
		morir[4] = new ImageIcon(this.getClass().getResource("/BombermanImagenes/Morir5.png"));


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
		for (Enemigo e : nivel.getEnemigos()){
			if (e.getEntidad().getBounds().intersects(this.getBounds())){
				nivel.destruirBomberman();
			}
		}
	}
	
	public void morir(int j){
		int i = 0;
		while (i<5){
			grafico.setIcon(morir[i]);
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
			}
			i++;
		}
	}
	
	

}
