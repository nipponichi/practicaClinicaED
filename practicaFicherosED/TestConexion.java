package practicaFicherosED;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TestConexion {
	
	/*
	  public static void main(String[] args) {
	  
	  Conexion conexion = new Conexion(); conexion.conectar();
	  
	  }*/
	 

	private static String selectTableSQL;
	private static String insertTableSQL;
	private static String updateTableSQL;

	public static void cerrar_conexion3(Connection cn, Statement stm, ResultSet rs) {
		// Liberar recursos revisar el orden en el que se cierran, orden inverso
		try {
			if (rs != null) {
				rs.close();
			}
			if (stm != null) {
				stm.close();
			}
			if (cn != null) {
				cn.close();
			}
			System.out.println("La conexión se ha cerrado con éxito");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		}

	}

	public static void consultaSelectPersonal() {
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		selectTableSQL = "SELECT * FROM Personal";       	
		try {
			// Abrimos la conexion con la base de datos
			cn = conexion.conectar();
			stm = cn.createStatement();
			// Pasamos la consulta al ResultSet
			rs = stm.executeQuery(selectTableSQL);

			while (rs.next()) {
				int codigo = rs.getInt(1);
				String nombre = rs.getString(2);
				String apellidos = rs.getString(3);
				String dni = rs.getString(4);
				String localidad = rs.getString(5);
				String telefono = rs.getString(6);
				String especialidad = rs.getString(7);
				
				Profesionales_Medicos medico = new Profesionales_Medicos(codigo, nombre, apellidos, dni, localidad, telefono, especialidad);
				PersonaApp_Scanner.medicos.add(medico);
			}
		} catch (SQLException e) { // TODO: handle exception

		} finally {
			cerrar_conexion3(cn, stm, rs);
			System.out.println("Personal cargado con exito");
		}
	}
	
	public static void consultaSelectPaciente() {
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		selectTableSQL = "SELECT * FROM Paciente";       	
		try {
			// Abrimos la conexion con la base de datos
			cn = conexion.conectar();
			stm = cn.createStatement();
			// Pasamos la consulta al ResultSet
			rs = stm.executeQuery(selectTableSQL);
			while (rs.next()) {
				
				String nombre = rs.getString(1);
				int edad = rs.getInt(2);
				String calle = rs.getString(3);
				String localidad = rs.getString(4);
				String codigoPostal = rs.getString(5);
				String dni = rs.getString(6);
				String sexo = rs.getString(7);
				double peso = rs.getDouble(8);
				double altura = rs.getDouble(9);
				
				Paciente paciente = new Paciente(nombre, edad, calle, localidad, codigoPostal, dni, sexo, peso, altura);
				//Añadimos de objeto paciente a arraylist de pacientes
				PersonaApp_Scanner.pacientes.add(paciente);
			}
		} catch (SQLException e) { // TODO: handle exception

		} finally {
			cerrar_conexion3(cn, stm, rs);
			System.out.println("Paciente(s) cargado(s) con exito");
		}
	}
	
	public static void consultaSelectVisita() {
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		SimpleDateFormat sdfFecha = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
		selectTableSQL = "SELECT * FROM Visita";       	
		try {
			// Abrimos la conexion con la base de datos
			cn = conexion.conectar();
			stm = cn.createStatement();
			// Pasamos la consulta al ResultSet
			rs = stm.executeQuery(selectTableSQL);
			Date fecha = null;
			Date hora = null;
			
			while (rs.next()) {
				
				String fechaStr = rs.getString(1);
				String horaStr = rs.getString(2);
				String dniPaciente = rs.getString(3);
				String dniPersonal = rs.getString(4);
				String resultado = rs.getString(5);
				

				try {
					fecha = sdfFecha.parse(fechaStr);
					hora = sdfHora.parse(horaStr);
				} catch (ParseException e) {
					System.out.println("La fecha introducida no es un formato valido");
					e.printStackTrace();
				}
				
				
				
				Visita visita = new Visita(fecha, hora, dniPaciente, dniPersonal, resultado);
				PersonaApp_Scanner.visitas.add(visita);
			}
		} catch (SQLException e) { // TODO: handle exception

		} finally {
			cerrar_conexion3(cn, stm, rs);
			System.out.println("Visita(s) cargada(s) con exito");
		}
	}

	public static void consultaInsertPersonal(int codigo, String nombre, String apellidos, String dni, String localidad,String telefono,String especialidad) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		PreparedStatement ps = null;

		// int id_usuario=null;
		// Crear sentencia SQL para insertar en la base de datos
		insertTableSQL = "INSERT INTO Personal (codigo,nombre,apellidos,dni,localidad,telefono,especialidad) VALUES (?,?,?,?,?,?,?)";

		try {

			cn = conexion.conectar();
			ps = cn.prepareStatement(insertTableSQL);

			ps.setInt(1, codigo);
	        ps.setString(2, nombre);
	        ps.setString(3, apellidos);
	        ps.setString(4, dni);
	        ps.setString(5, localidad);
	        ps.setString(6, telefono);
	        ps.setString(7, especialidad);
			ps.executeUpdate();

			System.out.println("El registro ha sido insertado con exito en la base de datos");

		} catch (SQLException e) { // TODO: handle exception

			e.printStackTrace();

		} finally { // Liberar recursos revisar el orden en el que se cierran
			try {

				if (ps != null) {
					ps.close();
				}

				if (cn != null) {
					cn.close();
				}

			} catch (Exception e2) {

				e2.printStackTrace();

			}

		}

	}
	
	public static void consultaInsertPaciente(String nombre, int edad, String calle, String localidad, String codpostal,
			String dni, String sexo, Double peso, Double altura) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		PreparedStatement ps = null;

		// int id_usuario=null;
		// Crear sentencia SQL para insertar en la base de datos
		insertTableSQL = "INSERT INTO Paciente (nombre,edad,calle,localidad,codpostal,dni,sexo,peso,altura) VALUES (?,?,?,?,?,?,?,?,?)";

		try {

			cn = conexion.conectar();
			ps = cn.prepareStatement(insertTableSQL);

			ps.setString(1, nombre);
			System.out.println(nombre);
			ps.setInt(2, edad);
			System.out.println(edad);
	        ps.setString(3, calle);
	        System.out.println(calle);
	        ps.setString(4, localidad);
	        System.out.println(localidad);
	        ps.setString(5, codpostal);
	        System.out.println(codpostal);
	        ps.setString(6, dni);
	        System.out.println(dni);
	        ps.setString(7, sexo);
	        System.out.println(sexo);
	        ps.setDouble(8, peso);
	        System.out.println(peso);
	        ps.setDouble(9, altura);
	        System.out.println(altura);
			ps.executeUpdate();

			System.out.println("El registro ha sido insertado con exito en la base de datos");

		} catch (SQLException e) { // TODO: handle exception

			e.printStackTrace();

		} finally { // Liberar recursos revisar el orden en el que se cierran
			try {

				if (ps != null) {
					ps.close();
				}

				if (cn != null) {
					cn.close();
				}

			} catch (Exception e2) {

				e2.printStackTrace();

			}

		}

	}
	
	public static void consultaInsertVisita(String fecha, String hora, String dniPaciente, String dniPersonal, String resultado) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		PreparedStatement ps = null;

		// int id_usuario=null;
		// Crear sentencia SQL para insertar en la base de datos
		insertTableSQL = "INSERT INTO Visita (fecha, hora, dniPaciente,dniPersonal,resultado) VALUES (?,?,?,?,?)";

		try {

			cn = conexion.conectar();
			ps = cn.prepareStatement(insertTableSQL);

			ps.setString(1, fecha);
			ps.setString(2, hora);
	        ps.setString(3, dniPaciente);
	        ps.setString(4, dniPersonal);
	        ps.setString(5, resultado);

			ps.executeUpdate();

			System.out.println("El registro ha sido insertado con exito en la base de datos");

		} catch (SQLException e) { // TODO: handle exception

			e.printStackTrace();

		} finally { // Liberar recursos revisar el orden en el que se cierran
			try {

				if (ps != null) {
					ps.close();
				}

				if (cn != null) {
					cn.close();
				}

			} catch (Exception e2) {

				e2.printStackTrace();

			}

		}

	}

	public static void consultaUpdatePaciente(String dni,double peso, double altura) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;

		// Crear sentencia SQL para insertar en la base de datos
		updateTableSQL = "UPDATE paciente set peso ='" + peso + "', altura='" + altura + "' where dni='"
				+ dni +"'";

		try {

			cn = conexion.conectar();
			stm = cn.createStatement();
			int valor = stm.executeUpdate(updateTableSQL);
			if (valor == 1) {
				System.out.println("El usuario ha sido actualizado correctamente");
			} else {
				System.out.println("No existe usuario con el dni referido");
			}

		} catch (SQLException e) { // TODO: handle exception

			e.printStackTrace();

		} finally { // Liberar recursos revisar el orden en el que se cierran
			try {

				if (stm != null) {
					stm.close();
				}

				if (cn != null) {
					cn.close();
				}

			} catch (Exception e2) {

				e2.printStackTrace();

			}

		}

	}
}
