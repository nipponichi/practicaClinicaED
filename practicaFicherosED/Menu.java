package practicaFicherosED;

import java.util.Scanner;

public class Menu {
	static Paciente paciente = new Paciente();
	static Visita visita = new Visita();
	static Profesionales_Medicos medico = new Profesionales_Medicos();
	static TestConexion testConexion = new TestConexion();
	static Configuracion configuracion = new Configuracion();
	private static final String PASSWORD = "1234"; 

	/**
	* Menu inicial, estrutura switch en la que
	* dirigimos al usuario entre las diferentes
	* opciones del software. 
	*/
	public static void menuInicial() {
		boolean esMenu = false;
		do {
		System.out.println("**********************\nSelecciona una opcion"
				+ "\n**********************"
				+ "\n1. Pacientes"
				+ "\n2. Personal"
				+ "\n3. Historial"
				+ "\n4. Configuracion"
				+ "\n5. Salir.");
		Scanner scSeleccion = new Scanner(System.in);
		int seleccion = scSeleccion.nextInt();
		switch(seleccion){
			case 1:
				menuPaciente();
				break;
			case 2:
				menuPersonal();				
				break;
			case 3:
				menuHistorial();
				break;
			case 4:
				System.out.println("Acceso restringido."
						+ " Inserte password (1234)");
				Scanner scPass = new Scanner(System.in);
				String usuarioPass = scPass.nextLine();
				if (usuarioPass.equals(PASSWORD)) {
					menuConfiguracion();
					} else {
					System.out.println("Acceso denegado");		
				}
				break;	
			case 5:
				System.out.println("Gracias por utilizar nuestro software");
				System.exit(0);
				break;
			default:
				esMenu = true;
				System.out.println("Opcion no valida\n por favor,"
						+ " seleccione una opcion entre las disponibles");
				break;
			}
		scSeleccion.close();
	} while (esMenu == true);
	}//menuInicial
	
	public static void menuPaciente() {
		boolean esMenu = false;
		do {
		System.out.println("**********************\nMenu Pacientes"
				+ "\n**********************"
				+ "\n1. Registrar nuevo paciente"
				+ "\n2. Registrar nueva visita"
				+ "\n3. Volver a inicio.");
		Scanner scSeleccion = new Scanner(System.in);
		int seleccion = scSeleccion.nextInt();
		switch(seleccion){
			case 1:
				paciente.registroPaciente();
				break;
			case 2:
				visita.registroVisita(null);				
				break;
			case 3:
				menuInicial();
				break;
			default:
				esMenu = true;
				System.out.println("Opcion no valida\n por favor,"
						+ " seleccione una opcion entre las disponibles");
				break;
			}
		scSeleccion.close();
	} while (esMenu == true);
	}//menuPaciente
	
	
	/**
	 * Submenú que nos permite registrar un nuevo miembro del personal de la clínica
	 */
	public static void menuPersonal() {
		boolean esMenu = false;
		do {
		System.out.println("**********************\nMenu Pacientes"
				+ "\n**********************"
				+ "\n1. Registrar nuevo personal medico"
				+ "\n2. Volver a inicio.");
		Scanner scSeleccion = new Scanner(System.in);
		int seleccion = scSeleccion.nextInt();
		switch(seleccion){
			case 1:
				medico.registroPersonal();
				break;
			case 2:
				menuInicial();
				break;
			default:
				esMenu = true;
				System.out.println("Opcion no valida\n por favor,"
						+ " seleccione una opcion entre las disponibles");
				break;
			}
		scSeleccion.close();
	} while (esMenu == true);
	}//menuPersonal	
	
	/**
	 * Submenú que nos permite listar visitas de dos maneras:
	 * 1 - Seleccionando DNI de paciente y doctor del listado
	 * 2 - Introduciendo una fecha por consola y seleccionado un doctor del listado
	 */
	public static void menuHistorial() {
		boolean esMenu = false;
		do {
		System.out.println("**********************\nMenu Historiales"
				+ "\n**********************"
				+ "\n1. Consultar historial por medico y paciente"
				+ "\n2. Consultar registro de visitas por fecha"
				+ "\n3. Volver a inicio.");
		Scanner scSeleccion = new Scanner(System.in);
		int seleccion = scSeleccion.nextInt();
		switch(seleccion){
			case 1:
				visita.historialVisitasDni();
				break;
			case 2:
				visita.historialVisitasFecha();
				break;
			case 3:
				menuInicial();
				break;
			default:
				esMenu = true;
				System.out.println("Opcion no valida\n por favor,"
						+ " seleccione una opcion entre las disponibles");
				break;
			}
		scSeleccion.close();
	} while (esMenu == true);
	}
	
