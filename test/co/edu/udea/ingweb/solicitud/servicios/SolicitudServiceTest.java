package co.edu.udea.ingweb.solicitud.servicios;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.ingweb.solicitud.dto.Cliente;
import co.edu.udea.ingweb.solicitud.dto.Empleado;
import co.edu.udea.ingweb.solicitud.dto.Solicitud;
import co.edu.udea.ingweb.util.exception.IWDaoException;
import co.edu.udea.ingweb.util.exception.IWServiceException;
import co.edu.udea.ingweb.util.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class SolicitudServiceTest {
	@Autowired
	SolicitudService solicitudService;
	

	@Test
	public void testActualizarSolicitud() {
		try {
			Cliente cliente = new Cliente();
			Empleado empleado = new Empleado();
			Date date = new Date("2016/05/14");
			solicitudService.actualizarSolicitud(2, "Queja update", "Queja prueba update", "cerrada", 2, date, cliente, empleado);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(IWServiceException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testEliminarSolicitud() {
		try {
			solicitudService.eliminarSolicitud(2);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(IWServiceException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtener() {
		List<Solicitud> solicitudes= null;
		try {
			solicitudes = solicitudService.obtener();
			assertTrue(solicitudes.size() >0);
		} catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testObtenerPorEmpleado() {
		List<Solicitud> solicitudes= null;
		try {
			solicitudes = solicitudService.obtenerPorEmpleado("e.gomez@gmail.com");
			assertTrue(solicitudes.size() >0);
		} catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtenerInt() {
		Solicitud solicitud= null;
		try {
			solicitud = solicitudService.obtener(2);
			assertNotNull(solicitud);
		} catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		} catch (IWServiceException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testSetDificultad() {
		try {
			solicitudService.setDificultad(2, 5);
		} catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		} catch (IWServiceException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testSetEmpleado() {
		try {
			solicitudService.setEmpleado(1, 2);
		} catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		} catch (IWServiceException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
