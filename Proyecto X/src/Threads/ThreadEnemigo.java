package Threads;

import Personajes.Enemigo;

/**
 * Clase que representa el Thread de el enemigo.
 * @author Tom�s Perotti - Iv�n Petrini.
 *
 */
public class ThreadEnemigo extends Thread{
		private Enemigo Logica;
		
		//Atributos
		private volatile boolean Detener;
		
		/**
		 * Constructor que inicializa el Thread del enemigo con su implementaci�n l�gica.
		 * @param enemigo
		 */
		public ThreadEnemigo(Enemigo logica) {
			this.Logica  = logica;
			this.Detener = false;
		}
		
		/**
		 * M�todo run del Thread
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
		 * M�todo que permite la detenci�n del Thread.
		 */
		public void detener() {
			System.out.println("Entro en DETENER");
			this.interrupt();			
			this.Detener = true;
			System.out.println("Entro en DETENER asdasd");
		}
		
		/**
		 * M�todo que destruye el enemigo.
		 */
		public void destruir() {
			System.out.println("Entro en DESTRUIR");
			this.Logica.morir();
			this.detener();
			
		}
}
