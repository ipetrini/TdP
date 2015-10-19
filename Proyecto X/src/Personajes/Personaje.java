package Personajes;

import javax.swing.JLabel;

import Graficos.EntidadGrafica;
import Nivel.Celda;
import Nivel.Nivel;

public abstract class Personaje {
	
	protected int velocidad;
	protected boolean dios;
	protected Nivel miNivel;
	protected Celda miCelda;
	protected EntidadGrafica grafico;
	
	public Personaje(int v, boolean d, Nivel n, Celda c){
		velocidad = v;
		dios = d;
		miNivel = n;
		miCelda = c;
		grafico = null;
	}
	
	public boolean esDios(){
		return dios;
	}
	
	public int getVelocidad(){
		return velocidad;
	}
	
	public Celda getCelda(){
		return miCelda;
	}
	
	public Nivel getNivel(){
		return miNivel;
	}
	
	public JLabel getGrafico(){
		return grafico.getGrafico();
	}
	
	
}
