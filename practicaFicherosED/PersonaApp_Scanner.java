package practicaFicherosED;

/**
 * Librerías requeridas
 */

import java.util.ArrayList;

public class PersonaApp_Scanner {
	static ArrayList <Paciente> pacientes = new ArrayList <Paciente>();
	static ArrayList <Visita> visitas = new ArrayList <Visita>();
	static ArrayList <Profesionales_Medicos> medicos = new ArrayList <Profesionales_Medicos>();
	

	
	/**
	 * Este método determina el mensaje a mostrar en pantalla<br>
	 * referente al IMC del objeto persona.
	 * @param p objeto Paciente
	 * @return 
	 */
	public static String MuestraMensajePeso(Paciente p) {
	    int IMC = p.calcularIMC();
	    String resultado = "";
	    switch (IMC) {
	        case Paciente.PESO_IDEAL:
	            resultado = "Normopeso";
	            break;
	        case Paciente.INFRAPESO:
	            resultado = "Infrapeso";
	            break;
	        case Paciente.SOBREPESO:
	            resultado = "Sobrepeso";
	            break;
	    }
	    return resultado;
	} //MuestraMensajePeso
	
	/**
	 * Este método determina el mensaje a mostrar en pantalla
	 * referente a la mayoria de edad de la persona.
	 * @param p objeto Paciente
	 */
	public static void MuestraMensajeEdad(int edad) {
		Paciente p = new Paciente("", edad, "", "",
				"");
		boolean mayoriaEdad = p.esMayorDeEdad();
		
		if (mayoriaEdad == true) {
			System.out.println("--------------------\nLa persona "
					+ "es mayor de edad\n"
					+ "--------------------");
		} else {
			System.out.println("--------------------\nLa persona "
					+ "es menor de edad\n"
					+ "--------------------");
		}
	}//MuestraMensajeEdad
	
}
