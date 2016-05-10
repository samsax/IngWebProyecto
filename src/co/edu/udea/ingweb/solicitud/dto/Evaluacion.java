package co.edu.udea.ingweb.solicitud.dto;

public class Evaluacion {
	int idEvaluacion;
	String tiempo;
	String conformidad;
	String atencion;
	public int getIdEvaluacion() {
		return idEvaluacion;
	}
	public void setIdEvaluacion(int idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}
	public String getTiempo() {
		return tiempo;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	public String getConformidad() {
		return conformidad;
	}
	public void setConformidad(String conformidad) {
		this.conformidad = conformidad;
	}
	public String getAtencion() {
		return atencion;
	}
	public void setAtencion(String atencion) {
		this.atencion = atencion;
	}
	public Evaluacion() {
	} 
	
}
