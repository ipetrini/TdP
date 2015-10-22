package Personajes;

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
	public Sirius(int v, boolean d, Nivel n, Celda c, int p) {
		super(v, d, n, c, p);
	}

	public void mover() {
		
	}

	public void morir() {
		
	}

}
