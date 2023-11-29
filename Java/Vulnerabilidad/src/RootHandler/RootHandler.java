package RootHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

public class RootHandler implements HttpHandler {
		public void handle(HttpExchange he) throws IOException {
		try {

		// respuesta al cliente para peticiones GET (descarga de la página)
		if (he.getRequestMethod().equalsIgnoreCase("GET")) {
		String response = "<html><head></head><body><form action=\"/\"method=\"post\">\r\n" 
		+ " Usuario: <input type=\"text\" name=\"usuario\"><br>\r\n"
		+ " Password: <input type=\"text\" name=\"password\"><br>\r\n"
		+ " <input type=\"submit\" value=\"Submit\">\r\n" + "</form></body></html>";
		he.sendResponseHeaders(200, response.length());
		OutputStream os = he.getResponseBody();
		os.write(response.getBytes());
		os.close();
		}
		
		// respuesta al cliente para peticiones GET (envío de los datos del formulario)
		else if (he.getRequestMethod().equalsIgnoreCase("POST")) {
			
		// obtención de los datos del cuerpo
		BufferedReader in = new BufferedReader(new
		InputStreamReader(he.getRequestBody()));
		StringBuilder content = new StringBuilder();
		String line = in.readLine();
		while (line != null) {
		content.append(line);
		line = in.readLine();
		}
		in.close();
		
		// obtención del usuario y password hasheado
		Map<String, String> parameters = this.queryToMap(content.toString());
		String usuario = parameters.get("usuario");
		String password = parameters.get("password");
		String passwordSHA3 = SHA3(password);
		
		// conexión a la base de datos
		Connection conexion =
		DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "banco");
		
		// creación de la instrucción SQL
		Statement instruccion = conexion.createStatement();
		String querySQL = "SELECT * FROM cliente WHERE usuario =\"" + usuario + "\"AND password =\"" + passwordSHA3 + "\"";
		System.out.println(querySQL);
		
		// ejecución de la instrucción SQL
		ResultSet resultados = instruccion.executeQuery(querySQL);
		
		// si la autenticación es correcta, se devuelve ok. En caso contrario, se devuelve	error
		String response = "error";
		if (resultados.next()) {
		response = "ok";
		}
		
		// envía respuesta al cliente y cierra la conexión
		he.sendResponseHeaders(200, response.length());
		OutputStream os = he.getResponseBody();
		os.write(response.getBytes());
		os.close();
		}
		} catch (Exception e) {
		e.printStackTrace();
		}
		}
		
		// extrae los valores del formulario enviados en el cuerpo de la petición POST
		public Map<String, String> queryToMap(String query) throws
		UnsupportedEncodingException {
		Map<String, String> result = new HashMap<>();
		for (String param : query.split("&")) {
		String[] entry = param.split("=");
		if (entry.length > 1) {
		entry[1] = entry[1].replace("+", " ");
		entry[1] = entry[1].replace("%3D", "=");
		entry[1] = entry[1].replace("%22", "\"");
		result.put(entry[0], entry[1]);
		} else {
		result.put(entry[0], "");
		}
		}
		return result;
		}
		
		// calcular el hash SHA3 a partir de un String
		public String SHA3(String str) {
		try {
		final MessageDigest digest = MessageDigest.getInstance("SHA3-256");
		final byte[] hashbytes = digest.digest(str.getBytes(StandardCharsets.UTF_8));
		return bytesToHex(hashbytes);
		} catch (Exception e) {
		e.printStackTrace();
		return null;
		}
		}
		
		// convierte un array de bytes en hexadecimal a String
		private static String bytesToHex(byte[] hash) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
		String hex = Integer.toHexString(0xff & hash[i]);
		if (hex.length() == 1)
		hexString.append('0');
		hexString.append(hex);
		}
		return hexString.toString();
		}
		}
