
public class Coche {
	
	//atributos
	 private float velocidad;
	 private float caballos;
	 private int asientos;
	 private int orientacionRuedas;
	 // atributo estatico
	 // Pasa a ser un valor constante
	 public static final float factorConversionCvKw = 1.35f;
	
	//métodos
	public void parar() { }	
	
	// método acelerar sin argumentos
	// SOBRECARGA DEL MÉTODO ACELERAR
	public void acelerar() {
		this.velocidad += 5;
	}
	
	// método acelerar con un argumento
	public void acelerar(float incrementoVelocidad) {
		this.velocidad += incrementoVelocidad;
	}
	
	// SOBRECARGA DEL MÉTODO DESACELERAR
	// método desacelerar sin argumentos
	public void desacelerar() { 
		this.velocidad -=5;
	}
	
	// método desacelerar con un argumento de tipo float
	public void desacelerar(float decrementoVelocidad) {
		this.velocidad -= decrementoVelocidad;
	}
	
	// método desacelerar con un argumento de tipo booleano
	public void desacelerar(boolean marchaAtras) {
		if(marchaAtras) this.velocidad = -5.0f;
		else desacelerar();
	}
	
	
	
	
	
	
	
	public void girarIzquierda() { }
	public void girarDerecha() { }
	
	// Desclaración de métodos estáticos
	// Método que convierte los cv a kw	
	
	public static float convertirCvKw(float caballos) {
		//this.caballos = caballos;
		//factorConversionCvKw = 2.3f;
		return caballos / factorConversionCvKw;
	}
			
			// Método que convierte los kw a cv	
	public static float convertirKwCv(float kilowatios) {
		return kilowatios * factorConversionCvKw;
	}
	
	//método constructor
	
	public Coche(float velocidad, float caballos, int asientos, int orientacionRuedas) {
		
		this.velocidad = velocidad;
		this.caballos = caballos;
		this.asientos = asientos;
		this.orientacionRuedas = orientacionRuedas;
	}
	
	// Obtener datos con modificador private (Getter/Setter)
		
		public float getCaballos() {
			return caballos;
		}
		
		public void setCaballos(float caballos) {
			this.caballos = caballos;
		}
		
		
	
	/*
	// Constructor por defecto
	public Coche() {
		this.velocidad = 5.0f;
		this.caballos = 0.0f;
		this.asientos = 4;
		this.orientacionRuedas = 0;
	}
	
	// Constructor parametrizado
	public Coche(int asientos) {
		this.velocidad = 5.0f;
		this.caballos = 0.0f;
		this.asientos = asientos;
		this.orientacionRuedas = 0;
	}
	
	// Constructor parametrizado
	public Coche(float velocidad, int caballos) {
		this.velocidad = velocidad;
		this.caballos = caballos;
		this.asientos = 2;
		this.orientacionRuedas = 0;
	}
	*/
	
	

	

}
