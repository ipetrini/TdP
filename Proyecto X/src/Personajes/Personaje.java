package Personajes;

import javax.swing.JLabel;

import Graficos.EntidadGrafica;
import Nivel.Celda;
import Nivel.Nivel;
/**
 * Clase abstracta que representa un personaje del juego.
 * @author Tomás Perotti - Iván Petrini.
 *
 */
public abstract class Personaje {
	
	protected int velocidad;
	protected boolean dios;
	protected Nivel miNivel;
	protected Celda miCelda;
	protected EntidadGrafica grafico;
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
	 * Métoda que retorna la condición de dios de un personaje.
	 * @return true si es dios, false en caso contrario.
	 */
	public boolean esDios(){
		return dios;
	}
	/**
	 * Método que retorna la velocidad del personaje.
	 * @return velocidad
	 */
	public int getVelocidad(){
		return velocidad;
	}
	/**
	 * Método que retorna la celda del personaje.
	 * @return celda
	 */
	public Celda getCelda(){
		return miCelda;
	}
	/**
	 * Método que retorna el nivel del personaje.
	 * @return nivel
	 */
	public Nivel getNivel(){
		return miNivel;
	}
	/**
	 * Método que retorna la imagen gráfica del personaje.
	 * @return imagen
	 */
	public JLabel getGrafico(){
		return grafico.getGrafico();
	}
	
	
}
