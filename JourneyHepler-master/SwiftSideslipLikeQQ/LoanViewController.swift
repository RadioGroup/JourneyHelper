//
//  LoanViewController.swift
//  SwiftSideslipLikeQQ
//
//  Created by 吴先滇 on 15/11/19.
//  Copyright © 2015年 com.lvwenhan. All rights reserved.
//

import UIKit

class LoanViewController: UIViewController,UIWebViewDelegate
{
    var request :  NSURLRequest!

    @IBOutlet weak var loanWeb: UIWebView!
    override func viewDidLoad() {
        super.viewDidLoad()
        self.loanWeb.delegate = self
        let url = NSURL(string: "http://bbs.fzu.edu.cn/forum.php?mod=forumdisplay&fid=311&page=1&mobile=2")
        request = NSURLRequest.init(URL:url!)
        loanWeb.loadRequest(request)
        
        

        // Do any additional setup after loading the view.
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
