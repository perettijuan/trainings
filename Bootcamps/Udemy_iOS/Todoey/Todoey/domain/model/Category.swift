//
//  Category.swift
//  Todoey
//
//  Created by Juan Peretti on 12/02/2025.
//

import Foundation

// Identifiable is mandatory for ForEach in SwiftUI
class Category : Identifiable {
    var id: UUID
    var categoryTitle: String
    
    init(id: UUID = UUID(), categoryTitle: String) {
        self.id = id
        self.categoryTitle = categoryTitle
    }
}
