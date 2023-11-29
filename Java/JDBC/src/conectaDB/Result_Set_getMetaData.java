package conectaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Result_Set_getMetaData {

	public static void main(String[] args) {
		
		try {
			
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "banco");
		
		Statement instruccion = conexion.createStatement();
		
		String query = "SELECT * FROM gestor";
		
		ResultSet resultados = instruccion.executeQuery(query);
		
		// devuelve el número de columnas
		System.out.println(resultados.getMetaData().getColumnCount());
		
		// devuelve el nombre de la primera columna
		System.out.println(resultados.getMetaData().getColumnName(1));
		
		// devuelve el tipo de dato de la primera columna (un número entero)
		// https://docs.oracle.com/javase/8/docs/api/constant-values.html#java.sql
		System.out.println(resultados.getMetaData().getColumnType(1));
		
		}catch(Exception e){
			
		}
	}

}
