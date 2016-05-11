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
import co.edu.udea.ingweb.solicitud.dao.RespuestaDao;
import co.edu.udea.ingweb.solicitud.dto.Cliente;
import co.edu.udea.ingweb.solicitud.dto.Empleado;
import co.edu.udea.ingweb.solicitud.dto.Evaluacion;
import co.edu.udea.ingweb.solicitud.dto.Respuesta;
import co.edu.udea.ingweb.util.exception.MyException;

public class RespuestaDAOHibernate extends HibernateDaoSupport implements RespuestaDao {

	@Override
	public List<Respuesta> listarRespuestas() throws MyException {
	List<Respuesta> respuestas = new ArrayList<Respuesta>();
		
		try{
			Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			Criteria criteria = session.createCriteria(Evaluacion.class);
			
			respuestas = criteria.list();
		}catch(HibernateException e){
			throw new MyException(e);
		}
		return respuestas;
	}

	@Override
	public Respuesta obtenerRespuesta(int identificacion) throws MyException{
		Respuesta respuesta = null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			respuesta = (Respuesta)session.get(Respuesta.class, identificacion);
			
		}catch(HibernateException e){
			throw new MyException(e);
			
	}
	
	return respuesta;

	}


	@Override
	public void crearRespuesta(Respuesta respuesta) throws MyException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.save(respuesta);
		}catch(HibernateException e){
			throw new MyException(e);
		}
		
	}

	@Override
	public void eliminarRespuesta(Respuesta respuesta) throws MyException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			session.delete(respuesta);
			
		}catch(HibernateException e){
			throw new MyException(e);
		}
		
	}

	@Override
	public void modificarRespuesta(Respuesta respuesta) throws MyException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			session.update(respuesta);
			
		}catch(HibernateException e){
			throw new MyException(e);
		}
		
	}

}
