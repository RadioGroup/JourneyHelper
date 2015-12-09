//
//  HomeViewController.swift
//  SwiftSideslipLikeQQ
//
//  Created by wxd on 15/11/10.
//  Copyright (c) 2015年 com.lvwenhan. All rights reserved.
//

import UIKit
import Alamofire


// 主页
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
    
    var index:Int = 0
    
    //    var string: NSMutableArray?

    @IBOutlet weak var homeTableView: UITableView!
    
    @IBOutlet var panGesture: UIPanGestureRecognizer!
    override func viewDidLoad()
    {
        super.viewDidLoad()
        self.userDefalutsHome = NSUserDefaults.standardUserDefaults()

        self.homeTableView.dataSource = self
        self.homeTableView.delegate = self
        self.homeTableView.registerNib(UINib(nibName: "HomeTableViewCell", bundle: nil), forCellReuseIdentifier: "HomeTableViewCell")
        
        // 设置中间 segmentView 视图
        let segmentView = UISegmentedControl(items: ["消息", "电话"])
        segmentView.selectedSegmentIndex = 0
        segmentView.setWidth(60, forSegmentAtIndex: 0)
        segmentView.setWidth(60, forSegmentAtIndex: 1)
        self.navigationItem.titleView = segmentView
        
        segmentView.hidden = true
        
        
//        var data = self.userDefalutsHome?.objectForKey("homedata")
//        self.string1 = data!["joindeList"]!!["tittle"] as? String
//        self.string2 = data!["joindeList"]!!["type"] as? String
//        self.string3 = data!["joindeList"]!!["createTime"] as? String
//        self.string4 = data!["joindeList"]!!["routeId"] as? String
//        print("数据数据2:\(string1)")

    }
    override func viewDidAppear(animated: Bool) {
        
    }
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        let cell:HomeTableViewCell = tableView.dequeueReusableCellWithIdentifier("HomeTableViewCell", forIndexPath: indexPath) as! HomeTableViewCell
//        
//        Alamofire.request(.GET, "http://172.50.180.239/findJoinedRouteList?userId=1")
//            .responseJSON { response in
//                //                    debugPrint(response)
//                if response.result.isSuccess
//                {
//                    let data = response.result.value
//                    self.allData = data as? NSDictionary
//                    self.string1 = self.allData?.objectForKey("joindeList")as?NSMutableArray
//                    
//                    
//                    print("数据数据：\(self.string1)")
//                    
//                }else if response.result.isFailure
//                {
//                    self.alertView = UIAlertView.init(title: "提示", message:"网络失效", delegate: nil, cancelButtonTitle: "好吧")
//                }
//                
//        }

        cell.backgroundColor = UIColor.clearColor()
        cell.titleLabel.text = string?.objectAtIndex(indexPath.row).objectForKey("title") as? String
        cell.createTimeLabel.text = string?.objectAtIndex(indexPath.row).objectForKey("createTime") as? String
        cell.typeLabel.text = string?.objectAtIndex(indexPath.row).objectForKey("type") as? String
        cell.routeIdLabel.text = string?.objectAtIndex(indexPath.row).objectForKey("routeId") as? String
        
        var url:NSURL?
        var data:NSData?
        var image:UIImage?

        
        url = NSURL(string: (string?.objectAtIndex(indexPath.row).objectForKey("routeImageUrl") as? String)!)!
        data = NSData(contentsOfURL:url!)!
        image = UIImage(data:data!)
        cell.imgae.image = image
        return cell
    }
    
    func numberOfSectionsInTableView(tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return (string?.count)!
    }
    
    func tableView(tableView: UITableView, heightForRowAtIndexPath indexPath: NSIndexPath) -> CGFloat {
        return 152.0
    }

    func tableView(tableView: UITableView, didSelectRowAtIndexPath indexPath: NSIndexPath) {
        
        self.index = indexPath.row
        
        self.performSegueWithIdentifier("showDetail", sender: self)
        Common.contactsVC.view.removeFromSuperview()
    }
    
//    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
//        var theSegue = segue.destinationViewController as? RouteDetailViewController
//        theSegue!.index = self.index
//    }
    
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
