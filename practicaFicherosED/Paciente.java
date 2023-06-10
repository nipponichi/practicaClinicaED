package practicaFicherosED;

import java.util.Scanner;

/**
 * Clase Paciente, heredera de Persona.
 * @author Javier
 *
 */
public class Paciente extends Persona {
	private String calle;
	private String codPostal;
	private String dni;	
	
	public Paciente () {
		
	}
	
	public Paciente (String nombre, int edad, String calle, String localidad,
			String codPostal, String dni, String sexo) {
		this.nombre = nombre;
		this.edad = edad;
		this.calle = calle;
		this.localidad = localidad;
		this.codPostal = codPostal;
		this.dni = dni;
		this.sexo = sexo;
	}
	
	public Paciente (String nombre, int edad, String calle, String localidad,
			String codPostal, String dni, String sexo, double peso, double altura) {
		this.nombre = nombre;
		this.edad = edad;
		this.calle = calle;
		this.localidad = localidad;
		this.codPostal = codPostal;
		this.dni = dni;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}
	
	public Paciente (double peso,
			 double altura) {
		this.peso = peso;
		this.altura = altura;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	/**
	 * Registro de nuevos pacientes,
	 * campos requeridos por teclado:
	 * DNI, nombre, edad, calle, localidad, cod_postal
	 */
	@SuppressWarnings("resource")
	public void registroPaciente() {
		boolean esDniRegistrado = false, esDniValido;
		Visita visita = new Visita();
		Persona persona = new Persona();
		String dni = null;
		
		System.out.println("********************************\n"
				+ "Introduce datos de nuevo paciente"
				+ "\n********************************");
		
		do {
		    System.out.println("Inserte el DNI del paciente: ");

		    Scanner scDni = new Scanner(System.in);
		    dni = scDni.nextLine().toUpperCase();

		    esDniValido = TratamientoFichero.esDniValido(dni);
		    esDniRegistrado = TratamientoFichero.esDniRegistrado(dni);

		    if (!esDniValido) {
		        System.out.println("El DNI introducido no es válido");
		    } else if (esDniRegistrado) {
		        System.out.println("El DNI introducido ya se encuentra registrado en nuestro sistema");
		        Menu.menuPacienteRegistrado(dni);
		    }

		} while (!esDniValido && esDniRegistrado);
		
		System.out.println("Introduzca el nombre");
		Scanner scNombre = new Scanner(System.in);
		String nombre = scNombre.nextLine();
		
		System.out.println("Introduzca la edad");
		Scanner scEdad = new Scanner(System.in);
		int edad = scEdad.nextInt();
		PersonaApp_Scanner.MuestraMensajeEdad(edad);
			
		System.out.println("Introduzca el sexo");
		Scanner scSexo = new Scanner(System.in);
		char sexo = scSexo.nextLine().toUpperCase().charAt(0);
		persona.comprobarSexo(sexo);
		String sexoStr = persona.determinarSexo(sexo);
		//System.out.println(sexoStr);
		
		System.out.println("Introduzca la calle");
		Scanner scCalle = new Scanner(System.in);
		String calle = scCalle.nextLine();

		System.out.println("Introduzca la localidad");
		Scanner scLocalidad = new Scanner(System.in);
		String localidad = scLocalidad.nextLine();
		
		System.out.println("Introduzca el codigo postal");
		Scanner scCodPostal = new Scanner(System.in);
		String codigoPostal = scCodPostal.nextLine();
		
		/**
		 * Objeto paciente con parámetros 
		 * de nuevo paciente.
		 */
		Paciente paciente = new Paciente(nombre, edad, calle, localidad,
				codPostal,dni, sexoStr);
		TestConexion.consultaInsertPaciente(nombre, edad, calle, localidad, codigoPostal, dni, sexoStr, 0.1, 0.1);
		PersonaApp_Scanner.pacientes.add(paciente);
		visita.registroVisita(dni);
	}//registroPaciente
	
	/**
	 * Método para seleccionar un paciente tras introducir el dni por teclado
	 * @param dni
	 * @return
	 */
	public Paciente selectorPaciente(String dni) {
	    int posicion = PersonaApp_Scanner.pacientes.size();
	    for (int i = 0; i < posicion; i++) {
	        Paciente paciente = PersonaApp_Scanner.pacientes.get(i);
	        if (paciente.getDni().equals(dni)) {
	            return paciente; // Retorna el paciente encontrado con el mismo DNI
	        }
	    }
	    return null;
	}//selectorPaciente
	
}//Paciente
