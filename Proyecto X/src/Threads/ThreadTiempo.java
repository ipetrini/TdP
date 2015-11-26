package Threads;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

import GUI.GUI;
import Nivel.Nivel;
/**
 * Clase que representa el thread del tiempo.
 * @author Tomás Perotti - Iván Petrini
 *
 */
public class ThreadTiempo extends Thread {

		protected int s, m, h;
		protected JLabel tiempo, contador, sombraTiempo, sombraContador;
		protected volatile boolean seguir;
		protected GUI gui;
		/**
		 * Constructor que inicializa la parte gráfica del tiempo y otros marcadores.
		 * @param nivel
		 */
		public ThreadTiempo(Nivel n){
			gui = n.getGUI();
			s=m=h=0;
			
			tiempo = new JLabel("Tiempo");
			tiempo.setBounds(160, 10, 200, 50);
			tiempo.setFont(new Font("OCR A Std", Font.BOLD | Font.ITALIC, 25));
			tiempo.setForeground(Color.WHITE);
			gui.addMarcador(tiempo);
			
			sombraTiempo = new JLabel("Tiempo");
			sombraTiempo.setBounds(161, 13, 200, 50);
			sombraTiempo.setFont(new Font("OCR A Std", Font.BOLD | Font.ITALIC, 25));
			sombraTiempo.setForeground(Color.BLACK);
			gui.addMarcador(sombraTiempo);
			
			contador = new JLabel();
			contador.setBounds(300, 10, 200, 50);
			contador.setForeground(Color.WHITE);
			contador.setFont(new Font("OCR A Std", Font.BOLD | Font.ITALIC, 25));
			contador.setText(String.format("%02d",h)+":"+String.format("%02d",m)+":"+String.format("%02d",s));
			gui.addMarcador(contador);
			
			sombraContador = new JLabel();
			sombraContador.setBounds(301, 13, 200, 50);
			sombraContador.setForeground(Color.BLACK);
			sombraContador.setFont(new Font("OCR A Std", Font.BOLD | Font.ITALIC, 25));
			sombraContador.setText(String.format("%02d",h)+":"+String.format("%02d",m)+":"+String.format("%02d",s));
			gui.addMarcador(sombraContador);
			
			
			seguir = true;
			
		}
		/**
		 * Método run del thread.
		 */
		public void run(){
			try{
				while(seguir){
					Thread.sleep(1000);
					s++;
					if (s>59){
						s=00;
						m++;
					}
					if (m>59){
						m=00;
						h++;
					}
					contador.setText(String.format("%02d",h)+":"+String.format("%02d",m)+":"+String.format("%02d",s));
					sombraContador.setText(String.format("%02d",h)+":"+String.format("%02d",m)+":"+String.format("%02d",s));


				}
			}
			catch (InterruptedException e){
			}
		
		}	
		/**
		 * Método utilizado para parar el tiempo.
		 */
		public void parar(){
			seguir = false;
			this.interrupt();
		}
		/**
		 * Método que retorna las horas del tiempo.
		 * @return horas
		 */
		public int getH(){
			return h;
		}
		/**
		 * Método que retorna los minutos del tiempo.
		 * @return minutos
		 */
		public int getM(){
			return m;
		}
		/**
		 * Método que retorna los segundos del tiempo.
		 * @return segundos
		 */
		public int getS(){
			return s;
		}
}
