package Nivel;

import javax.swing.JLabel;

import Graficos.ParedGrafica;
import Personajes.Bomberman;
import Personajes.Enemigo;

/**
 * Clase abstracta que representa una pared.
 * @author Tomás Perotti - Iván Petrini
 *
 */
public abstract class Pared {
	
	//Atributos
	protected ParedGrafica grafico;
	protected Celda miCelda;
	
	public abstract boolean recibirEnemigo(Enemigo e, int dir);
	public abstract boolean recibirBomberman(Bomberman b);
	public abstract boolean destruir();
	public JLabel getGrafico(){
		return grafico.getGrafico();
	}
	

}
