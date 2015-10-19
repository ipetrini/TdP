package Graficos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LibreGrafica extends ParedGrafica{

	public LibreGrafica(int x, int y) {
		super(x, y);
		this.normal = new ImageIcon(this.getClass().getResource("/ParedImagenes/Libre.png"));
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
