package co.edu.udea.ingweb.solicitud.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import co.edu.udea.ingweb.solicitud.dto.Cliente;
import co.edu.udea.ingweb.util.exception.MyException;

public class ClienteDaoImpl implements ClienteDao{

	@Override
	public List<Cliente> listarClientes() throws MyException {
		List<Cliente> clientes = new ArrayList<Cliente>();
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(Cliente.class);
			clientes = criteria.list();
		}catch(HibernateException e){
			throw new MyException(e);
		}
		return clientes;
	}

	@Override
	public Cliente obtenerCliente(int identificacion) throws MyException {
		Cliente cliente = null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			cliente = (Cliente)session.get(Cliente.class, identificacion);
			
		}catch(HibernateException e){
			throw new MyException(e);
		}
		
		return cliente;
	}

	@Override
	public void crearCliente(Cliente cliente) throws MyException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.save(cliente);
		}catch(HibernateException e){
			throw new MyException(e);
		}
	}

	@Override
	public void eliminarCliente(Cliente cliente) throws MyException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarCliente(Cliente cliente) throws MyException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			session.update(cliente);
			
		}catch(HibernateException e){
			throw new MyException(e);
		}
	}

}
