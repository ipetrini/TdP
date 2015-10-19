package Nivel;

import javax.swing.JLabel;

import Graficos.ParedGrafica;
import Personajes.Bomberman;
import Personajes.Enemigo;

public abstract class Pared {
	
	protected ParedGrafica grafico;
	protected Celda miCelda;
	
	public abstract boolean recibirEnemigo(Enemigo e);
	public abstract boolean recibirBomberman(Bomberman b);
	public abstract boolean destruir();
	public JLabel getGrafico(){
		return grafico.getGrafico();
	}
	

}
