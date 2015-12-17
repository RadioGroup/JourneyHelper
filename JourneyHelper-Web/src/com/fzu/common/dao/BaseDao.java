package com.fzu.common.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {

	/**
	 * 根据主键查询是否存在
	 * 
	 * @param entityClazz
	 * @param id
	 * @return
	 */
	boolean isExist(Class<T> entityClazz, Serializable id);

	/**
	 * 
	 * @param entityClazz
	 * @param id
	 * @return
	 */
	T get(Class<T> entityClazz, Serializable id);

	/**
	 * 
	 * @param entity
	 * @return
	 */
	Serializable save(T entity);

	/**
	 * 
	 * @param entity
	 */
	void update(T entity);

	/**
	 * 
	 * @param entity
	 */
	void delete(T entity);

	/**
	 * 
	 * @param entityClazz
	 * @param id
	 */
	void delete(Class<T> entityClazz, Serializable id);

	/**
	 * 
	 * @param entityClazz
	 * @return
	 */
	List<T> findAll(Class<T> entityClazz);

	/**
	 * 
	 * @param entityClazz
	 * @return
	 */
	long findCount(Class<T> entityClazz);

	List<T> findByPage(String hql, int pageNo, int pageSize);

	List<T> findByPage(String hql, int pageNo, int pageSize, Object... params);

	List<T> findByPageSQL(String sql, int pageNo, int pageSize);

	List<T> findByPageSQL(String sql, int pageNo, int pageSize, Object... params);
}
