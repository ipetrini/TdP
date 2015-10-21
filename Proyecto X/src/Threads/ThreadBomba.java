package Threads;

import Nivel.Bomba;
import Nivel.Nivel;
import Personajes.Bomberman;
import GUI.GUI;


public class ThreadBomba extends Thread {
	
	private Bomba logica;

	public ThreadBomba(Bomba b) {
		
		logica = b;
	}

	public void run() {
		try {
			System.out.println("Se ejecuto el RUN");
			Thread.sleep(2000);
			System.out.println("Se ejecuto el RUN despues de sleep");
			explotar();
			Thread.sleep(1000);
			desaparecer();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void explotar() {
		logica.explotar();
	
	}
	
	public void desaparecer() {
		logica.desaparecer();
	
	}
}