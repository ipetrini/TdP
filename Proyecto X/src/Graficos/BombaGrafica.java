package Graficos;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Clase utilizada para representar la gr�fica de la bomba.
 * @author Tom�s Perotti - Iv�n Petrini
 */

public class BombaGrafica  {
	
	//Atributos 
	protected Icon imagen;
	protected JLabel grafico;
	protected final int ancho = 32;
	protected final int alto = 32;	
	protected Point posicion;
	
	//Constructor
	/**
	 * Constructor que inicializa la bomba gr�fica.
	 * @param posicion x
	 * @param posicion y
	 */
	public BombaGrafica(int x, int y) {
		
		posicion = new Point(x * ancho, y * alto);
		grafico = null;
		imagen= new ImageIcon(this.getClass().getResource("/BombaImagenes/Bomba.gif"));
		
	}
	
	/**
	 * M�todo utilizado para hacer explotar gr�ficamente la bomba.
	 */
	public void explotar (){
		grafico.setIcon(null);
		grafico.setBounds(posicion.x-32, posicion.y-32, ancho*3, alto*3);
	}
	/**
	 * M�todo utilizado para hacer desaparecer gr�ficamente la bomba.
	 */
	public void desaparecer() {
		grafico.setIcon(null);
		
	}
	/**
	 * M�todo que retorna el gr�fico asociado a la bomba.
	 * @return JLabel
	 */
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(imagen);
			this.grafico.setBounds(posicion.x, posicion.y, ancho, alto);
		}
		return this.grafico;
	}

}