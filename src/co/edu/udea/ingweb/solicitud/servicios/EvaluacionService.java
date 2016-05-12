package co.edu.udea.ingweb.solicitud.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.udea.ingweb.solicitud.dao.EvaluacionDao;
import co.edu.udea.ingweb.solicitud.dto.Evaluacion;
import co.edu.udea.ingweb.util.exception.IWDaoException;
import co.edu.udea.ingweb.util.exception.IWServiceException;
import co.edu.udea.ingweb.util.exception.MyException;
import co.edu.udea.ingweb.util.exception.Validaciones;

public class EvaluacionService {
	@Autowired
	private EvaluacionDao evaluacionDao;
		
	public void guardaEvaluacion(int idEvaluacion, String tiempo, 
			String conformidad, String atencion) 
					throws IWDaoException, IWServiceException, MyException{
		
		Evaluacion evaluacion = null;
		
		if(Validaciones.isTextoVacio(idEvaluacion)){
			throw new IWServiceException("La identificación de la evaluación no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(tiempo)){
			throw new IWServiceException("El tiempo de evaluación no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(conformidad)){
			throw new IWServiceException("La conformidad de la evaluación no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(atencion)){
			throw new IWServiceException("La atención de la evaluación no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		evaluacion = new Evaluacion();
		
		evaluacion.setIdEvaluacion(idEvaluacion);
		evaluacion.setAtencion(atencion);
		evaluacion.setConformidad(conformidad);
		evaluacion.setTiempo(tiempo);
		
		evaluacionDao.crearEvaluacion(evaluacion);;
		
	}
	
	public void actualizarEvaluacion(int idEvaluacion, String tiempo, 
			String conformidad, String atencion) 
					throws IWDaoException, IWServiceException, MyException{
		
		Evaluacion evaluacion = null;
		
		if(Validaciones.isTextoVacio(idEvaluacion)){
			throw new IWServiceException("La identificación de la evaluación no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(tiempo)){
			throw new IWServiceException("El tiempo de evaluación no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(conformidad)){
			throw new IWServiceException("La conformidad de la evaluación no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(atencion)){
			throw new IWServiceException("La atención de la evaluación no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		evaluacion = evaluacionDao.obtenerEvaluacion(idEvaluacion);
		
		if(evaluacion == null){
			throw new IWServiceException("La evaluación a modificar no existe en el sistema");
		}


		evaluacion.setIdEvaluacion(idEvaluacion);
		evaluacion.setAtencion(atencion);
		evaluacion.setConformidad(conformidad);
		evaluacion.setTiempo(tiempo);
		
		evaluacionDao.modificarEvaluacion(evaluacion);
		
	}
	
	
	/**
	 * @throws MyException 
	 * */
	public void eliminarEvaluacion(int idEvaluacion) throws IWDaoException, IWServiceException, MyException{
		
		Evaluacion evaluacion = null;
		
		if(Validaciones.isTextoVacio(idEvaluacion)){
			throw new IWServiceException("La identificacion de la evaluación no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		evaluacion = evaluacionDao.obtenerEvaluacion(idEvaluacion);
		
		if(evaluacion == null){
			throw new IWServiceException("El empleado a eliminar no existe en el sistema");
		}
		
		evaluacionDao.eliminarEvaluacion(evaluacion);
		
	}
	
	public List<Evaluacion> obtener() throws IWDaoException, MyException{
		return evaluacionDao.listarEvaluacion();
	}
	
	public Evaluacion obtener(int idEvaluacion) throws IWDaoException, IWServiceException, MyException{
		if(idEvaluacion == -1 && "".equals(idEvaluacion)){
			throw new IWServiceException("La identificación de la evaluación a buscar no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		return evaluacionDao.obtenerEvaluacion(idEvaluacion);
	}

	public EvaluacionDao getEvaluacionDAO() {
		return evaluacionDao;
	}

	public void setEvaluacionDAO(EvaluacionDao evaluacionDAO) {
		this.evaluacionDao = evaluacionDAO;
	}
}
