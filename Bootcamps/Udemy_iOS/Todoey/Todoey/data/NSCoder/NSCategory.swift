//
//  NSCategory.swift
//  Todoey
//
//  Created by Juan Peretti on 13/02/2025.
//

import Foundation


class NSCategory : Codable {
    var id: UUID
    var categoryTitle: String
    var tasks: [NSTask]
    
    init(id: UUID, categoryTitle: String, tasks: [NSTask]) {
        self.id = id
        self.categoryTitle = categoryTitle
        self.tasks = tasks
    }
}
