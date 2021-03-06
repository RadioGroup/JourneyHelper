package com.fzu.journeyhelper.dao.impl;

import static org.hibernate.criterion.Example.create;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.fzu.common.dao.impl.BaseDaoHibernate4;
import com.fzu.journeyhelper.dao.RouteDao;
import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;

/**
 * A data access object (DAO) providing persistence and search support for Route
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.fzu.journeyhelper.domain.Route
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class RouteDaoImple extends BaseDaoHibernate4<Route> implements RouteDao {
	// property constants
	public static final String TITLE = "title";
	public static final String SUMMARY = "summary";
	public static final String ARTICLE = "article";

	@SuppressWarnings("unchecked")
	public List<Route> findByExample(Route instance) {
		log.debug("finding Route instance by example");
		try {
			List<Route> results = (List<Route>) getCurrentSession()
					.createCriteria("com.fzu.journeyhelper.domain.Route")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Route> findByTitle(Object title) {
		return findByProperty(Route.class, TITLE, title);
	}

	@SuppressWarnings("unchecked")
	public List<Route> findBySummary(Object summary) {
		return findByProperty(Route.class, SUMMARY, summary);
	}

	@SuppressWarnings("unchecked")
	public List<Route> findByArticle(Object article) {
		return findByProperty(Route.class, ARTICLE, article);
	}

	public static RouteDaoImple getFromApplicationContext(ApplicationContext ctx) {
		return (RouteDaoImple) ctx.getBean("RouteDaoImple");
	}

	@Override
	public Set<Route> findRoutelistByUser(User user) {
		return null;
	}

	@Override
	public Set<Route> findCreatelistByUser(User user) {
		return null;
	}

	/**
	 * 根据参数查询数量
	 */
	@Override
	public BigInteger findCount(Integer userId, Integer type, short isJoin) {

		// TODO isJoin 为判断用户是否参加，等待完善
		// String sql = "select count(r.routeId) from "
		// + "journeyhelperweb.route_user_relevance j"
		// + " inner join journeyhelperweb.route r "
		// + "on j.routeId=r.routeId " + "where j.userId <> ?0 "
		// + "and r.type = ?1 ";

		String sql2 = "select count(r.routeId) from journeyhelperweb.route r "
				+ "where r.routeId not in "
				+ "(select j.routeId from journeyhelperweb.route_user_relevance j"
				+ " where j.userId =?0 ) " + "and r.type = ?1 ";

		System.out.println("something erro");

		List<?> l = findBySql(sql2, userId, type);

		if (l != null && l.size() == 1) {
			return (BigInteger) l.get(0);
		} else {
			return new BigInteger("0");
		}
	}

	@Override
	public long findRoutesCount(String findkey) {

		findkey = "%" + findkey + "%";

		String hql1 = "select count(*) from Route as r left join r.user as u "
				// + "where r.user = u "
				+ "where " + " u.userName LIKE ?0" + " or u.nickName LIKE ?0"
				+ " or u.realName LIKE ?0" + " or u.email LIKE ?0"
				+ " or u.telephoneNumber LIKE ?0" + " or r.title LIKE ?0 "
				+ " or r.assemblingPlace LIKE ?0" + " or r.secnics LIKE ?0 "
				+ " or r.strengthGrade LIKE ?0 ";

		List<?> l = find(hql1, findkey);
		if (l != null && l.size() == 1) {
			return (Long) l.get(0);
		} else {
			return 0;
		}

	}

	@Override
	public List<Route> findRoutesByPage(String findkey, Integer pageNo,
			Integer pagesize) {
		findkey = "%" + findkey + "%";

		String hql = "select r from Route as r left join r.user u "
				// + "where r.user = u "
				+ " where " + " u.userName LIKE ?0" + " or u.nickName LIKE ?0"
				+ " or u.realName LIKE ?0" + " or u.email LIKE ?0"
				+ " or u.telephoneNumber LIKE ?0" + " or r.title LIKE ?0 "
				+ " or r.assemblingPlace LIKE ?0" + " or r.secnics LIKE ?0 "
				+ " or r.strengthGrade LIKE ?0 "
				+ "order by r.routeId desc";
		return findByPage(hql, pageNo, pagesize, findkey);
	}

	@Override
	public List<Route> findNewRouteByPage(int pageNo, int pageSize,
			Object[] params) {

		String hql3 = "from Route re where re not in ("
				+ "select elements(u.joinRoutes) from User u"
				+ " where u.userId=?0 " + ") " + "and re.type =?1 "
				+ "order by re.routeId desc";
		return findByPage(hql3, pageNo, pageSize, params);
	}
}