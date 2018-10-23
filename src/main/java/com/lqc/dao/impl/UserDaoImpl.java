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
	public User findByMobile(String mobile) {
		String hql = "from User where mobile = :mobile";
		Query query = currentSession().createQuery(hql).setParameter("mobile", mobile);
		return (User) query.setMaxResults(1).uniqueResult();
	}

	@Override
	public Boolean isExistMobile(String mobile) {
		String hql = "from User where mobile = :mobile";
		Query query = currentSession().createQuery(hql).setParameter("mobile", mobile);
		return query.setMaxResults(1).uniqueResult() != null;
	}

	@Override
	public void save(User user) {
		currentSession().save(user);
	}

	@Override
	public User findById(String userId) {
		String hql = "from User where id = :userId";
		Query query = currentSession().createQuery(hql).setParameter("userId", userId);
		return (User) query.setMaxResults(1).uniqueResult();
	}

}
