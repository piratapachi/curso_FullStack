package estudiante;

public class Profesor extends Persona {
		//Atributos especificos
		protected int numeroDeEdadesEstudiantes;
		protected int sumaDeEdadesEstudiantes;
		protected int estudiantesEdadMedia;
			
		public Profesor(int numeroDeEdadesEstudiantes, int sumaDeEdadesEstudiantes, int estudiantesEdadMedia) {
			this.numeroDeEdadesEstudiantes = numeroDeEdadesEstudiantes;
			this.sumaDeEdadesEstudiantes = sumaDeEdadesEstudiantes;
			this.estudiantesEdadMedia = estudiantesEdadMedia;
		}
		
		//Métodos
			public void agregarEdadEstudiante() {}
			public void mostrarInfo() {
				System.out.println("El id es: " + this.id);
				System.out.println("El edad es: " + this.edad);
				System.out.println("El telefono es: " + this.telefono);
		}
			@Override
			protected void mostrarID() {
				System.out.println(this.id + "-" + this.estudiantesEdadMedia);
			}
	}
