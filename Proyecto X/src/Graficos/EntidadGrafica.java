package Graficos;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.JLabel;
import Nivel.Celda;
import Nivel.Nivel;

/**
 * Clase abstracta que representa una entidad gráfica
 * @author Tomás Perotti - Iván Petrini
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
	 * Constructor que inicializa la entidad gráfica con su posición y su velocidad.
	 * @param posición x
	 * @param posición y
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
	 * Método que retorna la posición de la entidad.
	 * @return posicion
	 */
	public Point getPosicion(){
		return posicion;
	}
	
	/**
	 * Método que retorna la velocidad de la entidad.
	 * @return velocidad
	 */
	public int getVelocidad(){
		return velocidad;
	}
	/**
	 * Método que duplica la velocidad de la entidad gráfica.
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
	 * Método utilizado para destruir la entidad gráfica.
	 */
	public void morir(int i){
		grafico.setIcon(morir[i]);		
	}
		
	/**
	 * Método utilizado para obtener la imagen de la entidad gráfica.
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
	 * Método que retorna la posición de la entidad gráfica.
	 * @return Rectangle
	 */
	public Rectangle getBounds() {
		return new Rectangle(posicion.x, posicion.y, 20, 20);
	}
	
	/**
	 * Método utilizado para mover la entidad gráfica.
	 * @param dirección del movimiento.
	 */
	public abstract void mover(int i);
	/**
	 * Método que controla la respuesta a una colisión entre entidades.
	 */
	public abstract void colision();
	
	
}
