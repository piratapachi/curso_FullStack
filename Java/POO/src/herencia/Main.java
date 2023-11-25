package herencia;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bicicleta bicicleta = new Bicicleta();
		Coche coche = new Coche();		
		Avion avion = new Avion();
		Main.invocarParar(bicicleta);
		Main.invocarParar(coche);
		Main.invocarParar(avion);
		
		Vehiculo ford = new Coche();
		ford.parar();
		
		//coche.parar();
		//coche.parar();
	}
	
	
	public static void invocarParar(Vehiculo vehiculo) {
		vehiculo.parar();
	}
	
}
