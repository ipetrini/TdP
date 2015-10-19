package Nivel;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import Personajes.Bomberman;
import Personajes.Enemigo;
import PowerUps.PowerUp;

public class Celda {

		public static final int LEFT = KeyEvent.VK_LEFT;
		public static final int RIGHT = KeyEvent.VK_RIGHT;
		public static final int UP = KeyEvent.VK_UP;
		public static final int DOWN = KeyEvent.VK_DOWN;
		protected ArrayList<Enemigo> misEnemigos;
		protected Bomberman miBomberman;
		protected Nivel miNivel;
		protected Pared miPared;
		protected PowerUp miPowerUp;
		protected int x;
		protected int y;
		protected boolean hola;
		
		public Celda(Nivel nivel, int x, int y){
			miNivel = nivel;
			miPared = null;
			miPowerUp = null;
			this.x = x;
			this.y = y;
			misEnemigos = new ArrayList<Enemigo>();
			miBomberman = null;
		}
				
		public Pared getPared(){
			return miPared;
		}
		
		public ArrayList<Enemigo> getEnemigos(){
			return misEnemigos;
		}
		
		public void eliminarEnemigo(Enemigo e){
			misEnemigos.remove(e);
		}
		
		public void agregarEnemigo(Enemigo e){
			misEnemigos.add(e);
		}
		
		public Bomberman getBomberman(){
			return miBomberman;
		}
		
		public void setBomberman(Bomberman b){
			miBomberman = b;
		}
		
		public Nivel getMapa(){
			return miNivel;
		}
		
		public int getX(){
			return x;
		}
		
		public int getY(){
			return y;
		}
		
		public PowerUp getPowerUp(){
			return miPowerUp;
		}
		
		public void setPowerUp(PowerUp p){
			miPowerUp = p;
		}
		
		public void setPared(Pared p){
			miPared = p;
		}
		
		public boolean recibirEnemigo(Enemigo e){
			if (miPared!=null){
				if (miPared.recibirEnemigo(e)){
					return true;
				}
			}
			else {
				agregarEnemigo(e);
				if (miBomberman!=null)
					miNivel.destruirBomberman();
				return true;
			}					
			return false;
		
		}
		
		public boolean recibirBomberman(Bomberman b){
			if (miPared!=null){
				if (miPared.recibirBomberman(b)){
					return true;
				}
			}
			else{
				if (misEnemigos.size()!=0)
					miNivel.destruirBomberman();
				miBomberman=b;
				return true;
			}			
			return false;
		}
		
		public void destruirPared(){
			if(miPared.destruir())
				miPared = null;
		}
		
		public void explotar(){
			for (Enemigo e: misEnemigos){
				e.morir();
			}
			if (!miBomberman.esDios())
				miNivel.destruirBomberman();
		}
				
		public Celda getVecina(int dir){
			switch (dir){
				case UP :
					return miNivel.getCelda(x, y - 1);
				case DOWN :
					return miNivel.getCelda(x, y + 1);
				case LEFT :
					return miNivel.getCelda(x - 1, y);
				case RIGHT :
					return miNivel.getCelda(x + 1, y);
			}
			return null;
		}
		
		
}
