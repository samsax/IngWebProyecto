package co.edu.udea.ingweb.solicitud.servicios;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.ingweb.solicitud.dto.Empleado;
import co.edu.udea.ingweb.util.exception.IWDaoException;
import co.edu.udea.ingweb.util.exception.IWServiceException;
import co.edu.udea.ingweb.util.exception.MyException;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class EmpleadoServiceTest {

	@Autowired
	EmpleadoService empleadoServicio;
	
	@Test
	public void testGuardaEmpleado() throws IWServiceException, MyException {
		try{
			empleadoServicio.guardaEmpleado(1, "Empleado Prueba", "correo@prueba.com", "empleado", "123456");
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testActualizarEmpleado() throws IWServiceException, MyException {
		try {
			empleadoServicio.actualizarEmpleado(1, "Empleado Prueba", "correo@editado.com", "empleado editado");
		} catch (IWDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testEliminarEmpleado() throws IWServiceException, MyException {
		try {
			empleadoServicio.eliminarEmpleado(1);
		} catch (IWDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtener() throws MyException {
		List<Empleado> empleados = null;
		try {
			empleados = empleadoServicio.obtener();
			assertTrue(empleados.size() >0);
			
		} catch (IWDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtenerInt() throws IWDaoException, IWServiceException {
		Empleado empleado = null;
		try {
			empleadoServicio = new EmpleadoService();
			empleado= empleadoServicio.obtener(2);
			System.out.println("Cliente: " + empleado.getNombre());
			assertNotNull(empleado);
			
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
