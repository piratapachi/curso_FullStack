package estudiante;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Estudiante Alonso = new Estudiante();
		Estudiante Gerard = new Estudiante(2,19,666333666,42,93.7,8.7);
		Estudiante Milena = new Estudiante(2,19,666333666,42);
		Estudiante Alejandro = new Estudiante(2,19,666333666);
	
		//System.out.println(Estudiante.crearEstudiante());
		
		Estudiante estudiante = Estudiante.crearEstudiante();
		
		estudiante.agregarNuevaNota(9);
		
		/*
		Persona persona = new Persona();
		persona.mostrarInfo();
		*/
		
		Estudiante Carla = new Estudiante(10, 10, 10, 10);
		Profesor Juan = new Profesor(20, 20, 20);
		
		Carla.mostrarID();
		Juan.mostrarID();
	}
}
