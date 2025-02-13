//
//  DependencyProvider.swift
//  Todoey
//
//  Created by Juan Peretti on 10/02/2025.
//

import Foundation

struct DependencyProvider {
    
    static let shared = DependencyProvider()
    
    let sourceRepository: SourceRepository
    let taskRepository: TaskRepository
    let categoryRepository: CategoryRepository
    
    private init() {
        sourceRepository = SourceRepositoryImpl()
        taskRepository = TaskRepositoryImpl(sourceRepository: sourceRepository, coreDataStorage: CoreDataStorage(), nsCoderStorage: NSCoderStorage())
        categoryRepository = CategoryRepositoryImpl(sourceRepository: sourceRepository, coreDataStorage: CoreDataStorage(), nsCoderStorage: NSCoderStorage())
    }
    
}
