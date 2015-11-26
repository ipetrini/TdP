package Personajes;


import java.util.PriorityQueue;

import Graficos.SiriusGrafico;
import Nivel.Celda;
import Nivel.Nivel;
import dictionary.Dictionary;
import dictionary.Pair;

/**
 * Clase que representa al enemigo Sirius.
 * @author Tomás Perotti - Iván Petrini.
 *
 */
public class Sirius extends Enemigo {
	
	protected Celda celdaAnterior;
	/**
	 * Constructor que inicializa al enemigo Sirius con su velocidad, modo dios, nivel, celda, y puntaje.
	 * @param velocidad
	 * @param modo dios
	 * @param nivel
	 * @param celda
	 * @param puntaje
	 */
	public Sirius(Nivel n, Celda c) {
		super(30, false, n, c, 50);
		grafico = new SiriusGrafico(miCelda.getX(), miCelda.getY(), velocidad, miNivel);
		celdaAnterior = c;
	}


	
	
	public void mover() {
		
		int dir = -1;
			
		PriorityQueue<Integer> cola=new PriorityQueue<Integer>();
		Dictionary<Integer, Celda> mapeo= new Dictionary<Integer, Celda>();
		
		Bomberman bomber=this.getCelda().getMapa().getBomberman();
		Celda objetivo= bomber.getCelda();
				
		Celda celdaArriba= miCelda.getVecina(Celda.UP);
		Celda celdaAbajo= miCelda.getVecina(Celda.DOWN);
		Celda celdaIzquierda= miCelda.getVecina(Celda.LEFT);
		Celda celdaDerecha= miCelda.getVecina(Celda.RIGHT);
		
		int distUP = distancia(objetivo, celdaArriba);
		int distDOWN = distancia(objetivo, celdaAbajo);
		int distLEFT = distancia(objetivo, celdaIzquierda);
		int distRIGHT = distancia(objetivo, celdaDerecha);
		
		
		//Seteo la distancia de la celda anterior en 1000 para que intente no volver a dicha celda.
		if (celdaArriba==celdaAnterior){
			distUP=1000;
		}
		else{
			if (celdaAbajo==celdaAnterior){
				distDOWN=1000;
			}
			else{
				if(celdaIzquierda==celdaAnterior){
					distLEFT=1000;
				}
				else{
					distRIGHT=1000;
				}
			}
		}
				
		//Se ordenan las celdas en base a la distancia que tienen al boomberman
		cola.add(distUP);
		cola.add(distDOWN);
		cola.add(distLEFT);
		cola.add(distRIGHT);
		
		//Añado las celda al mapeo con sus respectivas distancias
		mapeo.add(distUP, celdaArriba);
		mapeo.add(distDOWN, celdaAbajo);
		mapeo.add(distLEFT, celdaIzquierda);
		mapeo.add(distRIGHT, celdaDerecha);
		
		
		boolean termine = false;
		celdaAnterior = miCelda;
		while (!termine && !cola.isEmpty()){			
			int menor = cola.poll();
			Pair<Integer, Celda> entrada = mapeo.get(menor);
			mapeo.remove(entrada);
			Celda obj = entrada.getValue();
			
			if (obj==celdaArriba)
				dir=Celda.UP;
			else{
				if(obj==celdaAbajo)
					dir=Celda.DOWN;
				else{
					if (obj==celdaIzquierda)
						dir=Celda.LEFT;
					else
						dir=Celda.RIGHT;
				}
			}
			miCelda.eliminarEnemigo(this);
			termine = moverAux(dir);			
		}
	}
	
	private int distancia (Celda a, Celda b){		
		return  Math.abs(a.getY()- b.getY())+ Math.abs(a.getX() - b.getX()) ;
	}
	
	

	private boolean moverAux(int dir){
		Celda next = this.miCelda.getVecina(dir);		
		if(next != null){
				if (next.recibirEnemigo(this, dir)){
					miCelda = next;
					return true;
				}	
		}
		else
			miCelda.agregarEnemigo(this);
		return false;
	}
	
}
