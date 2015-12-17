package com.fzu.journeyhelper.action.find;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fzu.journeyhelper.action.BaseAction;
import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;

/**
 * 行程查找action
 * 
 * @author Volcano
 * 
 */
public class FindRouteAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer status;
	// 通过用户名或者id获得用户的行程表
	private Integer userId;
	private String userName;

	private Integer type;
	private Integer page=1;// 页码
	private Integer pagesize=20;// 每页大小
	private BigInteger count = new BigInteger("0");// 总大小
	private short isJoin = 0;// 是否参加这个行程 ， 0便是没有参加的，1表示包括参加的

	private Set<Route> createList;
	private Set<Route> joindeList;
	private Set<Route> allList;

	public Integer getStatus() {
		return status;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public BigInteger getCount() {
		return count;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public void setIsJoin(short isJoin) {
		this.isJoin = isJoin;
	}

	public Set<Route> getCreateList() {
		return createList;
	}

	public Set<Route> getJoindeList() {
		return joindeList;
	}

	public Set<Route> getAllList() {
		return allList;
	}

	@Override
	public String toString() {
		return "FindRouteAction [userId=" + userId + ", userName=" + userName
				+ ", type=" + type + ", page=" + page + ", pagesize="
				+ pagesize + ", count=" + count + ", isJoin=" + isJoin + "]";
	}

	@Override
	public String execute() throws Exception {
		return null;
	}

	public String findCreateRoutes() throws Exception {
		User user = new User();
		user.setUserId(getUserId());
		user.setUserName(userName);
		createList = routeManager.findUserCreateRouteList(user);
		System.out.println(createList.size());
		status = 301;
		return SUCCESS;
	}

	public String findJoingRoutes() throws Exception {
		User user = new User();
		user.setUserId(getUserId());
		user.setUserName(userName);
		joindeList = routeManager.findUserJoinedRouteList(user);
		status = 301;
		return SUCCESS;
	}

	public String findallRoutes() throws Exception {
		User user = new User();
		user.setUserId(getUserId());
		user.setUserName(userName);
		createList = routeManager.findUserAllRouteList(user);
		status = 301;
		return SUCCESS;
	}

	/**
	 * 查询行程广场
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findNewRoute() throws Exception {

		System.out.println(toString());
		count = routeManager.findNewRouteCount(userId, type, isJoin);
		if (count.compareTo(BigInteger.ZERO) == 1) {
			List<Route> ans = routeManager.findNewRoute(page, pagesize, userId, type);
			allList = new HashSet<Route>();
			allList.addAll(ans); 
		}
		status = 301;
		return SUCCESS;
	}

}
