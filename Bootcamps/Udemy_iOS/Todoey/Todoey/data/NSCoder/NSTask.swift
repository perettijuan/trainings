//
//  NSTask.swift
//  Todoey
//
//  Created by Juan Peretti on 13/02/2025.
//

import Foundation
class NSTask : Codable {
    let id: String
    let title: String
    let isSelected: Bool
    
    init(id: String, title: String, isSelected: Bool) {
        self.id = id
        self.title = title
        self.isSelected = isSelected
    }
}
