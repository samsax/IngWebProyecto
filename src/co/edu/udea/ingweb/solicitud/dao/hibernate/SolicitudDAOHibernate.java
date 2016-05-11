package co.edu.udea.ingweb.solicitud.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sun.media.sound.EmergencySoundbank;

import co.edu.udea.ingweb.solicitud.dao.ClienteDao;
import co.edu.udea.ingweb.solicitud.dao.EmpleadoDao;
import co.edu.udea.ingweb.solicitud.dao.EvaluacionDao;
import co.edu.udea.ingweb.solicitud.dao.SolicitudDao;
import co.edu.udea.ingweb.solicitud.dto.Cliente;
import co.edu.udea.ingweb.solicitud.dto.Empleado;
import co.edu.udea.ingweb.solicitud.dto.Evaluacion;
import co.edu.udea.ingweb.solicitud.dto.Solicitud;
import co.edu.udea.ingweb.util.exception.MyException;

public class SolicitudDAOHibernate extends HibernateDaoSupport implements SolicitudDao
{

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

}
