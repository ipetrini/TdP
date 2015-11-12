package Nivel;

import javax.swing.JLabel;

import Graficos.BombaGrafica;
import Threads.ThreadBomba;

/**
 * Clase que representa la lógica de la bomba.
 * @author Tomás Perotti - Iván Petrini
 *
 */

public class Bomba {
	
	//Atributos
	protected Nivel miNivel;
	protected int alcance;
	protected Celda miCelda;
	protected BombaGrafica grafico;
	protected ThreadBomba thread;
	
	/**
	 * Constructor que inicializa a la bomba con su alcance y su celda correspondiente.
	 * @param alcance 
	 * @param celda
	 */
	public Bomba(int a, Celda c, Nivel n){
		alcance = a;
		miCelda = c;
		miNivel = n;
		grafico = new BombaGrafica(miCelda.getX(), miCelda.getY());
		thread = new ThreadBomba(this);
		thread.start();
	}
	
	/**
	 * Método que retorna el alcance de la bomba.
	 * @return alcance
	 */
	public int getAlcance(){
		return alcance;
	}
	
	/**
	 * Método que retorna la celda donde se encuentra la bomba.
	 * @return celda
	 */
	public Celda getCelda(){
		return miCelda;
	}
	
	/**
	 * Método que realiza la explosión de la bomba e interrumpe el hilo.
	 */
	public void explotar() {
		grafico.explotar();
		
		//Explota desde X hasta X-alcance
		for (int i = miCelda.getX(); i>=miCelda.getX()-alcance; i--){
			
			Celda vecina = miNivel.getCelda(i, miCelda.getY());
			if(vecina!=null)
				vecina.explotar();
				
			
		}
		//Explota desde X+1 hasta X+alcance
		for (int i = miCelda.getX()+1; i<=miCelda.getX()+alcance; i++){
			Celda vecina = miNivel.getCelda(i, miCelda.getY());
			if(vecina!=null)
				vecina.explotar();
			

		}
		//Explota desde Y hasta Y-alcance
		for (int j = miCelda.getY(); j>=miCelda.getY()-alcance; j--){
			Celda vecina = miNivel.getCelda(miCelda.getX(), j);
			if(vecina!=null)
				vecina.explotar();	
			
		}
		//Explota desde Y+1 hasta Y+alcance
		for (int j = miCelda.getY()+1; j<=miCelda.getY()+alcance; j++){
			Celda vecina = miNivel.getCelda(miCelda.getX(), j);
			if(vecina!=null)
				vecina.explotar();	
		
		}
		
		miNivel.getBomberman().aumentarBombas();
		
	}
	
	public void desaparecer() {
		grafico.desaparecer();
		
	}
	
	/**
	 * Método que hace desaparecer a la bomba luego de su explosión.
	 */
	public JLabel getGrafico() {
		return grafico.getGrafico();
	}
	
	/**
	 * Método que agrega la bomba a la GUI.
	 */
	public void agregarBomba(){
		miNivel.getGUI().add(getGrafico());		
	}
	
}