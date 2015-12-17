//
//  LogUpViewController.swift
//  SwiftSideslipLikeQQ
//
//  Created by 吴先滇 on 15/12/11.
//  Copyright © 2015年 com.lvwenhan. All rights reserved.
//

import UIKit
import Alamofire

class LogUpViewController: UIViewController,UITextFieldDelegate
{
    @IBOutlet weak var phoneText: UITextField!
    @IBOutlet weak var emailText: UITextField!
    @IBOutlet weak var passwordText: UITextField!
    @IBOutlet weak var usernameText: UITextField!

    override func viewDidLoad() {
        super.viewDidLoad()
        self.phoneText.delegate = self
        self.emailText.delegate = self
        self.passwordText.delegate = self
        self.usernameText.delegate = self
        
               // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    @IBAction func submitAction(sender: AnyObject)
    {
        SVProgressHUD.showWithStatus("加载中")
        let hostString = host!
        let username = usernameText.text!
        let password = passwordText.text!
        let email = emailText.text!
        let phone = phoneText.text!
        var  str  = "\(hostString)/userRegist?userName=\(username)&passWord=\(password)&nickName=nichen&realName=TOM&sex=男&age=20&job=&Email=\(email)&Telephone=\(phone)&location=&headUrl="
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
                        SVProgressHUD.showSuccessWithStatus("注册成功！")
                    }else if(status == 302)
                    {
                        SVProgressHUD.showErrorWithStatus("用户名已被占用")
                    }
                }else if response.result.isFailure
                {
                    SVProgressHUD.showErrorWithStatus("注册失败")
                    
                }
                self.presentingPopinViewController().dismissCurrentPopinControllerAnimated(true)
        }
    }

    override func touchesBegan(touches: Set<UITouch>, withEvent event: UIEvent?) {
        passwordText.resignFirstResponder()
        phoneText.resignFirstResponder()
        usernameText.resignFirstResponder()
        emailText.resignFirstResponder()
    }
    
    func textFieldShouldReturn(textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
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
