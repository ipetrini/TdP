package Personajes;

import java.util.Random;

import Graficos.RuguloGrafico;
import Nivel.Celda;
import Nivel.Nivel;

/**
 * Clase que representa al enemigo Rugulo del juego.
 * @author Tomás Perotti - Iván Petrini.
 *
 */
public class Rugulo extends Enemigo{

	/**
	 * Constructor que inicializa al enemigo Rugulo con su nivel y celda.
	 * @param nivel 
	 * @param celda
	 */
	public Rugulo(Nivel n, Celda c) {
		super(2, false, n, c, 15);
		grafico = new RuguloGrafico(miCelda.getX(), miCelda.getY(), velocidad);		
	}

	/**
	 * Método que realiza el movimiento del Rugulo de manera random.
	 */
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

	/**
	 * Método que produce la muerte del Rugulo.
	 */
	
	private void moverAux(int dir){
		Celda next = this.miCelda.getVecina(dir);		
		if(next != null){
				if (next.recibirEnemigo(this, dir)){
					miCelda = next;
					
			}					
		}
		else
			miCelda.agregarEnemigo(this);
	}

}
