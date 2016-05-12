package co.edu.udea.ingweb.solicitud.servicios;

import static org.junit.Assert.*;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import co.edu.udea.ingweb.solicitud.dto.Evaluacion;
import co.edu.udea.ingweb.solicitud.dto.Respuesta;
import co.edu.udea.ingweb.solicitud.dto.Solicitud;
import co.edu.udea.ingweb.util.exception.IWDaoException;
import co.edu.udea.ingweb.util.exception.IWServiceException;
import co.edu.udea.ingweb.util.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")

public class RespuestaServiceTest {

	@Autowired
	RespuestaService respuestaService;
	
	@Test
	public void testGuardaRespuesta() {
		try{
			Solicitud solicitud = new Solicitud(); 
			Evaluacion evaluacion = new Evaluacion();
			respuestaService.guardaRespuesta(2, "Prueba Respuesta 2", solicitud, evaluacion);	
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
	public void testActualizarRespuesta() {
		try {
			Solicitud solicitud = new Solicitud(); 
			Evaluacion evaluacion = new Evaluacion();
			respuestaService.actualizarRespuesta(1, "Prueba Respuesta", solicitud, evaluacion);	

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
	public void testEliminarRespuesta() {
		try {
			respuestaService.eliminarRespuesta(1);

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
		List<Respuesta> respuestas= null;
		try {
			respuestas = respuestaService.obtener();
			assertTrue(respuestas.size() >0);
		} catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtenerInt() throws IWServiceException {
		Respuesta respuesta= null;
		try {
			respuesta = respuestaService.obtener(2);
			assertNotNull(respuesta);
		} catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
