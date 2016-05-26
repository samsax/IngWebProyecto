package co.edu.udea.ingweb.solicitud.dao;

import java.util.List;


import co.edu.udea.ingweb.solicitud.dto.Evaluacion;
import co.edu.udea.ingweb.util.exception.MyException;

public interface EvaluacionDao {
	/**
	 * Firma del m�todo que nos permite obtener todos las evaluaciones.
	 * 
	 * @return Lista con las evaluaciones.
	 * @throws MyException
	 */
	public List<Evaluacion> listarEvaluacion() throws MyException;

	/**
	 * Firma del m�todo que nos permite obtener una unica evaluaci�n.
	 * 
	 * @param idevaluacion
	 *            con la cual se realizar� la b�squeda.
	 * @return Retorna la evaluaci�n buscada.
	 * @throws MyException
	 */
	public Evaluacion obtenerEvaluacion(Integer idevaluacion) throws MyException;

	/**
	 * Firma del m�todo que nos permite crear una nueva evaluaci�n.
	 * 
	 * @param evaluacion
	 *            que se va a crear en el sistema y almacenar en la BD.
	 * @throws MyException
	 */
	public void crearEvaluacion(Evaluacion evaluacion) throws MyException;

	/**
	 * Firma del m�todo que nos permite eliminar una evaluacion de la base de datos. 
	 * @param evaluacion que se va a eliminar.
	 * @throws MyException
	 */
	public void eliminarEvaluacion(Evaluacion evaluacion) throws MyException;

	/**
	 * Firma del metodo para modificar un empleado existente.
	 * @param evaluacion que se desea modificar.
	 * @throws MyException
	 */
	public void modificarEvaluacion(Evaluacion evaluacion) throws MyException;
}
