package Personajes;

import Nivel.Celda;
import Nivel.Nivel;
/**
 * Clase abstracta que representa a un enemigo del juego.
 * @author Tom�s Perotti - Iv�n Petrini.
 *
 */
public abstract class Enemigo extends Personaje {

	protected int puntaje;
	protected int pos;
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
	 * M�todo que retorna el puntaje generado por el enemigo.
	 * @return puntaje
	 */
	public int getPuntaje(){
		return puntaje;
	}
	/**
	 * M�todo que retorna la posici�n del enemigo.
	 * @return posici�n
	 */
	public int getPos(){
		return pos;
	}
	/**
	 * M�todo que setea la posici�n del enemigo.
	 * @param posici�n
	 */
	public void setPos(int p){
		pos = p;
	}
	/**
	 * M�todo que permite el movimiento del enemigo.
	 */
	public abstract void mover();
	/**
	 * M�todo que permite la muerte de un enemigo.
	 */
	public abstract void morir();
	
	
	
	
	
}

