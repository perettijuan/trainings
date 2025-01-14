//
//  ViewController.swift
//  Tipsy
//
//  Created by Angela Yu on 09/09/2019.
//  Copyright © 2019 The App Brewery. All rights reserved.
//

import UIKit

class CalculatorViewController: UIViewController {

    @IBOutlet weak var billTextField: UITextField!
    @IBOutlet weak var zeroPcButton: UIButton!
    @IBOutlet weak var tenPcButton: UIButton!
    @IBOutlet weak var twentyPcButton: UIButton!
    @IBOutlet weak var splitNumberLabel: UILabel!
    
    private var tip = 0.10
    private var numberOfPeople = 2
    private var billTotal = 0.0

    override func viewDidLoad() {
        super.viewDidLoad()
        zeroPcButton.tag = 0
        tenPcButton.tag = 10
        twentyPcButton.tag = 20
    }

    @IBAction func tipChanged(_ sender: UIButton) {
        zeroPcButton.isSelected = true
        zeroPcButton.isSelected = sender.tag == zeroPcButton.tag
        tenPcButton.isSelected = sender.tag == tenPcButton.tag
        twentyPcButton.isSelected = sender.tag == twentyPcButton.tag
        tip = Double( sender.tag) / 100.0
        billTextField.endEditing(true)
    }
    
    
    @IBAction func stepperValueChanged(_ sender: UIStepper) {
        splitNumberLabel.text = String(format: "%.0f", sender.value)
        numberOfPeople = Int(sender.value)
    }
    
    @IBAction func calculatePressed(_ sender: UIButton) {
        let bill = billTextField.text!
        
        if bill != "" {
            billTotal = Double(bill)!
            self.performSegue(withIdentifier: "toResults", sender: self)
        }
    }
    
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "toResults" {
            let result = billTotal * (1 + tip) / Double(numberOfPeople)
            let formattedResult = String(format: "%.2f", result)
            let destinationVC = segue.destination as! ResultsViewController
            destinationVC.tip = tip
            destinationVC.billPerPerson = formattedResult
            destinationVC.split = numberOfPeople
        }
    }
    
}

