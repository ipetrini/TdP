package Threads;

import Graficos.ExplosionGrafica;
/**
 * Clase que representa al Thread de la explosión de la bomba.
 * @author Tomás Perotti - Iván Petrini
 *
 */
public class ThreadExplosion extends Thread {
	
	protected ExplosionGrafica grafico;
	/**
	 * Constructor que inicializa a la gráfica de la explosión con la pasada por parámetro.
	 * @param g
	 */
	public ThreadExplosion(ExplosionGrafica g){
		grafico = g;
	}
	/**
	 * Método run del thread.
	 */
	public void run(){
		
		int i = 0;
		while (i < 10){
			grafico.cambiarGrafico(i);
			i++;
			try {
				Thread.sleep(75);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	

}
