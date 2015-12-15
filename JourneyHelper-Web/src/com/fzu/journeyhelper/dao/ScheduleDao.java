package com.fzu.journeyhelper.dao;

import java.util.List;

import com.fzu.common.dao.BaseDao;
import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.Schedule;

/**
 * 
 * Copyright (C): 2015-Hoatshon Project Name: JourneyHelper-Web
 * 
 * Description: ClassName: com.fzu.journeyhelper.dao.ScheduleDao Author: Hoatson
 * Create Time: 2015��11��20�� ����6:04:05 Modified By: Modified Time: 2015��11��20��
 * ����6:04:05 Modified Remark:
 * 
 * @version V1.0
 */
public interface ScheduleDao extends BaseDao<Schedule> {

	/**
	 *查询行程的计划安排
	 * 
	 * @param myRoute
	 * @return
	 */
	public List<Schedule> findByRoute(Route Route);
}
