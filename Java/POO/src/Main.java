
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Creación o instanciación de objetos
		
		//Nombre de la Clase + Nomb Obj = new(instancia) Nombre Clase(Constructor);	
		
		Coche audi = new Coche(0.0f, 350.0f, 2, 0);
		// Acceso a los métodos sobrecargados
		audi.desacelerar();
		audi.desacelerar(2.0f);
		audi.desacelerar(true);
		
		// se obtiene el valor actual del atributo caballos
		//y se muestra (350.0)
		
		//System.out.println(audi.getCaballos());
		
		// se modifica el valor actual del atributo caballos a 250
		
		audi.setCaballos(250.0f);
		
		// se obtiene el valor actual del atributo 
		//caballos y se muestra (250.0)
		
		//System.out.println(audi.getCaballos());
		
		
		Coche nissan = new Coche(0.0f, 90.0f, 4, 0);
		Coche volvo = new Coche(12.0f, 75.0f, 5, 5);
		
		// Visualización de los atributos del objeto audi
		//System.out.println(audi.asientos);
		//System.out.println(audi.velocidad);
		
		// Invocación de los métodos del objeto audi
		audi.acelerar();
		audi.parar();
		
		// Invocacion de los métodos estáticos
		
				// NombreClase.nombreMetodoEstatico
		float kw = Coche.convertirCvKw(350.0f);
		float cv = Coche.convertirKwCv(kw);
		
		System.out.println(kw);
		System.out.println(cv);
		
		// Acceso a un método estático desde un objeto
		//audi.convertirCvKw(350.0f);
		
		// No podriamos modificar el valor con la partícula final
		//Coche.factorConversionCvKw = 2.3f;
		
	}

}
