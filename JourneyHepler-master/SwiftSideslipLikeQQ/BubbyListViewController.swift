//
//  BubbyListViewController.swift
//  SwiftSideslipLikeQQ
//
//  Created by 吴先滇 on 15/12/14.
//  Copyright © 2015年 com.lvwenhan. All rights reserved.
//

import UIKit

class BubbyListViewController: UIViewController,UITableViewDelegate,UITableViewDataSource
{
    @IBOutlet weak var bubbyListTableView: UITableView!

    override func viewDidLoad()
    {
        super.viewDidLoad()
        self.bubbyListTableView.delegate = self
        self.bubbyListTableView.dataSource = self
        self.bubbyListTableView.registerNib(UINib(nibName: "BubbyListTableViewCell", bundle: nil), forCellReuseIdentifier: "BubbyListTableViewCell")
        // Do any additional setup after loading the view.
    }

    func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        
        let cell:BubbyListTableViewCell = tableView.dequeueReusableCellWithIdentifier("BubbyListTableViewCell", forIndexPath: indexPath) as! BubbyListTableViewCell
        cell.headImageView.image = UIImage(named: "000")
        cell.nickNameLabel.text = "hoatson"
        cell.realNameLabel.text = "火山"
        cell.mailLabel.text = "110@qq.com"
        
        return cell
    }
    
    func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 4
    }
    
    func numberOfSectionsInTableView(tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(tableView: UITableView, heightForRowAtIndexPath indexPath: NSIndexPath) -> CGFloat {
        return 115.0
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
