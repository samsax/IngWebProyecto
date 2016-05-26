package co.edu.udea.ingweb.solicitud.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.ingweb.solicitud.dao.EmpleadoDao;
import co.edu.udea.ingweb.solicitud.dto.Empleado;
import co.edu.udea.ingweb.util.exception.MyException;

@Transactional
public class EmpleadoDAOHibernate extends HibernateDaoSupport implements EmpleadoDao {

	@Override
	public List<Empleado> listarEmpleados() throws MyException {
	List<Empleado> empleados = new ArrayList<Empleado>();
		
		try{
			Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			Criteria criteria = session.createCriteria(Empleado.class);
			
			empleados = criteria.list();
		}catch(HibernateException e){
			throw new MyException(e);
		}
		return empleados;
	}

	@Override
	public Empleado obtenerEmpleado(int identificacion) throws MyException{
		Empleado empleado = null;
		Session session = null;
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
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			session.delete(empleado);
			
		}catch(HibernateException e){
			throw new MyException(e);
		}
		
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
	public Empleado obtenerEmpleadoLogin(String correo) throws MyException {
		Empleado empleado = null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			empleado = (Empleado)session.get(Empleado.class, correo);
			
		}catch(HibernateException e){
			throw new MyException(e);
		}
		return empleado;
	}

	@Override
	public List<Empleado> obtenerListaSubordinados(int idJefe)throws MyException{
		List<Empleado> empleados = new ArrayList<Empleado>();
		Empleado jefe = this.obtenerEmpleado(idJefe);
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Empleado.class)
				.add(Restrictions.eq("jefe", jefe));
		empleados = criteria.list();
		return empleados;
	};
	
}
