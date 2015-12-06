//
//  PhotosViewController.swift
//  SwiftSideslipLikeQQ
//
//  Created by 吴先滇 on 15/11/20.
//  Copyright © 2015年 com.lvwenhan. All rights reserved.
//

import UIKit

class PhotosViewController: UIViewController,UITableViewDataSource,UITableViewDelegate {

    
    @IBOutlet weak var tableView: UITableView!
    
    var photos0 = ["gushan0","qingyunshan0","tailaoshan0","tulou0"]
    var photos1 = ["gushan1","qingyunshan1","tailaoshan1","tulou1"]
    var string  = ["鼓山","青云山","太姥山","云水谣"]
    override func viewDidLoad() {
        super.viewDidLoad()
        self.tableView.delegate = self
        self.tableView.dataSource = self
        self.tableView.registerNib(UINib(nibName: "PhotosTableViewCell", bundle: nil ), forCellReuseIdentifier: "photos")
        
        
        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        let cell:PhotosTableViewCell = tableView.dequeueReusableCellWithIdentifier("photos", forIndexPath: indexPath) as! PhotosTableViewCell
        
        cell.backgroundColor = UIColor.clearColor()
        cell.imageView0.image = UIImage(named: photos0[indexPath.row])
        cell.imageView1.image = UIImage(named: photos1[indexPath.row])
        cell.label.text = string[indexPath.row]
        return cell
    }
    
    func numberOfSectionsInTableView(tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return string.count
    }
    
    func tableView(tableView: UITableView, heightForRowAtIndexPath indexPath: NSIndexPath) -> CGFloat {
        return 198.0
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
