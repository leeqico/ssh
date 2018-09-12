package com.lqc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.lqc.dao.UserDao;
import com.lqc.entity.User;

@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao{
	
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
	public List<User> getUsers() {
		return currentSession().createQuery("from User").list();
	}

	@Override
	public Boolean login(String mobile, String password) {
		String hql = "select 1 from User where mobile = :mobile and password = :password"; 
		Query query = currentSession().createQuery(hql).setParameter("mobile", mobile).setParameter("password", password);
		return query.setMaxResults(1).uniqueResult() != null;
	}

	@Override
	public User findByMobileAndPassword(String mobile, String password) {
		String hql = "from User where mobile = :mobile and password = :password"; 
		Query query = currentSession().createQuery(hql).setParameter("mobile", mobile).setParameter("password", password);
		return (User) query.setMaxResults(1).uniqueResult();
	}

	@Override
	public User findByMobile(String mobile) {
		String hql = "from User where mobile = :mobile";
		Query query = currentSession().createQuery(hql).setParameter("mobile", mobile);
		return (User) query.setMaxResults(1).uniqueResult();
	}

}
