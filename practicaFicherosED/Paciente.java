package practicaFicherosED;

import java.util.Scanner;

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
			System.out.println("Inserte el dni del paciente: ");
		
			Scanner scDni = new Scanner(System.in);
			dni = scDni.nextLine().toUpperCase();
		
			esDniValido = TratamientoFichero.esDniValido(dni);
		
			if (esDniValido) {
					esDniRegistrado = TratamientoFichero.esDniRegistrado(dni);
					if (esDniRegistrado) {
						System.out.println("El paciente ya se encuentra en "
								+ "nuestro registro de pacientes.");
						Menu.menuPacienteRegistrado(dni);
					}
			}
		
			if (!esDniValido) {
				System.out.println("El dni introducido no es valido");
			}
		}while (!esDniValido && !esDniRegistrado);
		
		System.out.println("Introduzca el nombre");
		Scanner scNombre = new Scanner(System.in);
		String nombre = scNombre.nextLine();
		
		System.out.println("Introduzca la edad");
		Scanner scEdad = new Scanner(System.in);
		int edad = scEdad.nextInt();
		PersonaApp_Scanner.MuestraMensajeEdad(edad);
			
		System.out.println("Introduzca el sexo");
		Scanner scSexo = new Scanner(System.in);
		char sexo = scSexo.nextLine().charAt(0);
		persona.comprobarSexo(sexo);
		String sexoStr = persona.determinarSexo(Character.toString(sexo));
		
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
				codPostal,dni, sexoStr);
		PersonaApp_Scanner.pacientes.add(paciente);
		visita.registroVisita(dni);
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
	    for (int i = 0; i < posicion; i++) {
	        Paciente paciente = PersonaApp_Scanner.pacientes.get(i);
	        if (paciente.getDni().equals(dni)) {
	            return paciente; // Retorna el paciente encontrado con el mismo DNI
	        }
	    }
	    return null;
	}//selectorPaciente
	
	/**
	 * Método
	 */
	@SuppressWarnings("resource")
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
					visita.registroVisita(null);
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
}//Paciente
