package conectaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conecta_banco {

	public static void main(String[] args) throws SQLException {

		//Crear objetos de la clase statement, resultset y connection
		Statement instruccion = null;
		ResultSet resultados = null;
		Connection conexion = null;
		
		//Crear conexion: driver + ruta bbdd
		conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco","banco","banco");
		
		try {
			 conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco","banco","banco");
		
			// muestra información del tipo de sistema de base de datos (MySQL)
			System.out.println("Base de datos: " + conexion.getMetaData().getDatabaseProductName());
			
			// muestra información sobre la versión del sistema de base de datos (5.5.5-10.4.11-MariaDB)
			System.out.println("Versión: " + conexion.getMetaData().getDatabaseProductVersion());

			// muestra información del diver MySQL (MySQL Connector/J)
			System.out.println("Driver: " + conexion.getMetaData().getDriverName());
			
			// muestra información de la versión del driver MySQL (mysql-connector-java-8.0.18)
			System.out.println("Versión del driver: " + conexion.getMetaData().getDriverVersion());
		
		} catch (SQLException e) {

			e.printStackTrace();
		
		} finally {
			
			try {
				
				//libera resultados
				if(resultados != null) {
					resultados.close();
				}
				
				//libera la instruccion
				if(instruccion != null) {
					instruccion.close();
				}
				
				//libera la conexion´
				if(conexion != null) {
					conexion.close();
				}
		}
				
			//Manejo de errores
				catch (Exception e) {
					e.printStackTrace();
				}
		}
	}
}
