package co.edu.udea.ingweb.solicitud.dao;

import java.util.List;

import co.edu.udea.ingweb.solicitud.dto.Empleado;
import co.edu.udea.ingweb.util.exception.MyException;

public interface EmpleadoDao {
	/**
	 * Firma del método que nos permite obtener todos los empleados.
	 * 
	 * @return Lista con los empleados.
	 * @throws MyException
	 */
	public List<Empleado> listarEmpleados() throws MyException;

	/**
	 * Firma del método que nos permite obtener un único empleado.
	 * 
	 * @param identificacion
	 *            con la cual se realizará la búsqueda.
	 * @return Retorna el empleado buscado.
	 * @throws MyException
	 */
	public Empleado obtenerEmpleado(int identificacion) throws MyException;
	
	/**
	 * Firma del método que nos permite obtener un único empleado 
	 * por su correo para login en el sistema.
	 * 
	 * @param identificacion
	 *            con la cual se realizará la búsqueda.
	 * @return Retorna el empleado buscado.
	 * @throws MyException
	 */
	public Empleado obtenerEmpleadoLogin(int correo) throws MyException;

	/**
	 * Firma del método que nos permite crear un nuevo empleado.
	 * 
	 * @param empleado
	 *            que se va a crear en el sistema y almacenar en la BD.
	 * @throws MyException
	 */
	public void crearEmpleado(Empleado empleado) throws MyException;

	/**
	 * Firma del método que nos permite eliminar un empleado de la base de datos. 
	 * @param empleado que se va a eliminar.
	 * @throws MyException
	 */
	public void eliminarEmpleado(Empleado empleado) throws MyException;

	/**
	 * Firma del metodo para modificar un empleado existente.
	 * @param empleado que se desea modificar.
	 * @throws MyException
	 */
	public void modificarEmpleado(Empleado empleado) throws MyException;
}
