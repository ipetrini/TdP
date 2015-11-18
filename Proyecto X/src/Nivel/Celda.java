package Nivel;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

import Graficos.ExplosionGrafica;
import Personajes.Bomberman;
import Personajes.Enemigo;
import PowerUps.PowerUp;
import Threads.ThreadExplosion;

/**
 * Clase que representa la celda.
 * @author Tom�s Perotti - Iv�n Petrini
 *
 */
public class Celda {

		//Atributos
		public static final int LEFT = KeyEvent.VK_LEFT;
		public static final int RIGHT = KeyEvent.VK_RIGHT;
		public static final int UP = KeyEvent.VK_UP;
		public static final int DOWN = KeyEvent.VK_DOWN;
		protected ArrayList<Enemigo> misEnemigos;
		protected Bomberman miBomberman;
		protected Nivel miNivel;
		protected Pared miPared;
		protected PowerUp miPowerUp;
		protected int x, y;
		protected ThreadExplosion explosion;
		
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
			this.x = x;
			this.y = y;
			misEnemigos = new ArrayList<Enemigo>();
			miBomberman = null;
		}
		
		/**
		 * M�todo que retorna la pared de la celda.	
		 * @return La pared si existe o nulo en caso contrario.
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
			return x;
		}
		
		/**
		 * M�todo que retorna la posici�n y de la celda.
		 * @return posici�n y
		 */
		public int getY(){
			return y;
		}
		
		/**
		 * M�todo que retorna el power up de la celda.
		 * @return Power Up si existe, nulo en caso contrario.
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
		 * M�todo que permite recibir o no un enemigo a la celda.
		 * @param enemigo
		 * @param direccion donde se movera el enemigo.
		 * @return true si lo puede recibir, false en caso contrario.
		 */
		public boolean recibirEnemigo(Enemigo e, int dir){
			if (miPared!=null){
				if (miPared.recibirEnemigo(e, dir)){
					return true;
				}
			}
			else {
				agregarEnemigo(e);
				e.moverGrafico(dir);
				return true;
			}					
			return false;
		
		}
		
		/**
		 * M�todo que permite recibir o no al Bomberman a la celda.
		 * @param enemigo
		 * @param direccion donde se movera el Bomberman.
		 * @return true si lo puede recibir, false en caso contrario.
		 */
		public boolean recibirBomberman(Bomberman b, int dir){
			if (miPared!=null){
				if (miPared.recibirBomberman(b)){
					return true;
				}
			}
			else{
				miBomberman=b;
				b.moverGrafico(dir);
				if (miPowerUp!=null){
					miPowerUp.activar(b);
					miPowerUp=null;
				}
				return true;
			}			
			return false;
		}
		
		/**
		 * M�todo que destruye la pared de la celda.
		 */
		public boolean destruirPared(){
			boolean destruir = miPared.destruir();
			
			if(destruir)
				miPared = null;
			
			
			return true;
		}
		
		/**
		 * M�todo que destruye todos los personajes de la celda. En caso de que el bomberman sea dios, no lo destruye.
		 */
		public boolean explotar(){		
			Iterator<Enemigo> it = misEnemigos.iterator();
			while(it.hasNext()){
				miNivel.destruirEnemigo(it.next());
				it.remove();
			}
			if (miBomberman!=null)
				miNivel.destruirBomberman();
			
			if (miPared != null){
				destruirPared();
				return true;
			}
			else{
				explosion = new ThreadExplosion(new ExplosionGrafica(x, y, miNivel));
				explosion.start();				
			}
			return false;
		}
			
		/**
		 * M�todo que retorna la celda vecina en relaci�n a la direcci�n pasada por par�metro.	
		 * @param direcci�n
		 * @return Celda o nulo si no existe celda en la direcci�n pasada por parametro
		 */
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
				default:
					return null;
			}
		}
		
		
}
