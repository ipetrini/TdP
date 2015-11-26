package Nivel;

import Graficos.DestructibleGrafica;
import Personajes.Bomberman;
import Personajes.Enemigo;

/**
 * Clase que representa la lógica de una pared destructible.
 * @author Tomás Perotti - Iván Petrini
 *
 */
public class Destructible extends Pared {

	/**
	 * Constructor que inicializa la pared destructible en su celda.
	 * @param celda
	 */
	public Destructible(Celda c){
		miCelda = c;
		grafico = new DestructibleGrafica(c.getX(), c.getY());
	}
	
	
	public boolean recibirEnemigo(Enemigo e, int dir) {
		if (e.esDios()){
			miCelda.agregarEnemigo(e);
			e.moverGrafico(dir);
			return true;
		}
		return false;
	}

	
	public boolean recibirBomberman(Bomberman b, int dir) {
		if (b.esDios()){
			miCelda.setBomberman(b);
			b.moverGrafico(dir);
			return true;
		}
		return false;
	}

	
	public boolean destruir() {
		grafico.explotar();
		miCelda.getMapa().getMarcador().aumentarPuntaje(10);
		miCelda.getMapa().celdaDestruida();
		if (miCelda.getMapa().destructiblesLeft()==0){
			miCelda.getMapa().terminarJuego();
			miCelda.getMapa().getGUI().ganarJuego();
		}
		return true;
	}

	@Override
	public boolean puedePowerUp() {
		return true;
	}

}
