//
//  OtherPageViewController.swift
//  SwiftSideslipLikeQQ
//
//  Created by wxd on 15/11/12.
//  Copyright (c) 2015年 com.lvwenhan. All rights reserved.
//

import UIKit
import Alamofire

// 点击侧滑菜单中的条目，主页跳转到的 View Controller

var stringOther: NSMutableArray?
var groundRouteId:Int?



class OtherPageViewController: UIViewController,UITableViewDataSource,UITableViewDelegate,SearchViewDelegate{
    
//    var PageTitle: String! // 从 HomeViewController 传递过来的值
    @IBOutlet weak var newsTableView: UITableView!
    var userid : Int?
    var data: NSDictionary?
    var userDefaults:NSUserDefaults?
    var pageSize : Int!
    var flag : Int?
    


        override func viewDidLoad()
    {
        super.viewDidLoad()
            pageSize = 5
        self.userDefaults = NSUserDefaults.standardUserDefaults()
        self.newsTableView.backgroundColor = UIColor(colorLiteralRed: 227.0/255.0, green: 227.0/255.0, blue: 227.0/255.0, alpha: 1)
        self.newsTableView.dataSource = self
        self.newsTableView.delegate = self
        self.newsTableView.registerNib(UINib(nibName: "NewsTableViewCell", bundle: nil), forCellReuseIdentifier: "NewsTableViewCell")
        self.requestdata()
        flag = 1
    
        let addButton = UIBarButtonItem(title: "查找", style: UIBarButtonItemStyle.Plain, target: self, action: "searchNews")
        self.navigationItem.rightBarButtonItem = addButton
        
        self.newsTableView.mj_header = MJRefreshNormalHeader.init(refreshingTarget: self, refreshingAction: "headRequest")
        self.newsTableView.mj_footer = MJRefreshAutoNormalFooter.init(refreshingTarget: self, refreshingAction: "footRequest")
//        // 自定义返回按钮
//        let backButton = UIBarButtonItem(title: "く返回", style: UIBarButtonItemStyle.Plain, target: self, action: "goBack")
//        self.navigationItem.leftBarButtonItem = backButton
//        
//        // 弥补因为返回按钮被替换导致的边缘滑入手势失效的问题
//        let gesture = UIPanGestureRecognizer(target: self, action: "goBack")
//        self.view.addGestureRecognizer(gesture)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func goBack() {
        self.navigationController?.popViewControllerAnimated(true)
        Common.rootViewController.mainTabBarController.tabBar.hidden = false
    }
    
    func searchNews()
    {
        if flag == 1
        {
       let searchView = SearchNewsViewController()
        searchView.view.layer.cornerRadius = 10
        searchView.setPopinTransitionStyle(.Zoom)
        searchView.setPopinAlignment(.Centered)
        searchView.searchDelegate = self
        presentPopinController(searchView, animated: true, completion: nil)
        flag = 0
        self.navigationItem.rightBarButtonItem?.title = "完成"
        }else if flag == 0
        {
         self.navigationItem.rightBarButtonItem?.title = "查找"
         flag = 1
         self.headRequest()
        }
    }
    
    func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        let cell:NewsTableViewCell = tableView.dequeueReusableCellWithIdentifier("NewsTableViewCell", forIndexPath: indexPath) as! NewsTableViewCell
        cell.titleLabel.text = stringOther?.objectAtIndex(indexPath.row).objectForKey("title") as? String
        cell.abstractLabel.text = stringOther?.objectAtIndex(indexPath.row).objectForKey("summary") as? String
        print("标题简要\(cell.abstractLabel.text)")
        
        var url:NSURL?
        var data:NSData?
        var image:UIImage?
        var str:String?
        
        
        //        var ul = string?.objectAtIndex(indexPath.row).objectForKey("routeImageUrl")
        //        print(ul)
        
        str = (stringOther?.objectAtIndex(indexPath.row).objectForKey("routeImageUrl") as? String)
        print("图片数据输出\(str)")
        
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
        cell.photoView.image = image
        
        
        
        return cell
    }
    
    func numberOfSectionsInTableView(tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
     
        var count: Int?
        count = stringOther?.count
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
        return 250.0
    }
    func tableView(tableView: UITableView, didSelectRowAtIndexPath indexPath: NSIndexPath)
    {
        let index = indexPath.row
        groundRouteId = stringOther?.objectAtIndex(indexPath.row).objectForKey("routeId") as? Int
        self.performSegueWithIdentifier("showRoute", sender: index)
       // Common.contactsVC.view.removeFromSuperview()
        
    }
    
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?)
    {
        if segue.identifier == "showRoute"
        {
            let controller = segue.destinationViewController as! GroundDetailViewController
            controller.index = (sender as? Int)!
        }
    }

    
    func requestdata()
    {
//        let hostString = host!
        self.userid = self.userDefaults!.objectForKey("userId") as? Int
        if(userid == nil)
        {
            
        }else
        {
//            let userId = 5
            let userId = self.userid!
            let pagesize = self.pageSize
            print(pagesize)
            let URL = NSURL(string: "http://120.27.34.200/JourneyHelper-Web/findNewRoute?userId=\(userId)&type=100&page=1&pagesize=\(pagesize)")!
            print(URL)
            let request = NSMutableURLRequest(URL: URL)
            Alamofire.request(.GET,request)
                .responseJSON
                {
                    response in
//                    print(response)
                    if response.result.isSuccess
                    {
                        SVProgressHUD.dismiss()
                        self.data = response.result.value as? NSDictionary
                        stringOther = self.data?.objectForKey("allList")as?NSMutableArray
                        //                        self.userDefaults.setObject(self.string, forKey: "homeData")
                        print("数据：\(stringOther)")
                        self.newsTableView.reloadData()
                        self.newsTableView.mj_header.endRefreshing()
                        self.newsTableView.mj_footer.endRefreshing()
                        
                    }else if response.result.isFailure
                    {
                        SVProgressHUD.showErrorWithStatus("您的网络挂了")
                        self.newsTableView.mj_header.endRefreshing()
                        self.newsTableView.mj_footer.endRefreshing()
                    }
            }
        }
   
    }
    func reloadData()
    {
        print("输出输出")
       self.newsTableView.reloadData()
    }
    func footRequest()
    {
        pageSize = pageSize+5
        self.requestdata()
    }
    func headRequest()
    {
        pageSize = 5
        self.requestdata()
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
