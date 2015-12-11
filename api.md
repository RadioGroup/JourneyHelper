### 接口形式 ：
#### host+接口功能+参数

#### 公网：
    host=http://120.27.34.200/JourneyHelper-Web
#### 内网：
    host=http://172.50.180.239/JourneyHelper-Web


----------

### 用户信息类型接口

#### 登入接口：
    host/userLogin?userName=hoatson&passWord=root
  
    返回数据形式：
    {
    	"status": 201, //201表示登录成功，202账户或者密码错误
    	"user": {
    		"age": 20,
    		"email": "756154017@qq.com",
    		"headUrl": "www.baidu.com",
    		"job": "学生",
    		"location": "福州",
    		"nickName": "牛逼哄哄",
    		"realName": "陈灿",
    		"sex": "男",
    		"telephoneNumber": "18859976557",
    		"userId": 1,
    		"userName": "root"
    	}
    }

#### 注册接口：
    host/userRegist?userName=hoatson&passWord=root&nickName=霍森&realName=陈灿&sex=男&age=20&job=学生&Email=756154017@qq.com&Telephone=18859976557&location=福州&headUrl=www.baidu.com
    返回数据形式：
    {
        "status": 301,//301注册成功，302用户名已被占用
        "user": {
            "age": 20,
            "email": "756154017@qq.com",
            "headUrl": "www.baidu.com",
            "job": "学生",
            "location": "福州",
            "nickName": "霍森",
            "realName": "陈灿",
            "sex": "男",
            "telephoneNumber": "18859976557",
            "userId": 4,
            "userName": "tom"
        },
        "userName": "tom"
    }
    


----------

### 行程类接口

#### 行程创建接口

    host/createRoute?userId=1&title=行程标题&beginTime=2015-12-24 08:00:00&endTime=2015-12-27 12:00:00&summary=行程摘要&article=行程详情描述&routeImageUrl=http://img.517huwai.com/Public/Uploads/2015/10/27/562f2af0d6762.jpg@560w_1000h&type=100&secnics=途径景点用分号隔开&assemblingPlace=集合地点&strengthGrade=活动强度
    
    返回数据形式：
    {
        "route": {
            "article": "行程详情描述",
            "assemblingPlace": "集合地点",
            "beginTime": "2015-12-24T08:00:00",
            "createTime": null,
            "endTime": "2015-12-27T12:00:00",
            "routeId": 10,
            "routeImageUrl": "http://img.517huwai.com/Public/Uploads/2015/10/27/562f2af0d6762.jpg@560w_1000h",
            "secnics": "途径景点用分号隔开",
            "strengthGrade": "活动强度",
            "summary": "行程摘要",
            "title": "行程标题",
            "type": 100,
            "user": {
            "age": 22,
            "email": "756154017@qq.com",
            "headUrl": "www.baidu.com",
            "job": "学生",
            "location": "福州",
            "nickName": "陈灿",
            "realName": "陈灿",
            "sex": "男",
            "telephoneNumber": "18859976557",
            "userId": 1,
            "userName": "root"
            }
        },
        "status": 201 //201创建成功，202
    }

添加行程安排：

    host/addSchedules?routeId=1&schedules={"routeId":1,"schedules":[{"accommodation":"七天连锁","beginTime":"2015-12-16 19:35:45","budget":204.3,"destination":"湘潭","diner":"火车上解决","endTime":"2015-12-09 19:36:23","remark":"下火车后直接到湘潭市中心七天旅馆","schedulingId":1,"vehicle":"火车"}],"status":null}
    
    返回数据形式：
    {
        "status": 201//201成功
    }

