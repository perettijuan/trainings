//
//  TaskRepository.swift
//  Todoey
//
//  Created by Juan Peretti on 10/02/2025.
//

import Foundation

protocol TaskRepository {
    func load(for category: Category) -> [Task]
    func add(task: Task, to: Category) -> Bool
    func update(task: Task) -> Bool
    func delete(task: Task) -> Bool
}
