package Nivel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import GUI.GUI;
import Threads.ThreadTiempo;

/**
 * Clase que representa el marcador, el cual lleva el puntaje y el tiempo de la partida.
 * @author Tomás Perotti - Iván Petrini.
 *
 */

public class Marcador extends Thread {
	
	protected GUI gui;
	protected int puntaje;
	ThreadTiempo tiempo;
	protected JLabel puntajelbl, sombrapuntaje, puntos, sombrapuntos;
		
	public Marcador (Nivel n) {	
		gui = n.getGUI();
		tiempo = new ThreadTiempo(n);
		tiempo.start();
		puntaje = 0;
		puntajelbl = new JLabel("Puntaje");
		puntajelbl.setBounds(550,10 , 200, 50);
		puntajelbl.setFont(new Font("OCR A Std", Font.BOLD | Font.ITALIC, 25));
		puntajelbl.setForeground(Color.WHITE);
		gui.addMarcador(puntajelbl);
		
		sombrapuntaje = new JLabel("Puntaje");
		sombrapuntaje.setBounds(551,13 , 200, 50);
		sombrapuntaje.setFont(new Font("OCR A Std", Font.BOLD | Font.ITALIC, 25));
		sombrapuntaje.setForeground(Color.BLACK);
		gui.addMarcador(sombrapuntaje);
		
		puntos = new JLabel(""+puntaje);
		puntos.setBounds(700, 11, 200, 50);
		puntos.setFont(new Font("OCR A Std", Font.BOLD | Font.ITALIC, 25));
		puntos.setForeground(Color.WHITE);
		gui.addMarcador(puntos);
		
		sombrapuntos = new JLabel(""+puntaje);
		sombrapuntos.setBounds(702, 14, 200, 50);
		sombrapuntos.setFont(new Font("OCR A Std", Font.BOLD | Font.ITALIC, 25));
		sombrapuntos.setForeground(Color.BLACK);
		gui.addMarcador(sombrapuntos);
		
	}
		
	public void aumentarPuntaje(int i) {
		puntaje+=i;
		puntos.setText(""+puntaje);
		sombrapuntos.setText(""+puntaje);		
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public void setPuntaje(int i) {
		puntaje=i;
	}


}
