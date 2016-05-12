package co.edu.udea.ingweb.solicitud.servicios;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.ingweb.solicitud.dao.ClienteDao;
import co.edu.udea.ingweb.solicitud.dto.Cliente;
import co.edu.udea.ingweb.util.exception.IWDaoException;
import co.edu.udea.ingweb.util.exception.IWServiceException;
import co.edu.udea.ingweb.util.exception.MyException;
import co.edu.udea.ingweb.util.exception.Validaciones;
/**
 * La anotación es para permitir que se hagan transacciones de manera adecuada
 * Como que haga rollback cuando falle alguna operación durante la misma
 * @author santiago.romero
 */

@Transactional
public class ClienteService {
	
	private ClienteDao clienteDao;
	
	public void guardaCliente(int cedula, String nombres, 
			String correoElectronico) throws IWDaoException, IWServiceException{

		
		Cliente cliente = null;
		
		if(Validaciones.isTextoVacio(cedula)){
			throw new IWServiceException("La c�dula del cliente no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(nombres)){
			throw new IWServiceException("Los nombres del cliente no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(correoElectronico)){
			throw new IWServiceException("El correo electr�nico del cliente no puede ser nula, ni una cadena de caracteres vacia");
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
	
	public void actualizarCliente(int cedula, String nombres,
			String correoElectronico) throws IWDaoException, IWServiceException{
		
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
	
	public void eliminarCliente(int cedula) throws IWDaoException, IWServiceException{
		
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
	
	public List<Cliente> obtener() throws IWDaoException{
		return clienteDao.listarClientes();
	}
	
	public Cliente obtener(String correo) throws IWDaoException, IWServiceException{
		if(correo == null && "".equals(correo)){
			throw new IWServiceException("El correo del cliente a buscar no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		return clienteDao.obtenerCliente(correo);
	}

	public Cliente obtener(int identificacion) throws IWDaoException, IWServiceException{
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