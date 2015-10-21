package Nivel;

import javax.swing.JLabel;

import Graficos.BombaGrafica2;
import Graficos.BombermanGrafico;
import Graficos.EntidadGrafica;
/**
 * Clase que representa la l�gica de la bomba.
 * @author Tom�s Perotti - Iv�n Petrini
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
	 * M�todo que retorna el alcance de la bomba.
	 * @return alcance
	 */
	public int getAlcance(){
		return alcance;
	}
	/**
	 * M�todo que retorna la celda donde se encuentra la bomba.
	 * @return celda
	 */
	public Celda getCelda(){
		return miCelda;
	}
	/**
	 * M�todo que realiza la explosi�n de la bomba.
	 */
	public void explotar() {
		grafico.explotar();
	}
	/**
	 * M�todo que hace desaparecer a la bomba luego de su explosi�n.
	 */
	public void desaparecer() {
		grafico.desaparecer();
	
	}
	/**
	 * M�todo que retorna la imagen de la bomba.
	 * @return imagen
	 */
	public JLabel getGrafico() {
		return grafico.getGrafico();
	}
	
}
