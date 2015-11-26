package Threads;

import Nivel.Bomba;

/**
 * Clase que representa el Thread de la bomba.
 * @author Tomás Perotti - Iván Petrini.
 *
 */
public class ThreadBomba extends Thread {
	
	//Atributos
	private Bomba logica;

	/**
	 * Constructor que inicializa al Thread de la bomba con su implementación lógica.
	 * @param bomba
	 */
	public ThreadBomba(Bomba b) {
		
		logica = b;
	}

	/**
	 * Método run del Thread.
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
	 * Método que permite la explosión de la bomba.
	 */
	public void explotar() {
		logica.explotar();	
	}
	/**
	 * Método que hace desaparecer a la bomba.
	 */
	public void desaparecer() {
		logica.desaparecer();
	}
}