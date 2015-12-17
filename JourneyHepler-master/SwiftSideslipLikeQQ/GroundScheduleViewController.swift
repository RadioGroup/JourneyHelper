//
//  GroundScheduleViewController.swift
//  SwiftSideslipLikeQQ
//
//  Created by apple on 15/12/17.
//  Copyright © 2015年 com.lvwenhan. All rights reserved.
//

import UIKit
import Alamofire
class GroundScheduleViewController: UIViewController,UITableViewDataSource,UITableViewDelegate {

    @IBOutlet weak var scheduleTableView: UITableView!
    var scheduleData:NSMutableArray?
    var data:NSDictionary?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.scheduleTableView.dataSource = self
        self.scheduleTableView.delegate = self
        self.scheduleTableView.backgroundColor = UIColor(colorLiteralRed: 227.0/255.0, green: 227.0/255.0, blue: 227.0/255.0, alpha: 1)
        self.scheduleTableView.registerNib(UINib(nibName: "ScheduleTableViewCell", bundle: nil), forCellReuseIdentifier: "ScheduleTableViewCell")
        self.requestdata()
        
        // Do any additional setup after loading the view.
    }

    func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        let cell:ScheduleTableViewCell = tableView.dequeueReusableCellWithIdentifier("ScheduleTableViewCell", forIndexPath: indexPath) as! ScheduleTableViewCell
        cell.destinationLabel.text = self.scheduleData?.objectAtIndex(indexPath.row).objectForKey("destination") as? String
        cell.beginTimeLabel.text = self.scheduleData?.objectAtIndex(indexPath.row).objectForKey("beginTime") as? String
        cell.accomLabel.text = self.scheduleData?.objectAtIndex(indexPath.row).objectForKey("accommodation") as? String
        cell.vehicleLabel.text = self.scheduleData?.objectAtIndex(indexPath.row).objectForKey("vehicle") as? String
        
        return cell

    }
    
    func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int
    {
        var count: Int?
        count = self.scheduleData?.count
        print(count)
        if(count == nil)
        {
            return 0
            
        }else
        {
            return count!
        }
        
    }
    
    func numberOfSectionsInTableView(tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(tableView: UITableView, heightForRowAtIndexPath indexPath: NSIndexPath) -> CGFloat {
        return 210.0
    }

    
    func requestdata()
    {
        let routeId = groundRouteId!
        var str = "http://172.50.180.239/JourneyHelper-Web/findRouteScheduleList?routeId=\(routeId)"
        print(str)
        str =  str.stringByAddingPercentEscapesUsingEncoding(NSUTF8StringEncoding)!
        let URL =  NSURL(string:str)!
        let request = NSMutableURLRequest(URL: URL)
        
        Alamofire.request(.GET, request)
            .responseJSON { response in
                print("详情数据\(response)")
                
                if response.result.isSuccess
                {
                    self.data = response.result.value as? NSDictionary
                    self.scheduleData = self.data!["schedules"]  as? NSMutableArray
                    if self.scheduleData == nil
                    {
                        SVProgressHUD.showErrorWithStatus("没有数据！")
                    }else
                    {
                        self.scheduleTableView.reloadData()
                    }
                    
                }
                else
                {
                    SVProgressHUD.showErrorWithStatus("请求出错！")
                }
              
        }
        
    }

    
    
    override func didReceiveMemoryWarning() {
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
