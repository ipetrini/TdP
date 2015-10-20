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
			mostrarBomba();
			Thread.sleep(3000);
			System.out.println("Se ejecuto el RUN despues de sleep");
			explotar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void mostrarBomba() {
		logica.mostrarBomba();
	
	}
	
	public void explotar() {
		logica.explotar();
	
	}
}