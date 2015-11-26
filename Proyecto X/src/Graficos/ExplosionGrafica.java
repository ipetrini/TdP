package Graficos;

import java.awt.Point;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Nivel.Nivel;
/**
 * Clase utilizada para representar la explosión de la bomba.
 * @author Tomás Perotti - Iván Petrini
 **/
public class ExplosionGrafica {

	protected Icon imagen[];
	protected JLabel grafico;
	protected final int ancho = 32;
	protected final int alto = 32;	
	protected Point posicion;
	protected Nivel nivel;
	
	public ExplosionGrafica (int x, int y, Nivel n){
		this.nivel = n;	
		posicion = new Point(x * ancho, y * alto);	
		grafico = new JLabel();
		imagen= new Icon [10];
		imagen[0]= new ImageIcon(this.getClass().getResource("/ExplosionImagenes/2.png"));
		imagen[1]= new ImageIcon(this.getClass().getResource("/ExplosionImagenes/3.png"));
		imagen[2]= new ImageIcon(this.getClass().getResource("/ExplosionImagenes/4.png"));
		imagen[3]= new ImageIcon(this.getClass().getResource("/ExplosionImagenes/5.png"));
		imagen[4]= new ImageIcon(this.getClass().getResource("/ExplosionImagenes/6.png"));
		imagen[5]= new ImageIcon(this.getClass().getResource("/ExplosionImagenes/7.png"));
		imagen[6]= new ImageIcon(this.getClass().getResource("/ExplosionImagenes/8.png"));
		imagen[7]= new ImageIcon(this.getClass().getResource("/ExplosionImagenes/9.png"));
		imagen[8]= new ImageIcon(this.getClass().getResource("/ExplosionImagenes/10.png"));
		imagen[9]= new ImageIcon(this.getClass().getResource("/ExplosionImagenes/11.png"));
		grafico.setIcon(null);
		grafico.setBounds(posicion.x, posicion.y, ancho, alto);
		nivel.getGUI().add(grafico);

	}
	
	public void cambiarGrafico(int i){
		grafico.setIcon(imagen[i]);
	}
}
