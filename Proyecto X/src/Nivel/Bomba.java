package Nivel;

public class Bomba {
	
	protected int alcance;
	protected Celda miCelda;
	
	public Bomba(int a, Celda c){
		alcance = a;
		miCelda = c;
	}
	
	public void explotar(){
		
	}
	
	public int getAlcance(){
		return alcance;
	}
	
	public Celda getCelda(){
		return miCelda;
	}
}
