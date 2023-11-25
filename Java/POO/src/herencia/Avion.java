package herencia;

public class Avion extends Vehiculo {
	
	public Avion(float velocidad, int asientos, int orientacionRuedas) {
		super(velocidad, asientos, orientacionRuedas);
		// TODO Auto-generated constructor stub
	}
	
	// Constructor por defecto
	public Avion() {
		
	}
	
	
	// atributos específicos del Avión
	private boolean tren_aterrizaje;
	
	// métodos específicos del Avión
	public void volar() { }
	public void aterrizar() { }

	// Aplicando polimorfismo ...
	public void parar() {
		System.out.println("Método parar del avión");
	}
	
}
