package AppGestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionCRUD {
	 static final String JDBC_DRIVER = "org.sqlite.JDBC";
	    static final String DB_URL = "jdbc:sqlite:http://localhost:3306/banco/Clientes";

	    public static void main(String[] args) {
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            Class.forName(JDBC_DRIVER);
	            connection = DriverManager.getConnection(DB_URL);

	            // Operación CREATE (Insertar)
	            insertarCliente(connection, "NombreCliente1", "ApellidoCliente1");

	            // Operación READ (Consultar)
	            consultarClientes(connection);

	            // Operación UPDATE (Actualizar)
	            actualizarCliente(connection, 1, "NuevoNombreCliente", "NuevoApellidoCliente");

	            // Operación READ después de la actualización
	            consultarClientes(connection);

	            // Operación DELETE (Borrar)
	            borrarCliente(connection, 1);

	            // Operación READ después de la eliminación
	            consultarClientes(connection);

	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (preparedStatement != null) preparedStatement.close();
	                if (connection != null) connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    private static void insertarCliente(Connection connection, String nombre, String apellido) throws SQLException {
	        String sql = "INSERT INTO clientes (nombre, apellido) VALUES (?, ?)";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setString(1, nombre);
	            preparedStatement.setString(2, apellido);
	            preparedStatement.executeUpdate();
	            System.out.println("Cliente insertado.");
	        }
	    }

	    private static void consultarClientes(Connection connection) throws SQLException {
	        String sql = "SELECT * FROM clientes";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
	             ResultSet resultSet = preparedStatement.executeQuery()) {

	            System.out.println("Lista de clientes:");
	            while (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String nombre = resultSet.getString("nombre");
	                String apellido = resultSet.getString("apellido");
	                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Apellido: " + apellido);
	            }
	        }
	    }

	    private static void actualizarCliente(Connection connection, int id, String nuevoNombre, String nuevoApellido) throws SQLException {
	        String sql = "UPDATE clientes SET nombre=?, apellido=? WHERE id=?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setString(1, nuevoNombre);
	            preparedStatement.setString(2, nuevoApellido);
	            preparedStatement.setInt(3, id);
	            preparedStatement.executeUpdate();
	            System.out.println("Cliente actualizado.");
	        }
	    }

	    private static void borrarCliente(Connection connection, int id) throws SQLException {
	        String sql = "DELETE FROM clientes WHERE id=?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setInt(1, id);
	            preparedStatement.executeUpdate();
	            System.out.println("Cliente borrado.");
	        }
	    }
}
