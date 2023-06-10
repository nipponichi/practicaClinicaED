package practicaFicherosED;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static String NOMBRE_BD = Configuracion.getNombreBBDD();
	private static String UBICACION = Configuracion.getUbicacion();
	private static String PUERTO = Configuracion.getPuerto();
	private static String USUARIO = Configuracion.getUsuario();
	private static String CLAVE = Configuracion.getClave();

	// Para versión mysql-conector-java-5.1.6.jar + mysql Server 5.7
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://" + UBICACION + ":" + PUERTO + "/" + NOMBRE_BD
			+ "?useUnicode=true&characterEncoding=utf-8";
	
	/**
	 * Método de conexión con BBDD, donde comprobamos el controlador una 
	 * única vez y realizamos conexiones a BBDD con un método independiente de 
	 * esta comprobación
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

			//System.out.println("Conexion correctamente establecida con la base de datos " + NOMBRE_BD);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en la conexión");
			e.printStackTrace();
			Menu.menuConfiguracion();
		}

		return conexion;
	}

}

