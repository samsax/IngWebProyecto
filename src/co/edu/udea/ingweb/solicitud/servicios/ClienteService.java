package co.edu.udea.ingweb.solicitud.servicios;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.ingweb.solicitud.dao.ClienteDao;
import co.edu.udea.ingweb.solicitud.dto.Cliente;
import co.edu.udea.ingweb.util.exception.IWDaoException;
import co.edu.udea.ingweb.util.exception.IWServiceException;
import co.edu.udea.ingweb.util.exception.MyException;
import co.edu.udea.ingweb.util.exception.Validaciones;
/**
 * @author Samuel Arenas	- samuelsaxofon@gmail.com
 * @author Camila Gómez		- camigomez35@gmail.com
 * @author Santiago Romero	- bonampa312@gmail.com
 */
public class ClienteService {
	
	@Autowired
	private ClienteDao clienteDao;

	/**
	 * Servicio paraguardarclientes
	 * 
	 * @param cedula
	 * @param nombres
	 * @param correoElectronico
	 * @throws IWDaoException
	 * @throws IWServiceException
	 * @throws MyException
	 */
	public void guardaCliente(int cedula, String nombres, 
		String correoElectronico) throws IWDaoException, IWServiceException, MyException{

		Cliente cliente = null;
		
		if(Validaciones.isTextoVacio(cedula)){
			throw new IWServiceException("La cï¿½dula del cliente no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(nombres)){
			throw new IWServiceException("Los nombres del cliente no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(correoElectronico)){
			throw new IWServiceException("El correo electrï¿½nico del cliente no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(!Validaciones.isEmail(correoElectronico)){
			throw new IWServiceException("El correo electronico del cliente debe ser valido");
		}
		
		if(clienteDao.obtenerCliente(correoElectronico) != null){
			throw new IWServiceException("Ya existe un cliente con cedula " + cedula +  " en el sistema");
		}
		
		cliente = new Cliente();
		
		cliente.setIdentificacion(cedula);
		cliente.setNombre(nombres);
		cliente.setCorreo(correoElectronico);
		
		clienteDao.crearCliente(cliente);
		
	}
	
	/**
	 * Servicioara actualizar un cliente
	 * 
	 * @param cedula
	 * @param nombres
	 * @param correoElectronico
	 * @throws IWDaoException
	 * @throws IWServiceException
	 * @throws MyException
	 */
	public void actualizarCliente(int cedula, String nombres,
			String correoElectronico) throws IWDaoException, IWServiceException, MyException{
		
		Cliente cliente = null;
		
		if(Validaciones.isTextoVacio(cedula)){
			throw new IWServiceException("La cedula del cliente no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(nombres)){
			throw new IWServiceException("Los nombres del cliente no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(correoElectronico)){
			throw new IWServiceException("El correo electronico del cliente no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(!Validaciones.isEmail(correoElectronico)){
			throw new IWServiceException("El correo electronico del cliente debe ser valido");
		}
		
		cliente = clienteDao.obtenerCliente(cedula);
		
		if(cliente == null){
			throw new IWServiceException("El cliente a modificar no existe en el sistema");
		}
		
		
		cliente.setIdentificacion(cedula);
		cliente.setNombre(nombres);
		cliente.setCorreo(correoElectronico);
		
		clienteDao.modificarCliente(cliente);
		
	}
	
	/**
	 * Servicio para eliinar un cliente 
	 * 
	 * @param cedula
	 * @throws IWDaoException
	 * @throws IWServiceException
	 * @throws MyException
	 */
	public void eliminarCliente(int cedula) throws IWDaoException, IWServiceException, MyException{
		
		Cliente cliente = null;
		
		if(Validaciones.isTextoVacio(cedula)){
			throw new IWServiceException("La cedula del cliente no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		cliente = clienteDao.obtenerCliente(cedula);
		
		if(cliente == null){
			throw new IWServiceException("El cliente a eliminar no existe en el sistema");
		}
		clienteDao.eliminarCliente(cliente);
	}
	
	/**
	 * Serivici para obtener una lista cn tdos los clientes
	 * 
	 * @return
	 * @throws IWDaoException
	 * @throws MyException
	 */
	public List<Cliente> obtener() throws IWDaoException, MyException{
		return clienteDao.listarClientes();
	}
	
	/**
	 * Servicio para obtener un cliente por su correo
	 * 
	 * @param correo
	 * @return
	 * @throws IWDaoException
	 * @throws IWServiceException
	 * @throws MyException
	 */
	public Cliente obtener(String correo) throws IWDaoException, IWServiceException, MyException{
		if(correo == null && "".equals(correo)){
			throw new IWServiceException("El correo del cliente a buscar no puede ser nula, ni una cadena de caracteres vacia");
		}
		return clienteDao.obtenerCliente(correo);
	}

	/**
	 * Servicio para obtener un cliente por su numero de identificación
	 * 
	 * @param identificacion
	 * @return
	 * @throws IWDaoException
	 * @throws IWServiceException
	 * @throws MyException
	 */
	public Cliente obtener(int identificacion) throws IWDaoException, IWServiceException, MyException{
		if(identificacion == -1 && "".equals(identificacion)){
			throw new IWServiceException("La cedula del cliente a buscar no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		return clienteDao.obtenerCliente(identificacion);
	}
	
	public ClienteDao getClienteDAO() {
		return clienteDao;
	}

	public void setClienteDAO(ClienteDao clienteDAO) {
		this.clienteDao = clienteDAO;
	}

}