package instrucciones_preparadas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class instrucciones_preparadas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			//1. Conexion
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "banco");
			
			//2. Inicializar instrucción preparada, marcando los valores a sustituir con el caracter "?"
			PreparedStatement ps = conexion.prepareStatement("INSERT INTO gestor(usuario,password,correo) VALUES (?,?,?)");
			
			//Se sustituyen las apariciones de "?" con los valores indicados
			ps.setString(1, "gestor10");
			ps.setString(2, "gestor10");
			ps.setString(3, "gestor10@correo.com");
			
			//Si no se ha actualizado la fila 1 ejecuta un error en la inserción:
			if(ps.executeUpdate() !=1) {
				throw new SQLException("Error en la inserción");
			}
			
			System.out.println("Programa finalizado");
		} catch (Exception e) {
			
		}
		
		
	}

}
