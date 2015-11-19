package Personajes;

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
		super(4, false, n, c, 50);
		grafico = new SiriusGrafico(miCelda.getX(), miCelda.getY(), velocidad, miNivel);
	}


	
	/*
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
	*/
	
	public void mover(){
		int BomberX = miNivel.getBomberman().getCelda().getX();
		int BomberY = miNivel.getBomberman().getCelda().getY();
		int SiriusX = miCelda.getX();
		int SiriusY = miCelda.getY();
		
		int mov = 0;
		
		if (SiriusX > BomberX)
			if (moverAux(Celda.LEFT))
				mov++;
		else{
			if (SiriusX < BomberX)
				if (moverAux(Celda.RIGHT))
					mov++;
		}
		
		if (SiriusY > BomberY)
			if (moverAux(Celda.UP))
				mov++;
		else{
			if (SiriusY < BomberY)
				if (moverAux(Celda.DOWN))
					mov++;
		}
		
		if (mov==0){
			int i = 0;
			while (i < 5){
				Random r = new Random();
				int x = r.nextInt(4);
				switch (x) {
				case 0 :
					if (moverAux(Celda.UP))
						mover();
				case 1 :
					if (moverAux(Celda.DOWN))
						mover();
				case 2 : 
					if (moverAux(Celda.LEFT))
						mover();
				case 3 : 
					if (moverAux(Celda.RIGHT))
						mover();
				}
			}
		}
	}
	
	public boolean puedeMover(int dir){
		return (miCelda.getVecina(dir)!=null && miCelda.getVecina(dir).getPared()==null);		
	}
	

	private boolean moverAux(int dir){
		Celda next = this.miCelda.getVecina(dir);		
		if(next != null){
				if (next.recibirEnemigo(this, dir)){
					miCelda = next;
					return true;
				}	
				else 
					return false;
		}
		else
			miCelda.agregarEnemigo(this);
		return false;
	}
	

	
	

}
