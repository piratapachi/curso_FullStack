package instrucciones_preparadas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Cualquier_instruccion_preparada {
	
	public static void main(String[] args) {
	
		try {
		
			//1. Conexion
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "banco");
			
			//2. Inicializar instrucción preparada, marcando los valores a sustituir con el caracter "?"
			PreparedStatement ps = conexion.prepareStatement("SELECT * FROM gestor WHERE Id IN (?,?)");
			
			//3. Se sustituye la primera aparacion del caracter "?" con el valor 3 teniendo en cuenta la posición 1
			ps.setInt(1, 4);
			
			//4. SE sustituye la segunda aparición del caracter "?" con el valor 4 teneiendo en cuenta la posición 2
			ps.setInt(2, 10);
			
			ResultSet resultados = ps.executeQuery();
			System.out.println("Listado de gestores: ");
			
			while(resultados.next()) {
				System.out.println("Gestor " + resultados.getInt("id"));
				System.out.println("Usuario " + resultados.getString("usuario"));
				System.out.println("Password " + resultados.getString("password"));
				System.out.println("Correo " + resultados.getString("correo"));
				System.out.println("...");
			}		
		}catch(Exception e) {
			
		}
	}
	}