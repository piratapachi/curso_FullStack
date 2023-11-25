package herencia;

public class Bicicleta extends Vehiculo {
	
	public Bicicleta(float velocidad, int asientos, int orientacionRuedas) {
		super(velocidad, asientos, orientacionRuedas);
		System.out.println("Constructor de la clase hija");
	}
	
	// Constructor por defecto 
	public Bicicleta() {
		System.out.println("Constructor de la clase hija por defecto");
	}

	@Override
	protected void parar() {
		
	}
	
	/*
	// Aplicando polimorfismo ...
	
	public void parar() {
		System.out.println("Método parar Bicicleta");
	}
	 */
	
}
