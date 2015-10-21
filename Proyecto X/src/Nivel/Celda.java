package Nivel;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import Personajes.Bomberman;
import Personajes.Enemigo;
import PowerUps.PowerUp;
/**
 * Clase que representa la celda.
 * @author Tom�s Perotti - Iv�n Petrini
 *
 */
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
		protected Point posicion;
		protected boolean hola;
		/**
		 * Constructor que inicializa la celda con su nivel y su posici�n.
		 * @param nivel
		 * @param posici�n x
		 * @param posici�n y
		 */
		public Celda(Nivel nivel, int x, int y){
			miNivel = nivel;
			miPared = null;
			miPowerUp = null;
			posicion = new Point(x,y);
			misEnemigos = new ArrayList<Enemigo>();
			miBomberman = null;
		}
		/**
		 * M�todo que retorna la pared de la celda.		
		 * @return pared
		 */
		public Pared getPared(){
			return miPared;
		}
		/**
		 * M�todo que retorna la lista de enemigos en la celda.
		 * @return lista enemigos
		 */
		public ArrayList<Enemigo> getEnemigos(){
			return misEnemigos;
		}
		/**
		 * M�todo que elimina un enemigo de la celda.
		 * @param enemigo
		 */
		public void eliminarEnemigo(Enemigo e){
			misEnemigos.remove(e);
		}
		/**
		 * M�todo que agrega un enemigo a la celda.
		 * @param enemigo
		 */
		public void agregarEnemigo(Enemigo e){
			misEnemigos.add(e);
		}
		/**
		 * M�todo que retorna el bomberman de la celda si se encuentra en la misma, de lo contrario retorna nulo.
		 * @return bomberman
		 */
		public Bomberman getBomberman(){
			return miBomberman;
		}
		/**
		 * M�todo que setea un bomberman a la celda.
		 * @param bomberman
		 */
		public void setBomberman(Bomberman b){
			miBomberman = b;
		}
		/**
		 * M�todo que retorna el nivel del juego.
		 * @return nivel.
		 */
		public Nivel getMapa(){
			return miNivel;
		}
		/**
		 * M�todo que retorna la posici�n x de la celda.
		 * @return posici�n x
		 */
		public int getX(){
			return posicion.x;
		}
		/**
		 * M�todo que retorna la posici�n y de la celda.
		 * @return posici�n y
		 */
		public int getY(){
			return posicion.y;
		}
		/**
		 * M�todo que retorna el power up de la celda.
		 * @return power up
		 */
		public PowerUp getPowerUp(){
			return miPowerUp;
		}
		/**
		 * M�todo que setea un power up a la celda.
		 * @param power up
		 */
		public void setPowerUp(PowerUp p){
			miPowerUp = p;
		}
		/**
		 * M�todo que setea una pared a la celda.
		 * @param pared
		 */
		public void setPared(Pared p){
			miPared = p;
		}
		/**
		 * M�todo que permite recibir un enemigo a la celda.
		 * @param enemigo
		 * @return true si lo recibe correctamente, false en caso contrario.
		 */
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
		/**
		 * M�todo que permite recibir al bomberman en la celda.
		 * @return true si lo recibio correctamente, false caso contrario.
		 */
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
		/**
		 * M�todo que destruye la pared de la celda.
		 */
		public void destruirPared(){
			if(miPared.destruir())
				miPared = null;
		}
		/**
		 * M�todo que destruye todos los personajes de la celda. En caso de que el bomberman sea dios, no lo destruye.
		 */
		public void explotar(){
			for (Enemigo e: misEnemigos){
				e.morir();
			}
			if (!miBomberman.esDios())
				miNivel.destruirBomberman();
		}
		/**
		 * M�todo que retorna la celda vecina en relaci�n a la direcci�n pasada por par�metro.	
		 * @param direcci�n
		 * @return celda
		 */
		public Celda getVecina(int dir){
			switch (dir){
				case UP :
					return miNivel.getCelda(posicion.x, posicion.y - 1);
				case DOWN :
					return miNivel.getCelda(posicion.x, posicion.y + 1);
				case LEFT :
					return miNivel.getCelda(posicion.x - 1,posicion.y);
				case RIGHT :
					return miNivel.getCelda(posicion.x + 1, posicion.y);
			}
			return null;
		}
		
		
}
