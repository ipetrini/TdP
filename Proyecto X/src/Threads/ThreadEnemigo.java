package Threads;

import Graficos.EntidadGrafica;
import Personajes.Enemigo;

/**
 * Clase que representa el Thread de el enemigo.
 * @author Tom�s Perotti - Iv�n Petrini.
 *
 */
public class ThreadEnemigo extends Thread{
		private Enemigo Logica;
		private EntidadGrafica grafico;
		
		//Atributos
		private volatile boolean Detener;
		
		/**
		 * Constructor que inicializa el Thread del enemigo con su implementaci�n l�gica.
		 * @param enemigo
		 */
		public ThreadEnemigo(Enemigo logica, EntidadGrafica g) {
			this.Logica  = logica;
			this.Detener = false;
			grafico = g;
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
			int i = 0;
			while (i<5){
				grafico.morir(i);
				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
				}
				i++;
			}
		}
		
		/**
		 * M�todo que permite la detenci�n del Thread.
		 */
		public void detener() {
			this.interrupt();			
			this.Detener = true;
		}
		
		/**
		 * M�todo que destruye el enemigo.
		 */
		public void destruir() {
			this.Logica.morir();
			this.detener();
			
		}
}
