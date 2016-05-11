package co.edu.udea.ingweb.solicitud.servicios;

import java.util.List;

import co.edu.udea.ingweb.solicitud.dao.EvaluacionDao;
import co.edu.udea.ingweb.solicitud.dto.Evaluacion;
import co.edu.udea.ingweb.util.exception.IWDaoException;
import co.edu.udea.ingweb.util.exception.IWServiceException;
import co.edu.udea.ingweb.util.exception.MyException;
import co.edu.udea.ingweb.util.exception.Validaciones;
/*
 * 
	int idEvaluacion;
	String tiempo;
	String conformidad;
	String atencion;
 */
public class EvaluacionService {
	
	private EvaluacionDao evaluacionDao;
		
		public void guardaEmpleado(int idEvaluacion, String tiempo, 
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
		
		
		/********************************/
		// Falta desde acá
		public void eliminarEmpleado(int cedula) throws IWDaoException, IWServiceException{
			
			Empleado empleado = null;
			
			if(Validaciones.isTextoVacio(cedula)){
				throw new IWServiceException("La c�dula del empleado no puede ser nula, ni una cadena de caracteres vacia");
			}
			
			empleado = evaluacionDao.obtenerEmpleado(cedula);
			
			if(empleado == null){
				throw new IWServiceException("El empleado a eliminar no existe en el sistema");
			}
			
			evaluacionDao.eliminarEmpleado(empleado);
			
		}
		
		public List<Empleado> obtener() throws IWDaoException{
			return evaluacionDao.listarEmpleados();
		}
		
		public Empleado obtener(int cedula) throws IWDaoException, IWServiceException{
			if(cedula == -1 && "".equals(cedula)){
				throw new IWServiceException("La c�dula del empleado a buscar no puede ser nula, ni una cadena de caracteres vacia");
			}
			
			return evaluacionDao.obtenerEmpleado(cedula);
		}
	
		public EmpleadoDao getEmpleadoDAO() {
			return evaluacionDao;
		}
	
		public void setEmpleadoDAO(EmpleadoDao empleadoDAO) {
			this.evaluacionDao = empleadoDAO;
		}
}
