package Graficos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class IndestructibleGrafica extends ParedGrafica {

	public IndestructibleGrafica(int x, int y) {
		super(x, y);
		this.normal = new ImageIcon(this.getClass().getResource("/ParedImagenes/Indestructible.png"));
		this.explosion = null;
	}
		
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(normal);
			this.grafico.setBounds(posicion.x, posicion.y, ancho, alto);
		}
		return this.grafico;
	}
	
	public void explotar(){		
	}

}
