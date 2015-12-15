package com.fzu.journeyhelper.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeDateUtil {
	
	
	public static Date stringToDate(String timeString){
		
		Date ans = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			ans = sdf.parse(timeString);			
		} catch (Exception e) {
			// 防止客户端返回的数据转码后出现问题
			System.out.println("客户端时间格式有问题，时间格式为："+timeString);
			ans =null;
		}
		
		return ans;
	}
	
}
