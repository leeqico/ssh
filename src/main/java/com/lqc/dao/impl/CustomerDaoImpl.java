package com.lqc.dao.impl;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.lqc.common.Page;
import com.lqc.common.Pageable;
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

	@Override
	public List<Customer> findList(String name) {
		String namehql = name == null ? "" : " where name like :name ";
		String hql = " from Customer " + namehql;
		Query query = currentSession().createQuery(hql);
		if (name != null) {
			query.setParameter("name", "%"+name+"%");
		}
		return query.list();
	}

	@Override
	public Page<Customer> findPage(Pageable pageable, String name) {
		String nameHql = name == null ? "" : " where name like :name ";
		String findListHql = " from Customer " + nameHql;
		String countHql = " select count(1) from Customer " + nameHql;
		Query query = currentSession().createQuery(countHql);
		if (name != null) {
			query.setParameter("name", "%"+name+"%");
		}
		Long total = (Long) query.uniqueResult();
		List<Customer> rows = null;
		if (total > 0) {
			Query countQuery = currentSession().createQuery(findListHql);
			if (name != null) {
				countQuery.setParameter("name", "%"+name+"%");
			}
			rows = countQuery.setFirstResult((pageable.getPage()-1)*pageable.getRows()).setMaxResults(pageable.getRows()).list();
		} else {
			rows = Collections.emptyList();
		}
		return new Page<Customer>(total,rows) ;
	}

}
