package Threads;

import Graficos.DestructibleGrafica;
/**
 * Clase que representa el Thread de una pared destructible.
 * @author Tom�s Perotti - Iv�n Petrini
 *
 */
public class ThreadDestructible extends Thread {
	
	protected DestructibleGrafica grafica;
	/**
	 * Constructor que inicializa la gr�fica de la pared destructible con la pasada por par�metro.
	 * @param d
	 */
	public ThreadDestructible(DestructibleGrafica d){		
		grafica = d;		
	}
	/**
	 * M�todo run del thread.
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
