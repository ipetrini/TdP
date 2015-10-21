package Nivel;

import javax.swing.JLabel;

import Graficos.BombaGrafica2;
import Graficos.BombermanGrafico;
import Graficos.EntidadGrafica;
/**
 * Clase que representa la lógica de la bomba.
 * @author Tomás Perotti - Iván Petrini
 *
 */
public class Bomba {
	
	//Agregue atributo nivel
	protected Nivel miNivel;
	protected int alcance;
	protected Celda miCelda;
	protected BombaGrafica2 grafico;
	/**
	 * Constructor que inicializa a la bomba con su alcance y su celda correspondiente.
	 * @param alcance 
	 * @param celda
	 */
	public Bomba(int a, Celda c){
		alcance = a;
		miCelda = c;
		grafico = new BombaGrafica2(miCelda.getX(), miCelda.getY());
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
	 * Método que realiza la explosión de la bomba.
	 */
	public void explotar() {
		grafico.explotar();
	}
	/**
	 * Método que hace desaparecer a la bomba luego de su explosión.
	 */
	public void desaparecer() {
		grafico.desaparecer();
	
	}
	/**
	 * Método que retorna la imagen de la bomba.
	 * @return imagen
	 */
	public JLabel getGrafico() {
		return grafico.getGrafico();
	}
	
}
