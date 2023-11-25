package estudiante;

public abstract class Persona {
	
	//Atributos
	protected int id;
	protected int edad;
	protected int telefono;
	
	//Constructor
	public Persona() {
		this.id = id;
		this.edad = edad;
		this.telefono = telefono;
	}
	
	//Metodos
	public void mostrarInfo() {
		System.out.println("El id es: " + this.id);
		System.out.println("El edad es: " + this.edad);
		System.out.println("El telefono es: " + this.telefono);
	}
	//Método abstracto
	protected abstract void mostrarID();
}