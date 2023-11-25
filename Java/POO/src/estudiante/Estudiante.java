package estudiante;

public class Estudiante extends Persona{
	//Atributos especificos
	  protected int numeroDeNotas;
	  protected double sumaDeNotas;
	  protected double notaMedia;
	   
	//Métodos
	  public void mostrarInfo() { }
	 
	//Sobrecarga de los tres métodos
	  public void agregarNuevaNota() {
		  	//float nota = 6;
		  	//this.sumaDeNotas += nota;
	        numeroDeNotas++;
	        notaMedia = sumaDeNotas / numeroDeNotas;
	        System.out.println("La nota media es: " + notaMedia);
	    }

	    // Segundo método: recibe como parámetro una nota (valor de tipo flotante)
	    public void agregarNuevaNota(float nota) {
	    	// Aumento valor a numeroDeNotas 
	        numeroDeNotas++;
	        // Sumo la nueva nota
	        sumaDeNotas += nota;
	        // Obtengo el nuevo valor diviendo
	        notaMedia = sumaDeNotas / numeroDeNotas;
	        System.out.println("La nota media es: " + notaMedia);
	    }

	    // Tercer método: recibe como parámetro una nota y una variable booleana para reiniciar a cero los atributos numeroDeNotas, sumaDeNotas y notaMedia
	    public void agregarNuevaNota(float nota, boolean reiniciar) {
	        if (reiniciar) {
	            numeroDeNotas = 0;
	            sumaDeNotas = 0;
	            notaMedia = 0;
	        }
	        
	        numeroDeNotas++;
	        sumaDeNotas += nota;
	        notaMedia = sumaDeNotas / numeroDeNotas;
	        System.out.println("La nota media es: " + notaMedia);
	    }
	  
	
	//Método estático público
	  public static Estudiante crearEstudiante() {	  
		  return new Estudiante();
	  }
	   
	//Constructor por defecto
	   public Estudiante() {
		 this.id = 2;
		 this.edad = 19;
		 this.telefono = 666333666;
		 this.numeroDeNotas = 49;
		 this.sumaDeNotas = 93.7;
		 this.notaMedia = 8.7;
	   }
	   
	//Constructor con todos los atributos de la clase
		 public Estudiante(int id, int edad, int telefono, int numeroDeNotas, 
				 double sumaDeNotas, double notaMedia) {
			 this.id = id;
			 this.edad = edad;
			 this.telefono = telefono;
			 this.numeroDeNotas = numeroDeNotas;
			 this.sumaDeNotas = sumaDeNotas;
			 this.notaMedia = notaMedia;
		 }
		 
	//Contructor parametrizado 2
		 public Estudiante(int id, int edad, int telefono, int numeroDeNotas) {
			 this.id = id;
			 this.edad = edad;
			 this.telefono = telefono;
			 this.numeroDeNotas = numeroDeNotas;
			 this.sumaDeNotas = 93.7;
			 this.notaMedia = 8.7;
		 }
		 
	//Constructor parametrizado 3 
		 public Estudiante(int id, int edad, int telefono) {
			 this.id = id;
			 this.edad = edad;
			 this.telefono = telefono;
			 this.numeroDeNotas = 42;
			 this.sumaDeNotas = 93.7;
			 this.notaMedia = 8.7;
		 }
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getEdad() {
			return edad;
		}
		public void setEdad(int edad) {
			this.edad = edad;
		}
		public int getTelefono() {
			return telefono;
		}
		public void setTelefono(int telefono) {
			this.telefono = telefono;
		}
		public int getNumeroDeNotas() {
			return numeroDeNotas;
		}
		public void setNumeroDeNotas(int numeroDeNotas) {
			this.numeroDeNotas = numeroDeNotas;
		}
		public double getSumaDeNotas() {
			return sumaDeNotas;
		}
		public void setSumaDeNotas(double sumaDeNotas) {
			this.sumaDeNotas = sumaDeNotas;
		}
		public double getNotaMedia() {
			return notaMedia;
		}
		public void setNotaMedia(double notaMedia) {
			this.notaMedia = notaMedia;
		}

		@Override
		protected void mostrarID() {
			System.out.println(this.id + "-" + this.notaMedia);		
		}
	 
	}
