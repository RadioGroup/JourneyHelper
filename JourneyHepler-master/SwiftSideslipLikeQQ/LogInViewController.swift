//
//  LogInViewController.swift
//  SwiftSideslipLikeQQ
//
//  Created by 吴先滇 on 15/12/11.
//  Copyright © 2015年 com.lvwenhan. All rights reserved.
//

import UIKit
import Alamofire

class LogInViewController: UIViewController
{
    @IBOutlet weak var usernameText: UITextField!
    @IBOutlet weak var passwordText: UITextField!
    var userDefaults: NSUserDefaults!
    var alertView : UIAlertView!
    var data: NSDictionary?
    var userData: NSDictionary?

    override func viewDidLoad()
    {
        super.viewDidLoad()
        self.userDefaults = NSUserDefaults.standardUserDefaults()
        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning()
    {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    @IBAction func logInAction(sender: AnyObject)
    {
        let user = "hoatson"
        let password = "root"
        
        SVProgressHUD.showWithStatus("努力加载中")
        
        Alamofire.request(.GET, "http://120.27.34.200/JourneyHelper-Web/userLogin?userName=\(user)&passWord=\(password)")
            .authenticate(user: user, password: password)
            .responseJSON
            {   response in
                debugPrint(response)
                if response.result.isSuccess
                {
                    let data = response.result.value
                    let status = data!["status"] as? Int
                    if(status == 201)
                    {
                        let user = data!["user"]
                        print("数据监测user\(user)")
                        self.userData = user as? NSDictionary
                        let userId = (self.userData!["userId"])!
                        self.userDefaults.setObject(user, forKey:"data")
                        self.userDefaults.setBool(true, forKey: "Log")
                        self.userDefaults.setObject(userId, forKey: "userId")
                        print("数据监测userId\(userId)")
                        
                        //                    Alamofire.request(.GET, "http://120.27.34.200/JourneyHelper-Web/findCreatedRoutes?userId=1")
                        let URL = NSURL(string: "http://120.27.34.200/JourneyHelper-Web/findCreatedRoutes?userId=\(userId)")!
                        print(URL)
                        let request = NSMutableURLRequest(URL: URL)
                        Alamofire.request(.GET,request)
                            .responseJSON
                            {
                                response in
                                if response.result.isSuccess
                                {
                                    SVProgressHUD.dismiss()
                                    self.data = response.result.value as? NSDictionary
                                    string = self.data?.objectForKey("createList")as?NSMutableArray
                                    //                        self.userDefaults.setObject(self.string, forKey: "homeData")
                                    print("数据：\(string)")
        
                                }else if response.result.isFailure
                                {
                                    //                                self.alertView = UIAlertView.init(title: "提示", message:"网络失效", delegate: nil, cancelButtonTitle: "好吧")
                                    SVProgressHUD.showErrorWithStatus("您的网络挂了")
                                }
                                
                                //            }
                                
                        }
                        
                    }
                    else if(status == 202)
                    {
                        SVProgressHUD.dismiss()
                        self.alertView = UIAlertView.init(title: "提示", message: "密码错误！！！", delegate: nil, cancelButtonTitle: "ok")
                        self.alertView.show()
                    }
                }else if response.result.isFailure
                {
                    //                    self.alertView = UIAlertView.init(title: "提示", message:"网络连接错误", delegate:nil, cancelButtonTitle: "好的")
                    //                    self.alertView.show()
                    SVProgressHUD.showErrorWithStatus("您的网络挂了。。。")
                }
                
                
        }
        
        
    }

    @IBAction func logUpAction(sender: AnyObject)
    {
        
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
