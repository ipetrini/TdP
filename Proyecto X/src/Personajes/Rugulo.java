package Personajes;

import java.util.Random;

import Graficos.RuguloGrafico;
import Nivel.Celda;
import Nivel.Nivel;

public class Rugulo extends Enemigo{

	public Rugulo(Nivel n, Celda c) {
		super(4, false, n, c, 15);
		grafico = new RuguloGrafico(miCelda.getX(), miCelda.getY(), velocidad);		
	}

	public void mover() {
		Random r = new Random();		
		int dir = r.nextInt(4);		
		int direccion = -1;
		switch (dir) {
			case 0 :
				direccion = Celda.UP;
				break;
			case 1 :
				direccion = Celda.DOWN;
				break;
			case 2 : 
				direccion = Celda.LEFT;
				break;
			case 3 : 
				direccion = Celda.RIGHT;
				break;
		}
		
		miCelda.eliminarEnemigo(this);
		moverAux(direccion);
	}

	public void morir() {
		
	}
	
	private void moverAux(int dir){
		Celda next = this.miCelda.getVecina(dir);		
		if(next != null){
				if (next.recibirEnemigo(this)){
					miCelda = next;
					this.grafico.mover(dir);
			}					
		}
	}

}
