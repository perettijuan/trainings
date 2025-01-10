//
//  Question.swift
//  Quizzler-iOS13
//
//  Created by Juan Peretti on 08/01/2025.
//  Copyright © 2025 The App Brewery. All rights reserved.
//

import Foundation

struct Question {
    let text: String
    let answer: String
    
    init(q: String, a: String) {
        self.text = q
        self.answer = a
    }
    
}
