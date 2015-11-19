package Graficos;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.JLabel;
import Nivel.Celda;
import Nivel.Nivel;

/**
 * Clase abstracta que representa una entidad gr�fica
 * @author Tom�s Perotti - Iv�n Petrini
 *
 */

public abstract class EntidadGrafica {
	
	//Atributos
	protected JLabel grafico;
	protected Icon imagen[];
	protected Icon movimiento[];
	protected Icon morir[];
	protected Point posicion;
	protected final int ancho = 32;
	protected final int alto = 32;	
	protected int velocidad;
	protected Nivel nivel;
	protected int speeds;
	
	//Constructor
	/**
	 * Constructor que inicializa la entidad gr�fica con su posici�n y su velocidad.
	 * @param posici�n x
	 * @param posici�n y
	 */
	protected EntidadGrafica(int x, int y, int v, Nivel n){		
		imagen = new Icon[4];
		movimiento = new Icon[4];
		posicion = new Point(x * ancho, y * alto);
		velocidad = v;		
		morir = new Icon[5];
		nivel = n;
		speeds = 0;
	}
	
	/**
	 * M�todo que retorna la posici�n de la entidad.
	 * @return posicion
	 */
	public Point getPosicion(){
		return posicion;
	}
	
	/**
	 * M�todo que retorna la velocidad de la entidad.
	 * @return velocidad
	 */
	public int getVelocidad(){
		return velocidad;
	}
	
	public void duplicarVelocidad(){
		if (speeds == 0){
			velocidad -= 15;
			speeds++;
		}
		if (speeds == 1){
			velocidad -= 15;
			speeds++;
		}
		else
			velocidad -= 5;
	}
		
	protected void cambiarIcono(int d){
		int direccion = -1;		
		switch (d){
			case Celda.UP : 
				direccion = 0;
				break;
			case Celda.DOWN : 
				direccion = 1;
				break;
			case Celda.LEFT : 
				direccion = 2;
				break;
			case Celda.RIGHT : 
				direccion = 3;
				break;
		}		
		grafico.setIcon(imagen[direccion]);
	}
	
	protected void cambiarMovimiento(int d){
		int direccion = -1;
		switch (d){
		case Celda.UP : 
			direccion = 0;
			break;
		case Celda.DOWN : 
			direccion = 1;
			break;
		case Celda.LEFT : 
			direccion = 2;
			break;
		case Celda.RIGHT : 
			direccion = 3;
			break;
		}		
		grafico.setIcon(movimiento[direccion]);
	}
	
	/**
	 * M�todo utilizado para destruir la entidad gr�fica.
	 */
	public void morir(int i){
		grafico.setIcon(morir[i]);		
	}
	
	/**
	 * M�todo utilizado para mover la entidad gr�fica.
	 * @param direcci�n del movimiento.
	 */
	
	public void mover(int dir){
		if(grafico != null){
			cambiarMovimiento(dir);
			
			try {
				switch (dir){
					case Celda.UP :
						for(int i = 0; i < alto; i+=velocidad){
							grafico.setBounds(posicion.x, posicion.y -= velocidad, ancho, alto);
							Thread.sleep(100);
						}
						
						break;
					case Celda.DOWN : 
						for(int i = 0; i < alto; i+=velocidad){
							grafico.setBounds(posicion.x, posicion.y += velocidad, ancho, alto);
							Thread.sleep(100);
						}
						break;
					case Celda.RIGHT :
						for(int i = 0; i < ancho; i+=velocidad){
							grafico.setBounds(posicion.x += velocidad, posicion.y, ancho, alto);
							Thread.sleep(100);
						}
						break;
					case Celda.LEFT :
						for(int i = 0; i < ancho; i+= velocidad){
							grafico.setBounds(posicion.x -= velocidad, posicion.y, ancho, alto);
							Thread.sleep(100);
						}
						break;
				}
				
			} catch (InterruptedException e) {
			}
		cambiarIcono(dir);	
		}
	}
	
	
	/**
	 * M�todo utilizado para obtener la imagen de la entidad gr�fica.
	 * @return imagen del grafico.
	 */
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(imagen[1]);
			this.grafico.setBounds(posicion.x, posicion.y, ancho, alto);
		}
		return this.grafico;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(posicion.x, posicion.y, 20, 20);
	}
	
	//public abstract void mover(int i);
	
	
}
