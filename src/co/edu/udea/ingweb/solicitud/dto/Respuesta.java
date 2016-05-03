package co.edu.udea.ingweb.solicitud.dto;

public class Respuesta {
	int idRespuesta;
	String texto;
	Solicitud codigo;
	Evaluacion empleado;
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
	public Evaluacion getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Evaluacion empleado) {
		this.empleado = empleado;
	}
	public Respuesta() {
	
	}
	
	

}
