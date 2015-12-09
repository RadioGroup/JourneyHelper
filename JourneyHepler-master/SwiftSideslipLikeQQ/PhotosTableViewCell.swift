//
//  PhotosTableViewCell.swift
//  SwiftSideslipLikeQQ
//
//  Created by 吴先滇 on 15/11/20.
//  Copyright © 2015年 com.lvwenhan. All rights reserved.
//

import UIKit

class PhotosTableViewCell: UITableViewCell {

    
    @IBOutlet weak var label: UILabel!
    
    @IBOutlet weak var imageView0: UIImageView!
    @IBOutlet weak var imageView1: UIImageView!
    
    override func awakeFromNib()
    {
        
        super.awakeFromNib()
        // Initialization code
        self.layer.masksToBounds = true
        self.layer.cornerRadius = self.frame.size.width/10
    }

    override func setSelected(selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

    }
    
}
