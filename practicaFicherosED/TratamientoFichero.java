package practicaFicherosED;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TratamientoFichero {
	static PersonaApp_Scanner personaApp = new PersonaApp_Scanner();
	static Paciente paciente = new Paciente();
	static Visita visita = new Visita();
	static Profesionales_Medicos medico = new Profesionales_Medicos();
	
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
