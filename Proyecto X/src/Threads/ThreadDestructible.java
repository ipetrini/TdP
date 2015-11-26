package Threads;

import Graficos.DestructibleGrafica;
/**
 * Clase que representa el Thread de una pared destructible.
 * @author Tomás Perotti - Iván Petrini
 *
 */
public class ThreadDestructible extends Thread {
	
	protected DestructibleGrafica grafica;
	/**
	 * Constructor que inicializa la gráfica de la pared destructible con la pasada por parámetro.
	 * @param d
	 */
	public ThreadDestructible(DestructibleGrafica d){		
		grafica = d;		
	}
	/**
	 * Método run del thread.
	 */
	public void run(){
		int i = 0;
		while (i<7){
			grafica.cambiarExplosion(i);
			i++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}		
	}

}
