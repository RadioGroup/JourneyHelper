//
//  RightViewController.swift
//  SwiftSideslipLikeQQ
//
//  Created by 吴先滇 on 15/12/10.
//  Copyright © 2015年 com.lvwenhan. All rights reserved.
//

import UIKit
import Alamofire

class RightViewController: UIViewController,UITextFieldDelegate,UITextViewDelegate {

    
    @IBOutlet weak var journeyPlanText: UITextView!
        @IBOutlet weak var journeyPlaceText: UITextField!
    @IBOutlet weak var journeyTimeText: UITextField!
    @IBOutlet weak var journeyTitleText: UITextField!
    var userDefaults: NSUserDefaults!
    override func viewDidLoad()
    {
        super.viewDidLoad()
        self.userDefaults = NSUserDefaults.standardUserDefaults()
        self.journeyPlaceText.delegate = self
        self.journeyPlanText.delegate = self
        self.journeyTimeText.delegate = self
        self.journeyTitleText.delegate = self
        
        
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
        
        
        
//        let parameters = [
//            "userId": "1",
//            "title":"\(titleText)",
//            "beginTime":"2015-12-27 12:00:00",
//            "endTime":"2015-12-27 12:00:00",
//            "summary":"\(planText)",
//            "article":"行程描述",
//            "routeImageUrl":"http://img.517huwai.com/Public/Uploads/2015/10/27/562f2af0d6762.jpg@560w_1000h",
//            "type":"201",
//            "secnics":"途径景点用分号隔开",
//            "assemblingPlace":"\(placeText)",
//            "strengthGrade":"活动强度",
//        ]
//        
//
//        
//        Alamofire.request(.POST, "http://120.27.34.200/JourneyHelper-Web/createRoute", parameters:parameters,encoding: .URL)
//            .responseString { response in
//                print(response.request)
//                print(response.response)
//                print(response.result)
//                print(response.debugDescription)
//                print(Alamofire.URLStringConvertible)
//        }

        
       let hostString = host!
       var str = "\(hostString)/createRoute?userId=\(userId)&title=\(titleText)&beginTime=&endTime=&summary=&article=\(planText)&routeImageUrl=&type=&secnics=&assemblingPlace=\(placeText)&strengthGrade="
        str =  str.stringByAddingPercentEscapesUsingEncoding(NSUTF8StringEncoding)!
        let URL =  NSURL(string:str)!
        let request = NSMutableURLRequest(URL: URL)
        print("数据:\(URL)")
        Alamofire.request(.GET, request)
            .responseJSON
        {
            response in
                debugPrint(response)
        }
        
        
        
    }
   
    func textViewShouldEndEditing(textView: UITextView) -> Bool {
        textView.resignFirstResponder()
        return true
    }
    
    override func touchesBegan(touches: Set<UITouch>, withEvent event: UIEvent?) {
        journeyTitleText.resignFirstResponder()
        journeyTimeText.resignFirstResponder()
        journeyPlanText.resignFirstResponder()
        journeyPlaceText.resignFirstResponder()
        
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
