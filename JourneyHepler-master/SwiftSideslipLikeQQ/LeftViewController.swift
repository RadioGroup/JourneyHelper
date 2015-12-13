//
//  LeftViewController.swift
//  SwiftSideslipLikeQQ
//
//  Created by wxd on 15/11/11.
//  Copyright (c) 2015年 com.lvwenhan. All rights reserved.
//

import UIKit

// 侧滑菜单 View Controller
class LeftViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
    let titlesDictionary = ["我的行程", "招募信息", "租借分享", "个人设置", "照片墙"]

    @IBOutlet weak var settingTableView: UITableView!
    @IBOutlet weak var avatarImageView: UIImageView!
    
    @IBOutlet weak var heightLayoutConstraintOfSettingTableView: NSLayoutConstraint!

    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        settingTableView.delegate = self
        settingTableView.dataSource = self
        settingTableView.tableFooterView = UIView()
        
//        heightLayoutConstraintOfSettingTableView.constant = Common.screenHeight < 500 ? Common.screenHeight * (568 - 221) / 568 : 347
        self.view.frame = CGRectMake(0, 0, 320 * 0.78, Common.screenHeight)
        
        

        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    // 处理点击事件
    func tableView(tableView: UITableView, didSelectRowAtIndexPath indexPath: NSIndexPath)
    {
        let viewController = Common.rootViewController
        viewController.homeViewController.titleOfOtherPages = titlesDictionary[indexPath.row]
        if indexPath.row == 0
        {
            viewController.homeViewController.performSegueWithIdentifier("showOtherPages", sender: self)
            Common.contactsVC.view.removeFromSuperview()
            viewController.mainTabBarController.tabBar.hidden = true
            viewController.mainTabBarController.selectedIndex = 0
            viewController.showHome()
            tableView.deselectRowAtIndexPath(indexPath, animated: false)
        }else if indexPath.row == 4
        {
            viewController.homeViewController.performSegueWithIdentifier("showPhotos", sender: self)
            Common.contactsVC.view.removeFromSuperview()
            viewController.mainTabBarController.tabBar.hidden = true
            viewController.mainTabBarController.selectedIndex = 0
            viewController.showHome()
            tableView.deselectRowAtIndexPath(indexPath, animated: false)
        }else if indexPath.row == 1
        {
            viewController.homeViewController.performSegueWithIdentifier("showRecruitment", sender: self)
            Common.contactsVC.view.removeFromSuperview()
            viewController.mainTabBarController.tabBar.hidden = true
            viewController.mainTabBarController.selectedIndex = 0
            viewController.showHome()
            tableView.deselectRowAtIndexPath(indexPath, animated: false)
        }else if indexPath.row == 2
        {
            viewController.homeViewController.performSegueWithIdentifier("showLease", sender: self)
            Common.contactsVC.view.removeFromSuperview()
            viewController.mainTabBarController.tabBar.hidden = true
            viewController.mainTabBarController.selectedIndex = 0
            viewController.showHome()
            tableView.deselectRowAtIndexPath(indexPath, animated: false)
        }else if indexPath.row == 3
        {
            viewController.homeViewController.performSegueWithIdentifier("showSettings", sender: self)
            Common.contactsVC.view.removeFromSuperview()
            viewController.mainTabBarController.tabBar.hidden = true
            viewController.mainTabBarController.selectedIndex = 0
            viewController.showHome()
            tableView.deselectRowAtIndexPath(indexPath, animated: false)
        }
    }
    
    func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 5
    }
    func numberOfSectionsInTableView(tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell
    {
        let cell = tableView.dequeueReusableCellWithIdentifier("leftViewCell", forIndexPath: indexPath) 
        
        cell.backgroundColor = UIColor.clearColor()
        cell.textLabel!.text = titlesDictionary[indexPath.row]
        
        return cell
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
