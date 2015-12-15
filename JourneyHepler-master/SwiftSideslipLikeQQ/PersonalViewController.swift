//
//  PersonalViewController.swift
//  SwiftSideslipLikeQQ
//
//  Created by apple on 15/12/15.
//  Copyright © 2015年 com.lvwenhan. All rights reserved.
//

import UIKit

class PersonalViewController: UIViewController,UITableViewDataSource,UITableViewDelegate
{
    var str = ["昵称:","真实姓名:","性别:","邮箱:","电话:","所在地:"]

    @IBOutlet weak var personalTable: UITableView!
    override func viewDidLoad()
    {
        super.viewDidLoad()
        self.personalTable.delegate = self
        self.personalTable.dataSource = self
         self.personalTable.registerNib(UINib(nibName: "PersonalTableViewCell", bundle: nil), forCellReuseIdentifier: "PersonalTableViewCell")
       
        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning()
    {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int
    {
        return 6
        
    }
    
    func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell
    {
        let cell:PersonalTableViewCell = tableView.dequeueReusableCellWithIdentifier("PersonalTableViewCell", forIndexPath: indexPath) as! PersonalTableViewCell
        cell.head.text = self.str[indexPath.row]
        return cell

    }
    func numberOfSectionsInTableView(tableView: UITableView) -> Int
    {
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
