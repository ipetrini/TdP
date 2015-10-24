package GUI;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Nivel.Nivel;
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
			public void keyPressed(KeyEvent arg0) {
				accion(arg0);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1010, 456);
		Mapa = new JPanel();
		Mapa.setBackground(new Color(34, 139, 34));
		Mapa.setBorder(new EmptyBorder(5, 5, 5, 5));
		Mapa.setLayout(null);
		setContentPane(Mapa);
		nivel = new Nivel(this);
		System.out.println("La bomba es ingresada con la tecla ESPACIO");
		
	}
	
	protected void accion(KeyEvent key){
		if(!lock){
			if (key.getKeyCode() == KeyEvent.VK_SPACE ) {
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
	 * @return si se puede seguir moviendo el bomberman o no.
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

