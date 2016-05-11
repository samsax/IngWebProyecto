package co.edu.udea.ingweb.solicitud.servicios;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.ingweb.solicitud.dao.ClienteDao;

import co.edu.udea.ingweb.solicitud.dto.Cliente;
import co.edu.udea.ingweb.util.exception.IWDaoException;
import co.edu.udea.ingweb.util.exception.IWServiceException;
import co.edu.udea.ingweb.util.exception.Validaciones;
/**
 * La anotación es para permitir que se hagan transacciones de manera adecuada
 * Como que haga rollback cuando falle alguna operación durante la misma
 * @author santiago.romero
 */

@Transactional
public class ClienteService {
	
	private ClienteDao clienteDao;
	
	public void guardaCliente(int cedula, String nombres, String apellidos, 
			String correoElectronico, String usuarioCrea) throws IWDaoException, IWServiceException{
		
		Cliente cliente = null;
		
		if(Validaciones.isTextoVacio(cedula)){
			throw new IWServiceException("La c�dula del cliente no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(nombres)){
			throw new IWServiceException("Los nombres del cliente no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(apellidos)){
			throw new IWServiceException("Los apellidos del cliente no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(correoElectronico)){
			throw new IWServiceException("El correo electr�nico del cliente no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(usuarioCrea)){
			throw new IWServiceException("El usuario que crea el cliente no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		if(!Validaciones.isEmail(correoElectronico)){
			throw new IWServiceException("El correo electr�nico del cliente debe ser v�lido");
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
	
	public void actualizarCliente(int cedula, String nombres, String apellidos, 
			String correoElectronico, String usuarioModifica) throws IWDaoException, IWServiceException{
		
		Cliente cliente = null;
		
		if(Validaciones.isTextoVacio(cedula)){
			throw new IWServiceException("La c�dula del cliente no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(nombres)){
			throw new IWServiceException("Los nombres del cliente no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(apellidos)){
			throw new IWServiceException("Los apellidos del cliente no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(correoElectronico)){
			throw new IWServiceException("El correo electr�nico del cliente no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(usuarioModifica)){
			throw new IWServiceException("El usuario que modifica el cliente no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		if(!Validaciones.isEmail(correoElectronico)){
			throw new IWServiceException("El correo electr�nico del cliente debe ser v�lido");
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
	
	public void eliminarCliente(int cedula, String usuarioElimina) throws IWDaoException, IWServiceException{
		
		Cliente cliente = null;
		
		if(Validaciones.isTextoVacio(cedula)){
			throw new IWServiceException("La c�dula del cliente no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(usuarioElimina)){
			throw new IWServiceException("El usuario que elimina el cliente no puede ser nula, ni una cadena de caracteres vacia");
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
	
	public Cliente obtener(String cedula) throws IWDaoException, IWServiceException{
		if(cedula == null && "".equals(cedula)){
			throw new IWServiceException("La c�dula del cliente a buscar no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		return clienteDao.obtenerCliente(cedula);
	}

	public ClienteDao getClienteDAO() {
		return clienteDao;
	}

	public void setClienteDAO(ClienteDao clienteDAO) {
		this.clienteDao = clienteDAO;
	}

}