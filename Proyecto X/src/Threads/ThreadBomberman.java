package Threads;

import Nivel.Nivel;
import Personajes.Bomberman;
import GUI.GUI;

public class ThreadBomberman extends Thread {
	
	private Nivel juego;
	private GUI gui;
	private volatile boolean detener = false;
	private Bomberman logica;

	public ThreadBomberman(Nivel j, GUI gui, Bomberman b) {
		this.juego = j;
		this.gui = gui;
		logica = b;
	}

	public void run() {
		while(!detener){
				if(gui.getLock()){
				juego.mover(gui.getDirection());
				gui.toggleLock();
			}
		}
	}
	
	public void detener() {
		
			this.interrupt();
			this.detener = true;
			
	}
	
	public void destruir() {
		
		this.logica.morir();
		this.detener();		
		
	}
}


