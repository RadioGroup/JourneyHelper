//
//  RightViewController.swift
//  SwiftSideslipLikeQQ
//
//  Created by 吴先滇 on 15/12/10.
//  Copyright © 2015年 com.lvwenhan. All rights reserved.
//

import UIKit

class RightViewController: UIViewController {
    @IBOutlet weak var journeyTime: UITextField!

    @IBOutlet weak var journeyTitle: UITextField!
    @IBOutlet weak var journeyPlan: UITextView!
    @IBOutlet weak var journeyPlace: UITextField!
    
    override func viewDidLoad() {

        super.viewDidLoad()
        
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
