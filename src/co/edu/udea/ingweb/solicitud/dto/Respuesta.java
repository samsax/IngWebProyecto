package co.edu.udea.ingweb.solicitud.dto;

public class Respuesta {
	int idRespuesta;
	String texto;
	Solicitud codigo;
	Evaluacion evaluacion;
	
	
	
	public int getIdRespuesta() {
		return idRespuesta;
	}
	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Solicitud getCodigo() {
		return codigo;
	}
	public void setCodigo(Solicitud codigo) {
		this.codigo = codigo;
	}
	public Evaluacion getEvaluacion() {
		return evaluacion;
	}
	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}
	public Respuesta() {
	
	}
	
	

}
