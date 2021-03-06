package co.edu.udea.ingweb.solicitud.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.ingweb.solicitud.dao.ClienteDao;
import co.edu.udea.ingweb.solicitud.dao.EmpleadoDao;
import co.edu.udea.ingweb.solicitud.dao.SolicitudDao;
import co.edu.udea.ingweb.solicitud.dto.Empleado;
import co.edu.udea.ingweb.solicitud.dto.Solicitud;
import co.edu.udea.ingweb.util.exception.MyException;

@Transactional
public class SolicitudDAOHibernate extends HibernateDaoSupport implements SolicitudDao
{
	private EmpleadoDao empleadoDao;
	private ClienteDao clienteDao;
	@SuppressWarnings("unchecked")
	@Override
	public List<Solicitud> listarSolicitudes() throws MyException {
	List<Solicitud> solicitudes = new ArrayList<Solicitud>();
		
		try{
			Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			Criteria criteria = session.createCriteria(Solicitud.class);
			
			solicitudes = criteria.list();
		}catch(HibernateException e){
			throw new MyException(e);
		}
		return solicitudes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Solicitud> listarSolicitudesPorEmpleado(String correoEmpleado) throws MyException {
	List<Solicitud> solicitudes = new ArrayList<Solicitud>();
		
		try{
			Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			Empleado empleado = empleadoDao.obtenerEmpleado(correoEmpleado);
			Criteria criteria = session.createCriteria(Solicitud.class)
					.add(Restrictions.eq("empleado.identificacion", empleado.getIdentificacion()));
			
			solicitudes = criteria.list();
		}catch(HibernateException e){
			throw new MyException(e);
		}
		return solicitudes;
	}
	
	@Override
	public Solicitud obtenerSolicitud(int identificacion) throws MyException{
		Solicitud solicitud = null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			solicitud = (Solicitud)session.get(Solicitud.class, identificacion);
			
		}catch(HibernateException e){
			throw new MyException(e);
			
	}
	
	return solicitud;

	}


	@Override
	public void crearSolicitud(Solicitud solicitud) throws MyException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.save(solicitud);
		}catch(HibernateException e){
			throw new MyException(e);
		}
		
	}

	@Override
	public void eliminarSolicitud(Solicitud solicitud) throws MyException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			session.delete(solicitud);
			
		}catch(HibernateException e){
			throw new MyException(e);
		}
		
	}

	@Override
	public void modificarSolicitud(Solicitud solicitud) throws MyException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			session.update(solicitud);
			
		}catch(HibernateException e){
			throw new MyException(e);
		}
		
	}

	public EmpleadoDao getEmpleadoDao() {
		return empleadoDao;
	}

	public void setEmpleadoDao(EmpleadoDao empleadoDao) {
		this.empleadoDao = empleadoDao;
	}

	public ClienteDao getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

}
