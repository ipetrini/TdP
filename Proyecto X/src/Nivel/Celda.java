package Nivel;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import Personajes.Bomberman;
import Personajes.Enemigo;
import PowerUps.PowerUp;
/**
 * Clase que representa la celda.
 * @author Tomás Perotti - Iván Petrini
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
		 * Constructor que inicializa la celda con su nivel y su posición.
		 * @param nivel
		 * @param posición x
		 * @param posición y
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
		 * Método que retorna la pared de la celda.		
		 * @return pared
		 */
		public Pared getPared(){
			return miPared;
		}
		/**
		 * Método que retorna la lista de enemigos en la celda.
		 * @return lista enemigos
		 */
		public ArrayList<Enemigo> getEnemigos(){
			return misEnemigos;
		}
		/**
		 * Método que elimina un enemigo de la celda.
		 * @param enemigo
		 */
		public void eliminarEnemigo(Enemigo e){
			misEnemigos.remove(e);
		}
		/**
		 * Método que agrega un enemigo a la celda.
		 * @param enemigo
		 */
		public void agregarEnemigo(Enemigo e){
			misEnemigos.add(e);
		}
		/**
		 * Método que retorna el bomberman de la celda si se encuentra en la misma, de lo contrario retorna nulo.
		 * @return bomberman
		 */
		public Bomberman getBomberman(){
			return miBomberman;
		}
		/**
		 * Método que setea un bomberman a la celda.
		 * @param bomberman
		 */
		public void setBomberman(Bomberman b){
			miBomberman = b;
		}
		/**
		 * Método que retorna el nivel del juego.
		 * @return nivel.
		 */
		public Nivel getMapa(){
			return miNivel;
		}
		/**
		 * Método que retorna la posición x de la celda.
		 * @return posición x
		 */
		public int getX(){
			return posicion.x;
		}
		/**
		 * Método que retorna la posición y de la celda.
		 * @return posición y
		 */
		public int getY(){
			return posicion.y;
		}
		/**
		 * Método que retorna el power up de la celda.
		 * @return power up
		 */
		public PowerUp getPowerUp(){
			return miPowerUp;
		}
		/**
		 * Método que setea un power up a la celda.
		 * @param power up
		 */
		public void setPowerUp(PowerUp p){
			miPowerUp = p;
		}
		/**
		 * Método que setea una pared a la celda.
		 * @param pared
		 */
		public void setPared(Pared p){
			miPared = p;
		}
		/**
		 * Método que permite recibir un enemigo a la celda.
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
		 * Método que permite recibir al bomberman en la celda.
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
		 * Método que destruye la pared de la celda.
		 */
		public void destruirPared(){
			if(miPared.destruir())
				miPared = null;
		}
		/**
		 * Método que destruye todos los personajes de la celda. En caso de que el bomberman sea dios, no lo destruye.
		 */
		public void explotar(){
			for (Enemigo e: misEnemigos){
				e.morir();
			}
			if (!miBomberman.esDios())
				miNivel.destruirBomberman();
		}
		/**
		 * Método que retorna la celda vecina en relación a la dirección pasada por parámetro.	
		 * @param dirección
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
