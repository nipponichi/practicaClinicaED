package practicaFicherosED;

import java.util.Scanner;

public class Menu {
	static PersonaApp_Scanner personaApp = new PersonaApp_Scanner();
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
				+ "\n1. Registrar nuevo paciente"
				+ "\n2. Registrar nueva visita"
				+ "\n3. Mostrar historial de paciente"
				+ "\n4. Salir.");
		Scanner scSeleccion = new Scanner(System.in);
		int seleccion = scSeleccion.nextInt();
		switch(seleccion){
			case 1:
				personaApp.registroPaciente(null, false, true);
				break;
			case 2:
				personaApp.registroVisita(null);				
				break;
			case 3:
				personaApp.historialPaciente();
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
}
