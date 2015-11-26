package Threads;

import Graficos.ExplosionGrafica;
/**
 * Clase que representa al Thread de la explosi�n de la bomba.
 * @author Tom�s Perotti - Iv�n Petrini
 *
 */
public class ThreadExplosion extends Thread {
	
	protected ExplosionGrafica grafico;
	/**
	 * Constructor que inicializa a la gr�fica de la explosi�n con la pasada por par�metro.
	 * @param g
	 */
	public ThreadExplosion(ExplosionGrafica g){
		grafico = g;
	}
	/**
	 * M�todo run del thread.
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
