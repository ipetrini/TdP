package Graficos;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;
import Nivel.Celda;

public abstract class EntidadGrafica {
	
	protected JLabel grafico;
	protected Icon imagen[];
	protected Icon movimiento[];
	protected Icon morir;
	protected Point posicion;
	protected final int ancho = 32;
	protected final int alto = 32;	
	protected int velocidad;
	
	public EntidadGrafica(int x, int y, int v){		
		imagen = new Icon[4];
		movimiento = new Icon[4];
		posicion = new Point(x * ancho, y * alto);
		velocidad = v;				
	}
	
	public Point getPosicion(){
		return posicion;
	}
	
	public int getVelocidad(){
		return velocidad;
	}
	
	protected void cambiarIcono(int d){
		int direccion = -1;		
		switch (d){
			case Celda.UP : 
				direccion = 0;
				break;
			case Celda.DOWN : 
				direccion = 1;
				break;
			case Celda.LEFT : 
				direccion = 2;
				break;
			case Celda.RIGHT : 
				direccion = 3;
				break;
		}		
		grafico.setIcon(imagen[direccion]);
	}
	
	protected void cambiarMovimiento(int d){
		int direccion = -1;
		switch (d){
		case Celda.UP : 
			direccion = 0;
			break;
		case Celda.DOWN : 
			direccion = 1;
			break;
		case Celda.LEFT : 
			direccion = 2;
			break;
		case Celda.RIGHT : 
			direccion = 3;
			break;
		}		
		grafico.setIcon(movimiento[direccion]);
	}
	
	public void morir(){
		grafico.setIcon(morir);		
		//grafico.setIcon(null);
	}
	
	public void mover(int dir){
		if(grafico != null){
			cambiarMovimiento(dir);
			
			try {
				switch (dir){
					case Celda.UP :
						for(int i = 0; i < alto; i+=velocidad){
							grafico.setBounds(posicion.x, posicion.y -= velocidad, ancho, alto);
							Thread.sleep(100);
						}
						
						break;
					case Celda.DOWN : 
						for(int i = 0; i < alto; i+=velocidad){
							grafico.setBounds(posicion.x, posicion.y += velocidad, ancho, alto);
							Thread.sleep(100);
						}
						break;
					case Celda.RIGHT :
						for(int i = 0; i < ancho; i+=velocidad){
							grafico.setBounds(posicion.x += velocidad, posicion.y, ancho, alto);
							Thread.sleep(100);
						}
						break;
					case Celda.LEFT :
						for(int i = 0; i < ancho; i+= velocidad){
							grafico.setBounds(posicion.x -= velocidad, posicion.y, ancho, alto);
							Thread.sleep(100);
						}
						break;
				}
				
			} catch (InterruptedException e) {
			
				
				
			}
		cambiarIcono(dir);	
		}
	}
	
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(imagen[1]);
			this.grafico.setBounds(posicion.x, posicion.y, ancho, alto);
		}
		return this.grafico;
	}
	
}
