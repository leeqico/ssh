package com.lqc.common.dao;

import java.util.List;

import com.lqc.common.query.Page;
import com.lqc.common.query.Pageable;
import com.lqc.common.query.PropertyFilter;

public interface BaseDao<T> {
	
	/**
	 * 按ID查询
	 * @param id ID
	 * @return 实体，若不存在则返回null
	 */
	T find(String id);
	
	/**
	 * 查询全部
	 * @return
	 */
	List<T> findAll();
	
	/**
	 * 分页查询
	 * @param pageable
	 * @return
	 */
	Page<T> findPage(PropertyFilter[] propertyFilters, Pageable pageable);

}
