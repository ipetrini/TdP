package Nivel;

import javax.swing.JLabel;

import Graficos.BombaGrafica;
import Graficos.BombaGrafica2;
import Graficos.BombermanGrafico;
import Graficos.EntidadGrafica;

public class Bomba {
	
	//Agregue atributo nivel
	protected Nivel miNivel;
	protected int alcance;
	protected Celda miCelda;
	protected BombaGrafica2 grafico;
	
	public Bomba(int a, Celda c){
		alcance = a;
		miCelda = c;
		grafico = new BombaGrafica2(miCelda.getX(), miCelda.getY());
	}
	
	public int getAlcance(){
		return alcance;
	}
	
	public Celda getCelda(){
		return miCelda;
	}
	
	public void explotar() {
		grafico.explotar();
	}
	
	public JLabel getGrafico() {
		return grafico.getGrafico();
	}
	public void mostrarBomba() {
		//grafico.mostrarBomba();
	}
}
