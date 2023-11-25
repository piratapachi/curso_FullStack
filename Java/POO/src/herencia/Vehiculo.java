package herencia;

public abstract class Vehiculo {

	// atributos
	protected float velocidad;
	protected int asientos;
	protected int orientacionRuedas;
	
	/*
	// Mi nueva Super Clase
	public Vehiculo(float variable) {
		this.variable = variable;
		System.out.println("Constructor de la clase padre");
	}
	*/
	
	// Constructor por defecto
	public Vehiculo() {
		System.out.println("Constructor de la clase padre");
	}
	
	
	// Super Constructor
	public Vehiculo(float velocidad, int asientos, int orientacionRuedas) {
		this.velocidad = velocidad;
		this.asientos = asientos;
		this.orientacionRuedas = orientacionRuedas;
	}
	
	// métodos
	
	// Declaración de un método abstracto
	protected abstract void parar();
	
	// Declaración de metodo no abstracto
	protected void parar(boolean choque) {
		
	}
	
	/*
	// Aplicando POLIMORFISMO
	protected void parar() {
		System.out.println("Método para parar el vehículo");
	}
	*/

	
	public void acelerar() { }
	public void desacelerar() { }
	public void girarIzquierda() { }
	public void girarDerecha() { }

}
