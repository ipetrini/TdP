package Threads;

import Personajes.Enemigo;
/**
 * Clase que representa el Thread de el enemigo.
 * @author Tom�s Perotti - Iv�n Petrini.
 *
 */
public class ThreadEnemigo extends Thread{
	// Logica que implementa al malo.
		private Enemigo Logica;
		
		// Flag que indica cuando debe detenerse la ejecuci�n del hilo.
		// Es volatile porque es accedida desde concurrentemente desde diferentes threads.
		private volatile boolean mDetener;
		/**
		 * Constructor que inicializa el Thread del enemigo con su implementaci�n l�gica.
		 * @param enemigo
		 */
		public ThreadEnemigo(Enemigo logica) {
			this.Logica  = logica;
			this.mDetener = false;
		}
		
		/**
		 * M�todo run del Thread
		 */
		public void run() {
			// Ejecuto indefinidamente hasta que el flag sea verdadero.
			while(!this.mDetener){
				// Duermo el hilo 1 segundo.
				// De esta manera cada turno se ejecuta cada 1 segundo.
				try {
					Thread.sleep(0);
					
					// Realizo el movimiento
					this.Logica.mover();
				} catch (InterruptedException e) { }
			}
		}
		/**
		 * M�todo que permite la detenci�n del Thread.
		 */
		public void detener() {
			// Interrumpo el hilo para que no continue con su ejecuci�n.
			this.interrupt(); 
			
			// Seteamos el flag para detener su ejecuci�n.
			this.mDetener = true;
		}
		/**
		 * M�todo que destruye el enemigo.
		 */
		public void destruir() {
			// Detengo la ejecucion del hilo.
			this.detener();
			
			// Notificamos a la logica que este hilo se destruyo.
		}
}
