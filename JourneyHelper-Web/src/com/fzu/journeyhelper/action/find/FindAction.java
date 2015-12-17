package com.fzu.journeyhelper.action.find;

import java.util.List;

import com.fzu.journeyhelper.action.BaseAction;
import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;

public class FindAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private Integer status;
	private String searchUser="0";
	private String searchRoute="0";
	private List<User> users;
	private List<Route> routes;
	
	
	private Integer page=1;// 页码
	private Integer pagesize=20;// 每页大小
	private long count = 0;// 总大小
	
	public Integer getStatus(){
		return this.status;
	}
	
	public void setSearchUser(String searchUser) {
		this.searchUser = searchUser;
	}
	
	
	
	public void setSearchRoute(String searchRoute) {
		this.searchRoute = searchRoute;
	}

	public List<User> getUsers() {
		return users;
	}

	
	
	public List<Route> getRoutes() {
		return routes;
	}

	
	public long getCount() {
		return count;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	
	
	@Override
	public String toString() {
		return "FindAction [status=" + status + ", searchUser=" + searchUser
				+ ", searchRoute=" + searchRoute + ", page=" + page
				+ ", pagesize=" + pagesize + ", count=" + count + "]";
	}

	public String searchUser(){
		System.out.println(toString());
		count = userManager.searchUserCount(searchUser);
		if(count!=0){			
			users = userManager.searchUser(searchUser,page,pagesize);
			status = 201;
			return SUCCESS;
		}else{
			status = 202;
			return ERROR;
		}
		
		
	}
	
	public String searchRoute(){
		System.out.println(toString());
		count = routeManager.searchRouteCount(searchRoute);
		if(count!=0){
			routes = routeManager.searchRoute(searchRoute,page,pagesize);
			return SUCCESS;	
		}else{
			status =202;
			return ERROR;
		}
		
		
	}
	
	
}
