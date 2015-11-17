package GUI;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Nivel.Marcador;
import Nivel.Nivel;
import java.awt.Color;
import java.awt.Component;

/**
 * Frame utilizado para representar la interfaz gráfica del juego Bomberman.
 * @author Tomás Perotti - Iván Petrini
 *
 */

public class GUI {

	/**
	 * 
	 */
	private JFrame frame;
	private JPanel Mapa, Marcador, Ayuda;
	private JLabel imagen;
	private Nivel nivel;
	private boolean lock = false;
	private int direction = -1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI f = new GUI();
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
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(0, 0, 1196, 516);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				accion(arg0);
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			
		Mapa = new JPanel();
		Mapa.setBackground(new Color(34, 139, 34));
		Mapa.setBorder(new EmptyBorder(5, 5, 5, 5));
		Mapa.setLayout(null);
		Mapa.setBounds(1, 70, 991, 456);
		frame.add(Mapa);
		
		Marcador = new JPanel();
		Marcador.setBackground(Color.LIGHT_GRAY);
		Marcador.setBorder(new EmptyBorder(5, 5, 5, 5));
		Marcador.setLayout(null);
		Marcador.setBounds(0, 0, 991, 100);
		frame.add(Marcador);
		nivel = new Nivel(this);
		System.out.println("La bomba es ingresada con la tecla ESPACIO");
	
		imagen = new JLabel();
		imagen.setBounds(991, 0, 198, 516);
		imagen.setIcon(new ImageIcon(this.getClass().getResource("/GUI/Ayuda.png")));
		frame.add(imagen);
		
		
		
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
	
	public void terminarJuego() {
		JOptionPane.showMessageDialog(frame,"Juego terminado","Bomberman",JOptionPane.WARNING_MESSAGE);
		System.exit(0);
	}
	public void add(Component c){
		Mapa.add(c);
	}
	
	public void addMarcador(Component c){
		Marcador.add(c);
	}

}

