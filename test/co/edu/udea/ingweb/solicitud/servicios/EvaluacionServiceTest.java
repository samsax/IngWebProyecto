package co.edu.udea.ingweb.solicitud.servicios;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import co.edu.udea.ingweb.solicitud.dto.Evaluacion;
import co.edu.udea.ingweb.util.exception.IWDaoException;
import co.edu.udea.ingweb.util.exception.IWServiceException;
import co.edu.udea.ingweb.util.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class EvaluacionServiceTest {
	@Autowired
	EvaluacionService evaluacionService;
	
	@Test
	public void testGuardaEvaluacion() throws IWDaoException, IWServiceException, MyException {
		try{
		evaluacionService.guardaEvaluacion(5, "20", "3", "4");}
		catch(IWDaoException e){
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
	public void testActualizarEvaluacion() {
		try{
			evaluacionService.actualizarEvaluacion(5, "15", "3", "4");}
			catch(IWDaoException e){
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
	public void testEliminarEvaluacion() {
		try{
			evaluacionService.eliminarEvaluacion(5);}
			catch(IWDaoException e){
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
		List<Evaluacion> evaluaciones = null;
		try{
			evaluaciones = evaluacionService.obtener();
			assertTrue(evaluaciones.size() >0);
		}
		catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtenerInt() throws IWDaoException, IWServiceException, MyException {
		Evaluacion evaluacion = evaluacionService.obtener(3);
		assertEquals(5, evaluacion.getAtencion());
	}

}
