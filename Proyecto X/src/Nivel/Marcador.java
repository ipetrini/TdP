package Nivel;

/**
 * Clase que representa el marcador, el cual lleva el puntaje y el tiempo de la partida.
 * @author Tomás Perotti - Iván Petrini.
 *
 */

public class Marcador {
	
	private int puntaje;
	//private Reloj reloj;
	
	public Marcador (int p) {
		puntaje=p;
	}
	
	public void aumentarPuntaje(int i) {
		puntaje+=i;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public void setPuntaje(int i) {
		puntaje=i;
	}

}
