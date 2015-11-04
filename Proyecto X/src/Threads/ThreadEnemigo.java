package Threads;

import Personajes.Enemigo;

/**
 * Clase que representa el Thread de el enemigo.
 * @author Tomás Perotti - Iván Petrini.
 *
 */
public class ThreadEnemigo extends Thread{
		private Enemigo Logica;
		
		//Atributos
		private volatile boolean Detener;
		
		/**
		 * Constructor que inicializa el Thread del enemigo con su implementación lógica.
		 * @param enemigo
		 */
		public ThreadEnemigo(Enemigo logica) {
			this.Logica  = logica;
			this.Detener = false;
		}
		
		/**
		 * Método run del Thread
		 */
		public void run() {
			while(!this.Detener){
				try {
					Thread.sleep(100);					
					this.Logica.mover();
				} catch (InterruptedException e) { }
			}
		}
		
		/**
		 * Método que permite la detención del Thread.
		 */
		public void detener() {
			this.interrupt();			
			this.Detener = true;
		}
		
		/**
		 * Método que destruye el enemigo.
		 */
		public void destruir() {
			this.Logica.morir();
			this.detener();
			
		}
}
