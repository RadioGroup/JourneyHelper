//
//  RightViewController.swift
//  SwiftSideslipLikeQQ
//
//  Created by 吴先滇 on 15/12/10.
//  Copyright © 2015年 com.lvwenhan. All rights reserved.
//

import UIKit
import Alamofire

class RightViewController: UIViewController {

    
    @IBOutlet weak var journeyPlanText: UITextView!
        @IBOutlet weak var journeyPlaceText: UITextField!
    @IBOutlet weak var journeyTimeText: UITextField!
    @IBOutlet weak var journeyTitleText: UITextField!
    var userDefaults: NSUserDefaults!
    override func viewDidLoad()
    {
        super.viewDidLoad()
        self.userDefaults = NSUserDefaults.standardUserDefaults()
        
        
        
        // Do any additional setup after loading the view.
    }

    @IBAction func submitAction(sender: AnyObject)
    {
        let titleText = (journeyTitleText.text)!
        let timeText = (journeyTimeText.text)!
        let planText = (journeyPlanText.text)!
        let placeText = (journeyPlaceText.text)!
        
        
        let userId = (userDefaults.objectForKey("userId"))!
        print("userId 测试输出 \(userId) \(titleText) \(timeText) \(planText) \(placeText)")
        
        
        
        let parameters = [
            "userId": "1",
            "title":"\(titleText)",
            "beginTime":"2015-12-27 12:00:00",
            "endTime":"2015-12-27 12:00:00",
            "summary":"\(planText)",
            "article":"行程描述",
            "routeImageUrl":"http://img.517huwai.com/Public/Uploads/2015/10/27/562f2af0d6762.jpg@560w_1000h",
            "type":"201",
            "secnics":"途径景点用分号隔开",
            "assemblingPlace":"\(placeText)",
            "strengthGrade":"活动强度",
        ]
        

        
        Alamofire.request(.POST, "http://120.27.34.200/JourneyHelper-Web/createRoute", parameters:parameters,encoding: .URL)
            .responseString { response in
                print(response.request)
                print(response.response)
                print(response.result)
                print(response.debugDescription)
                print(Alamofire.URLStringConvertible)
        }

//        let URL = NSURL(string: "http://120.27.34.200/JourneyHelper-Web/createRoute")!
//        var request = NSMutableURLRequest(URL: URL)
//        
//        let encoding = Alamofire.ParameterEncoding.URL
//        (request, _) = encoding.encode(request, parameters: parameters)
//        print(encoding)
      
        
//        Alamofire.request(.POST, "http://120.27.34.200/JourneyHelper-Web/createRoute?userId=1&title=行程标题&beginTime=2015-12-24 08:00:00&endTime=2015-12-27 12:00:00&summary=行程摘要&article=行程详情描述&routeImageUrl=http://img.517huwai.com/Public/Uploads/2015/10/27/562f2af0d6762.jpg@560w_1000h&routeImageUrl=100&secnics=途径景点用分号隔开&assemblingPlace=集合地点&strengthGrade=活动强度")

//        let URL = NSURL(string: "http://172.50.180.239//createRoute?userId=\(userId)&title=\(titleText)&beginTime=\(timeText)&endTime=nil&summary=nil&article=\(planText)&routeImageUrl=nil&type=nil&secnics=nil&assemblingPlace=\(placeText)&strengthGrade=nil")!
//        let request = NSMutableURLRequest(URL: URL)
//        print("数据:\(URL)")
//        Alamofire.request(.GET, request)
//            .responseJSON
//        {
//            response in
//                debugPrint(response)
//        }
        
        
        
    }
    
    
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
