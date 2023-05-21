package practicaFicherosED;

import org.junit.Test;
import static org.junit.Assert.*;


public class Profesionales_MedicosTest {
    
    Profesionales_Medicos medico1= new Profesionales_Medicos();
	Profesionales_Medicos medico2= new Profesionales_Medicos();
    
    public Profesionales_MedicosTest() {
    }


    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        Profesionales_Medicos instance = new Profesionales_Medicos();
        instance.setCodigo(002);
        int resultadoEsperado = 001;
        int resultado = instance.getCodigo();
        assertEquals(resultadoEsperado, resultado);
        
    }
    
    

    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        int codigo = 002;
        Profesionales_Medicos instance = new Profesionales_Medicos();
        instance.setCodigo(codigo);
        //assertEquals(resultadoEsperado, resultado);
    }

  
    
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Profesionales_Medicos instance = new Profesionales_Medicos();
        String resultadoEsperado = "Juan Manuel";
        instance.setNombre("Juan");
        String resultado = instance.getNombre();
        assertEquals(resultadoEsperado, resultado);
        
    }

  
    
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "Maria";
        Profesionales_Medicos instance = new Profesionales_Medicos();
        instance.setNombre(nombre);
    }

    
    
    @Test
    public void testGetApellidos() {
        System.out.println("getApellidos");
        Profesionales_Medicos instance = new Profesionales_Medicos();
        String resultadoEsperado = "Blanca";
        instance.setApellidos("Blanco");
        String resultado = instance.getApellidos();
        assertEquals(resultadoEsperado, resultado);
       
    }

    
    
    
    @Test
    public void testSetApellidos() {
        System.out.println("setApellidos");
        String apellidos = "Romero";
        Profesionales_Medicos instance = new Profesionales_Medicos();
        instance.setApellidos(apellidos);
        
    }

    @Test
    public void testGetDni() {
        System.out.println("getDni");
        Profesionales_Medicos instance = new Profesionales_Medicos();
        String resultadoEsperado = "12131314B";
        instance.setDni("12131313B");
        String resultado = instance.getDni();
        assertEquals(resultadoEsperado, resultado);
        
    }
    
    @Test
    public void testSetDni() {
        System.out.println("setDni");
        String dni = "48567898A";
        Profesionales_Medicos instance = new Profesionales_Medicos();
        instance.setDni(dni);
    }


    @Test
    public void testGetLocalidad() {
        System.out.println("getLocalidad");
        Profesionales_Medicos instance = new Profesionales_Medicos();
        String resultadoEsperado = "Leganes";
        instance.setLocalidad("Madrid");
        String resultado = instance.getLocalidad();
        assertEquals(resultadoEsperado, resultado);
        
    }


    @Test
    public void testSetLocalidad() {
        System.out.println("setLocalidad");
        String localidad = "Madrid";
        Profesionales_Medicos instance = new Profesionales_Medicos();
        instance.setLocalidad(localidad);
      
    }


    @Test
    public void testGetTelefono() {
        System.out.println("getTelefono");
        Profesionales_Medicos instance = new Profesionales_Medicos();
        String resultadoEsperado = "686848485";
        instance.setTelefono("686848484");
        String resultado = instance.getTelefono();
        assertEquals(resultadoEsperado, resultado);
        
    }

    @Test
    public void testSetTelefono() {
        System.out.println("setTelefono");
        String telefono = "684887851";
        Profesionales_Medicos instance = new Profesionales_Medicos();
        instance.setTelefono(telefono);
    
    }

    @Test
    public void testGetEspecialidad() {
        System.out.println("getEspecialidad");
        Profesionales_Medicos instance = new Profesionales_Medicos();
        String resultadoEsperado = "Medicina General";
        instance.setEspecialidad("Medicina Pediatrica");
        String resultado = instance.getEspecialidad();
        assertEquals(resultadoEsperado, resultado);
      
    }

    @Test
    public void testSetEspecialidad() {
        System.out.println("setEspecialidad");
        String especialidad = "Medicina General";
        Profesionales_Medicos instance = new Profesionales_Medicos();
        instance.setEspecialidad(especialidad);
        
    }
	/*
	@Test
	public void registroPersonal1() {
		System.out.print("Verificacion de Clase Not Null");
	   // medico1= new Profesionales_Medicos(001,"Andrea","Monterrey Blanco","58844544V","Madrid","689842145","Medicina General");
	    assertNotNull(medico1);
	}

	
	
	
	
	@Test
	public void registroPersonal2() {
		System.out.print("Test de Control Duplicado ");
	    medico1= new Profesionales_Medicos(001,"Andrea","Monterrey Blanco","58844544V","Madrid","689842145","Medicina General");
	    medico2= new Profesionales_Medicos(001,"Andrea","Monterrey Blanco","58844544V","Madrid","689842145","Medicina General");
	    PersonaApp_Scanner.medicos.add(medico1);
	    PersonaApp_Scanner.medicos.add(medico2);
	    assertEquals(medico1,medico2);
	}

	
	
	

	@Test
	public void registroPersonal3() {
		System.out.print("Prueba Completa");
		Configuracion.leerConfiguracion();
		TestConexion.consultaSelectPersonal();
		medico1= new Profesionales_Medicos(001,"Andrea","Monterrey Blanco","58844544V","Madrid","689842145","Medicina General");
		PersonaApp_Scanner.medicos.add(medico1);
		medico1.asignarMedico();
	//devuelve true porque todos los valores son correctos
	}
	
	
    @Test
	public void registroPersonal() {
		Configuracion.leerConfiguracion();
		TestConexion.consultaSelectPaciente();
		TestConexion.consultaSelectPersonal();
		TestConexion.consultaSelectVisita();
		Profesionales_Medicos instance = new Profesionales_Medicos();
		instance.registroPersonal();
	}*/
	
}

