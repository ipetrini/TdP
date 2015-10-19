package Personajes;

import Nivel.Celda;
import Nivel.Nivel;

public abstract class Enemigo extends Personaje {

	protected int puntaje;
	protected int pos;
	
	public Enemigo(int v, boolean d, Nivel n, Celda c, int p){
		super(v, d, n, c);
		puntaje = p;
	}
	
	public int getPuntaje(){
		return puntaje;
	}
	
	public int getPos(){
		return pos;
	}
	
	public void setPos(int p){
		pos = p;
	}
	
	public abstract void mover();
	
	public abstract void morir();
	
	
	
	
	
}

