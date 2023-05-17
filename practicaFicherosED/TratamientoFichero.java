package practicaFicherosED;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TratamientoFichero {
	static PersonaApp_Scanner personaApp = new PersonaApp_Scanner();
	static Paciente paciente = new Paciente();
	static Visita visita = new Visita();
	static Profesionales_Medicos medico = new Profesionales_Medicos();
	static String rutaPaciente = "C:\\Users\\Javier\\eclipse-workspace\\practicaFicherosED\\src"
			+ "\\almacenamiento\\Pacientes.txt";
	static String rutaVisita = "C:\\Users\\Javier\\eclipse-workspace\\practicaFicherosED\\src"
			+ "\\almacenamiento\\Visitas.txt";

	/**
	 * Método de escritura de archivos: Pacientes.txt y Visitas.txt.
	 */
	public static void grabarCliente(Paciente p,boolean esVisita, boolean esPacienteNuevo) {
		String ruta = null;
		FileWriter fichero = null;
		PrintWriter pw = null;
		
		//Comprobamos si registraremos paciente o visita
		if (esVisita != true) {
			ruta = rutaPaciente;
		} 
		
		else {
			ruta = rutaVisita;
		}	
		
		/**
		 * Metodo de editar el archivo, si el fichero existe, se edita, si no,
		 * capturamos la excepcion.
		 */
		try {
			/**
			 * Se añade flag a la edición del archivo para no sobreescribir los datos ya guardados.
			 */
			fichero = new FileWriter(ruta, true);
			pw = new PrintWriter(fichero);
			/**
			 * Se comprueba si el DNI ha sido introducido por teclado o
			 * necesitamos usar el metodo generarDNI() de clase Persona
			 */
			
			//Si no es visita y el dni es recogido por teclado
			if (esVisita != true && p.getDni() != null) {
				pw.println(p.getDni()+","+p.getNombre()+","+p.getEdad()+","+p.getCalle()+","
						+ ""+p.getLocalidad()+","+p.getCodPostal());
				System.out.println("++++++++++++++++++++++++++++++++++++++++\nRegistro de nuevo paciente con "
						+ "dni "+p.getDni()+" ha sido guardado con exito.\n"
								+ "++++++++++++++++++++++++++++++++++++++++");
			
			//Si no es visita y el dni no es recogido por teclado
			} 
			
			else if (esVisita != true && p.getDni() == null) {
				pw.println(p.getDNI()+","+p.getNombre()+","+p.getEdad()+","+p.getCalle()+","
						+ ""+p.getLocalidad()+","+p.getCodPostal());
				System.out.println("++++++++++++++++++++++++++++++++++++++++\nRegistro de nuevo paciente con "
						+ "dni "+p.getDNI()+" ha sido guardado con exito.\n"
								+ "++++++++++++++++++++++++++++++++++++++++");
			
			//Si es visita
			} 
			
			else {
				pw.println("DNI: "+p.getDni()+", Peso: "+p.getPeso()+"Kgs, Altura: "
							+ ""+p.getAltura()+"m, IMC: "+p.calcularIMC());
				System.out.println("++++++++++++++++++++++++++++++++++++++++\nRegistro de visita de paciente con "
						+ "dni "+p.getDni()+" ha sido guardado con exito.\n"
								+ "++++++++++++++++++++++++++++++++++++++++");
			}
			
		} 
		
		catch (Exception e) {
			System.err.println("El fichero 'Pacientes.txt' no existe para la ruta expecificada");
			e.printStackTrace();
			/**
			 * Método para cerrar la edicion del archivo, si el fichero tiene contenido, se cierra, si no,
			 * capturamos la excepción.
			 */
			
		} 
		
		finally {
			try {
				if (null != fichero) {
					fichero.close();
				}
			} 
			
			catch (Exception e2) {
				System.err.println("El fichero 'Pacientes.txt' no existe para la ruta expecificada");
				e2.printStackTrace();
			}
		} 
		// Si el paciente es continuamos registrando la visita inicial
		if (esPacienteNuevo == true && p.getDni() != null) {
			System.out.println("Se procede a registrar la visita inicial");
			visita.registroVisita(p.getDni());
		}
		
		else if (esPacienteNuevo == true && p.getDni() == null) {
			System.out.println("Se procede a registrar la visita inicial");
			visita.registroVisita(p.getDni());
			
		}
		
		else {
			Menu.menuInicial();
		}

	}//grabarCliente
	
	/**
	 * Método de busqueda de DNI en Pacientes
	 * @param dni de tipo String.
	 * @return true o false si el DNI se encuentra en el arrayList de pacientes
	 */
	public static boolean esDniRegistrado (String dni) {
		int posicion = PersonaApp_Scanner.pacientes.size();
		for (int i = 0; i < posicion; i++) {
			if(PersonaApp_Scanner.pacientes.get(i).getDni().equals(dni)){
				return true;
			}
		}
		return false;
	} //esDniRegistrado
	
	/**
	 * Comprobamos si el cliente ha sido registrado en Visitas
	 * @param dni
	 */
	public static boolean esHistorico (String dni) {
		int posicion = PersonaApp_Scanner.visitas.size();
		for (int i = 0; i < posicion; i++) {
			if(PersonaApp_Scanner.visitas.get(i).getDniPaciente().equals(dni)){
				return true;
			}
		}
		return false;
	}//esHistorico

	/**
	 * Comprueba si el formato del dni corresponde al estandar
	 * comparando con un patron que exige 7 u8 cifras y una letra.
	 * @return true o false
	 */
	public static boolean esDniValido(String entrada) {
		Pattern pat = Pattern.compile("[0-9]{7,8}[A-Z]");
		Matcher mat = pat.matcher (entrada);
		return (mat.find());
	}//esDniValido
	
}
