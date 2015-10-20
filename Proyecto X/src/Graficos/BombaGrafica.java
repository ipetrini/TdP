package Graficos;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BombaGrafica  {
	
	protected Icon imagen[];
	protected JLabel grafico;
	protected final int ancho = 32;
	protected final int alto = 32;	
	protected Point posicion;
	
	public BombaGrafica(int x, int y) {
		
		posicion = new Point(x * ancho, y * alto);
		imagen= new Icon [1];
		imagen[1]= new ImageIcon(this.getClass().getResource("/BombaImagenes/bomba.png"));
		//imagen[2]= new ImageIcon(this.getClass().getResource("/BombaImagenes/explot.jpg"));
		grafico = new JLabel(imagen[1]);
		grafico.setBounds(posicion.x, posicion.y, ancho, alto);
		
		

	}
	
	public void explotar (){
		grafico.setIcon(imagen[2]);
	}

}
