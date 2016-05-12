package co.edu.udea.ingweb.solicitud.servicios;

import java.util.Date;
import java.util.List;

import co.edu.udea.ingweb.solicitud.dao.SolicitudDao;
import co.edu.udea.ingweb.solicitud.dto.Cliente;
import co.edu.udea.ingweb.solicitud.dto.Empleado;
import co.edu.udea.ingweb.solicitud.dto.Solicitud;
import co.edu.udea.ingweb.util.exception.IWDaoException;
import co.edu.udea.ingweb.util.exception.IWServiceException;
import co.edu.udea.ingweb.util.exception.MyException;
import co.edu.udea.ingweb.util.exception.Validaciones;

@Transactional
public class SolicitudService {
	
	private SolicitudDao solicitudDao;
	
	public void guardaSolicitud(int idCodigo, String tipo, String texto, 
			String estado, int dificultad, Date fechaCrea, 
			Cliente cliente, Empleado empleado) throws IWDaoException, IWServiceException, MyException{
		
		Solicitud solicitud = null;
		 
		if(Validaciones.isTextoVacio(idCodigo)){
			throw new IWServiceException("El código de la solicitud no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(tipo)){
			throw new IWServiceException("El tipo de solicitud no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(texto)){
			throw new IWServiceException("El texto de la solicitud no puede ser nulo, ni una cadena de caracteres vacia");
		}
		
		solicitud = new Solicitud();
		
		solicitud.setIdcodigo(idCodigo);
		solicitud.setTipo(tipo);
		solicitud.setTexto(texto);
		solicitud.setEstado(estado);
		solicitud.setDificultad(dificultad);
		solicitud.setFechaCreacion(fechaCrea);
		solicitud.setCliente(cliente);
		solicitud.setEmpleado(empleado);
		
		try {
			solicitudDao.crearSolicitud(solicitud);
		} catch (MyException e) {
			throw new MyException("Error al crear la solicitud");
		}
		
	}
	
	public void actualizarSolicitud(int idCodigo, String tipo, String texto, 
			String estado, int dificultad, Date fechaCrea, 
			Cliente cliente, Empleado empleado) throws IWDaoException, IWServiceException, MyException{
		
		Solicitud solicitud = null;
		 
		if(Validaciones.isTextoVacio(idCodigo)){
			throw new IWServiceException("El código de la solicitud no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(tipo)){
			throw new IWServiceException("El tipo de solicitud no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(texto)){
			throw new IWServiceException("El texto de la solicitud no puede ser nulo, ni una cadena de caracteres vacia");
		}
		
		solicitud = solicitudDao.obtenerSolicitud(idCodigo);
		
		solicitud.setIdcodigo(idCodigo);
		solicitud.setTipo(tipo);
		solicitud.setTexto(texto);
		solicitud.setEstado(estado);
		solicitud.setDificultad(dificultad);
		solicitud.setFechaCreacion(fechaCrea);
		solicitud.setCliente(cliente);
		solicitud.setEmpleado(empleado);
		
		try {
			solicitudDao.modificarSolicitud(solicitud);
		} catch (MyException e) {
			throw new MyException("Error al crear la solicitud");
		}
		
	}
	
	public void eliminarSolicitud(int idCodigo) throws IWDaoException, IWServiceException, MyException{
		
		Solicitud solicitud = null;
		
		if(Validaciones.isTextoVacio(idCodigo)){
			throw new IWServiceException("El código de la solicitud no puede ser nulo, ni una cadena de caracteres vacia");
		}
		
		
		solicitud = solicitudDao.obtenerSolicitud(idCodigo);
		
		if(solicitud == null){
			throw new IWServiceException("La solicitud a eliminar no existe en el sistema");
		}
		
		try {
			solicitudDao.eliminarSolicitud(solicitud);
		} catch (MyException e) {
			throw new MyException("Error al eliminar la solicitud");
		}
		
	}
	
	public List<Solicitud> obtener() throws IWDaoException, MyException{
		return solicitudDao.listarSolicitudes();
	}
	
	public Solicitud obtener(int idCodigo) throws IWDaoException, IWServiceException, MyException{
		if(idCodigo == -1 && "".equals(idCodigo)){
			throw new IWServiceException("El código de la solicitud a buscar no puede ser nulo, ni una cadena de caracteres vacia");
		}
		
		return solicitudDao.obtenerSolicitud(idCodigo);
	}

	public SolicitudDao getClienteDAO() {
		return solicitudDao;
	}

	public void setSolicitudDAO(SolicitudDao solicitudDAO) {
		this.solicitudDao = solicitudDAO;
	}

}