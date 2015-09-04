package program;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class GUI extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	//Atributos
	private JPanel contentPane;
	private JButton btnVerFrase;
	private JLabel imagenHomero;
	private JTextArea textArea;
	
	/**
	 * Lanza la aplicación
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
	 * Crea el frame
	 */
	public GUI() {
		setResizable(false);
		setTitle("Proyecto 0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		imagenHomero = new JLabel("");
		imagenHomero.setBounds(27, 22, 393, 288);
		contentPane.add(imagenHomero);
		imagenHomero.setIcon(new ImageIcon(GUI.class.getResource("/program/GifHomer.gif")));
		
		btnVerFrase = new JButton("Ver frase");
		btnVerFrase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnVerFrase.setBounds(171, 321, 89, 23);
		btnVerFrase.addActionListener(this);		
		contentPane.add(btnVerFrase);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(SystemColor.control);
		textArea.setFont(new Font("Tahoma", Font.BOLD, 13));
		textArea.setBounds(27, 376, 383, 43);
		contentPane.add(textArea);
	}
	
	//Oyente
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnVerFrase){
			textArea.setText("No soy un hombre de plegarias, pero si estás en el cielo,\n¡sálvame, por favor, Superman!");
			
		}
	}
}
