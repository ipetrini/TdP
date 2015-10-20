package Nivel;

import java.util.ArrayList;
import java.util.Random;

import GUI.GUI;
import Personajes.Altair;
import Personajes.Bomberman;
import Personajes.Enemigo;
import Personajes.Rugulo;
import Personajes.Sirius;
import Threads.ThreadBomberman;
import Threads.ThreadEnemigo;

public class Nivel {

	protected ArrayList<Enemigo> misEnemigos;
	protected ThreadEnemigo[] threadE;
	protected ThreadBomberman threadB;
	protected Bomberman miBomberman;
	protected Celda[][] Mapa;
	protected Marcador miMarcador;
	protected final int ancho = 31;
	protected final int alto = 13;
	
	public Nivel(GUI gui){
		Mapa = new Celda[ancho][alto];
		//Creo la lista de enemigos y el arreglo de Threads para los enemigos.
		misEnemigos = new ArrayList<Enemigo>();
		threadE = new ThreadEnemigo[6];

		crearMapa(gui);
		
		Celda c = this.getCelda(1, 1);
		miBomberman = new Bomberman(false, null, Mapa[1][1]);
		c.setBomberman(miBomberman);
		gui.add(miBomberman.getGrafico());
		threadB = new ThreadBomberman(this, gui, miBomberman);
		threadB.start();
		
		//Creo y añado los enemigos a la GUI.
		Random r = new Random();
		int i = 0;
		while (i<6){
			int x = r.nextInt(ancho);
			int y = r.nextInt(alto);
			if (Mapa[x][y].getPared()==null){
				Rugulo rug = new Rugulo(this, Mapa[x][y]);
				misEnemigos.add(rug);
				Mapa[x][y].agregarEnemigo(rug);
				gui.add(rug.getGrafico());
				threadE[i] = new ThreadEnemigo(rug);
				threadE[i].start();		
				i++;
			}

		}
	}
	
	public Marcador getMarcador(){
		return miMarcador;
	}
	
	public Bomberman getBomberman(){
		return miBomberman;
	}
	
	public void eliminarEnemigo(Enemigo e){
		misEnemigos.remove(e);
	}
	
	public Celda getCelda(int x, int y){
		if((x < ancho) && (x >= 0) && (y < alto) && (y >= 0))
			return Mapa[x][y];
		return null;
	}
	
	public void terminarJuego(){
		
	}
	
	public void mover(){
		for (Enemigo e: misEnemigos)
			e.mover();
	}
	
	public void mover(int dir){
		miBomberman.mover(dir);
	}
	
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
		//Rellena el mapa con paredes Indestructibles
		for (int i = 1; i < ancho-1; i++){
			for (int j = 1; j < alto-1; j++){
				if (i%2==0 && j%2 == 0){
					Mapa[i][j].setPared(new Indestructible(Mapa[i][j]));
					gui.add(Mapa[i][j].getPared().getGrafico());
				}
			}
		}
		//Rellena el mapa con paredes Destructibles.
		Random r = new Random();
		int x = 0;
		while (x<50){
			int i = r.nextInt(ancho);
			int j = r.nextInt(alto);
			if (Mapa[i][j].getPared()==null && noBloquea(i,j)){
				Mapa[i][j].setPared(new Destructible(Mapa[i][j]));
				gui.add(Mapa[i][j].getPared().getGrafico());
				x++;
			}
		}
	}
	
	private boolean noBloquea(int i, int j){
		if ((i==1 &&j==1) || (i==1 && j==2) || (i==2 && j==1))
			return false;
		return true;
	}
	
	public void destruirBomberman() {
		if(this.threadB != null){
			
			this.threadB.destruir();
			this.threadB = null;
			
		}
	}
}
