//
//  OtherPageViewController.swift
//  SwiftSideslipLikeQQ
//
//  Created by wxd on 15/11/12.
//  Copyright (c) 2015年 com.lvwenhan. All rights reserved.
//

import UIKit

// 点击侧滑菜单中的条目，主页跳转到的 View Controller
class OtherPageViewController: UIViewController,UITableViewDataSource,UITableViewDelegate {
    
//    var PageTitle: String! // 从 HomeViewController 传递过来的值
    @IBOutlet weak var newsTableView: UITableView!


        override func viewDidLoad()
    {
        super.viewDidLoad()
        self.newsTableView.backgroundColor = UIColor(colorLiteralRed: 227.0/255.0, green: 227.0/255.0, blue: 227.0/255.0, alpha: 1)
        self.newsTableView.dataSource = self
        self.newsTableView.delegate = self
        self.newsTableView.registerNib(UINib(nibName: "NewsTableViewCell", bundle: nil), forCellReuseIdentifier: "NewsTableViewCell")
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
    
    func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        let cell:NewsTableViewCell = tableView.dequeueReusableCellWithIdentifier("NewsTableViewCell", forIndexPath: indexPath) as! NewsTableViewCell
        return cell
    }
    
    func numberOfSectionsInTableView(tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 4
    }
    
    func tableView(tableView: UITableView, heightForRowAtIndexPath indexPath: NSIndexPath) -> CGFloat {
        return 250.0
    }
    func tableView(tableView: UITableView, didSelectRowAtIndexPath indexPath: NSIndexPath)
    {
        let index = indexPath.row
        self.performSegueWithIdentifier("showRoute", sender: index)
       // Common.contactsVC.view.removeFromSuperview()
        
    }
    
//    func tableView(tableView: UITableView, didSelectRowAtIndexPath indexPath: NSIndexPath)
//    {
//        
//        let index = indexPath.row
//        routeIdPass = string?.objectAtIndex(indexPath.row).objectForKey("routeId") as? Int
//        self.performSegueWithIdentifier("showDetail", sender: index)
//        Common.contactsVC.view.removeFromSuperview()
//    }
//    
//    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?)
//    {
//        if segue.identifier == "showDetail"
//        {
//            let controller = segue.destinationViewController as! RouteDetailViewController
//            controller.index = (sender as? Int)!
//        }
//    }

    
    func requestdata(){
        
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