#### 查询用户自己创建的行程接口
    host/findCreatedRoutes?userId=1
   
    返回数据形式：
    {
        "createList": [
         {
            "article": "此地庙宇之宏伟，远胜古希腊、罗马遗留给我们的一切，走出吴哥庙宇，重\r\n返人间，刹那间犹如从灿烂的文明堕入蛮荒。”----让吴哥窟重见天日的法国生物\r\n学家亨利•穆奥如是说。\r\n 也许是当年盛极一时的辉煌过去，或是五朵莲花塔之上的那抹金色，亦或是\r\n《花样年华》里梁朝伟暧昧的倾诉，吴哥窟，在向往它的人眼中，总像一声神秘\r\n幽远的叹息，吸引了全世界各地的人如同朝圣者一般，跨越千山万水来虔诚地膜\r\n拜。2016年元旦，指南针户外跟您一起前往柬埔寨暹粒一睹真容。",
            "assemblingPlace": null,
            "beginTime": "2015-12-24T08:00:00",
            "createTime": null,
            "endTime": "2015-12-27T12:00:00",
            "routeId": 2,
            "routeImageUrl": "http://img.517huwai.com/Public/Uploads/2015/10/27/562f2af0d6762.jpg@560w_1000h",
            "secnics": null,
            "strengthGrade": null,
            "summary": "特色：本活动属于纯玩+摄影半自助游性质，不安排购物环节，想买纪念品的可以利用最后一天自由活动的时间结伴前往老市场逛街。独立成行不跟旅行社拼团，限制16人以内，指南针领队亲自带队，人少玩的才自在。",
            "title": "【指南针】《元旦》高棉的微笑---神秘吴哥窟，柬埔寨6天5晚小队伍摄影",
            "type": null,
            "user": { //行程创建者
                "age": 22,
                "email": "756154017@qq.com",
                "headUrl": "www.baidu.com",
                "job": "学生",
                "location": "福州",
                "nickName": "陈灿",
                "realName": "陈灿",
                "sex": "男",
                "telephoneNumber": "18859976557",
                "userId": 1,
                "userName": "root"
                }
            },
            ……
        ],
        "status": 301
    }

#### 查询用户参与的行程
    host/findJoingRoutes?userId=1
    
    返回数据形式：
    同查询用户自己创建的行程接口
    
#### 行程安排查询接口
    host/findRouteScheduleList?routeId=1
    
    返回数据形式：
    {
        "routeId": 1,
        "schedules": [
            {
                "accommodation": "七天连锁",
                "beginTime": "2015-12-16T19:35:45",
                "budget": 204,
                "destination": "湘潭",
                "diner": "火车上解决",
                "endTime": "2015-12-09T19:36:23",
                "remark": "下火车后直接到湘潭市中心七天旅馆",
                "schedulingId": 6,
                "vehicle": "火车"
            }
            ……
        ],
        "status": null
    }

#### 查询行程参与用户的列表查询接口

    host/findRouteMenberList?routeId=1
    //返回数据类型
    {
        "routeId": 1,
        "status": null,
        "users": [
            {
                "age": 22,
                "email": "756154017@qq.com",
                "headUrl": "www.baidu.com",
                "job": "学生",
                "location": "福州",
                "nickName": "陈灿",
                "realName": "陈灿",
                "sex": "男",
                "telephoneNumber": "18859976557",
                "userId": 1,
                "userName": "root"
            }
            ……
        ]
    }




### 通知类型接口：
#### 查询用户的通知：
#####未读通知：
    host/findUserNotHandleNotification?userId=1
    {
        "notifications": [
        {
            "content": "用户 x申请加入行程y",
            "createTime": null,
            "ishandle": 1,
            "notificationId": 1,
            "route": {
                "article": "线路描述",
                "assemblingPlace": null,
                "beginTime": "2015-12-12T12:00:00",
                "createTime": null,
                "endTime": "2015-12-12T18:00:00",
                "routeId": 1,
                "routeImageUrl": "http://static02.lvye.com/lvyecms/media/homepagecms/201512/1449215916.35.png",
                "secnics": null,
                "strengthGrade": null,
                "summary": "线路描述",
                "title": "【逍遥游】12月12日【周六】“渔阳的激情”特价滑雪“120元”爽滑一整天，赠送入门辅导",
                "type": null
            },
            "type": 1,
            "userBySendUserId": {
                "age": 22,
                "email": "756154017@qq.com",
                "headUrl": "www.baidu.com",
                "job": "学生",
                "location": "福州",
                "nickName": "陈灿",
                "realName": "陈灿",
                "sex": "男",
                "telephoneNumber": "18859976557",
                "userId": 1,
                "userName": "root"
            }
        }
        ],
        "status": 201
}

#### 数据更新类型

修改用户信息：

host/updateUserInfoAction?userId=1&passWord=root&nickName=霍森&realName=陈灿&sex=男&age=22&job=学生&Email=756154017@qq.com&Telephone=18859976557&location=福州&headUrl=www.baidu.com

#### 发送一条加入行程的申请

    host/applyJoinRoute?userId=1&routeId=1
    {
        "status": 201//201成功
    }
