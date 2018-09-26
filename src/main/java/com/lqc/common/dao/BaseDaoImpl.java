package com.lqc.common.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.lqc.common.query.ClauseConnector;
import com.lqc.common.query.HQLClause;
import com.lqc.common.query.Page;
import com.lqc.common.query.Pageable;
import com.lqc.common.query.PropertyFilter;
import com.lqc.common.utils.HQLUtils;

public class BaseDaoImpl<T> implements BaseDao<T>{
	
	private static final FlushMode DEFAULT_FLUSH_MODE = FlushMode.COMMIT;
	
	/** 实体类型 */
	protected Class<T> entityClass;
	
	protected String findHql;
	
	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;
	
	public BaseDaoImpl() {
		Type type = getClass().getGenericSuperclass();
		Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
		entityClass = (Class<T>) parameterizedType[0];
	}
	
	/**
	 * @return 当前Session
	 */
	protected Session currentSession() {
		Session session =  sessionFactory.getCurrentSession();
		if (!DEFAULT_FLUSH_MODE.equals(session.getFlushMode())) {
			session.setFlushMode(DEFAULT_FLUSH_MODE);
		}
		return session;
	}

	@Override
	public T find(String id) {
		if (StringUtils.isEmpty(id)) {
			return null;
		}
		String hql = "from " + entityClass.getName() + " where id = :id";
		return (T) currentSession().createQuery(hql).setParameter("id", id).setMaxResults(1).uniqueResult();
	}

	@Override
	public List<T> findAll() {
		String hql = "from " + entityClass.getName();
		return currentSession().createQuery(hql).list();
	}

	@Override
	public Page<T> findPage(PropertyFilter[] propertyFilters, Pageable pageable) {
		String findListHql = "from " + entityClass.getName();
		String countHql = "select count(1) from " + entityClass.getName();
		HQLClause hqlClause = HQLUtils.toWhereClause(ClauseConnector.where, propertyFilters);
		findListHql += hqlClause;
		countHql += hqlClause;
		Long total = (Long) currentSession().createQuery(countHql).setProperties(hqlClause.getParameters()).uniqueResult();
		List<T> rows = null;
		if (total > 0) {
			rows = currentSession().createQuery(findListHql).setProperties(hqlClause.getParameters()).setFirstResult((pageable.getPage()-1)*pageable.getRows()).setMaxResults(pageable.getRows()).list();
		} else {
			rows = Collections.emptyList();
		}
		return new Page<T>(total, rows);
	}
	
}
