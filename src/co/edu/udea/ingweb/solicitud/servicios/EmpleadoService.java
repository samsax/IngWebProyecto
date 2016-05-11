package co.edu.udea.ingweb.solicitud.servicios;

import java.util.List;

import co.edu.udea.ingweb.solicitud.dao.EmpleadoDao;
import co.edu.udea.ingweb.solicitud.dto.Empleado;
import co.edu.udea.ingweb.util.exception.IWDaoException;
import co.edu.udea.ingweb.util.exception.IWServiceException;
import co.edu.udea.ingweb.util.exception.Validaciones;


@Transactional
public class EmpleadoService {

private EmpleadoDao empleadoDao;
	
	public void guardaEmpleado(int identificacion, String nombres, 
			String correoElectronico, String cargo, String contrasena) 
					throws IWDaoException, IWServiceException{
		
		Empleado empleado = null;
		
		if(Validaciones.isTextoVacio(identificacion)){
			throw new IWServiceException("La c�dula del empleado no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(nombres)){
			throw new IWServiceException("Los nombres del empleado no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(cargo)){
			throw new IWServiceException("El cargo del empleado no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(correoElectronico)){
			throw new IWServiceException("El correo electr�nico del empleado no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(contrasena)){
			throw new IWServiceException("La contraseña del empleado no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		empleado = new Empleado();
		
		empleado.setIdentificacion(identificacion);
		empleado.setCargo(cargo);
		empleado.setContrasena(contrasena);
		empleado.setNombre(nombres);
		empleado.setCorreo(correoElectronico);
		
		empleadoDao.crearEmpleado(empleado);;
		
	}
	
	public void actualizarEmpleado(int identificacion, String nombres, 
			String correoElectronico, String cargo, String contrasena) 
					throws IWDaoException, IWServiceException{
		
		Empleado empleado = null;
		
		if(Validaciones.isTextoVacio(identificacion)){
			throw new IWServiceException("La c�dula del empleado no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(nombres)){
			throw new IWServiceException("Los nombres del empleado no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(cargo)){
			throw new IWServiceException("El cargo del empleado no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(correoElectronico)){
			throw new IWServiceException("El correo electr�nico del empleado no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(contrasena)){
			throw new IWServiceException("La contraseña del empleado no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		empleado = empleadoDao.obtenerEmpleado(identificacion);
		
		if(empleado == null){
			throw new IWServiceException("El empleado a modificar no existe en el sistema");
		}
		
		empleado.setIdentificacion(identificacion);
		empleado.setCargo(cargo);
		empleado.setContrasena(contrasena);
		empleado.setNombre(nombres);
		empleado.setCorreo(correoElectronico);
		
		empleadoDao.modificarEmpleado(empleado);
		
	}
	
	public void eliminarEmpleado(int cedula) throws IWDaoException, IWServiceException{
		
		Empleado empleado = null;
		
		if(Validaciones.isTextoVacio(cedula)){
			throw new IWServiceException("La c�dula del empleado no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		empleado = empleadoDao.obtenerEmpleado(cedula);
		
		if(empleado == null){
			throw new IWServiceException("El empleado a eliminar no existe en el sistema");
		}
		
		empleadoDao.eliminarEmpleado(empleado);
		
	}
	
	public List<Empleado> obtener() throws IWDaoException{
		return empleadoDao.listarEmpleados();
	}
	
	public Empleado obtener(int cedula) throws IWDaoException, IWServiceException{
		if(cedula == -1 && "".equals(cedula)){
			throw new IWServiceException("La c�dula del empleado a buscar no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		return empleadoDao.obtenerEmpleado(cedula);
	}

	public EmpleadoDao getEmpleadoDAO() {
		return empleadoDao;
	}

	public void setEmpleadoDAO(EmpleadoDao empleadoDAO) {
		this.empleadoDao = empleadoDAO;
	}
}
