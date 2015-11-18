package Personajes;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

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
		Map<Integer, Celda> mapeo = new Hashtable<Integer, Celda>();
		int mov1=1000, mov2=1000, mov3=1000, mov4=1000;
		Celda c1, c2, c3, c4;
		c1 = miCelda.getVecina(Celda.UP);
		if (c1!=null)
			if (c1.getPared()==null){
				mov1 = ((c1.getX() - miNivel.getBomberman().getCelda().getX()) + (c1.getY() - miNivel.getBomberman().getCelda().getY()) - 1);
				mapeo.put(mov1, c1);
			}
		c2 = miCelda.getVecina(Celda.DOWN);
		if (c2!=null)
			if (c2.getPared()==null){
				mov2 = (c2.getX() - miNivel.getBomberman().getCelda().getX() + (c2.getY() - miNivel.getBomberman().getCelda().getY()) - 1);
				mapeo.put(mov2, c2);
			}
		c3 = miCelda.getVecina(Celda.LEFT);
		if (c3!=null)
			if (c3.getPared()==null){
				mov3 = (c3.getX() - miNivel.getBomberman().getCelda().getX() + (c3.getY() - miNivel.getBomberman().getCelda().getY()) - 1);
				mapeo.put(mov3, c3);
			}
		c4 = miCelda.getVecina(Celda.RIGHT);
		if (c4!=null)
			if (c4.getPared()==null){
				mov4 = (c4.getX() - miNivel.getBomberman().getCelda().getX() + (c4.getY() - miNivel.getBomberman().getCelda().getY()) - 1);
				mapeo.put(mov4, c4);
			}
		
		
	
		
		PriorityQueue<Integer> cola = new PriorityQueue<Integer>();
		cola.add(mov1);
		cola.add(mov2);
		cola.add(mov3);
		cola.add(mov4);

		boolean termine = false;
		while (!termine){
			int aMover = cola.poll();
			Celda c = mapeo.get(aMover);
			if (c == c1){
				//System.out.println("Entre c1");
				if (c1.getPared()==null){
					miCelda.eliminarEnemigo(this);
					moverAux(Celda.UP);
					termine = true;
				}
			}
			else if (c == c2){
				//System.out.println("Entre c2");
				if (c2.getPared()==null){
					miCelda.eliminarEnemigo(this);
					moverAux(Celda.DOWN);
					termine = true;
				}
			}
			else if (c == c3){
				//System.out.println("Entre c3");
				if (c3.getPared()== null){
					miCelda.eliminarEnemigo(this);
					moverAux(Celda.LEFT);
					termine = true;
				}
			}
			else{
				if (c4.getPared()==null){
				//	System.out.println("Entre c4");
					miCelda.eliminarEnemigo(this);
					moverAux(Celda.RIGHT);
					termine = true;
				}
			}
						
		}
			
		
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
