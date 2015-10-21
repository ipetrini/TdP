package Nivel;

import Graficos.IndestructibleGrafica;
import Personajes.Bomberman;
import Personajes.Enemigo;
/**
 * Clase que representa una pared indestructible.
 * @author true si se recibio correctamente, falso en caso contrario.
 *
 */
public class Indestructible extends Pared{
/**
 * Constructor que inicializa a la pared indestructible con su celda.
 * @param celda
 */
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
