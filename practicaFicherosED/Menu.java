package practicaFicherosED;

import java.util.Scanner;

public class Menu {
	static PersonaApp_Scanner personaApp = new PersonaApp_Scanner();
	static Paciente paciente = new Paciente();
	static Visita visita = new Visita();
	static Profesionales_Medicos medico = new Profesionales_Medicos();
	/**
	 * Método main
	 * @param args
	 */
	public static void main(String[] args) {
		//Acceso a menu inicial
		menuInicial();		
	}//main

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
				+ "\n3.	Historial"
				+ "\n4. Salir.");
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
				visita.registroVisita(null, null);				
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
	
	public static void menuHistorial() {
		boolean esMenu = false;
		do {
		System.out.println("**********************\nMenu Pacientes"
				+ "\n**********************"
				+ "\n1. Consultar historial por medico y paciente"
				+ "\n2. Consultar registro de visitas por fecha"
				+ "\n3. Volver a inicio.");
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
}
