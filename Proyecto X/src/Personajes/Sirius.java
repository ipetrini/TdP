package Personajes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

import Graficos.SiriusGrafico;
import Nivel.Celda;
import Nivel.Nivel;

/**
 * Clase que representa al enemigo Sirius.
 * @author Tomás Perotti - Iván Petrini.
 *
 */
public class Sirius extends Enemigo {

	/**
	 * Constructor que inicializa al enemigo Sirius con su velocidad, modo dios, nivel, celda, y puntaje.
	 * @param velocidad
	 * @param modo dios
	 * @param nivel
	 * @param celda
	 * @param puntaje
	 */
	public Sirius(Nivel n, Celda c) {
		super(2, false, n, c, 50);
		grafico = new SiriusGrafico(miCelda.getX(), miCelda.getY(), velocidad, miNivel);
	}


	
	
	public void mover() {
	
		Map<Integer, Integer> mapeo = new Hashtable<Integer, Integer>();
		int mov1=1000, mov2=1000, mov3=1000, mov4=1000;
		Celda c1, c2, c3, c4;
		c1 = miCelda.getVecina(Celda.UP);
		if (c1!=null)
			if (c1.getPared()==null){
				mov1 = Math.abs(((c1.getX() - miNivel.getBomberman().getCelda().getX()) + (c1.getY() - miNivel.getBomberman().getCelda().getY()) - 1));
				mapeo.put(mov1, Celda.UP);
			}
		c2 = miCelda.getVecina(Celda.DOWN);
		if (c2!=null)
			if (c2.getPared()==null){
				mov2 = Math.abs((c2.getX() - miNivel.getBomberman().getCelda().getX() + (c2.getY() - miNivel.getBomberman().getCelda().getY()) - 1));
				mapeo.put(mov2, Celda.DOWN);
			}
		c3 = miCelda.getVecina(Celda.LEFT);
		if (c3!=null)
			if (c3.getPared()==null){
				mov3 = Math.abs((c3.getX() - miNivel.getBomberman().getCelda().getX() + (c3.getY() - miNivel.getBomberman().getCelda().getY()) - 1));
				mapeo.put(mov3, Celda.LEFT);
			}
		c4 = miCelda.getVecina(Celda.RIGHT);
		if (c4!=null)
			if (c4.getPared()==null){
				mov4 = Math.abs((c4.getX() - miNivel.getBomberman().getCelda().getX() + (c4.getY() - miNivel.getBomberman().getCelda().getY()) - 1));
				mapeo.put(mov4, Celda.RIGHT);
			}
		
		
		PriorityQueue<Integer> cola = new PriorityQueue<Integer>();
		cola.add(mov1);
		cola.add(mov2);
		cola.add(mov3);
		cola.add(mov4);

		boolean termine = false;
		while (!termine){
			int dir = mapeo.get(cola.poll());
			if (miCelda.getVecina(dir).getPared()==null){			
				moverAux(dir);
				termine=true;
			}
			
		}
			
	
	}
	
	public boolean puedeMover(int dir){
		return (miCelda.getVecina(dir)!=null && miCelda.getVecina(dir).getPared()==null);		
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
