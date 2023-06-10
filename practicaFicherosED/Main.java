package practicaFicherosED;

public class Main {

	/**
	 * Método main donde realizamos la carga de ArrayList desde BBDD y lanzamos el menu inicial 
	 * @param args
	 */
	public static void main(String[] args) {
		Configuracion.leerConfiguracion();
		TestConexion.consultaSelectPaciente();
		TestConexion.consultaSelectPersonal();
		TestConexion.consultaSelectVisita();
		Menu.menuInicial();		
	}//main

}
