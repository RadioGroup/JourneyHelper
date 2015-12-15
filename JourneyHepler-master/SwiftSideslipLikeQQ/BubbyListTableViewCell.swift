//
//  BubbyListTableViewCell.swift
//  SwiftSideslipLikeQQ
//
//  Created by 吴先滇 on 15/12/15.
//  Copyright © 2015年 com.lvwenhan. All rights reserved.
//

import UIKit

class BubbyListTableViewCell: UITableViewCell {
    @IBOutlet weak var mailLabel: UILabel!
    @IBOutlet weak var nickNameLabel: UILabel!
    @IBOutlet weak var headImageView: UIImageView!
    @IBOutlet weak var realNameLabel: UILabel!

    override func awakeFromNib() {
        super.awakeFromNib()
        self.headImageView.layer.cornerRadius = 37.0
        self.headImageView.clipsToBounds = true 
        // Initialization code
    }

    override func setSelected(selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
}
