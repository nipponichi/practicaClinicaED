package practicaFicherosED;

import java.util.Date;

public class Visita {
	private Date fecha;
	private Date hora;
	private String dniDoctor;
	private String dniPaciente;
	private String datosPaciente;

	public Visita() {
		
	}
	
	public Visita(Date fecha, Date hora, String dniDoctor, String dniPaciente, String datosPaciente) {
		this.fecha = fecha;
		this.hora = hora;
		this.dniDoctor = dniDoctor;
		this.dniPaciente = dniPaciente;
		this.datosPaciente = datosPaciente;
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

	public String getDatosPaciente() {
		return datosPaciente;
	}

	public void setDatosPaciente(String datosPaciente) {
		this.datosPaciente = datosPaciente;
	}
	
	
}
