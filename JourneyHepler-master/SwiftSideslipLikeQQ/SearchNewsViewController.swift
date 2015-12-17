//
//  SearchNewsViewController.swift
//  SwiftSideslipLikeQQ
//
//  Created by apple on 15/12/17.
//  Copyright © 2015年 com.lvwenhan. All rights reserved.
//

import UIKit
import Alamofire
protocol SearchViewDelegate
{
    func reloadData()
}
class SearchNewsViewController: UIViewController
{

    @IBOutlet weak var SearchText: UITextField!
    var data: NSDictionary?
    var searchDelegate: SearchViewDelegate?
    override func viewDidLoad()
    {
        
        super.viewDidLoad()

    }

    override func didReceiveMemoryWarning()
    {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    @IBAction func submit(sender: AnyObject)
    {
        if (self.SearchText.text == nil)
        {
            
        }
        else
        {
        let text =  self.SearchText.text!
        var  str  = "http://120.27.34.200/JourneyHelper-Web/searchRoute?searchRoute=\(text)&page=1&pagesize=5"
        str = str.stringByAddingPercentEscapesUsingEncoding(NSUTF8StringEncoding)!
        print(str)
        let URL = NSURL(string: str)!
        SVProgressHUD.showWithStatus("加载中。。。")
        
        Alamofire.request(.POST, URL)
            .responseJSON
            {
                response in
                if response.result.isSuccess
                {
                    self.data = response.result.value  as? NSDictionary
                    stringOther = self.data!["routes"] as? NSMutableArray
                    SVProgressHUD.showSuccessWithStatus("查找成功")
                    print("输出输出123123\(stringOther)")
                   self.searchDelegate?.reloadData()
                    
                    
                }else if response.result.isFailure
                {
                    SVProgressHUD.showErrorWithStatus("请求出错")
                    
                }

            }
            self.presentingPopinViewController().dismissCurrentPopinControllerAnimated(true)
            
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
