package Personajes;

import java.awt.event.KeyEvent;

import Graficos.BombermanGrafico;
import Nivel.Bomba;
import Nivel.Celda;
import Nivel.Nivel;
import Threads.ThreadBomba;

public class Bomberman extends Personaje {
	
	protected int cantBombas;
	protected int alcance;
	
	public Bomberman(boolean d, Nivel n, Celda c) {
		super(4, d, n, c);
		cantBombas = 1;
		alcance = 1;
		grafico = new BombermanGrafico(miCelda.getX(), miCelda.getY(), velocidad);
	}
	
	public void mover(int i) {
		miCelda.setBomberman(null);
		switch (i){
		case KeyEvent.VK_UP :
			moverAux(KeyEvent.VK_UP);
			break;
		case KeyEvent.VK_DOWN :
			moverAux(KeyEvent.VK_DOWN);
			break;
		case KeyEvent.VK_LEFT :
			moverAux(KeyEvent.VK_LEFT);
			break;
		case KeyEvent.VK_RIGHT :
			moverAux(KeyEvent.VK_RIGHT);
			break;
		}
	}	
	
	private void moverAux(int dir){
		Celda next = this.miCelda.getVecina(dir);		
		if(next != null){
				if (next.recibirBomberman(this)){
					miCelda = next;
					this.grafico.mover(dir);
			}					
		}
	}
	public void aumentarBombas(){
		cantBombas++;
	}
	
	public void duplicarAlcance(){
		alcance*=2;
	}
	
	public void velocidad2X(){
		velocidad *= 2;
	}
	
	public void setDios(boolean v){
		dios = v;
	}
	
	public void morir(){
		if (dios==false){
			//miNivel.terminarJuego();
			grafico.morir();
		}
	}
	
	public void ponerBomba(){
		Bomba b = new Bomba(alcance, this.getCelda());
		//miNivel.getGUI().add(b.getGrafico());
		Thread t = new ThreadBomba (b);
		t.start();
	}
	

	
}
