//
//  PersonalTableViewCell.swift
//  SwiftSideslipLikeQQ
//
//  Created by apple on 15/12/15.
//  Copyright © 2015年 com.lvwenhan. All rights reserved.
//

import UIKit

class PersonalTableViewCell: UITableViewCell {
    @IBOutlet weak var head: UILabel!
    @IBOutlet weak var information: UILabel!
    override func awakeFromNib() {
       
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
}
