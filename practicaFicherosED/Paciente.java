package practicaFicherosED;

import java.util.Scanner;

public class Paciente extends Persona {
	private String calle;
	private String localidad;
	private String codPostal;
	private String dni;	
	
	public Paciente () {
		
	}
	
	public Paciente (String nombre, int edad, String calle, String localidad,
			String codPostal) {
		this.nombre = nombre;
		this.edad = edad;
		this.calle = calle;
		this.localidad = localidad;
		this.codPostal = codPostal;
	}
	
	public Paciente (String nombre, int edad, String calle, String localidad,
			String codPostal, String dni) {
		this.nombre = nombre;
		this.edad = edad;
		this.calle = calle;
		this.localidad = localidad;
		this.codPostal = codPostal;
		this.dni = dni;
	}
	
	public Paciente (String nombre, int edad, String calle, String localidad,
			String codPostal, String dni, double peso,
			 double altura) {
		this.nombre = nombre;
		this.edad = edad;
		this.calle = calle;
		this.localidad = localidad;
		this.codPostal = codPostal;
		this.dni = dni;
		this.nombre = nombre;
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
		String dni;
		
		System.out.println("********************************\n"
				+ "Introduce datos de nuevo paciente"
				+ "\n********************************");
		
		do {
			System.out.println("Inserte el dni del paciente: ");
		
			Scanner scDni = new Scanner(System.in);
			dni = scDni.nextLine().toUpperCase();
		
			esDniValido = TratamientoFichero.esDniValido(dni);
		
			if (esDniValido == true) {
					esDniRegistrado = TratamientoFichero.esDniRegistrado(dni);
					if (esDniRegistrado == true) {
						System.out.println("El paciente ya se encuentra en "
								+ "nuestro registro de pacientes.");
					}
			}
		
			if (esDniValido == false) {
				System.out.println("El dni introducido no es valido");
			}
		}while (esDniValido == false && esDniRegistrado == false);
		
		System.out.println("Introduzca el nombre");
		Scanner scNombre = new Scanner(System.in);
		String nombre = scNombre.nextLine();
		
		System.out.println("Introduzca la edad");
		Scanner scEdad = new Scanner(System.in);
		int edad = scEdad.nextInt();
		PersonaApp_Scanner.MuestraMensajeEdad(edad);
		
		System.out.println("Introduzca la calle");
		Scanner scCalle = new Scanner(System.in);
		String calle = scCalle.nextLine();

		System.out.println("Introduzca la localidad");
		Scanner scLocalidad = new Scanner(System.in);
		String localidad = scLocalidad.nextLine();
		
		System.out.println("Introduzca el codigo postal");
		Scanner scCodPostal = new Scanner(System.in);
		String codPostal = scCodPostal.nextLine();
		
		/**
		 * Objeto paciente con parámetros 
		 * de nuevo paciente.
		 */
		Paciente paciente = new Paciente(nombre, edad, calle, localidad,
				codPostal,dni);
		visita.registroVisita(dni, paciente);
	}//registroPaciente

	/**
	 * Método para mostrar historial de visitas de paciente por consola
	 */
	@SuppressWarnings("resource")
	public void historialPaciente() {
		boolean esDniValido;
		boolean esDniRegistrado;
		String dni;
		do {
		System.out.println("Inserte el dni del paciente: ");
		
		Scanner scDni = new Scanner(System.in);
		dni = scDni.nextLine().toUpperCase();
		
		esDniValido = TratamientoFichero.esDniValido(dni);
		esDniRegistrado = TratamientoFichero.esDniRegistrado(dni);
		
		if (esDniValido == false) {
			System.out.println("El dni introducido no es valido");
		} else {
			
			if (esDniRegistrado == true) {
				System.out.println("*******************************\n"
						+ "Historial de paciente con Dni "+dni+":\n"
						+ "Para valor IMC:(-1) Infrapeso | (0) "
						+ "Normopeso | (1) Sobrepeso\n");
				TratamientoFichero.esHistorico(dni);

			} else {
				System.out.println("El dni introducido no se"
						+ "encuentra en el registro de visitas");
			}
		}
		} while (esDniValido == false || esDniRegistrado == false);	
	}//historialPaciente
	
	public Paciente selectorPaciente(String dni) {
	    int posicion = PersonaApp_Scanner.pacientes.size();
	    Paciente paciente = null;
	    for (int i = 0; i < posicion; i++) {
	        if (PersonaApp_Scanner.pacientes.get(i).getDni().equals(dni)) {
	            paciente = PersonaApp_Scanner.pacientes.get(i);
	            break;
	        }
	    }
	    return paciente;
	}//selectorPaciente
	
	public void registroAuxiliar() {
		Visita visita = new Visita();
		boolean esMenu = false;
		do {
			System.out.println("El DNI introducido no se encuentra\n"
					+ "entre nuestros registros.\n"
					+ "Desea registrar a un nuevo paciente?"
					+ "\n1. Si"
					+ "\n2. No, volver a introducir DNI"
					+ "\n3. Volver a menu inicial");
	
			Scanner opcionRegistro = new Scanner(System.in);
			int seleccionRegistro = opcionRegistro.nextInt();
			switch (seleccionRegistro) {
				case 1:
					registroPaciente();
					break;
				case 2:
					visita.registroVisita(null,null);
					break;
				case 3:
					Menu.menuInicial();
					break;
				default:
					esMenu = true;
					System.out.println("Opcion no valida\n por favor,"
							+ "seleccione una opcion entre las disponibles");
					break;
			}
	
		} while (esMenu == true);
	}//registroVisita
}
