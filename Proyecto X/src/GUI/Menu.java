package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/**
 * Clase que representa el menú del juego.
 * @author Tomás Perotti - Iván Petrini
 *
 */
public class Menu {


	
	private JPanel panel;
	private JFrame frame;
	JLabel menu;
	Icon empezar;
	Icon highscores;
	int posicion;
	private boolean lock = false;
	Clip sonido;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("unused")
					Menu p = new Menu();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea el frame.
	 */
	public Menu() {
		frame = new JFrame("Bomberman");
		frame.setResizable(false);
		frame.setBounds(0, 0, 531, 508);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				accion(arg0);
			}
		});
				
		panel = new JPanel();
		panel.setBounds(0, 0, 531, 508);
		frame.add(panel);
		panel.setLayout(null);

		posicion = 0;
		menu = new JLabel();
		empezar = new ImageIcon(this.getClass().getResource("/GuiImagenes/Menu.png"));
		highscores = new ImageIcon(this.getClass().getResource("/GuiImagenes/Menu2.png"));
		menu.setIcon(empezar);
		menu.setBounds(0, -10, 531, 508);
		panel.add(menu);
	
		
		try {
			sonido=AudioSystem.getClip();
			sonido.open(AudioSystem.getAudioInputStream(getClass().getResource("/Sonidos/menu.wav")));
			sonido.start();

		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
		
		


	}
	
	protected void accion(KeyEvent key){
		if (!lock){
			if (key.getKeyCode() == KeyEvent.VK_DOWN) {
				menu.setIcon(highscores);
				posicion = 1;
			}	
			if (key.getKeyCode() == KeyEvent.VK_UP){
				menu.setIcon(empezar);
				posicion = 0;			
			}
			
			if (key.getKeyCode() == KeyEvent.VK_ENTER){
				if (posicion == 0){
					@SuppressWarnings("unused")
					GUI nuevo = new GUI();
					sonido.stop();
					frame.dispose();
				}
				else{
					panel.remove(menu);
					panel.repaint();
					panel.setBackground(Color.BLACK);
					
					Highscores h = new Highscores();
					
					
					JTextArea scoreslbl = new JTextArea();
					scoreslbl.setFont(new Font("Arial Black", Font.PLAIN, 30));
					scoreslbl.setBackground(null);
					scoreslbl.setForeground(Color.WHITE);
					panel.add(scoreslbl);
					scoreslbl.setBounds(160, 0, 500, 400);
					scoreslbl.setText(h.getHighscoreString());
					scoreslbl.setEditable(false);
					
					JButton volver =new JButton("Volver");
					panel.add(volver);
					volver.setBounds(200, 420, 120, 30);
					volver.setBorder(null);
					
					volver.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent arg0) {
							@SuppressWarnings("unused")
							Menu n = new Menu();
							frame.dispose();
							sonido.stop();
						}
					});
					
					lock = true;

					
				}
			}
		}
			
	}
}
