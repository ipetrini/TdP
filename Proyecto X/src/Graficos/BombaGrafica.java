package Graficos;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Clase utilizada para representar la gráfica de la bomba.
 * @author Tomás Perotti - Iván Petrini
 */

public class BombaGrafica  {
	
	//Atributos 
	protected Icon imagen[];
	protected JLabel grafico;
	protected final int ancho = 32;
	protected final int alto = 32;	
	protected Point posicion;
	
	//Constructor
	/**
	 * Constructor que inicializa la bomba gráfica.
	 * @param posicion x
	 * @param posicion y
	 */
	public BombaGrafica(int x, int y) {
		
		posicion = new Point(x * ancho, y * alto);
		grafico = null;
		imagen= new Icon [2];
		imagen[0]= new ImageIcon(this.getClass().getResource("/BombaImagenes/bomba.png"));
		imagen[1]= new ImageIcon(this.getClass().getResource("/BombaImagenes/explode.png"));
		
	}
	
	/**
	 * Método utilizado para hacer explotar gráficamente la bomba.
	 */
	public void explotar (){
		grafico.setIcon(imagen[1]);
		grafico.setBounds(posicion.x-32, posicion.y-32, ancho*3, alto*3);
	}
	
	public void desaparecer() {
		grafico.setIcon(null);
		
	}
	
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(imagen[0]);
			this.grafico.setBounds(posicion.x, posicion.y, ancho, alto);
		}
		return this.grafico;
	}

}