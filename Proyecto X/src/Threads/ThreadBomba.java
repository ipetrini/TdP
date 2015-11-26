package Threads;

import Nivel.Bomba;

/**
 * Clase que representa el Thread de la bomba.
 * @author Tom�s Perotti - Iv�n Petrini.
 *
 */
public class ThreadBomba extends Thread {
	
	//Atributos
	private Bomba logica;

	/**
	 * Constructor que inicializa al Thread de la bomba con su implementaci�n l�gica.
	 * @param bomba
	 */
	public ThreadBomba(Bomba b) {
		
		logica = b;
	}

	/**
	 * M�todo run del Thread.
	 */
	public void run() {
		try {
			Thread.sleep(3000);
			explotar();
			Thread.sleep(1000);
			desaparecer();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * M�todo que permite la explosi�n de la bomba.
	 */
	public void explotar() {
		logica.explotar();	
	}
	/**
	 * M�todo que hace desaparecer a la bomba.
	 */
	public void desaparecer() {
		logica.desaparecer();
	}
}