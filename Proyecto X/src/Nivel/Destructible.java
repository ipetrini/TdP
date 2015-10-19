package Nivel;

import Graficos.DestructibleGrafica;
import Personajes.Bomberman;
import Personajes.Enemigo;

public class Destructible extends Pared {

	public Destructible(Celda c){
		grafico = new DestructibleGrafica(c.getX(), c.getY());
	}
	
	public boolean recibirEnemigo(Enemigo e) {
		if (e.esDios()){
			miCelda.agregarEnemigo(e);
			return true;
		}
		return false;
	}

	public boolean recibirBomberman(Bomberman b) {
		if (b.esDios()){
			miCelda.setBomberman(b);
			return true;
		}
		return false;
	}

	public boolean destruir() {
		return true;
	}

}
