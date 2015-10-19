package Graficos;

import java.awt.Point;
import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class ParedGrafica {

	protected JLabel grafico;
	protected Icon normal;
	protected Icon explosion;
	protected Point posicion;
	protected final int ancho = 32;
	protected final int alto = 32;	
	
	public ParedGrafica(int x, int y){
		grafico = null;
		posicion = new Point(x * ancho, y * alto);
	}
	
	public Point getPosicion(){
		return posicion;
	}
	
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(normal);
			this.grafico.setBounds(posicion.x, posicion.y, ancho, alto);
		}
		return this.grafico;
	}
	
	public abstract void explotar();
}
