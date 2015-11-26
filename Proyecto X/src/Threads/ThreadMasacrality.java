package Threads;

import Personajes.Bomberman;
/**
 * Clase que representa al thread del power up Masacrality.
 * @author Tomás Perotti - Iván Petrini
 *
 */
public class ThreadMasacrality extends Thread {
	
	protected Bomberman b;
	/**
	 * Constructor que inicializa al Bomberman con la masacrality.
	 * @param b
	 */
	public ThreadMasacrality(Bomberman b){
		this.b = b;
		start();
	}
	
	/**
	 * Método run del Thread.
	 */
	public void run() {
		try {
			Thread.sleep(5000);
			b.setDios(false);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		

}
