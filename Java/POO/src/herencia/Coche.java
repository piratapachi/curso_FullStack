package herencia;

public class Coche extends Vehiculo {
	
	// atributos específicos del Coche
	private float caballos;
	
	
	// Reescritura del metodo
	public void parar() { 
		// invocación al método de la superclase
		//super.parar();
		System.out.println("Método parar del coche");
		
	}
	
	// Constructor por defecto
	public Coche() {
		
	}
	
	public Coche(float velocidad, float caballos, int asientos, int orientacionRuedas) {
		
		super(velocidad, asientos, orientacionRuedas);
		
		// inicialización de los atributos especificos del coche
		this.caballos = caballos;
	}
}
