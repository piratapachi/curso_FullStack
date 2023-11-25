package Interfaces;

public interface Vehiculo {
	//Declaración de un atributo
	public static final float g = 9.8f;
	
	//Declaración de métodos abstractos
	public abstract void parar();
	public abstract void acelerar();
	public abstract void desacelerar();
	public abstract void girar_izquierda();
	public abstract void girar_derecha();
	
}
