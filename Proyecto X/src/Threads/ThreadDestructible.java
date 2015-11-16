package Threads;

import Graficos.DestructibleGrafica;

public class ThreadDestructible extends Thread {
	
	protected DestructibleGrafica grafica;
	
	public ThreadDestructible(DestructibleGrafica d){		
		grafica = d;		
	}
	
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
