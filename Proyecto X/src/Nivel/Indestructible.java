package Nivel;

import Graficos.IndestructibleGrafica;
import Personajes.Bomberman;
import Personajes.Enemigo;

public class Indestructible extends Pared{

	public Indestructible(Celda c){
		grafico = new IndestructibleGrafica(c.getX(), c.getY());
	}
	
	public boolean recibirEnemigo(Enemigo e) {
		return false;
	}

	public boolean recibirBomberman(Bomberman b) {
		return false;
	}

	public boolean destruir() {
		return false;
	}

}
