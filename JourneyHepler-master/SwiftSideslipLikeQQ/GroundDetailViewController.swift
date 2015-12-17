//
//  GroundDetailViewController.swift
//  SwiftSideslipLikeQQ
//
//  Created by apple on 15/12/16.
//  Copyright © 2015年 com.lvwenhan. All rights reserved.
//

import UIKit
import Alamofire

class GroundDetailViewController: UIViewController,UIAlertViewDelegate {
    @IBOutlet weak var articleText: UITextView!

    @IBOutlet weak var photoView: UIImageView!
    var alertView : UIAlertView!
    var userid: Int?
    var userDefaults: NSUserDefaults?
    
    
    var index:Int = 0
    override func viewDidLoad() {
        super.viewDidLoad()
        self.userDefaults = NSUserDefaults.standardUserDefaults()
        self.articleText.text = stringOther?.objectAtIndex(index).objectForKey("article") as? String
        
        var url:NSURL?
        var data:NSData?
        var image:UIImage?
        var strUrl:String?
        
        strUrl =  (stringOther?.objectAtIndex(index).objectForKey("routeImageUrl") as? String)
        
        if strUrl == nil
        {
            self.photoView.image = UIImage(named: "nil")
        }else
        {
            url = NSURL(string:strUrl!)
            data = NSData(contentsOfURL:url!)
            if data == nil
            {
                self.photoView.image = UIImage(named: "nil")
            }else{
                image = UIImage(data:data!)
                self.photoView.image = image
            }
        }
        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    @IBAction func joinIn(sender: AnyObject)
    {
        self.alertView = UIAlertView.init(title: "提示", message: "是否确定要加入该行程", delegate:self, cancelButtonTitle:"取消", otherButtonTitles:"确定")
        self.alertView.show()
    }
    
    func alertView(alertView: UIAlertView, clickedButtonAtIndex buttonIndex: Int)
    {
        if buttonIndex == 0
        {
            
        }else
        {
            SVProgressHUD.showWithStatus("请求中。。。")
            self.userid = self.userDefaults?.objectForKey("userId") as? Int
            print("ID\(self.userid)")
            if(userid == nil)
            {
                SVProgressHUD.showErrorWithStatus("请求错误，请重新登录后尝试")
                
            }else
            {
                let routeId = groundRouteId!
                let userId = self.userid!
                //            let userId = self.userid!
                let URL = NSURL(string: "http://172.50.180.239/JourneyHelper-Web/applyJoinRoute?userId=\(userId)&routeId=\(routeId)")!
                print(URL)
                let request = NSMutableURLRequest(URL: URL)
                Alamofire.request(.GET,request)
                    .responseJSON
                    {
                        response in
                        if response.result.isSuccess
                        {
                            SVProgressHUD.showSuccessWithStatus("请求已发送")
                            
                        }else if response.result.isFailure
                        {
                            SVProgressHUD.showErrorWithStatus("您的网络挂了")
                        }
                }
            }
            

        }
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
