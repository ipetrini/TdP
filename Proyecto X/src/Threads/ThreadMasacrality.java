package Threads;

import Personajes.Bomberman;

public class ThreadMasacrality extends Thread {
	
	protected Bomberman b;
	
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
