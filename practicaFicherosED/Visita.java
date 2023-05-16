package practicaFicherosED;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
	
	public Visita(Date fecha, Date hora, String dniDoctor, String dniPaciente, String resultado) {
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
	public void registroVisita(String dniPaciente, Paciente paciente) {
		boolean esDniValido, esDniRegistrado = false;
		Visita visita;
		Profesionales_Medicos medico = new Profesionales_Medicos();
		String dniDoctor;
		String resultado;
		String dni;
		
		
		if (dniPaciente == null) {

			System.out.println("********************************\n"
					+ "Registro de nueva visita"
					+ "\n********************************");
		
			do {
				System.out.println("Inserte el dni del paciente: ");
			
				Scanner scDni = new Scanner(System.in);
				dni = scDni.nextLine().toUpperCase();
			
				esDniValido = TratamientoFichero.esDniValido(dni);
			
				if (esDniValido == true) {
						esDniRegistrado = TratamientoFichero.esDniRegistrado(dni);
						if (esDniRegistrado == true) {
							paciente = paciente.selectorPaciente(dni);
						}
				} else {
					
				}
			
				if (esDniValido == false) {
					System.out.println("El dni introducido no es valido");
				}
			}while (esDniValido == false && esDniRegistrado == false);

			
			System.out.println("Introduzca el peso en kilogramos");
			Scanner scPeso = new Scanner(System.in);
			double peso = scPeso.nextDouble();
			
			System.out.println("Inserte la altura en metros");
			Scanner scAltura = new Scanner(System.in);
			double altura = scAltura.nextDouble();
			
			Date fecha = new Date();
			Date hora = new Date();
			dniDoctor = medico.asignarMedico();
			resultado = PersonaApp_Scanner.MuestraMensajePeso(paciente);
			/**
			 * Declaracion objeto Paciente 
			 * para guardar visitas.
			 */
			paciente = new Paciente();
			visita = new Visita(fecha,hora,dniDoctor, 
					dniPaciente, resultado);
			
			PersonaApp_Scanner.pacientes.add(paciente);
			PersonaApp_Scanner.visitas.add(visita);
			Menu.menuInicial();
			//Mostramos el resultado de la visita
			
			
			//Guardamos la visita en fichero Visitas.txt
			//TratamientoFichero.grabarCliente(pacienteVisita,esVisita, esPacienteNuevo);
		
		}
	}
}


