//
//  ViewController.swift
//  JourneyHelper
//
//  Created by 吴泽钦 on 10/30/15.
//  Copyright © 2015 Wu. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    var homeViewController:HomeViewComtrollerViewController!
    var distance: CGFloat = 0
    
    let FullDistance : CGFloat = 0.78
    let Proportion: CGFloat = 0.77
    var centerOfLeftViewAtBeginning: CGPoint!
    var proportionOfLeftView: CGFloat = 1
    var distanceOfLeftView: CGFloat = 50
    
    // 该 TabBar Controller 不是传统意义上的容器，在此只负责提供 UITabBar 这个 UI 组件
//    var mainTabBarController: MainTabBarController!
    
    // 主界面点击手势，用于在菜单划出状态下点击主页后自动关闭菜单
    var tapGesture: UITapGestureRecognizer!
    // 首页的 Navigation Bar 的提供者，是首页的容器
    var homeNavigationController: UINavigationController!
    // 侧滑菜单黑色半透明遮罩层
    var blackCover: UIView!
    
    var mainView: UIView!
    // 侧滑菜单视图的来源
    var leftViewController: LeftViewController!

    override func viewDidLoad()
    {
        super.viewDidLoad()
        //给主视图设置背景
        let imageView = UIImageView(image:UIImage(named: "back"))
        imageView.frame = UIScreen.mainScreen().bounds
        self.view.addSubview(imageView)
        
        leftViewController = UIStoryboard(name: "Main", bundle: nil).instantiateViewControllerWithIdentifier("LeftViewController") as! LeftViewController
        leftViewController.view.backgroundColor = UIColor.clearColor()
        // 适配 4.7 和 5.5 寸屏幕的缩放操作，有偶发性小 bug
        if Common.screenWidth > 320 {
            proportionOfLeftView = Common.screenWidth / 320
            distanceOfLeftView += (Common.screenWidth - 320) * FullDistance / 2
        }
        leftViewController.view.center = CGPointMake(leftViewController.view.center.x - 50, leftViewController.view.center.y)
        leftViewController.view.transform = CGAffineTransformScale(CGAffineTransformIdentity, 0.8, 0.8)
        
        // 动画参数初始化
        centerOfLeftViewAtBeginning = leftViewController.view.center
        //侧滑视图的添加
        self.view.addSubview(leftViewController.view)
        
        // 在侧滑菜单之上增加黑色遮罩层，目的是实现视差特效
        blackCover = UIView(frame: CGRectOffset(self.view.frame, 0, 0))
        blackCover.backgroundColor = UIColor.blackColor()
        self.view.addSubview(blackCover)
        
        mainView = UIView(frame: self.view.frame)
        
        homeNavigationController = UIStoryboard(name: "Main", bundle: nil).instantiateViewControllerWithIdentifier("HomeNavigationController")as! UINavigationController
        homeViewController = homeNavigationController.viewControllers.first as! HomeViewComtrollerViewController
        mainView.addSubview(homeViewController.navigationController!.view)
        mainView.addSubview(homeViewController.view)
        self.view.addSubview(mainView)

        
        //通过 stroyboard取出 homeviewcontroller 的view放在背景视图上面
        homeViewController = UIStoryboard(name: "Main", bundle: nil).instantiateViewControllerWithIdentifier("HomeViewController") as! HomeViewComtrollerViewController
        self.view.addSubview(homeViewController.view)
        
        // 从 StoryBoard 取出首页的 Navigation Controller
        homeNavigationController = UIStoryboard(name: "Main", bundle: nil).instantiateViewControllerWithIdentifier("HomeNavigationController") as! UINavigationController
        // 从 StoryBoard 初始化而来的 Navigation Controller 会自动初始化他的 Root View Controller，即 HomeViewController
        // 我们将其（指针）取出，赋给容器 View Controller 的成员变量 homeViewController
        homeViewController = homeNavigationController.viewControllers.first as! HomeViewComtrollerViewController
        
//        // 分别指定 Navigation Bar 左右两侧按钮的事件
//        homeViewController.navigationItem.leftBarButtonItem?.action = Selector("showLeft")
//        homeViewController.navigationItem.rightBarButtonItem?.action = Selector("showRight")
        
        // 将主视图加入容器
        self.view.addSubview(mainView)
        
        // 给主视图绑定 UIPanGestureRecognizer
        let panGesture = homeViewController.panGesture
        panGesture.addTarget(self, action: Selector("pan:"))
        mainView.addGestureRecognizer(panGesture)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    //响应事件
    func pan(recongnizer: UIPanGestureRecognizer)
    {
        let x = recongnizer.translationInView(self.view).x
        let trueDistance = distance + x //实时距离
                let trueProportion = trueDistance / (Common.screenWidth*FullDistance)
        
        //如果 UIPANGETURERECONGNIZER 结束，则激活自动停靠
        if recongnizer.state == UIGestureRecognizerState.Ended
        {
            if trueDistance > Common.screenWidth * (Proportion / 3)
            {
                showLeft()
            }else if trueDistance < Common.screenWidth * -(Proportion / 3)
            {
                showRight()
            }else
            {
                showHome()
            }
            
            return
        }
        
        // 计算缩放比例
        var proportion: CGFloat = recongnizer.view!.frame.origin.x >= 0 ? -1 : 1
        proportion *= trueDistance / Common.screenWidth
        proportion *= 1 - Proportion
        proportion /= FullDistance + Proportion/2 - 0.5
        proportion += 1
        if proportion <= Proportion { // 若比例已经达到最小，则不再继续动画
            return
        }
        // 执行视差特效
        blackCover.alpha = (proportion - Proportion) / (1 - Proportion)
        // 执行平移和缩放动画
        recongnizer.view!.center = CGPointMake(self.view.center.x + trueDistance, self.view.center.y)
        recongnizer.view!.transform = CGAffineTransformScale(CGAffineTransformIdentity, proportion, proportion)
        
        // 执行左视图动画
        let pro = 0.8 + (proportionOfLeftView - 0.8) * trueProportion
        leftViewController.view.center = CGPointMake(centerOfLeftViewAtBeginning.x + distanceOfLeftView * trueProportion, centerOfLeftViewAtBeginning.y - (proportionOfLeftView - 1) * leftViewController.view.frame.height * trueProportion / 2 )
        leftViewController.view.transform = CGAffineTransformScale(CGAffineTransformIdentity, pro, pro)
    }

    
    func showLeft()
    {
        mainView.addGestureRecognizer(tapGesture)
        distance = self.view.center.x * (FullDistance + Proportion / 2)
        doTheAnimate(self.Proportion,showWhat: "left")
    }
    func showRight()
    {
        // 给首页 加入 点击自动关闭侧滑菜单功能
        mainView.addGestureRecognizer(tapGesture)
        distance = self.view.center.x * -(FullDistance + Proportion / 2)
        doTheAnimate(self.Proportion,showWhat: "right")
    }
    func showHome()
    {
        // 从首页 删除 点击自动关闭侧滑菜单功能
        mainView.removeGestureRecognizer(tapGesture)
        distance = 0
        doTheAnimate(1,showWhat: "home")
    }
    
    func doTheAnimate(proportion: CGFloat, showWhat: String)
    {
        UIView.animateWithDuration(0.3, delay: 0, options: UIViewAnimationOptions.CurveEaseInOut, animations: { () -> Void in
            // 移动首页中心
            self.mainView.center = CGPointMake(self.view.center.x + self.distance, self.view.center.y)
            // 缩放首页
            self.mainView.transform = CGAffineTransformScale(CGAffineTransformIdentity, proportion, proportion)
            if showWhat == "left" {
                // 移动左侧菜单的中心
                self.leftViewController.view.center = CGPointMake(self.centerOfLeftViewAtBeginning.x + self.distanceOfLeftView, self.leftViewController.view.center.y)
                // 缩放左侧菜单
                self.leftViewController.view.transform = CGAffineTransformScale(CGAffineTransformIdentity, self.proportionOfLeftView, self.proportionOfLeftView)
            }
            // 改变黑色遮罩层的透明度，实现视差效果
            self.blackCover.alpha = showWhat == "home" ? 1 : 0
            
            // 为了演示效果，在右侧菜单划出时隐藏漏出的左侧菜单，并无实际意义
            self.leftViewController.view.alpha = showWhat == "right" ? 0 : 1
            }, completion: nil)
    }
}

