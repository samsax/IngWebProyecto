package co.edu.udea.ingweb.solicitud.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import co.edu.udea.ingweb.solicitud.dto.Cliente;
import co.edu.udea.ingweb.solicitud.dto.Empleado;
import co.edu.udea.ingweb.util.exception.MyException;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;

public class EmpleadoDaoImpl implements EmpleadoDao{

	@Override
	public List<Empleado> listarEmpleados() throws MyException {
		List<Empleado> empleados = new ArrayList<Empleado>();
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			Criteria criteria = session.createCriteria(Cliente.class);
			
			empleados = criteria.list();
			
		}catch(HibernateException e){
			throw new MyException(e);
		}
		
		return empleados;
	}

	@Override
	public Empleado obtenerEmpleado(int identificacion) throws MyException {
		Session session = null;
		Empleado empleado = null;
		
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			empleado = (Empleado)session.get(Empleado.class, identificacion);
		}catch(HibernateException e){
			throw new MyException(e);
		}
		
		return empleado;
	}

	@Override
	public void crearEmpleado(Empleado empleado) throws MyException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.save(empleado);
		}catch(HibernateException e){
			throw new MyException(e);
		}
	}

	@Override
	public void eliminarEmpleado(Empleado empleado) throws MyException {
		
	}

	@Override
	public void modificarEmpleado(Empleado empleado) throws MyException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			session.update(empleado);
			
		}catch(HibernateException e){
			throw new MyException(e);
		}
	}

	@Override
	public Empleado obtenerEmpleadoLogin(int correo) throws MyException {
		Session session = null;
		Empleado empleado = null;
		
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			empleado = (Empleado)session.get(Empleado.class, correo);
		}catch(HibernateException e){
			throw new MyException(e);
		}
		return empleado;
	}

}
