package co.edu.udea.ingweb.solicitud.servicios;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.ingweb.solicitud.dto.Cliente;
import co.edu.udea.ingweb.solicitud.dto.Empleado;
import co.edu.udea.ingweb.util.exception.IWDaoException;
import co.edu.udea.ingweb.util.exception.MyException;


public class EmpleadoServiceTest {

	@Autowired
	EmpleadoService empleadoServece;
	
	@Test
	public void testGuardaEmpleado() {
		try{
			empleadoServece.guardaEmpleado(1152454724, "Empleado Prueba", "correo@prueba.com", "empleado", "123456");
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testActualizarEmpleado() {
		try {
			empleadoServece.actualizarEmpleado(1152454724, "Empleado Prueba", "correo@editado.com", "empleado editado");
		} catch (IWDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testEliminarEmpleado() {
		try {
			empleadoServece.eliminarEmpleado(1152454724);
		} catch (IWDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtener() {
		List<Empleado> empleados = null;
		try {
			empleados = empleadoServece.obtener();
			assertTrue(empleados.size() >0);
			
		} catch (IWDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtenerInt() {
		Empleado empleado = null;
		try {
			empleadoServece = new EmpleadoService();
			empleado= empleadoServece.obtener(1152454724);
			System.out.println("Cliente: " + empleado.getNombre());
			assertNotNull(empleado);
			
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
