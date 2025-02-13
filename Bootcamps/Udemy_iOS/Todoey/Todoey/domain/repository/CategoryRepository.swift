//
//  CategoryRepository.swift
//  Todoey
//
//  Created by Juan Peretti on 12/02/2025.
//

import Foundation


protocol CategoryRepository {
    func load() -> [Category]
    func load(uuid: UUID) -> Category?
    func add(category: Category) -> Bool
}
