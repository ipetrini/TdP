package Threads;

import Graficos.ExplosionGrafica;

public class ThreadExplosion extends Thread {
	
	protected ExplosionGrafica grafico;
	
	public ThreadExplosion(ExplosionGrafica g){
		grafico = g;
	}
	
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
