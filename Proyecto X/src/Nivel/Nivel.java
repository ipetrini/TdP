package Nivel;

import java.util.ArrayList;
import java.util.Random;


import GUI.GUI;
import Personajes.Altair;
import Personajes.Bomberman;
import Personajes.Enemigo;
import Personajes.Rugulo;
import PowerUps.Bombality;
import PowerUps.Fatality;
import PowerUps.Masacrality;
import PowerUps.SpeedUp;
import Threads.ThreadBomberman;
import Threads.ThreadEnemigo;
import Threads.ThreadTiempo;

/**
 * Clase que representa el nivel del juego.
 * @author Tomás Perotti - Iván Petrini.
 *
 */
public class Nivel {

	//Atributos
	protected ArrayList<Enemigo> misEnemigos;
	protected ThreadEnemigo[] threadE;
	protected ThreadBomberman threadB;
	protected ThreadTiempo tiempo;
	protected Bomberman miBomberman;
	protected Celda[][] Mapa;
	protected Marcador miMarcador;
	protected final int ancho = 31;
	protected final int alto = 13;
	protected GUI gui;
	protected int contDestructibles;
	
	
	/**
	 * Constructor que inicializa la interfaz gráfica del juego con sus respectivos personajes y celdas.
	 * @param frame
	 */
	public Nivel(GUI gui){
		this.gui = gui;
		contDestructibles=20;
		miMarcador = new Marcador(this);
		Mapa = new Celda[ancho][alto];
		//Creo la lista de enemigos y el arreglo de Threads para los enemigos.
		misEnemigos = new ArrayList<Enemigo>();
		threadE = new ThreadEnemigo[5];
		crearMapa(gui);
		
		
			
	}
	
	/**
	 * Método que retorna el marcador del juego.
	 * @return Marcador
	 */
	public Marcador getMarcador(){
		return miMarcador;
	}
	
	/**
	 * Método que retorna el bomberman del juego.
	 * @return bomberman
	 */
	public Bomberman getBomberman(){
		return miBomberman;
	}
	/**
	 * Método que retorna el frame del juego.
	 * @return frame.
	 */
	public GUI getGUI(){
		return this.gui;
	}
	
	/**
	 * Método que elimina un enemigo del juego.
	 * @param enemigo
	 */
	public void eliminarEnemigo(Enemigo e){
		misEnemigos.remove(e);
	}
	
	/**
	 * Método que retorna la celda de una posición pasada por parámetro.
	 * @param posicion x
	 * @param posicion y
	 * @return Celda si existe, nulo caso contrario.
	 */
	public Celda getCelda(int x, int y){
		if((x < ancho) && (x >= 0) && (y < alto) && (y >= 0))
			return Mapa[x][y];
		return null;
	}
	
	/**
	 * Método que termina la partida del juego. 
	 */
	public void terminarJuego(){
		gui.terminarJuego();
	}
	
	/**
	 * Método que mueve los enemigos.
	 */
	public void mover(){
		for (Enemigo e: misEnemigos)
			e.mover();
	}
	
	/**
	 * Método que mueve al bomberman a una dirección dada.
	 * @param dirección
	 */
	public void mover(int dir){
		miBomberman.mover(dir);
	}
	
	/**
	 * Método encargado de la creación del mapa en la interfaz gráfica.
	 * @param GUI
	 */
	public void crearMapa(GUI gui){
		
		//Setea el borde de paredes Indestructibles
		for (int i = 0; i < ancho; i++){
			for (int j = 0; j < alto; j++){
					Mapa[i][j] = new Celda(this, i, j);
					if ((j == 0 || j == 12) || (i == 0 || i == 30)){
						Mapa[i][j].setPared(new Indestructible(Mapa[i][j]));
						gui.add(Mapa[i][j].getPared().getGrafico());
					}				
			}
		}
		
		//Agrego al Bomberman al Mapa y creo su thread.
		Celda c = this.getCelda(1, 1);
		miBomberman = new Bomberman(false, this, Mapa[1][1]);
		c.setBomberman(miBomberman);
		gui.add(miBomberman.getGrafico());
		threadB = new ThreadBomberman(this, gui, miBomberman, miBomberman.getEntidad());
		threadB.start();
	
		//Rellena el mapa con paredes Indestructibles
		for (int i = 1; i < ancho-1; i++){
			for (int j = 1; j < alto-1; j++){
				if (i%2==0 && j%2 == 0){
					Mapa[i][j].setPared(new Indestructible(Mapa[i][j]));
					gui.add(Mapa[i][j].getPared().getGrafico());
				}
			}
		}
		//Añado Altairs
		añadirAltairs();

		//Rellena el mapa con paredes Destructibles.
		Random r = new Random();
		int x = 0;
		while (x<contDestructibles){
			int i = r.nextInt(ancho);
			int j = r.nextInt(alto);
			if (Mapa[i][j].getPared()==null && noBloquea(i,j)){
				Mapa[i][j].setPared(new Destructible(Mapa[i][j]));
				gui.add(Mapa[i][j].getPared().getGrafico());
				x++;
			}
		}
		añadirRugulos();
		agregarPowerUps();
		
	}
	
