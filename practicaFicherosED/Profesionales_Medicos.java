package practicaFicherosED;

import java.util.Random;
import java.util.Scanner;

/**
 * Falta comprobar si dni esta registrado o es valido para doctor
 * podria ser herencia de persona?
 * @author Javier
 *
 */

public class Profesionales_Medicos {
	private int codigo; 
	private String nombre, apellidos, dni, localidad, telefono, especialidad;


	public Profesionales_Medicos() {
		
	}
	
	public Profesionales_Medicos(int codigo, String nombre, String apellidos, String dni,
			String localidad, String telefono, String especialidad) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.localidad = localidad;
		this.telefono = telefono;
		this.especialidad = especialidad;	
	}
		
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	@SuppressWarnings("resource")
	public void registroPersonal() {
		Profesionales_Medicos medico;
		int codigo;
		String nombre, apellidos, dni, localidad, telefono, especialidad;
		codigo = PersonaApp_Scanner.medicos.size();
		System.out.println("Introduce nombre:");
		Scanner scNombre = new Scanner(System.in);
		nombre = scNombre.nextLine();
		System.out.println("Introduce apellidos:");
		Scanner scApellidos = new Scanner(System.in);
		apellidos = scApellidos.nextLine();
		System.out.println("Introduce dni:");
		Scanner scDni = new Scanner(System.in);
		dni = scDni.nextLine();
		System.out.println("Introduce localidad:");
		Scanner scLocalidad = new Scanner(System.in);
		localidad = scLocalidad.nextLine();
		System.out.println("Introduce telefono:");
		Scanner scTelefono = new Scanner(System.in);
		telefono = scTelefono.nextLine();
		System.out.println("Introduce especialidad:");
		Scanner scEspecialidad = new Scanner(System.in);
		especialidad = scEspecialidad.nextLine();
		medico = new Profesionales_Medicos(codigo, nombre, apellidos, 
				dni, localidad, telefono, especialidad);
		
	}
	
    public String asignarMedico() {
    	int posicion = PersonaApp_Scanner.medicos.size();
        Random random = new Random();
        int posicionAleatoria = random.nextInt(posicion);
        return PersonaApp_Scanner.medicos.get(posicionAleatoria).getDni();
    }
	
}
