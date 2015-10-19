package Threads;

import Personajes.Enemigo;

public class ThreadEnemigo extends Thread{
	// Logica que implementa al malo.
		private Enemigo Logica;
		
		// Flag que indica cuando debe detenerse la ejecución del hilo.
		// Es volatile porque es accedida desde concurrentemente desde diferentes threads.
		private volatile boolean mDetener;
		
		public ThreadEnemigo(Enemigo logica) {
			this.Logica  = logica;
			this.mDetener = false;
		}
		
		@Override
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
		
		public void detener() {
			// Interrumpo el hilo para que no continue con su ejecución.
			this.interrupt(); 
			
			// Seteamos el flag para detener su ejecución.
			this.mDetener = true;
		}
		
		public void destruir() {
			// Detengo la ejecucion del hilo.
			this.detener();
			
			// Notificamos a la logica que este hilo se destruyo.
		}
}
