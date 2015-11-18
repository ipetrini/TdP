package Personajes;

import java.util.Random;

import Graficos.AltairGrafico;
import Nivel.Celda;
import Nivel.Nivel;

/**
 * Clase que representa al enemigo Altair del juego.
 * @author Tomás Perotti - Iván Petrini.
 *
 */
public class Altair extends Enemigo{

	/**
	 * Constructor que inicializa al enemigo Altair con su velocidad, modo dios, nivel, celda y puntaje.
	 * @param velocidad
	 * @param modo dios
	 * @param nivel
	 * @param celda
	 * @param puntaje
	 */
	public Altair(Nivel n, Celda c) {
		super(2, true, n, c, 20);
		grafico = new AltairGrafico(miCelda.getX(), miCelda.getY(), velocidad, miNivel);	
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
