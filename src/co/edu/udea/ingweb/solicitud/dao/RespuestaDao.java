package co.edu.udea.ingweb.solicitud.dao;

import java.util.List;

import co.edu.udea.ingweb.solicitud.dto.Respuesta;
import co.edu.udea.ingweb.util.exception.MyException;

public interface RespuestaDao {
	/**
	 * Firma del m�todo que nos permite obtener todos las respuestas.
	 * 
	 * @return Lista con las respuestas.
	 * @throws MyException
	 */
	public List<Respuesta> listarRespuestas() throws MyException;

	/**
	 * Firma del m�todo que nos permite obtener una unica respuesta.
	 * 
	 * @param idrespuesta
	 *            con la cual se realizar� la b�squeda.
	 * @return Retorna la evaluacion buscada.
	 * @throws MyException
	 */
	public Respuesta obtenerRespuesta(int idrespuestas) throws MyException;

	/**
	 * Firma del m�todo que nos permite crear una nueva respuesta.
	 * 
	 * @param respuesta
	 *            que se va a crear en el sistema y almacenar en la BD.
	 * @throws MyException
	 */
	public void crearRespuesta(Respuesta respuesta) throws MyException;

	/**
	 * Firma del m�todo que nos permite eliminar una respuesta de la base de datos. 
	 * @param respuesta que se va a eliminar.
	 * @throws MyException
	 */
	public void eliminarRespuesta(Respuesta respuesta) throws MyException;

	/**
	 * Firma del metodo para modificar una respuesta existente.
	 * @param respuesta que se desea modificar.
	 * @throws MyException
	 */
	public void modificarRespuesta(Respuesta respuesta) throws MyException;
}
