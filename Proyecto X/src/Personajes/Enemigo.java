package Personajes;

import Nivel.Celda;
import Nivel.Nivel;

/**
 * Clase abstracta que representa a un enemigo del juego.
 * @author Tomás Perotti - Iván Petrini.
 *
 */
public abstract class Enemigo extends Personaje {

	
	protected int puntaje;
	protected int posThread;
	/**
	 * Constructor que inicializa al enemigo con su velocidad, nivel, celda, modo dios y puntaje.
	 * @param velocidad
	 * @param modo dios
	 * @param nivel
	 * @param celda
	 * @param puntaje
	 */
	public Enemigo(int v, boolean d, Nivel n, Celda c, int p){
		super(v, d, n, c);
		puntaje = p;
	}
	
	/**
	 * Método que retorna el puntaje generado por el enemigo.
	 * @return puntaje
	 */
	public int getPuntaje(){
		return puntaje;
	}		
	
	/**
	 * Método que permite el movimiento del enemigo.
	 */
	public abstract void mover();
	
	/**
	 * Método que permite la muerte de un enemigo.
	 */
	public void morir(){
		miNivel.getMarcador().aumentarPuntaje(this.puntaje);
		miCelda.eliminarEnemigo(this);
		System.out.println("Enemigo murio");
	}
	/**
	 * Método que setea la posición del thread a una recibida por parámetro.
	 * @param posición
	 */
	public void setPosThread(int i){
		posThread = i;
	}
	/**
	 * Método que retorna la posición actual del thread.
	 * @return posicion
	 */
	public int getPosThread(){
		return posThread;
	}
	
	
	
	
}

