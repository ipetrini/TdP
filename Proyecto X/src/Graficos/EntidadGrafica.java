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
	/**
	 * M�todo que duplica la velocidad de la entidad gr�fica.
	 */
	public void duplicarVelocidad(){
		velocidad /= 2;
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
	/**
	 * M�todo que retorna la posici�n de la entidad gr�fica.
	 * @return Rectangle
	 */
	public Rectangle getBounds() {
		return new Rectangle(posicion.x, posicion.y, 20, 20);
	}
	
	/**
	 * M�todo utilizado para mover la entidad gr�fica.
	 * @param direcci�n del movimiento.
	 */
	public abstract void mover(int i);
	/**
	 * M�todo que controla la respuesta a una colisi�n entre entidades.
	 */
	public abstract void colision();
	
	
}
