//
//  ScheduleViewController.swift
//  SwiftSideslipLikeQQ
//
//  Created by 吴先滇 on 15/12/14.
//  Copyright © 2015年 com.lvwenhan. All rights reserved.
//

import UIKit

class ScheduleViewController: UIViewController,UITableViewDataSource,UITableViewDelegate{

    @IBOutlet weak var scheduleTableView: UITableView!
    override func viewDidLoad() {
        super.viewDidLoad()
        self.scheduleTableView.dataSource = self
        self.scheduleTableView.delegate = self
        self.scheduleTableView.registerNib(UINib(nibName: "ScheduleTableViewCell", bundle: nil), forCellReuseIdentifier: "ScheduleTableViewCell")
        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        let cell:ScheduleTableViewCell = tableView.dequeueReusableCellWithIdentifier("ScheduleTableViewCell", forIndexPath: indexPath) as! ScheduleTableViewCell
        cell.destinationLabel.text = "福州"
        cell.beginTimeLabel.text = "12月14日 周一"
        cell.accomLabel.text = "七天连锁"
        cell.vehicleLabel.text = "自行车"
        
        return cell
    }
    
    
    func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 4
    }
    
    func numberOfSectionsInTableView(tableView: UITableView) -> Int {
        return 1
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
