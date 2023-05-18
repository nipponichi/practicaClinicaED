package practicaFicherosED;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static final String NOMBRE_BD = "bd_ejemplo";
	private static final String UBICACION = "localhost";
	private static final String PUERTO = "3306";
	private static final String USUARIO = "root";
	private static final String CLAVE = "root";

	// Para versión mysql-conector-java-5.1.6.jar + mysql Server 5.7
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://" + UBICACION + ":" + PUERTO + "/" + NOMBRE_BD
			+ "?useUnicode=true&characterEncoding=utf-8";

	// RECUERDA CAMBIAR!!

	// Para versión mysql-conector-java-8.0.11.jar + mysql Server 8.0.33

	// private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";

	/*
	 * private static final String URL = "jdbc:mysql://localhost:3306/" + nombreBd +
	 * "?useUnicode=true&use" +
	 * "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&" +
	 * "serverTimezone=UTC";
	 */

	static {

		try {
			Class.forName(CONTROLADOR);
		} catch (ClassNotFoundException e) {
			// * TODO Auto-generated catch block
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		}
	}

	public Connection conectar() {
		Connection conexion = null;

		try {

			// Establecemos la conexión para eso java nos prporciona conexion =
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);

			System.out.println("Conexión correctamente establecida con la base de datos " + NOMBRE_BD);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en la conexión");
			e.printStackTrace();
		}

		return conexion;
	}

	// SEGUNDA ACTUALIZACION

	// @SuppressWarnings("unused")

	/*
	 * public Connection conectar() { Connection conexion = null;
	 * 
	 * try { Class.forName(CONTROLADOR);
	 * 
	 * // Establecemos la conexión para eso java nos prporciona conexion =
	 * DriverManager.getConnection(URL, USUARIO, CLAVE);
	 * 
	 * System.out.println("Conexión establecida con BD correctamente");
	 * 
	 * } catch (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * System.out.println("Error al cargar el controlador"); e.printStackTrace(); }
	 * catch (SQLException e) { // TODO Auto-generated catch block
	 * System.out.println("Error en la conexión"); e.printStackTrace(); }
	 * 
	 * return conexion; }
	 */

	/*
	 * public static void conectar() {
	 * 
	 * try { Class.forName("com.mysql.jdbc.Driver");
	 * 
	 * String userName = "root"; String password = "root";
	 * 
	 * String url =*
	 * "jdbc:mysql://localhost:3306/bd_ejemplo?useUnicode=true&characterEncoding=utf-8"
	 * ;// recuerda // cambiar!!
	 * 
	 * DriverManager.getConnection(url, userName, password);
	 * System.out.println("Conexión establecida con BD correctamente");
	 * 
	 * } catch (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * System.out.println("Error al cargar el controlador"); e.printStackTrace();
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * System.out.println("Error en la conexión"); e.printStackTrace(); }
	 * 
	 * }
	 */

	
	/*
	 * public static void main(String[] args) {
	 * 
	 * // conectar();
	 * 
	 * try { Class.forName("com.mysql.jdbc.Driver");
	 * 
	 * // Establecemos la conexión para eso java nos prporciona
	 * 
	 * String userName = "root"; String password = "root";
	 * 
	 * String url =
	 * "jdbc:mysql://localhost:3306/bd_ejemplo?useUnicode=true&characterEncoding=utf-8"
	 * ;// recuerda // cambiar!!
	 * 
	 * DriverManager.getConnection(url, userName, password);
	 * System.out.println("Conexión establecida con BD correctamente");
	 * 
	 * } catch (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * 
	 * System.out.println("Error al cargar el controlador"); e.printStackTrace();
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * 
	 * System.out.println("Error en la conexión"); e.printStackTrace(); }
	 * 
	 * 
	 * }
	 */
}

