//
//  NewsTableViewCell.swift
//  SwiftSideslipLikeQQ
//
//  Created by apple on 15/12/16.
//  Copyright © 2015年 com.lvwenhan. All rights reserved.
//

import UIKit

class NewsTableViewCell: UITableViewCell {

    
    @IBOutlet weak var titleLabel: UILabel!
  
   
    @IBOutlet weak var photoView: UIImageView!
    
    @IBOutlet weak var abstractLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
}
