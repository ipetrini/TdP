package GUI;

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
import javax.swing.border.EmptyBorder;

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
	private JLabel imagen, sound;
	private Nivel nivel;
	private boolean lock = false;
	private int direction = -1; int clickSonido = 0;
	Clip sonido;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("unused")
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
		
		frame = new JFrame("Bomberman");
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
		frame.setBackground(Color.LIGHT_GRAY);
		
		Mapa = new JPanel();
		Mapa.setBackground(new Color(34, 139, 34));
		Mapa.setBorder(new EmptyBorder(5, 5, 5, 5));
		Mapa.setLayout(null);
		Mapa.setBounds(1, 70, 991, 456);
		frame.add(Mapa);
		
		Marcador = new JPanel();
		Marcador.setBackground(Color.lightGray);
		Marcador.setBorder(new EmptyBorder(5, 5, 5, 5));
		Marcador.setLayout(null);
		Marcador.setBounds(0, 0, 991, 100);
		frame.add(Marcador);
		nivel = new Nivel(this);
		System.out.println("La bomba es ingresada con la tecla ESPACIO");
	
		
		Ayuda = new JPanel();
		Ayuda.setBounds(991, 0 , 198, 516);
		Ayuda.setBackground(Color.BLACK);
		frame.add(Ayuda);
		
		imagen = new JLabel();
		imagen.setBounds(991, 0, 198, 516);
		imagen.setIcon(new ImageIcon(this.getClass().getResource("/GuiImagenes/Ayuda.png")));
		Ayuda.add(imagen);
		
		try {
			sonido=AudioSystem.getClip();
			sonido.open(AudioSystem.getAudioInputStream(getClass().getResource("/Sonidos/nivel.wav")));
			sonido.start();
			sonido.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
		
		Icon conSonido = new ImageIcon(this.getClass().getResource("/GuiImagenes/sonido.png"));
		Icon sinSonido = new ImageIcon(this.getClass().getResource("/GuiImagenes/sinsonido.png"));
		
		sound = new JLabel();
		sound.setIcon(conSonido);
		sound.setBounds(50, 17, 32, 32);
		Marcador.add(sound);
		
		
		
		sound.addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  	if (clickSonido==0){
		    		sound.setIcon(sinSonido);
		    		sonido.stop();
		    		clickSonido = 1;
		    	}
		    	else{
		    		sound.setIcon(conSonido);
		    		sonido.start();
		    		clickSonido = 0;
		    	}
		    }  
		}); 
	
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
	/**
	 * Método utilizado para mostrar información por pantalla cuando el usuario pierde el juego.
	 */
	public void terminarJuego() {
		Mapa.removeAll();
		Mapa.repaint();
		Marcador.removeAll();
		Marcador.repaint();
		Ayuda.remove(imagen);
		Ayuda.repaint();
		
		try {
			sonido.close();
			sonido.open(AudioSystem.getAudioInputStream(getClass().getResource("/Sonidos/gameover.wav")));
			if (clickSonido == 0)
				sonido.start();
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
		
		JLabel imagenPerdiste = new JLabel();
		Mapa.add(imagenPerdiste);
		imagenPerdiste.setIcon(new ImageIcon(this.getClass().getResource("/GuiImagenes/GameOver.png")));
		imagenPerdiste.setBounds(0,0,991, 456);
		
		JLabel gameOver = new JLabel();
		Marcador.add(gameOver);
		gameOver.setIcon(new ImageIcon(this.getClass().getResource("/GuiImagenes/perdiste.png")));
		gameOver.setBounds(0, 0, 991, 100);
		
		JButton playagain=new JButton("Play Again");
		frame.add(playagain);
		playagain.setBounds(1030, 420, 120, 30);
		playagain.setIcon(new ImageIcon(this.getClass().getResource("/GuiImagenes/playAgain.png")));
		playagain.setBorder(null);
		
		Highscores highscores = new Highscores();

		JLabel fondohg = new JLabel();
		fondohg.setIcon(new ImageIcon(this.getClass().getResource("/GuiImagenes/highscores.png")));
		Ayuda.add(fondohg);
		
		JTextArea scoreslbl = new JTextArea();
		scoreslbl.setFont(new Font("Arial Black", Font.PLAIN, 20));
		scoreslbl.setBackground(null);
		scoreslbl.setForeground(Color.WHITE);
		Ayuda.add(scoreslbl);
		scoreslbl.setBounds(950, 100, 100, 100);
		scoreslbl.setText(highscores.getHighscoreString());
		scoreslbl.setEditable(false);

		
		
		
		playagain.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				@SuppressWarnings("unused")
				GUI nuevo = new GUI();
				frame.dispose();	
				sonido.stop();
			}
		});
		

	}
	
	/**
	 * Método utilizado para mostrar información por pantalla cuando el usuario gana el juego.
	 */
	public void ganarJuego(){
		Mapa.removeAll();
		Mapa.repaint();
		Marcador.removeAll();
		Marcador.repaint();
		Ayuda.remove(imagen);
		Ayuda.repaint();
		
		try {
			sonido.close();
			sonido.open(AudioSystem.getAudioInputStream(getClass().getResource("/Sonidos/victory.wav")));
			if (clickSonido == 0)
				sonido.start();
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
		
		JLabel imagenGanaste = new JLabel();
		Mapa.add(imagenGanaste);
		imagenGanaste.setIcon(new ImageIcon(this.getClass().getResource("/GuiImagenes/Victory.png")));
		imagenGanaste.setBounds(0,0,991, 516);
		
		JLabel victory = new JLabel();
		Marcador.add(victory);
		victory.setIcon(new ImageIcon(this.getClass().getResource("/GuiImagenes/ganaste.png")));
		victory.setBounds(0, 0, 991, 100);
		
		JButton playagain=new JButton("Play Again");
		frame.add(playagain);
		playagain.setBounds(1030, 420, 120, 30);
		playagain.setIcon(new ImageIcon(this.getClass().getResource("/GuiImagenes/playAgain.png")));
		playagain.setBorder(null);
		
		Score s = new Score(nivel.getMarcador().getH(), nivel.getMarcador().getM(), nivel.getMarcador().getS());
		Highscores highscores = new Highscores();
		highscores.addScore(s);

		JLabel fondohg = new JLabel();
		fondohg.setIcon(new ImageIcon(this.getClass().getResource("/GuiImagenes/highscores.png")));
		Ayuda.add(fondohg);
		
		JTextArea scoreslbl = new JTextArea();
		scoreslbl.setFont(new Font("Arial Black", Font.PLAIN, 20));
		scoreslbl.setBackground(null);
		scoreslbl.setForeground(Color.WHITE);
		Ayuda.add(scoreslbl);
		scoreslbl.setBounds(950, 100, 100, 100);
		scoreslbl.setText(highscores.getHighscoreString());
		scoreslbl.setEditable(false);
		
		
		
		playagain.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				@SuppressWarnings("unused")
				GUI nuevo = new GUI();
				sonido.stop();
				frame.dispose();								
			}
		});
		
	}
	/**
	 * Método utilizado para agregar un componente al juego.
	 * @param componente
	 */
	public void add(Component c){
		Mapa.add(c);
	}
	/**
	 * Método utilizado para agregar el marcador del juego.
	 * @param componente
	 */
	public void addMarcador(Component c){
		Marcador.add(c);
	}

	public void crearHighscores(){
		Highscores h = new Highscores();
		Score s = new Score(0,0,0);
		h.addScore(s);
		h.addScore(s);
		h.addScore(s);
		h.addScore(s);
		h.addScore(s);
		h.addScore(s);
		h.addScore(s);
		h.addScore(s);
	}
}

