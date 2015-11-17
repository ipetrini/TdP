package Threads;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;

import GUI.GUI;
import Nivel.Nivel;

public class ThreadTiempo extends Thread {

		protected int s, m, h, contDestructibles;
		protected JLabel tiempo, contador, sombraTiempo, sombraContador, destructLeft;
		protected volatile boolean seguir;
		protected GUI gui;
		protected Nivel nivel;
		
		public ThreadTiempo(Nivel n){
			gui = n.getGUI();
			s=m=h=0;
			nivel=n;
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
			
			/*destructLeft = new JLabel(""+contDestructibles);
			destructLeft.setBounds(450, 10 , 100, 50);
			destructLeft.setFont(new Font("OCR A Std", Font.BOLD | Font.ITALIC, 25));
			destructLeft.setForeground(Color.BLACK);
			gui.addMarcador(destructLeft);*/
			
			seguir = true;
			
		}
		
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
					if (nivel.destructiblesLeft() == 0)  nivel.terminarJuego();


				}
			}
			catch (InterruptedException e){
			}
			}		
}
