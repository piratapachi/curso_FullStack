package conectaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Operaciones_CRUD {

	public static void main(String[] args) {

		try {
			
			//1. Crear conexion
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "banco");
			
			//2. Crear objeto statement
			Statement instruccion = conexion.createStatement();
			
			//3. Ejecutar instrucciones SQL
			String query = "INSERT INTO gestor(usuario, password, correo) VALUES ('gestor99', 'gestor99', 'gestor99@correo.com')";
			
			//Ejecutar instruccion con el metodo execute
			boolean resultado = instruccion.execute(query);
			
			//Si es false entonces la instruccion no devuelve un objeto de tipo resultSet
			
			if(!resultado) {
				//Mostrar numero de registros insertados
				System.out.println("Registros insertados: " + instruccion.getUpdateCount());
			}
			
			//Ejecutar instrucción con el método executeUpdate
			int registrosInsertados = instruccion.executeUpdate(query);
			
			//Mostrar numero de registros insertados
			System.out.println("Registros insertados: " + registrosInsertados);
			
		} catch(Exception e) {
			
		}
		
	}

}
