package practicaFicherosED;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Visita {
	private Date fecha;
	private Date hora;
	private String dniDoctor;
	private String dniPaciente;
	private String resultado;

	public Visita() {
		
	}
	
	public Visita(Date fecha, Date hora, String dniDoctor, String dniPaciente, 
			String resultado) {
		this.fecha = fecha;
		this.hora = hora;
		this.dniDoctor = dniDoctor;
		this.dniPaciente = dniPaciente;
		this.resultado = resultado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public String getDniDoctor() {
		return dniDoctor;
	}

	public void setDniDoctor(String dniDoctor) {
		this.dniDoctor = dniDoctor;
	}

	public String getDniPaciente() {
		return dniPaciente;
	}

	public void setDniPaciente(String dniPaciente) {
		this.dniPaciente = dniPaciente;
	}
	
	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	/**
	 * Registro de nuevas visitas,
	 * campos requeridos:
	 * DNI, fecha de la consulta, hora de la consulta, peso, unidad de
	 * peso, altura, unidad de altura, resultado de calcular el IMC.
	 */
	@SuppressWarnings("resource")
	public void registroVisita(String dniPaciente) {
		
		Profesionales_Medicos medico = new Profesionales_Medicos();
		Paciente paciente = new Paciente();
		
		boolean esDniValido = false, esDniRegistrado = false;
		Visita visita;
		String dniDoctor;
		String resultado;
		
		
		if (dniPaciente == null) {

			System.out.println("********************************\n"
					+ "Registro de nueva visita"
					+ "\n********************************");
		
			do {
			    System.out.println("Inserte el dni del paciente: ");
			  
			    Scanner scDni = new Scanner(System.in);
			    dniPaciente = scDni.nextLine().toUpperCase();
			  
			    esDniValido = TratamientoFichero.esDniValido(dniPaciente);
			    esDniRegistrado = TratamientoFichero.esDniRegistrado(dniPaciente);
			  
			    if (!esDniValido) {
			        System.out.println("El dni introducido no es valido");
			    } else if (!esDniRegistrado) {
			    	System.out.println("El dni introducido no se encuentra en"
			    			+ " nuestro registro");
			    	Menu.menuPacienteNoRegistrado();
			    } else {	
			        paciente = paciente.selectorPaciente(dniPaciente);
			    }
			} while (!esDniValido || !esDniRegistrado);
		} else {
			paciente = paciente.selectorPaciente(dniPaciente);
		}
			System.out.println("Introduzca el peso en kilogramos");
			Scanner scPeso = new Scanner(System.in);
			double peso = scPeso.nextDouble();
			
			System.out.println("Inserte la altura en metros");
			Scanner scAltura = new Scanner(System.in);
			double altura = scAltura.nextDouble();
			
			Date fecha = new Date();
			Date hora = new Date();
			SimpleDateFormat sdfFecha = new SimpleDateFormat("dd/MM/YYYY");
			SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
			String fechaStr = sdfFecha.format(fecha);
			String horaStr = sdfHora.format(hora);
			dniDoctor = medico.asignarMedico();
			resultado = PersonaApp_Scanner.MuestraMensajePeso(paciente);
			TestConexion.consultaInsertVisita(fechaStr, horaStr, dniPaciente, dniDoctor, resultado);
			/**
			 * Declaracion objeto Paciente 
			 * para guardar visitas.
			 */
			visita = new Visita(fecha, hora, dniDoctor,dniPaciente, resultado);
			
			//Actualizamos objeto paciente con peso y altura
			paciente.setPeso(peso);
			paciente.setAltura(altura);
			
			TestConexion.consultaUpdatePaciente(dniPaciente, peso, altura);
			
			PersonaApp_Scanner.pacientes.add(paciente);
			System.out.println("Dni: "+paciente.getDni() + " Nombre: "+paciente.getNombre()
				+" peso: "+paciente.getPeso() + " Altura: " + paciente.getAltura());
			PersonaApp_Scanner.visitas.add(visita);
			Menu.menuInicial();
			//Mostramos el resultado de la visita
			
			
			//Guardamos la visita en fichero Visitas.txt
			//TratamientoFichero.grabarCliente(pacienteVisita,esVisita, esPacienteNuevo);
		
	}//registroVisita
	/**
	 * 
	 */
	@SuppressWarnings("resource")
	public void historialVisitasFecha() {
		Profesionales_Medicos medico = new Profesionales_Medicos();
		Visita visita = new Visita();
		SimpleDateFormat sdfFecha = new SimpleDateFormat("dd/MM/yyyy"); 
		SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm"); 
		String fechaStr = "";
		boolean fechaOk = false;

		do {
		    System.out.println("Introduzca una fecha (dd/mm/aaaa): ");
		  
		    try {
		    	Scanner scFecha = new Scanner(System.in);
		    	fechaStr = scFecha.nextLine();
		    	fecha = sdfFecha.parse(fechaStr);
		        
		        for (int i = 0; i < PersonaApp_Scanner.visitas.size(); i++) {
		        	visita = PersonaApp_Scanner.visitas.get(i);
		        	if (sdfFecha.format(visita.getFecha()).equals(fechaStr)){
		        		fechaOk = true;
		        		break;
		        	} else {
		        		System.out.println("La fecha introducida no se encuentra entre"
		        				+ " nuestros registros de visitas.");
		        	}
		        }        
		    } catch (ParseException e) {
		        System.out.println("El formato de fecha ha de ser (dd/mm/aaaa)");
		    }	
		} while(!fechaOk);
		
    	int opcion;
        do {
            System.out.println("Seleccione un Doctor del listado:");
            for (int i = 0; i <PersonaApp_Scanner.medicos.size(); i++) {
            	System.out.println((i + 1) + ". " + PersonaApp_Scanner.medicos.get(i).getApellidos());
            }
            System.out.println("0. Salir");
            Scanner scOpcion = new Scanner(System.in);
            opcion = scOpcion.nextInt();

            if (opcion >= 1 && opcion <= PersonaApp_Scanner.medicos.size()) {
                medico = PersonaApp_Scanner.medicos.get(opcion - 1);
                System.out.println("Ha seleccionado al Dr. " + medico.getApellidos());
                break;
            } else if (opcion != 0) {
                System.out.println("Opcion no valida. Intentelo de nuevo.");
            } else if (opcion == 0) {
            	Menu.menuHistorial();
            }
        } while (opcion != 0);
		String dniDoctorSeleccionado = medico.getDni();
		System.out.println("Listado de visitas de pacientes durante " 
		        + fechaStr 
		        + " para Dr. " + medico.getApellidos());
		        
		for (int i = 0; i < PersonaApp_Scanner.visitas.size(); i++) {
		    visita = PersonaApp_Scanner.visitas.get(i);
		    
		    if (sdfFecha.format(visita.getFecha()).equals(fechaStr)){
		        
		        if (visita.getDniDoctor().equals(dniDoctorSeleccionado)) {
		            System.out.println((i + 1) 
		                + ". Fecha: " + sdfFecha.format(visita.getFecha()) 
		                + " Hora: " + sdfHora.format(visita.getFecha()) 
		                + " Paciente: " + visita.getDniPaciente()
		                + " Resultado: " + visita.getResultado());
		        }
		    }
		}
		Menu.menuHistorial();
	}
	
	/**
	 * 
	 */
	@SuppressWarnings("resource")
	public void historialVisitasDni() {
		Paciente paciente = new Paciente();
		Profesionales_Medicos medico = new Profesionales_Medicos();
		String dni;
		boolean esDniValido,esDniRegistrado;
		SimpleDateFormat sdfFecha = new SimpleDateFormat("dd/MM/yyyy"); 
		SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm"); 
		
		do {
		    System.out.println("Inserte el dni del paciente: ");
		  
		    Scanner scDni = new Scanner(System.in);
		    dni = scDni.nextLine().toUpperCase();
		  
		    esDniValido = TratamientoFichero.esDniValido(dni);
		    esDniRegistrado = TratamientoFichero.esDniRegistrado(dni);
		  
		    if (!esDniValido) {
		        System.out.println("El dni introducido no es valido");
		    } else if (!esDniRegistrado) {
		    	System.out.println("El dni introducido no se encuentra en"
		    			+ " nuestro registro");
		    	Menu.menuPacienteNoRegistrado();
		    } else {	
		        paciente = paciente.selectorPaciente(dni);
		        System.out.println("Se ha seleccionado al paciente "
		        + paciente.getNombre()
		        +" con DNI: "+ paciente.getDni());
		    }
		} while (!esDniValido || !esDniRegistrado);
		
    	int opcion;
        do {
            System.out.println("Seleccione un Doctor del listado:");
            for (int i = 0; i <PersonaApp_Scanner.medicos.size(); i++) {
                System.out.println((i + 1) + ". " + PersonaApp_Scanner.medicos.get(i).getApellidos());
            }
            System.out.println("0. Salir");
            Scanner scOpcion = new Scanner(System.in);
            opcion = scOpcion.nextInt();

            if (opcion >= 1 && opcion <= PersonaApp_Scanner.medicos.size()) {
                medico = PersonaApp_Scanner.medicos.get(opcion - 1);
                System.out.println("Ha seleccionado al Dr. " + medico.getApellidos());
                break;
            } else if (opcion != 0) {
                System.out.println("Opcion no valida. Intentelo de nuevo.");
            } else if (opcion == 0) {
            	Menu.menuHistorial();
            }
        } while (opcion != 0);
        
        String dniPacienteSeleccionado = paciente.getDni();
        String dniDoctorSeleccionado = medico.getDni();
        
        System.out.println("Listado de visitas del paciente " 
        + paciente.getNombre() 
        + " con DNI: " + dniPacienteSeleccionado 
        + " con el/la Dr/Dra. " + medico.getApellidos());
        for (int i = 0; i < PersonaApp_Scanner.visitas.size(); i++) {
            Visita visita = PersonaApp_Scanner.visitas.get(i);
            if (visita.getDniPaciente().equals(dniPacienteSeleccionado) &&
            		visita.getDniDoctor().equals(dniDoctorSeleccionado)) {
                System.out.println((i + 1) 
                	+ ". Fecha:"+ sdfFecha.format(visita.getFecha()) 
                	+ " Hora: " + sdfHora.format(visita.fecha) 
                	+ " Resultado: " + visita.getResultado());
            }
        }
        Menu.menuHistorial();
    }
}


