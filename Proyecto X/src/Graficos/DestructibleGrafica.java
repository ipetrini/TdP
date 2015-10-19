package Graficos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DestructibleGrafica extends ParedGrafica {

	public DestructibleGrafica(int x, int y){
		super(x, y);
		this.normal = new ImageIcon(this.getClass().getResource("/ParedImagenes/Destructible.png"));
		this.explosion = new ImageIcon(this.getClass().getResource("/ParedImagenes/ExplosionPared.gif"));
		
	}
	
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(normal);
			this.grafico.setBounds(posicion.x, posicion.y, ancho, alto);
		}
		return this.grafico;
	}
	
	public void explotar(){
		this.grafico.setIcon(explosion);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	

}
