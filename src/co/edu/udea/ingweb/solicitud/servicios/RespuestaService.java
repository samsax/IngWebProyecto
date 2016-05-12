package co.edu.udea.ingweb.solicitud.servicios;

import java.util.List;

import co.edu.udea.ingweb.solicitud.dao.RespuestaDao;
import co.edu.udea.ingweb.solicitud.dto.Evaluacion;
import co.edu.udea.ingweb.solicitud.dto.Respuesta;
import co.edu.udea.ingweb.solicitud.dto.Solicitud;
import co.edu.udea.ingweb.util.exception.IWDaoException;
import co.edu.udea.ingweb.util.exception.IWServiceException;
import co.edu.udea.ingweb.util.exception.MyException;
import co.edu.udea.ingweb.util.exception.Validaciones;
/**
 * int idRespuesta;
 * String texto;
 * Solicitud codigo;
 * Respuesta respuesta;
 */
public class RespuestaService {

	private RespuestaDao respuestaDao;
	
	public void guardaRespuesta(int idRespuesta, String texto, 
			Solicitud solicitud, Evaluacion evaluacion) 
					throws IWDaoException, IWServiceException, MyException{
		
		Respuesta respuesta= null;
		
		if(Validaciones.isTextoVacio(idRespuesta)){
			throw new IWServiceException("La identificación de la evaluación no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(texto)){
			throw new IWServiceException("El tiempo de evaluación no puede ser nulo, ni una cadena de caracteres vacia");
		}
		
		respuesta = new Respuesta();
		
		respuesta.setIdRespuesta(idRespuesta);
		respuesta.setTexto(texto);
		respuesta.setCodigo(solicitud);
		respuesta.setEvaluacion(evaluacion);
		respuestaDao.crearRespuesta(respuesta);;
		
	}
	
	public void actualizarRespuesta(int idRespuesta, String texto, 
			Solicitud solicitud, Evaluacion evaluacion) 
					throws IWDaoException, IWServiceException, MyException{
		
		Respuesta respuesta = null;
		
		if(Validaciones.isTextoVacio(idRespuesta)){
			throw new IWServiceException("La identificación de la evaluación no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(texto)){
			throw new IWServiceException("El tiempo de evaluación no puede ser nulo, ni una cadena de caracteres vacia");
		}
		
		respuesta = respuestaDao.obtenerRespuesta(idRespuesta);
		
		if(respuesta == null){
			throw new IWServiceException("La evaluación a modificar no existe en el sistema");
		}

		respuesta.setIdRespuesta(idRespuesta);
		respuesta.setTexto(texto);
		respuesta.setCodigo(solicitud);
		respuesta.setEvaluacion(evaluacion);		
		respuestaDao.modificarRespuesta(respuesta);
		
	}
	
	
	/**
	 * @throws MyException 
	 * */
	public void eliminarRespuesta(int idRespuesta) throws IWDaoException, IWServiceException, MyException{
		
		Respuesta respuesta = null;
		
		if(Validaciones.isTextoVacio(idRespuesta)){
			throw new IWServiceException("La identificacion de la respuesta no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		respuesta = respuestaDao.obtenerRespuesta(idRespuesta);
		
		if(respuesta == null){
			throw new IWServiceException("La respuesta a eliminar no existe en el sistema");
		}
		
		respuestaDao.eliminarRespuesta(respuesta);
		
	}
	
	public List<Respuesta> obtener() throws IWDaoException, MyException{
		return respuestaDao.listarRespuestas();
	}
	
	public Respuesta obtener(int idRespuesta) throws IWDaoException, IWServiceException, MyException{
		if(idRespuesta == -1 && "".equals(idRespuesta)){
			throw new IWServiceException("La identificación de la respuesta a buscar no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		return respuestaDao.obtenerRespuesta(idRespuesta);
	}

	public RespuestaDao getRespuestaDAO() {
		return respuestaDao;
	}

	public void setRespuestaDAO(RespuestaDao respuestaDAO) {
		this.respuestaDao = respuestaDAO;
	}
	
}
