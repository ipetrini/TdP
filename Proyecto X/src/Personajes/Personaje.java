package Personajes;

import javax.swing.JLabel;

import Graficos.EntidadGrafica;
import Nivel.Celda;
import Nivel.Nivel;

/**
 * Clase abstracta que representa un personaje del juego.
 * @author Tom�s Perotti - Iv�n Petrini.
 *
 */
public abstract class Personaje {
	
	//Atributos
	protected int velocidad;
	protected boolean dios;
	protected Nivel miNivel;
	protected Celda miCelda;
	public EntidadGrafica grafico;
	
	/**
	 * Constructor que inicializa al personaje con su velocidad, nivel, modo dios, y su celda.
	 * @param velocidad
	 * @param modo dios
	 * @param nivel
	 * @param celda
	 */
	public Personaje(int v, boolean d, Nivel n, Celda c){
		velocidad = v;
		dios = d;
		miNivel = n;
		miCelda = c;
		grafico = null;
	}
	
	/**
	 * M�toda que retorna la condici�n de dios de un personaje.
	 * @return true si es dios, false en caso contrario.
	 */
	public boolean esDios(){
		return dios;
	}
	
	/**
	 * M�todo que retorna la velocidad del personaje.
	 * @return velocidad
	 */
	public int getVelocidad(){
		return velocidad;
	}
	
	/**
	 * M�todo que retorna la celda del personaje.
	 * @return celda
	 */
	public Celda getCelda(){
		return miCelda;
	}
	
	/**
	 * M�todo que retorna el nivel del personaje.
	 * @return nivel
	 */	
	public Nivel getNivel(){
		return miNivel;
	}
	
	/**
	 * M�todo que retorna la imagen gr�fica del personaje.
	 * @return imagen
	 */
	public JLabel getGrafico(){
		return grafico.getGrafico();
	}
	
	/**
	 * M�todo que se encarga de mover el grafico del personaje.
	 * @param direccion
	 */
	public void moverGrafico(int d){
		grafico.mover(d);
	}
	
	
}
