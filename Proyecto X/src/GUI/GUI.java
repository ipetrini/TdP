package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Nivel.Nivel;
import Threads.ThreadBomberman;
import java.awt.Color;
/**
 * Frame utilizado para representar la interfaz gráfica del juego Bomberman.
 * @author Tomás Perotti - Iván Petrini
 *
 */
public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel Mapa;	
	private Nivel nivel;
	private boolean lock = false;
	private int direction = -1;
	private ThreadBomberman thread;
	/**
	 * Ejecuta la aplicación.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea el frame.
	 */
	public GUI() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				accion(arg0);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1010, 456);
		Mapa = new JPanel();
		Mapa.setBackground(new Color(34, 139, 34));
		Mapa.setBorder(new EmptyBorder(5, 5, 5, 5));
		Mapa.setLayout(new BorderLayout(0, 0));
		setContentPane(Mapa);
		nivel = new Nivel(this);
		//thread = new ThreadBomberman(nivel, this, nivel.getBomberman());
		//thread.start();
	}
	
	protected void accion(KeyEvent key){
		if(!lock){
			if (key.getKeyCode() == KeyEvent.VK_SPACE ) {
				System.out.println("Detecte la barra");
				nivel.getBomberman().ponerBomba();
			}
			else{
				direction = key.getKeyCode();
				this.lock = true;
			}
		}
	}
	/**
	 * Método que retorna si se puede seguir moviendo el bomberman o no.
	 * @return
	 */
	public boolean getLock(){
		return this.lock;
	}
	/**
	 * Método que cambia el valor booleano de lock a su inverso.
	 */
	public void toggleLock(){
		this.lock = !this.lock;
	}
	/**
	 * Método que retorna la dirección de movimiento previamente capturada por la interfaz.
	 * @return dirección
	 */
	public int getDirection(){
		return this.direction;
	}
	

}

