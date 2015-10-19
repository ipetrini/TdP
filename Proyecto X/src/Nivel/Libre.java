package Nivel;

import Graficos.LibreGrafica;
import Personajes.Bomberman;
import Personajes.Enemigo;

public class Libre extends Pared {

	public Libre(Celda c){
		grafico = new LibreGrafica(c.getX(), c.getY());
	}
	
	public boolean recibirEnemigo(Enemigo e) {
		return true;
	}

	
	public boolean recibirBomberman(Bomberman b) {
		return true;
	}

	
	public boolean destruir() {
		return false;
	}

}
