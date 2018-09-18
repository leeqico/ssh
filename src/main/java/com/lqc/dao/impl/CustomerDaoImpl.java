package com.lqc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.lqc.dao.CustomerDao;
import com.lqc.entity.Customer;

@Repository(value = "customerDaoImpl")
public class CustomerDaoImpl implements CustomerDao {
	
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	protected Session currentSession() {
		Session session = sessionFactory.getCurrentSession();
		if (!FlushMode.COMMIT.equals(session.getFlushMode())) {
			session.setFlushMode(FlushMode.COMMIT);
		}
		return session;
	}

	@Override
	public List<Customer> findAll() {
		return currentSession().createQuery("from Customer").list();
	}

	@Override
	public void save(Customer customer) {
		currentSession().save(customer);
	}

	@Override
	public Customer findCustomerById(String id) {
		String hql = " from Customer where id = :id";
		return (Customer) currentSession().createQuery(hql).setParameter("id", id).setMaxResults(1).uniqueResult();
	}

	@Override
	public void update(Customer customer) {
		currentSession().update(customer);
	}

	@Override
	public void removeCustomerById(String id) {
		String sql = "delete from customer where id = :id";
		currentSession().createSQLQuery(sql).setParameter("id", id).executeUpdate();
	}

}
