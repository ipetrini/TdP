package Personajes;

import Nivel.Celda;
import Nivel.Nivel;

/**
 * Clase abstracta que representa a un enemigo del juego.
 * @author Tomás Perotti - Iván Petrini.
 *
 */
public abstract class Enemigo extends Personaje {

	//Atributos
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
		grafico.morir();
		System.out.println("Enemigo murio");
	}
	
	public void setPosThread(int i){
		posThread = 1;
	}
	
	public int getPosThread(){
		return posThread;
	}
	
	
	
	
}

