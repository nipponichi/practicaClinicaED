package practicaFicherosED;

import static org.junit.Assert.*;


import org.junit.Test;

public class VisitaTest {

	
	@Test
	public void testHistorialVisitasDni() {
		Configuracion.leerConfiguracion();
		TestConexion.consultaSelectPaciente();
		TestConexion.consultaSelectPersonal();
		TestConexion.consultaSelectVisita();
		Visita instance = new Visita();
		instance.historialVisitasDni();
	}
}
	
	/*
	@Test
	public void testHistorialVisitasDni3A() {
		System.out.print("Comprueba que el patron DNI se Cumpla");
		  assertTrue(TratamientoFichero.esDniValido("AAAAAAA"));
	}
	
	@Test
	public void testHistorialVisitasDni3B() {
		System.out.print("Comprueba que el patron DNI se Cumpla");
		  assertTrue(TratamientoFichero.esDniValido("47878787878787"));
	}
	
	@Test
	public void testHistorialVisitasDni3C() {
		System.out.print("Comprueba que el patron DNI se Cumpla");
		  assertTrue(TratamientoFichero.esDniValido("48484"));
	}
	
	@Test
	public void testHistorialVisitasDni3D() {
		System.out.print("Comprueba que el patron DNI se Cumpla");
		  assertTrue(TratamientoFichero.esDniValido("48556729A"));
	}
*/
		
	/*
	
	@Test
	public void testHistorialVisitasDni1() {
		System.out.print("Comprueba el Registro en ArrayList y Base de Datos");
		
		Configuracion.leerConfiguracion();
		TestConexion.consultaSelectPaciente();
		TestConexion.consultaSelectPersonal();
		TestConexion.consultaSelectVisita();
		
		String dni="48556729K";

		boolean esDniRegistrado;
	
		esDniRegistrado = TratamientoFichero.esDniRegistrado(dni);
		assertTrue(esDniRegistrado);	
	}
	
	
}*/