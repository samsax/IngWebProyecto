package co.edu.udea.ingweb.solicitud.dto;

import java.util.Date;

public class Solicitud {
	Integer idcodigo;
	String tipo;
	String texto;
	String estado;
	int dificultad;
	Date fechaCreacion;
	Date fechaRespuesta;
	Cliente cliente;
	Empleado empleado;
	String respuesta;
	
	
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public Integer getIdcodigo() {
		return idcodigo;
	}
	public void setIdcodigo(Integer idcodigo) {
		this.idcodigo = idcodigo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getDificultad() {
		return dificultad;
	}
	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaRespuesta() {
		return fechaRespuesta;
	}
	public void setFechaRespuesta(Date fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public Empleado getEmpleadoSinJefe(){
		Empleado emp = this.empleado;
		emp.setJefe(null);
		return emp;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Solicitud() {
	}

}
