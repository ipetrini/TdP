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
	 * Launch the application.
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
	 * Create the frame.
	 */
	public GUI() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				mover(arg0);
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
	
	protected void mover(KeyEvent key){
		if(!lock){
			direction = key.getKeyCode();
			this.lock = true;
		}
	}
	
	public boolean getLock(){
		return this.lock;
	}
	
	public void toggleLock(){
		this.lock = !this.lock;
	}
	
	public int getDirection(){
		return this.direction;
	}
	

}

