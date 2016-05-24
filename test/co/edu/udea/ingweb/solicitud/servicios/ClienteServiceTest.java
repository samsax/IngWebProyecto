package co.edu.udea.ingweb.solicitud.servicios;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.ingweb.solicitud.dto.Cliente;
import co.edu.udea.ingweb.util.exception.IWDaoException;
import co.edu.udea.ingweb.util.exception.IWServiceException;
import co.edu.udea.ingweb.util.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class ClienteServiceTest {

	@Autowired
	ClienteService clienteService;
	
	@Test
	public void testGuardaCliente() throws IWServiceException, MyException {
		try{
			clienteService.guardaCliente(1152454724, "Cliente de prueba", "cliente@prueba.com");
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testActualizarCliente() throws IWServiceException, MyException {
		try {
			clienteService.actualizarCliente(1, "Cliente prueba edicion", "correo@editado.com");
		} catch (IWDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testEliminarCliente() throws IWServiceException, MyException {
		try {
			clienteService.eliminarCliente(1);
		} catch (IWDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtener() throws MyException {
		List<Cliente> clientes = null;
		try {
			clientes = clienteService.obtener();
			assertTrue(clientes.size() >0);
			
		} catch (IWDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtenerString() throws IWDaoException, IWServiceException {
		Cliente cliente = null;
		try {
			cliente= clienteService.obtener("sanromero@gmail.com");
			System.out.println("Cliente: " + cliente.getNombre());
			assertNotNull(cliente);
			
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testObtenerInt() throws IWDaoException, IWServiceException {
		Cliente cliente = null;
		try {
			cliente= clienteService.obtener(2);
			System.out.println("Cliente: " + cliente.getNombre());
			assertNotNull(cliente);
			
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
