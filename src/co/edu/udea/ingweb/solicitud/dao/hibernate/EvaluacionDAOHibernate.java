package co.edu.udea.ingweb.solicitud.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.ingweb.solicitud.dao.EvaluacionDao;
import co.edu.udea.ingweb.solicitud.dto.Evaluacion;
import co.edu.udea.ingweb.util.exception.MyException;

public class EvaluacionDAOHibernate extends HibernateDaoSupport implements EvaluacionDao {

	@Override
	public List<Evaluacion> listarEvaluacion() throws MyException {
	List<Evaluacion> evaluaciones = new ArrayList<Evaluacion>();
		
		try{
			Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			Criteria criteria = session.createCriteria(Evaluacion.class);
			
			evaluaciones = criteria.list();
		}catch(HibernateException e){
			throw new MyException(e);
		}
		return evaluaciones;
	}

	@Override
	public Evaluacion obtenerEvaluacion(int identificacion) throws MyException{
		Evaluacion evaluacion = null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			evaluacion = (Evaluacion)session.get(Evaluacion.class, identificacion);
			
		}catch(HibernateException e){
			throw new MyException(e);
			
	}
	
	return evaluacion;

	}


	@Override
	public void crearEvaluacion(Evaluacion evaluacion) throws MyException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.save(evaluacion);
		}catch(HibernateException e){
			throw new MyException(e);
		}
		
	}

	@Override
	public void eliminarEvaluacion(Evaluacion evaluacion) throws MyException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			session.delete(evaluacion);
			
		}catch(HibernateException e){
			throw new MyException(e);
		}
		
	}

	@Override
	public void modificarEvaluacion(Evaluacion evaluacion) throws MyException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			session.update(evaluacion);
			
		}catch(HibernateException e){
			throw new MyException(e);
		}
		
	}

}