	private boolean noBloquea(int i, int j){
		if ((i==1 &&j==1) || (i==1 && j==2) || (i==2 && j==1))
			return false;
		return true;
	}
	
	private void añadirRugulos(){
		//Creo y añado los Rugulos a la GUI.
		Random r = new Random();
		int i = 2;
		while (i<5){
			int x = r.nextInt(ancho);
			int y = r.nextInt(alto);
			if (Mapa[x][y].getPared()==null){
				Rugulo rug = new Rugulo(this, Mapa[x][y]);
				misEnemigos.add(rug);
				Mapa[x][y].agregarEnemigo(rug);
				gui.add(rug.getGrafico());
				threadE[i] = new ThreadEnemigo(rug, rug.getEntidad());
				threadE[i].start();	
				rug.setPosThread(i);
				i++;
			}
		}
	}
	private void añadirAltairs(){
		Random r = new Random();
		int i = 0;
		while (i<2){
			int x = r.nextInt(ancho);
			int y = r.nextInt(alto);
			if (Mapa[x][y].getPared()==null){
				Altair alt = new Altair(this, Mapa[x][y]);
				misEnemigos.add(alt);
				Mapa[x][y].agregarEnemigo(alt);
				gui.add(alt.getGrafico());
				threadE[i] = new ThreadEnemigo(alt, alt.getEntidad());
				threadE[i].start();
				alt.setPosThread(i);
				i++;
			}
		}
	}
	
	private void agregarPowerUps(){

		Random r = new Random();
		int p = 0;
		while (p<=10){
			int k = r.nextInt(ancho);
			int j = r.nextInt(alto);
			Celda c = Mapa[k][j];
			if (c.getPared()!=null && c.getPowerUp() == null){
				if (p<4){
					if (c.getPared().puedePowerUp()){
						SpeedUp s = new SpeedUp(c);
						c.setPowerUp(s);
						gui.add(s.getGrafico());
						p++;
					}
				}
				else if (p<7){
					if (c.getPared().puedePowerUp()){
						Bombality b = new Bombality(c);
						c.setPowerUp(b);
						gui.add(b.getGrafico());
						p++;
					}
				}
				else if (p<10){
					if (c.getPared().puedePowerUp()){
						Fatality f = new Fatality(c);
						c.setPowerUp(f);
						gui.add(f.getGrafico());
						p++;
					}
				}
				else{
					if (c.getPared().puedePowerUp()){
						Masacrality m = new Masacrality(c);
						c.setPowerUp(m);
						gui.add(m.getGrafico());
						p++;
					}
				}					
			}
		}
	}
	
	/**
	 * Método que destruye el bomberman del juego.
	 */
	public void destruirBomberman() {
		if (!miBomberman.esDios()){
			if(this.threadB != null){
				this.threadB.destruir();
				this.threadB = null;
			}
		}
		terminarJuego();
	}
	/**
	 * Método que decrementa la cantidad de celdas destructibles en uno.
	 */
	
	public void celdaDestruida(){
		miMarcador.decrementarDestructibles();
	}
	/**
	 * Método que retorna la cantidad de celdas destructibles restantes.
	 * @return
	 */
	public int destructiblesLeft() {
		return contDestructibles;
	}
	/**
	 * Método que destruye al enemigo pasado por parámetro.
	 * @param enemigo
	 */
	public void destruirEnemigo(Enemigo e){
		if (threadE[e.getPosThread()]!=null){
			threadE[e.getPosThread()].destruir();
			threadE[e.getPosThread()]=null;
		}
			
	}
	
	
	

	
	
}