	/**
	 * Submenú cargado tras dar de alta a un profesional, podemos elegir entre dar de alta
	 * a mas personal de la clínica o volver al menú inicial.
	 */
	public static void menuContinuar() {
		boolean esMenu = false;
		do {
		System.out.println("**********************\nMenu Personal"
				+ "\n**********************"
				+ "\n1. Dar de alta a otro profesional"
				+ "\n2. Volver a inicio.");
		Scanner scSeleccion = new Scanner(System.in);
		int seleccion = scSeleccion.nextInt();
		switch(seleccion){
			case 1:
				medico.registroPersonal();
				break;
			case 2:
				menuInicial();
				break;
			default:
				esMenu = true;
				System.out.println("Opcion no valida\n por favor,"
						+ " seleccione una opcion entre las disponibles");
				break;
			}
		scSeleccion.close();
	} while (esMenu == true);
	}
	
	/**
	 * submenú que tras identificar que el dni introducido ya se encuentra en nuestro registro,
	 * nos da la opción directa de registrar una nueva visita para el paciente.
	 * @param dni
	 */
	public static void menuPacienteRegistrado(String dni) {
		boolean esMenu = false;
		do {
		System.out.println("**********************\nQue desea hacer?"
				+ "\n**********************"
				+ "\n1. Registrar nueva visita para este paciente"
				+ "\n2. Volver a inicio.");
		Scanner scSeleccion = new Scanner(System.in);
		int seleccion = scSeleccion.nextInt();
		switch(seleccion){
			case 1:
				visita.registroVisita(dni);
				break;
			case 2:
				menuInicial();
				break;
			default:
				esMenu = true;
				System.out.println("Opcion no valida\n por favor,"
						+ " seleccione una opcion entre las disponibles");
				break;
			}
		scSeleccion.close();
	} while (esMenu == true);
	}
	
	/**
	 * submenú que tras no identificar el dni introducido en nuestro registro, nos permite
	 * saltar directamente al menú de registro de nuevos pacientes para poder tramitar la visita
	 * posteriormente.
	 */
	public static void menuPacienteNoRegistrado() {
		boolean esMenu = false;
		do {
		System.out.println("**********************\nQue desea hacer?"
				+ "\n**********************"
				+ "\n1. Registrar nuevo paciente"
				+ "\n2. Volver a inicio.");
		Scanner scSeleccion = new Scanner(System.in);
		int seleccion = scSeleccion.nextInt();
		switch(seleccion){
			case 1:
				paciente.registroPaciente();
				break;
			case 2:
				menuInicial();
				break;
			default:
				esMenu = true;
				System.out.println("Opcion no valida\n por favor,"
						+ " seleccione una opcion entre las disponibles");
				break;
			}
		scSeleccion.close();
	} while (esMenu == true);
	}
	
	/**
	 * Menú de configuración que nos facilita la edición del fichero configurarion.txt
	 * para asignar nuevas credenciales de acceso a la base de datos.
	 * Este menú requiere contraseña para acceder, salvo si el programa detecta un error de credenciales
	 * al iniciar, ya que entiende que es el primer arranque del programa y estas credenciales necesitan
	 * ser configuradas.
	 */
	public static void menuConfiguracion() {

		boolean esMenu = false;
		do {
		System.out.println("**********************\nMenu Configuracion"
				+ "\n**********************"
				+ "\n1. Configurar campos"
				+ "\n2. Volver a inicio.");
		Scanner scSeleccion = new Scanner(System.in);
		int seleccion = scSeleccion.nextInt();
		switch(seleccion){
			case 1:
				configuracion.guardarConfiguracion();
				break;
			case 2:
				menuInicial();
				break;
			default:
				esMenu = true;
				System.out.println("Opcion no valida\n por favor,"
						+ " seleccione una opcion entre las disponibles");
				break;
			}
		scSeleccion.close();
	} while (esMenu == true);	

	}
}
