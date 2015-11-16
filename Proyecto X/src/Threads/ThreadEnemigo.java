package Threads;

import Graficos.EntidadGrafica;
import Personajes.Enemigo;

/**
 * Clase que representa el Thread de el enemigo.
 * @author Tomás Perotti - Iván Petrini.
 *
 */
public class ThreadEnemigo extends Thread{
		private Enemigo Logica;
		private EntidadGrafica grafico;
		
		//Atributos
		private volatile boolean Detener;
		
		/**
		 * Constructor que inicializa el Thread del enemigo con su implementación lógica.
		 * @param enemigo
		 */
		public ThreadEnemigo(Enemigo logica, EntidadGrafica g) {
			this.Logica  = logica;
			this.Detener = false;
			grafico = g;
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
