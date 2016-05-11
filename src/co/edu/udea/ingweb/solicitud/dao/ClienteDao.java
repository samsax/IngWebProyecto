package co.edu.udea.ingweb.solicitud.dao;

import java.util.List;

import co.edu.udea.ingweb.solicitud.dto.Cliente;
import co.edu.udea.ingweb.util.exception.MyException;

public interface ClienteDao {
	/**
	 * Firma del m�todo que nos permite obtener todos los clientes.
	 * 
	 * @return Lista con los clientes.
	 * @throws MyException
	 */
	public List<Cliente> listarClientes() throws MyException;

	/**
	 * Firma del m�todo que nos permite obtener un �nico cliente.
	 * 
	 * @param identificacion
	 *            con el cual se realizar� la b�squeda.
	 * @return Retorna el cliente buscado.
	 * @throws MyException
	 */
	public Cliente obtenerCliente(int identificacion) throws MyException;

	/**
	 * Forma del método para obtener un único cliente por medio del correo
	 * @param correo
	 * @return
	 * @throws MyException
	 */
	public Cliente obtenerCliente(String correo) throws MyException;
	
	/**
	 * Firma del m�todo que nos permite crear un nuevo cliente.
	 * 
	 * @param cliente
	 *            que se va a crear en el sistema y almacenar en la BD.
	 * @throws MyException
	 */
	public void crearCliente(Cliente cliente) throws MyException;

	/**
	 * Firma del m�todo que nos permite eliminar un cliente de la base de datos. 
	 * @param cliente que se va a eliminar.
	 * @throws MyException
	 */
	public void eliminarCliente(Cliente cliente) throws MyException;

	/**
	 * Firma del metodo para modificar un cliente existente.
	 * @param cliente que se desea modificar.
	 * @return 
	 * @throws MyException
	 */
	public Cliente modificarCliente(Cliente cliente) throws MyException;
}
