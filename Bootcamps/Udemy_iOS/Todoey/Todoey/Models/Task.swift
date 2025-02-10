//
//  Task.swift
//  Todoey
//
//  Created by Juan Peretti on 04/02/2025.
//

import Foundation

// This should be separated in different layers
class Task : Identifiable, Codable {
    
    init(id: String, title: String, isSelected: Bool) {
        self.id = id
        self.title = title
        self.isSelected = isSelected
    }
    
    let id: String
    let title: String
    let isSelected: Bool
}
