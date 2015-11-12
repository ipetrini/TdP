package Personajes;

import java.awt.event.KeyEvent;

import Graficos.BombermanGrafico;
import Nivel.Bomba;
import Nivel.Celda;
import Nivel.Nivel;

/**
 * Clase que representa al personaje bomberman del juego.
 * @author Tomás Perotti - Iván Petrini.
 *
 */
public class Bomberman extends Personaje {
	
	//Atributos
	protected int cantBombas;
	protected int alcance;
	
	/**
	 * Constructor que inicializa al bomberman con su nivel, modo dios, y su celda.
	 * @param modo dios
	 * @param nivel
	 * @param celda
	 */
	public Bomberman(boolean d, Nivel n, Celda c) {
		super(4, d, n, c);
		cantBombas = 1;
		alcance = 10;
		grafico = new BombermanGrafico(miCelda.getX(), miCelda.getY(), velocidad);
	}
	
	/**
	 * Método que mueve al bomberman en base a la dirección pasada por parámetro.
	 * @param dirección
	 */
	public void mover(int i) {
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
	
	private void moverAux(int dir) {
		Celda next = this.miCelda.getVecina(dir);		
		if(next != null){
				if (next.recibirBomberman(this, dir)){
					miCelda.setBomberman(null);
					miCelda = next;
			}					
		}
		
	}
	
	/**
	 * Método que aumenta la cantidad de bombas del bomberman en uno.
	 */
	public void aumentarBombas(){
		cantBombas++;
	}
	
	/**
	 * Método que duplica el alcance de las bombas del bomberman.
	 */
	public void duplicarAlcance(){
		alcance*=2;
	}
	
	/**
	 * Método que duplica la velocidad del bomberman.
	 */
	public void velocidad2X(){
		velocidad *= 2;
		grafico.duplicarVelocidad();
	}
	
	/**
	 * Método que setea la condición de dios del bomberman con el boolean pasada por parámetro.
	 * @param true si es dios, false caso contrario.
	 */
	public void setDios(boolean v){
		dios = v;
	}
	
	/**
	 * Método que produce la muerte del bomberman.
	 */
	public void morir(){
		if (dios==false){
			//miNivel.terminarJuego();
			System.out.println("Bomberman murio.");
			grafico.morir();
		}
	}
	
	/**
	 * Método que realiza la colocación de la bomba en la celda del bomberman.
	 */
	public void ponerBomba(){
		if(cantBombas>0){
			Bomba b = new Bomba(alcance, this.getCelda(), miNivel);
			b.agregarBomba();
			cantBombas--;
		}
	}
	

	
}
