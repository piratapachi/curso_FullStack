package AppGestion;

		import java.util.ArrayList;
		import java.util.List;
		import java.util.Random;
		import java.util.Scanner;
		import java.util.HashMap;
		import java.util.Map;

		public class SistemaGestion {

		    private List<Gestor> gestores = new ArrayList<>();
		    private List<Cliente> clientes = new ArrayList<>();
		    private List<Mensaje> mensajes = new ArrayList<>();
		    private List<Transferencia> transferencias = new ArrayList<>();
		    private Scanner scanner = new Scanner(System.in);
		    private Map<String, String> usuariosRegistrados = new HashMap<>();
		    private String usuarioActual = null;
		    
		    public static void main(String[] args) {
		        SistemaGestion sistema = new SistemaGestion();
		        sistema.iniciarMenu();
		    }

		    private void iniciarMenu() {
		        int opcion;
		        do {
		            System.out.println("------ Menú de Gestión ------");
		            System.out.println("1. Inserción de un gestor.");
		            System.out.println("2. Inserción masiva de gestores con datos aleatorios.");
		            System.out.println("3. Obtención de un gestor.");
		            System.out.println("4. Obtención de todos los gestores.");
		            System.out.println("5. Actualización de un gestor.");
		            System.out.println("6. Eliminación de un gestor.");
		            System.out.println("7. Inserción de un cliente.");
		            System.out.println("8. Obtención de un cliente.");
		            System.out.println("9. Obtención de todos los clientes.");
		            System.out.println("10. Actualización de un cliente.");
		            System.out.println("11. Eliminación de un cliente.");
		            System.out.println("12. Obtención de un mensaje.");
		            System.out.println("13. Obtención de todos los mensajes.");
		            System.out.println("14. Envío de un mensaje.");
		            System.out.println("15. Obtención de una transferencia.");
		            System.out.println("16. Obtención de todas las transferencias.");
		            System.out.println("17. Envío de una transferencia.");
		            System.out.println("18. Salir.");
		            System.out.println("19. Registrar nuevo usuario.");
		            System.out.println("20. Iniciar sesión.");
		            System.out.print("Seleccione una opción: ");
		            opcion = scanner.nextInt();
		            scanner.nextLine();

		            switch (opcion) {
		                case 1:
		                    insertarGestor();
		                    break;
		                case 2:
		                    insertarMasivaGestores();
		                    break;
		                case 3:
		                    obtenerGestor();
		                    break;
		                case 4:
		                    obtenerTodosGestores();
		                    break;
		                case 5:
		                    actualizarGestor();
		                    break;
		                case 6:
		                    eliminarGestor();
		                    break;
		                case 7:
		                    insertarCliente();
		                    break;
		                case 8:
		                    obtenerCliente();
		                    break;
		                case 9:
		                    obtenerTodosClientes();
		                    break;
		                case 10:
		                    actualizarCliente();
		                    break;
		                case 11:
		                    eliminarCliente();
		                    break;
		                case 12:
		                    obtenerMensaje();
		                    break;
		                case 13:
		                    obtenerTodosMensajes();
		                    break;
		                case 14:
		                    enviarMensaje();
		                    break;
		                case 15:
		                    obtenerTransferencia();
		                    break;
		                case 16:
		                    obtenerTodasTransferencias();
		                    break;
		                case 17:
		                    enviarTransferencia();
		                    break;
		                case 18:
		                	if (usuarioActual != null) {
		                        System.out.println("Cerrando sesión del usuario: " + usuarioActual);
		                        usuarioActual = null;
		                    }
		                    System.out.println("Saliendo del programa. ¡Hasta luego!");
		                    break;
		                case 19:
		                    registrarUsuario();
		                    break;
		                case 20:
		                    iniciarSesion();
		                    break;
		                default:
		                    System.out.println("Opción no válida. Inténtelo de nuevo.");
		            }

		        } while (opcion != 18);
		    }

		    private void insertarGestor() {
		    	
		    	System.out.print("Ingrese el nombre del gestor: ");
		        String nombre = scanner.nextLine();
		        System.out.print("Ingrese el correo electrónico del gestor: ");
		        String correo = scanner.nextLine();

		        Gestor nuevoGestor = new Gestor(nombre, correo);
		        gestores.add(nuevoGestor);

		        System.out.println("Gestor insertado con éxito.");
		    }

		    private void insertarMasivaGestores() {
		    	System.out.print("Ingrese la cantidad de gestores a insertar: ");
		        int cantidad = scanner.nextInt();

		        for (int i = 0; i < cantidad; i++) {
		            String nombre = "Gestor" + (i + 1);
		            String correo = "gestor" + (i + 1) + "@example.com";
		            Gestor nuevoGestor = new Gestor(nombre, correo);
		            gestores.add(nuevoGestor);
		        }
		    }

		    private void obtenerGestor() {
		    	 System.out.print("Ingrese el correo electrónico del gestor: ");
		    	    String correo = scanner.nextLine();

		    	    for (Gestor gestor : gestores) {
		    	        if (gestor.getCorreo().equals(correo)) {
		    	            System.out.println("Gestor encontrado: " + gestor.getNombre());
		    	            return;
		    	        }
		    	    }
		    }

		    private void obtenerTodosGestores() {
		    	  System.out.println("Lista de todos los gestores:");

		    	    for (Gestor gestor : gestores) {
		    	        System.out.println("Nombre: " + gestor.getNombre() + ", Correo: " + gestor.getCorreo());
		    	    }
		    }

		    private void actualizarGestor() {
		    	System.out.print("Ingrese el correo electrónico del gestor a actualizar: ");
		        String correo = scanner.nextLine();

		        for (Gestor gestor : gestores) {
		            if (gestor.getCorreo().equals(correo)) {
		                System.out.print("Ingrese el nuevo nombre del gestor: ");
		                String nuevoNombre = scanner.nextLine();
		                System.out.print("Ingrese el nuevo correo electrónico del gestor: ");
		                String nuevoCorreo = scanner.nextLine();

		                gestor.setNombre(nuevoNombre);
		                gestor.setCorreo(nuevoCorreo);

		                System.out.println("Gestor actualizado con éxito.");
		                return;
		            }
		            }
		    }

		    private void eliminarGestor() {
		    	 System.out.print("Ingrese el correo electrónico del gestor a eliminar: ");
		    	    String correo = scanner.nextLine();

		    	    gestores.removeIf(gestor -> gestor.getCorreo().equals(correo));

		    	    System.out.println("Gestor eliminado con éxito.");
		    }

		    private void insertarCliente() {
		    	System.out.print("Ingrese el nombre del cliente: ");
		        String nombre = scanner.nextLine();
		        System.out.print("Ingrese el apellido del cliente: ");
		        String apellido = scanner.nextLine();

		        Cliente nuevoCliente = new Cliente(nombre, apellido);
		        clientes.add(nuevoCliente);

		        System.out.println("Gestor insertado con éxito.");
		    }

		    private void obtenerCliente() {
		    	System.out.print("Ingrese el nombre del cliente: ");
	    	    String nombre = scanner.nextLine();

	    	    for (Cliente cliente : clientes) {
	    	        if (cliente.getNombre().equals(nombre)) {
	    	            System.out.println("Cliente encontrado: " + cliente.getNombre());
	    	            return;
	    	        }
	    	    }
		    }

		    private void obtenerTodosClientes() {
		        System.out.println("Lista de todos los clientes:");
		        
	    	    for (Cliente cliente : clientes) {
	    	        System.out.println("Nombre: " + cliente.getNombre() + ", Apellido: " + cliente.getApellido());
	    	    }
		    }

		    private void actualizarCliente() {
		    	System.out.print("Ingrese el apellido del cliente a actualizar: ");
		        String apellido = scanner.nextLine();

		        for (Cliente cliente : clientes) {
		            if (cliente.getApellido().equals(apellido)) {
		                System.out.print("Ingrese el nuevo nombre del cliente: ");
		                String nuevoNombre = scanner.nextLine();
		                System.out.print("Ingrese el nuevo apellido del cliente: ");
		                String nuevoApellido = scanner.nextLine();

		                cliente.setNombre(nuevoNombre);
		                cliente.setApellido(nuevoApellido);

		                System.out.println("Gestor actualizado con éxito.");
		                return;
		            }
		            }
		    }

		    private void eliminarCliente() {
		    	 System.out.print("Ingrese el appelido del cliente a eliminar: ");
		    	    String apellido = scanner.nextLine();

		    	    clientes.removeIf(cliente -> cliente.getApellido().equals(apellido));

		    	    System.out.println("Cliente eliminado con éxito.");
		    }

		    private void obtenerMensaje() {
		        System.out.print("Ingrese el asunto del mensaje: ");
		        String asunto = scanner.nextLine();

		        for (Mensaje mensaje : mensajes) {
		            if (mensaje.getAsunto().equals(asunto)) {
		                System.out.println("Mensaje encontrado: " + mensaje.getAsunto());
		                return;
		            }
		            }
		    }

		    private void obtenerTodosMensajes() {
		        System.out.println("Lista de todos los mensajes:");
		        
	    	    for (Mensaje mensaje : mensajes) {
	    	        System.out.println("Asunto: " + mensaje.getAsunto() + ", Mensaje: " + mensaje.getMensaje());
	    	    }
		    }

		    private void enviarMensaje() {
		    	System.out.print("Ingrese el asunto del mensaje: ");
		        String asunto = scanner.nextLine();
		        System.out.print("Ingrese el mensaje: ");
		        String mensaje = scanner.nextLine();

		        Mensaje nuevoMensaje = new Mensaje(asunto, mensaje);
		        mensajes.add(nuevoMensaje);

		        System.out.println("Mensaje enviado con éxito.");
		    }

		    private void obtenerTransferencia() {
		        System.out.print("Ingrese el destinatario de la transferencia: ");
		        String destinatario = scanner.nextLine();

		        for (Transferencia transferencia : transferencias) {
		            if (transferencia.getDestinatario().equals(destinatario)) {
		                System.out.println("Transferencia encontrada: " + transferencia.getDestinatario());
		                return;
		            }
		            }
		    }

		    private void obtenerTodasTransferencias() {
		        System.out.println("Lista de todas las transferencias:");
		        
		        for (Transferencia transferencia : transferencias) {
	    	        System.out.println("Destinatario: " + transferencia.getDestinatario() + ", Remitente: " + transferencia.getRemitente());
	    	    }
		    }

		    private void enviarTransferencia() {
		    	System.out.print("Ingrese el destinatario de la transferencia: ");
		        String destinatario = scanner.nextLine();
		        System.out.print("Ingrese el remitente: ");
		        String remitente = scanner.nextLine();

		        Transferencia nuevoTransferencia = new Transferencia(destinatario, remitente);
		        transferencias.add(nuevoTransferencia);

		        System.out.println("Transferencia enviada con éxito.");
		    }
		    
		    private void registrarUsuario() {
		        System.out.print("Ingrese un nombre de usuario: ");
		        String nuevoUsuario = scanner.nextLine();

		        if (usuariosRegistrados.containsKey(nuevoUsuario)) {
		            System.out.println("El nombre de usuario ya está registrado. Intente con otro.");
		            return;
		        }

		        System.out.print("Ingrese una contraseña: ");
		        String nuevaContraseña = scanner.nextLine();

		        usuariosRegistrados.put(nuevoUsuario, nuevaContraseña);

		        System.out.println("Usuario registrado con éxito.");
		    }

		    private void iniciarSesion() {
		        if (usuarioActual != null) {
		            System.out.println("Ya hay una sesión activa. Cierre sesión antes de iniciar una nueva.");
		            return;
		        }

		        System.out.print("Ingrese su nombre de usuario: ");
		        String nombreUsuario = scanner.nextLine();

		        if (!usuariosRegistrados.containsKey(nombreUsuario)) {
		            System.out.println("Nombre de usuario no registrado. Regístrese antes de iniciar sesión.");
		            return;
		        }

		        System.out.print("Ingrese su contraseña: ");
		        String contraseña = scanner.nextLine();

		        if (usuariosRegistrados.get(nombreUsuario).equals(contraseña)) {
		            usuarioActual = nombreUsuario;
		            System.out.println("Inicio de sesión exitoso. ¡Bienvenido, " + usuarioActual + "!");
		        } else {
		            System.out.println("Contraseña incorrecta. Inténtelo de nuevo.");
		        }
		    }
		  
	}

