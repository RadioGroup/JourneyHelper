//
//  BubbyListViewController.swift
//  SwiftSideslipLikeQQ
//
//  Created by 吴先滇 on 15/12/14.
//  Copyright © 2015年 com.lvwenhan. All rights reserved.
//

import UIKit
import Alamofire
class BubbyListViewController: UIViewController,UITableViewDelegate,UITableViewDataSource
{
    @IBOutlet weak var bubbyListTableView: UITableView!
    var listData:NSMutableArray?
    var list:NSDictionary?
    
    override func viewDidLoad()
    {
        super.viewDidLoad()
        self.bubbyListTableView.delegate = self
        self.bubbyListTableView.dataSource = self
        self.bubbyListTableView.registerNib(UINib(nibName: "BubbyListTableViewCell", bundle: nil), forCellReuseIdentifier: "BubbyListTableViewCell")
        requestdata()
        // Do any additional setup after loading the view.
    }

    func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        
        let cell:BubbyListTableViewCell = tableView.dequeueReusableCellWithIdentifier("BubbyListTableViewCell", forIndexPath: indexPath) as! BubbyListTableViewCell
        cell.headImageView.image = UIImage(named: "000")
        cell.nickNameLabel.text = self.listData?.objectAtIndex(indexPath.row).objectForKey("nickName") as? String
        cell.realNameLabel.text = self.listData?.objectAtIndex(indexPath.row).objectForKey("realName") as? String
        cell.mailLabel.text = self.listData?.objectAtIndex(indexPath.row).objectForKey("email") as? String
        
        return cell
    }
    
    func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        let count:Int?
        count = self.listData?.count
        if count == nil{
            return 0
        }
        else{
            return count!
        }
    }
    
    func numberOfSectionsInTableView(tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(tableView: UITableView, heightForRowAtIndexPath indexPath: NSIndexPath) -> CGFloat {
        return 115.0
    }
    
    func requestdata()
    {
        let routeId = routeIdPass!
        var str = "http://120.27.34.200/JourneyHelper-Web/findRouteMenberList?routeId=\(routeId)"
        print(str)
        str =  str.stringByAddingPercentEscapesUsingEncoding(NSUTF8StringEncoding)!
        let URL =  NSURL(string:str)!
        let request = NSMutableURLRequest(URL: URL)
        
        Alamofire.request(.GET, request)
            .responseJSON { response in
                
                if response.result.isSuccess
                {
                    self.list = response.result.value as? NSDictionary
                    self.listData = self.list!["users"]  as? NSMutableArray
                    if self.listData == nil
                    {
                        SVProgressHUD.showErrorWithStatus("没有数据！")
                    }else
                    {
                        self.bubbyListTableView.reloadData()
                    }
                    
                }
                else
                {
                    SVProgressHUD.showErrorWithStatus("请求出错！")
                }
                //                print("Success: \(response.result.isSuccess)")
                //                print("Response String: \(response.result.value)")
        }
        
    }

    
    
    override func didReceiveMemoryWarning()
    {
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
