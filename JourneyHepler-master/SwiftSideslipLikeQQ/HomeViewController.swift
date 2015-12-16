//
//  HomeViewController.swift
//  SwiftSideslipLikeQQ
//
//  Created by wxd on 15/11/10.
//  Copyright (c) 2015年 com.lvwenhan. All rights reserved.
//

import UIKit
import Alamofire


var routeIdPass : Int?
class HomeViewController: UIViewController,UITableViewDelegate,UITableViewDataSource
{
    
    var titleOfOtherPages = ""
    var userDefalutsHome: NSUserDefaults!
    var alertView: UIAlertView!
    var string1: NSMutableArray?
    var string2: NSMutableArray?
    var string3: NSMutableArray?
    var string4: NSMutableArray?
    var allData: NSDictionary?
    var data: NSDictionary?
    var userid: Int?
    
    var index:Int = 0
    
    //    var string: NSMutableArray?
    
    @IBOutlet weak var homeTableView: UITableView!
    
    @IBOutlet var panGesture: UIPanGestureRecognizer!
    override func viewDidLoad()
    {
        super.viewDidLoad()
        self.userDefalutsHome = NSUserDefaults.standardUserDefaults()
        self.homeTableView.backgroundColor = UIColor(colorLiteralRed: 227.0/255.0, green: 227.0/255.0, blue: 227.0/255.0, alpha: 1)
        self.homeTableView.dataSource = self
        self.homeTableView.delegate = self
        self.homeTableView.registerNib(UINib(nibName: "HomeTableViewCell", bundle: nil), forCellReuseIdentifier: "HomeTableViewCell")
        
        self.homeTableView.mj_header = MJRefreshNormalHeader.init(refreshingTarget: self, refreshingAction: Selector("loadNewData"))
        
        // 设置中间 segmentView 视图
        let segmentView = UISegmentedControl(items: ["消息", "电话"])
        segmentView.selectedSegmentIndex = 0
        segmentView.setWidth(60, forSegmentAtIndex: 0)
        segmentView.setWidth(60, forSegmentAtIndex: 1)
        self.navigationItem.titleView = segmentView
        
        segmentView.hidden = true
        
        self.requestData()
        
        
    }
    override func viewDidAppear(animated: Bool) {
        
    }
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func requestData()
    {
        let hostString = host!
        self.userid = self.userDefalutsHome.objectForKey("userId") as? Int
        if(userid == nil)
        {
            
        }else
        {
            
        let userId = self.userid!
        let URL = NSURL(string: "\(hostString)/findCreatedRoutes?userId=\(userId)")!
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
                    self.homeTableView.reloadData()
                    
                }else if response.result.isFailure
                {
                    SVProgressHUD.showErrorWithStatus("您的网络挂了")
                }
            }
        }

    }
    
    func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        let cell:HomeTableViewCell = tableView.dequeueReusableCellWithIdentifier("HomeTableViewCell", forIndexPath: indexPath) as! HomeTableViewCell
        
        cell.backgroundColor = UIColor(colorLiteralRed: 227.0/255.0, green: 227.0/255.0, blue: 227.0/255.0, alpha: 1)
        cell.titleLabel.text = string?.objectAtIndex(indexPath.row).objectForKey("title") as? String
        cell.createTimeLabel.text = string?.objectAtIndex(indexPath.row).objectForKey("beginTime") as? String
        
        
        var url:NSURL?
        var data:NSData?
        var image:UIImage?
        var str:String?
        
        
        //        var ul = string?.objectAtIndex(indexPath.row).objectForKey("routeImageUrl")
        //        print(ul)
        
        str = (string?.objectAtIndex(indexPath.row).objectForKey("routeImageUrl") as? String)!
        //        print("数据输出\(str)")
        
        if str == nil
        {
            image = UIImage(named: "nil")
            
        }
        else
        {
            url = NSURL(string: str!)
            data = NSData(contentsOfURL:url!)
            if data == nil
            {
                image = UIImage(named: "nil")
                
            }else
            {
                image = UIImage(data:data!)
            }
        }
        cell.imgae.image = image
        return cell
    }
    
    func numberOfSectionsInTableView(tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int
    {
        var count: Int?
        count = string?.count
        print(count)
        if(count == nil)
        {
            return 0
            
        }else
        {
            return count!
        }
    }
    
    func tableView(tableView: UITableView, heightForRowAtIndexPath indexPath: NSIndexPath) -> CGFloat {
        return 232.0
    }
    
    func tableView(tableView: UITableView, didSelectRowAtIndexPath indexPath: NSIndexPath)
    {
        
        let index = indexPath.row
        routeIdPass = string?.objectAtIndex(indexPath.row).objectForKey("routeId") as? Int
        self.performSegueWithIdentifier("showDetail", sender: index)
        Common.contactsVC.view.removeFromSuperview()
    }
    
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?)
    {
        if segue.identifier == "showDetail"
        {
            let controller = segue.destinationViewController as! RouteDetailViewController
            controller.index = (sender as? Int)!
        }
    }
    
    func loadNewData()
    {
        let hostString = host!
        self.userid = self.userDefalutsHome.objectForKey("userId") as? Int
        if (self.userid == nil)
        {
            SVProgressHUD.showErrorWithStatus("刷新失败，请重新登陆后尝试！")
            self.homeTableView.mj_header.endRefreshing()
        }
        else
        {
            let userId = self.userid!
            let URL = NSURL(string: "\(hostString)/findCreatedRoutes?userId=\(userId)")!
            print(URL)
            Alamofire.request(.GET, URL)
                .responseJSON
                { response in
                    self.data = response.result.value as? NSDictionary
                    if(response.result.isSuccess)
                    {
                        let status = self.data!["status"] as? Int
                        if(status == 301)
                        {
                            string = self.data?.objectForKey("createList")as?NSMutableArray
                            self.homeTableView.reloadData()
                            self.homeTableView.mj_header.endRefreshing()
                            
                        }else if(status == 302)
                        {
                            SVProgressHUD.showErrorWithStatus("刷新失败")
                            self.homeTableView.mj_header.endRefreshing()
                        }

                       
                    }else if(response.result.isFailure)
                    {
                        SVProgressHUD.showErrorWithStatus("刷新失败")
                        self.homeTableView.mj_header.endRefreshing()
                        
                    }
            }
            
        }
        
    }
    
    // MARK: - Navigation
    
    // In a storyboard-based application, you will often want to do a little preparation before navigation
    //    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
    //        if segue.identifier == "showOtherPages" {
    //            if let a = segue.destinationViewController as? OtherPageViewController {
    //                a.PageTitle = titleOfOtherPages
    //            }
    //        }
    //    }
    
    
}
