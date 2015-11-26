package GUI;

import java.io.Serializable;
/**
 * Clase que representa el puntaje de un jugador durante el juego.
 * @author Tomás Perotti - Iván Petrini
 *
 */
public class Score implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3484711864026060041L;
	private int h, m, s;
	
	public Score(int h, int m, int s){
		this.h = h;
		this.m = m;
		this.s = s;
	}
	
	public int getHoras(){
		return h;
	}
	
	public int getMin(){
		return m;
	}
	
	public int getSeg(){
		return s;
	}
	
	
	
}
