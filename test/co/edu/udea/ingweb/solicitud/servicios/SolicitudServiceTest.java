package co.edu.udea.ingweb.solicitud.servicios;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class SolicitudServiceTest {
	@Autowired
	SolicitudService solicitudService;
	@Test
	public void testGuardaSolicitud() {
		fail("Not yet implemented");
	}

	@Test
	public void testActualizarSolicitud() {
		fail("Not yet implemented");
	}

	@Test
	public void testEliminarSolicitud() {
		fail("Not yet implemented");
	}

	@Test
	public void testObtener() {
		fail("Not yet implemented");
	}

	@Test
	public void testObtenerInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDificultad() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEmpleado() {
		fail("Not yet implemented");
	}

}
