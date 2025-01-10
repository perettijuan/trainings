//
//  CalculatorBrain.swift
//  BMI Calculator
//
//  Created by Juan Peretti on 10/01/2025.
//  Copyright © 2025 Angela Yu. All rights reserved.
//

import UIKit


struct CalculatorBrain {
    
    private var bmi: BMI?
    
    func getBMIValue() -> String {
        let bmiValue = String(format: "%.1f", bmi?.value ?? 0.0)
        return bmiValue
    }
    
    func getBMIAdvice() -> String {
        return bmi?.advice ?? ""
    }
    
    func getBMIColor() -> UIColor {
        return bmi?.color ?? UIColor.yellow
    }
    
    
    mutating func calculateBmi(height: Float, weight: Float) {
        let bmiValue = weight / (height * height)
        if bmiValue < 18.5 {
            bmi = BMI(value: bmiValue, advice: "Eat more pies", color: UIColor.blue)
        } else if bmiValue < 24.9 {
            bmi = BMI(value: bmiValue, advice: "Fit as a fiddle!", color: UIColor.green)
        } else {
            bmi = BMI(value: bmiValue, advice: "Eat less pies", color: UIColor.red)
        }
    }
}
