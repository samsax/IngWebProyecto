package co.edu.udea.ingweb.solicitud.dao;

import java.util.List;

import co.edu.udea.ingweb.solicitud.dto.Solicitud;
import co.edu.udea.ingweb.util.exception.MyException;

public interface SolicitudDao {
	/**
	 * Firma del m�todo que nos permite obtener todos las solicitudes.
	 * 
	 * @return Lista con las solicitudes.
	 * @throws MyException
	 */
	public List<Solicitud> listarSolicitudes() throws MyException;

	/**
	 * Firma del m�todo que nos permite obtener las solicitudes de un empleado.
	 * 
	 * @return Lista con las solicitudes.
	 * @throws MyException
	 */
	public List<Solicitud> listarSolicitudesPorEmpleado(String correoEmpleado) throws MyException;
	
	/**
	 * Firma del m�todo que nos permite obtener una unica solicitud.
	 * 
	 * @param idcodigo
	 *            con la cual se realizar� la b�squeda.
	 * @return Retorna la solicitud buscada.
	 * @throws MyException
	 */
	public Solicitud obtenerSolicitud(int idcodigo) throws MyException;

	/**
	 * Firma del m�todo que nos permite crear una nueva solicitud.
	 * 
	 * @param solicitud
	 *            que se va a crear en el sistema y almacenar en la BD.
	 * @throws MyException
	 */
	public void crearSolicitud(Solicitud solicitud) throws MyException;

	/**
	 * Firma del m�todo que nos permite eliminar una solicitud de la base de datos. 
	 * @param solicitud que se va a eliminar.
	 * @throws MyException
	 */
	public void eliminarSolicitud(Solicitud solicitud) throws MyException;

	/**
	 * Firma del metodo para modificar una solicitud existente.
	 * @param solicitud que se desea modificar.
	 * @throws MyException
	 */
	public void modificarSolicitud(Solicitud solicitud) throws MyException;
}
