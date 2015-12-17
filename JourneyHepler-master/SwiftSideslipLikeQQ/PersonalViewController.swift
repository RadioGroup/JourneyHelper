//
//  PersonalViewController.swift
//  SwiftSideslipLikeQQ
//
//  Created by apple on 15/12/15.
//  Copyright © 2015年 com.lvwenhan. All rights reserved.
//

import UIKit
import Alamofire

class PersonalViewController: UIViewController
{
    @IBOutlet weak var localtion: UITextField!
    @IBOutlet weak var phoneNumber: UITextField!
    @IBOutlet weak var email: UITextField!
    @IBOutlet weak var nickName: UITextField!
    @IBOutlet weak var realName: UITextField!
    var userDefaults: NSUserDefaults?
    var data: NSDictionary?
//    var str = ["昵称:","真实姓名:","性别:","邮箱:","电话:","所在地:"]

    override func viewDidLoad()
   
       {
        super.viewDidLoad()
        self.userDefaults = NSUserDefaults.standardUserDefaults()
        self.data = self.userDefaults?.objectForKey("data") as? NSDictionary
        print("个人用户数据\(self.data)")
        self.nickName.placeholder = self.data!["nickName"] as? String
        self.realName.placeholder = self.data!["realName"] as? String
        self.phoneNumber.placeholder = self.data!["telephoneNumber"] as? String
        self.email.placeholder = self.data!["email"] as? String
        self.localtion.placeholder = self.data!["location"] as? String
        
       
        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning()
    {
        super.didReceiveMemoryWarning()
    }
    
    @IBAction func confirmAction(sender: AnyObject)
    {
     
        
        SVProgressHUD.showWithStatus("加载中")
        let hostString = host!
        let nick = self.nickName.text!
        let real = self.realName.text!
        let email = self.email.text!
        let phone = self.phoneNumber.text!
        let local = self.localtion.text!
        var  str  = "\(hostString)/updateUserInfoAction?userId=1&passWord=root&nickName=\(nick)&realName=\(real)&sex=男&age=22&job=学生&Email=\(email)&Telephone=\(phone)&location=\(local)&headUrl="
        str = str.stringByAddingPercentEscapesUsingEncoding(NSUTF8StringEncoding)!
        print(str)
        let URL = NSURL(string: str)!
        
        Alamofire.request(.POST, URL)
            .responseJSON
            {
                response in
                if response.result.isSuccess
                {
                    let data = response.result.value
                    let status = data!["status"] as? Int
                    if(status == 301)
                    {
                        SVProgressHUD.showSuccessWithStatus("修改成功")
                    }else if(status == 302)
                    {
                        SVProgressHUD.showErrorWithStatus("修改失败")
                    }
                }else if response.result.isFailure
                {
                    SVProgressHUD.showErrorWithStatus("请求出错")
                    
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
