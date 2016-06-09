package co.edu.udea.ingweb.solicitud.servicios;

import java.util.List;



import co.edu.udea.ingweb.solicitud.dao.EmpleadoDao;
import co.edu.udea.ingweb.solicitud.dto.Empleado;
import co.edu.udea.ingweb.util.exception.IWDaoException;
import co.edu.udea.ingweb.util.exception.IWServiceException;
import co.edu.udea.ingweb.util.exception.MyException;
import co.edu.udea.ingweb.util.exception.Validaciones;

/**
 * @author Equipo 5
 */
public class EmpleadoService {

	private EmpleadoDao empleadoDao;
	/**
	 * Guarda un empleado
	 * 
	 * @param identificacion
	 * @param nombres
	 * @param correoElectronico
	 * @param cargo
	 * @param contrasena
	 * @param idjefe
	 * @throws IWDaoException
	 * @throws IWServiceException
	 * @throws MyException
	 */
	public void guardaEmpleado(int identificacion, String nombres, 
			String correoElectronico, String cargo, String contrasena, int idjefe) 
					throws IWDaoException, IWServiceException, MyException{
		
		Empleado empleado = null;
		
		if(Validaciones.isTextoVacio(identificacion)){
			throw new IWServiceException("La cï¿½dula del empleado no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(nombres)){
			throw new IWServiceException("Los nombres del empleado no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(cargo)){
			throw new IWServiceException("El cargo del empleado no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(correoElectronico)){
			throw new IWServiceException("El correo electrï¿½nico del empleado no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(contrasena)){
			throw new IWServiceException("La contraseÃ±a del empleado no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(contrasena)){
			throw new IWServiceException("La contraseÃ±a del empleado no puede ser nula, ni una cadena de caracteres vacia");
		}
		empleado = new Empleado();
		Empleado jefe = empleadoDao.obtenerEmpleado(idjefe);
		empleado.setIdentificacion(identificacion);
		empleado.setCargo(cargo);
		empleado.setContrasena(contrasena);
		empleado.setNombre(nombres);
		empleado.setCorreo(correoElectronico);
		empleado.setJefe(jefe);
		empleadoDao.crearEmpleado(empleado);
		
	}
	
	/**
	 * Acualiza los datos de un empleado
	 * Se le envían todos los parámetros correspondientes
	 * a un nuevo empleado
	 * 
	 * @param identificacion
	 * @param nombres
	 * @param correoElectronico
	 * @param cargo
	 * @throws IWDaoException
	 * @throws IWServiceException
	 * @throws MyException
	 */
	public void actualizarEmpleado(int identificacion, String nombres, 
			String correoElectronico, String cargo) 
					throws IWDaoException, IWServiceException, MyException{
		
		Empleado empleado = null;
		
		if(Validaciones.isTextoVacio(identificacion)){
			throw new IWServiceException("La cï¿½dula del empleado no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(nombres)){
			throw new IWServiceException("Los nombres del empleado no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(cargo)){
			throw new IWServiceException("El cargo del empleado no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(correoElectronico)){
			throw new IWServiceException("El correo electrï¿½nico del empleado no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		empleado = empleadoDao.obtenerEmpleado(identificacion);
		
		if(empleado == null){
			throw new IWServiceException("El empleado a modificar no existe en el sistema");
		}
		
		empleado.setIdentificacion(identificacion);
		empleado.setCargo(cargo);
		empleado.setNombre(nombres);
		empleado.setCorreo(correoElectronico);
		
		empleadoDao.modificarEmpleado(empleado);
		
	}
	/**
	 * Elimina un empleado dada su identificación 
	 * y notifica en caso de que sea una identificación no válida
	 * 
	 * @param cedula
	 * @throws IWDaoException
	 * @throws IWServiceException
	 * @throws MyException
	 */
	public void eliminarEmpleado(int cedula) throws IWDaoException, IWServiceException, MyException{
		
		Empleado empleado = null;
		
		if(Validaciones.isTextoVacio(cedula)){
			throw new IWServiceException("La cï¿½dula del empleado no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		empleado = empleadoDao.obtenerEmpleado(cedula);
		
		if(empleado == null){
			throw new IWServiceException("El empleado a eliminar no existe en el sistema");
		}
		
		empleadoDao.eliminarEmpleado(empleado);
		
	}
	/**
	 * Retorna todos los empleados existentes en la base de datos como una lista
	 * 
	 * @return
	 * @throws IWDaoException
	 * @throws MyException
	 */
	public List<Empleado> obtener() throws IWDaoException, MyException{
		return empleadoDao.listarEmpleados();
	}
	
	/**
	 * Retorna un único empleado dada su cédula / identificación
	 * y notifica si se ingresa una cédula no válida
	 *  
	 * @param cedula
	 * @return
	 * @throws IWDaoException
	 * @throws IWServiceException
	 * @throws MyException
	 */
	public Empleado obtener(int cedula) throws IWDaoException, IWServiceException, MyException{
		if(cedula == -1 && "".equals(cedula)){
			throw new IWServiceException("La cedula del empleado a buscar no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		return empleadoDao.obtenerEmpleado(cedula);
	}

	 /**
	  * Retorna un único empleado dado su correo
	  * y notifica si se ingresa un correo no válido
	  * @param correoElectronico
	  * @return
	  * @throws IWDaoException
	  * @throws IWServiceException
	  * @throws MyException
	  */
	public Empleado obtener(String correoElectronico) throws IWDaoException, IWServiceException, MyException{
		if(correoElectronico == null && "".equals(correoElectronico)){
			throw new IWServiceException("El correo del cliente a buscar no puede ser nula, ni una cadena de caracteres vacia");
		}
		return empleadoDao.obtenerEmpleado(correoElectronico);
	}
	
	
	
	public EmpleadoDao getEmpleadoDAO() {
		return empleadoDao;
	}
	

	public void setEmpleadoDAO(EmpleadoDao empleadoDAO) {
		this.empleadoDao = empleadoDAO;
	}
	
	public void actualizarJefe(int idEmpleado, int idJefe) throws MyException{
		Empleado empleado = empleadoDao.obtenerEmpleado(idEmpleado);
		Empleado jefe = empleadoDao.obtenerEmpleado(idEmpleado);
		empleado.setJefe(jefe);
		empleadoDao.modificarEmpleado(empleado);
	}
}
