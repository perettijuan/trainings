//
//  ResultsViewController.swift
//  Tipsy
//
//  Created by Juan Peretti on 10/01/2025.
//  Copyright © 2025 The App Brewery. All rights reserved.
//

import UIKit

class ResultsViewController: UIViewController {

    @IBOutlet weak var totalLabel: UILabel!
    @IBOutlet weak var settingsLabel: UILabel!
    
    var tip = 0.0
    var split = 0
    var billPerPerson = ""
    
    override func viewDidLoad() {
        super.viewDidLoad()
        totalLabel.text = billPerPerson
        settingsLabel.text = "Split between \(split) people, with \(tip)% tip."
    }
    
    
    @IBAction func recalculate(_ sender: UIButton) {
        self.dismiss(animated: true, completion: nil)
    }
}
