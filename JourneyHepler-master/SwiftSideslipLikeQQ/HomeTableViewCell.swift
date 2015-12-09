//
//  HomeTableViewCell.swift
//  SwiftSideslipLikeQQ
//
//  Created by 吴先滇 on 15/11/20.
//  Copyright © 2015年 com.lvwenhan. All rights reserved.
//

import UIKit

class HomeTableViewCell: UITableViewCell {
    
    @IBOutlet weak var typeLabel: UILabel!
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var imgae: UIImageView!
    @IBOutlet weak var createTimeLabel: UILabel!
    @IBOutlet weak var routeIdLabel: UILabel!
   
    override func awakeFromNib()
    {
      
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
}
