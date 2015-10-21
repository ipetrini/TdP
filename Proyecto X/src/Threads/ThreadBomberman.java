package Threads;

import Nivel.Nivel;
import Personajes.Bomberman;
import GUI.GUI;
/**
 * Clase que representa el Thread del Bomberman.
 * @author Tomás Perotti - Iván Petrini.
 *
 */
public class ThreadBomberman extends Thread {
	
	private Nivel juego;
	private GUI gui;
	private volatile boolean detener = false;
	private Bomberman logica;
/**
 * Constructor que inicializa el Thread del Bomberman con su implementación lógica, su nivel, y la interfaz del juego.
 * @param nivel
 * @param GUI
 * @param bomberman
 */
	public ThreadBomberman(Nivel j, GUI gui, Bomberman b) {
		this.juego = j;
		this.gui = gui;
		logica = b;
	}
/**
 * Método run del Thread.
 */
	public void run() {
		while(!detener){
				if(gui.getLock()){
				juego.mover(gui.getDirection());
				gui.toggleLock();
			}
		}
	}
	/**
	 * Método que permite la detención del Thread.
	 */
	public void detener() {
		
			this.interrupt();
			this.detener = true;
			
	}
	/**
	 * Método que destruye el bomberman.
	 */
	public void destruir() {
		
		this.logica.morir();
		this.detener();		
		
	}
}


