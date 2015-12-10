//
//  RouteDetailViewController.swift
//  SwiftSideslipLikeQQ
//
//  Created by 吴先滇 on 15/11/20.
//  Copyright © 2015年 com.lvwenhan. All rights reserved.
//

import UIKit

class RouteDetailViewController: UIViewController {

    @IBOutlet weak var titleLabel: UILabel!
    
    @IBOutlet weak var imageView: UIImageView!
    
    @IBOutlet weak var beginTimeLabel: UILabel!
    
    @IBOutlet weak var strongLabel: UILabel!
    
    @IBOutlet weak var propertyLabel: UILabel!
    
    
    @IBOutlet weak var textView: UITextView!
    
    var index:Int = 0
    
    override func viewDidLoad() {
        
        super.viewDidLoad()
        self.titleLabel.text = string?.objectAtIndex(index).objectForKey("title") as? String
        self.beginTimeLabel.text = string?.objectAtIndex(index).objectForKey("beginTime") as? String
        self.strongLabel.text = string?.objectAtIndex(index).objectForKey("strengthGrade") as? String
        self.propertyLabel.text = string?.objectAtIndex(index).objectForKey("assemblingPlace") as? String
        self.textView.text = string?.objectAtIndex(index).objectForKey("article") as? String
        var url:NSURL?
        var data:NSData?
        var image:UIImage?
        
        

//        var set = string?.objectAtIndex(index).objectForKey("routeImageUrl") as? String
//         set = set!.stringByReplacingOccurrencesOfString("/", withString: "", options: NSStringCompareOptions.LiteralSearch, range: nil)
//                url = NSURL(string: set!)!
        url = NSURL(string: (string?.objectAtIndex(index).objectForKey("routeImageUrl") as? String)!)!
        data = NSData(contentsOfURL:url!)!
        image = UIImage(data:data!)
        self.imageView.image = image

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
