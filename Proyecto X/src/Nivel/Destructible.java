package Nivel;

import Graficos.DestructibleGrafica;
import Personajes.Bomberman;
import Personajes.Enemigo;
/**
 * Clase que representa la l�gica de una pared destructible.
 * @author Tom�s Perotti - Iv�n Petrini
 *
 */
public class Destructible extends Pared {
/**
 * Constructor que inicializa la pared destructible con su celda.
 * @param celda
 */
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
