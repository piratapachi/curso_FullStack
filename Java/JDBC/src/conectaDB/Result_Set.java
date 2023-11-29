package conectaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Result_Set {

	public static void main(String[] args) {
		
		try {
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "banco");
				
		// obtención de un objeto de tipo Statement	
		Statement instruccion = conexion.createStatement();
				
		// construir sentencia SQL
		String query = "SELECT * FROM gestor";
		
		ResultSet resultados1 = instruccion.executeQuery(query);
		
		System.out.println("Listado de gestores (con executeQuery): ");
				
		// ejecutar instrucción con el método executeQuery
		while (resultados1.next()) {
		System.out.println("Gestor " + resultados1.getInt("id"));
		System.out.println("Usuario: " + resultados1.getString("usuario"));
		System.out.println("Password: " + resultados1.getString("password"));
		System.out.println("Correo: " + resultados1.getString("correo"));
		System.out.println("...");
			}
		
		// ejecutar instrucción con el método execute
		boolean resultado = instruccion.execute(query);
				
		// si es true, entonces la instrucción devuelve un objeto de tipo ResultSet
		if (resultado) {
		ResultSet resultados2 = instruccion.getResultSet();

		System.out.println("Listado de gestores (con execute): ");
		while (resultados2.next()) {
		System.out.println("Gestor " + resultados2.getInt("id"));
		System.out.println("Usuario: " + resultados2.getString("usuario"));
		System.out.println("Password: " + resultados2.getString("password"));
		System.out.println("Correo: " + resultados2.getString("correo"));
		System.out.println("...");
			}
				}
		}
		catch(Exception e) {
			
		}
	}
	}
