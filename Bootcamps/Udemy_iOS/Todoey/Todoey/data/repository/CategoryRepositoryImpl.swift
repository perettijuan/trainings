//
//  CategoryRepositoryImpl.swift
//  Todoey
//
//  Created by Juan Peretti on 12/02/2025.
//

import Foundation

class CategoryRepositoryImpl: CategoryRepository {
    
    // Ideally, this dependency should not exists, just for simplification
    private let sourceRepository: SourceRepository
    
    private let coreDataStorage: CoreDataStorage
    private let nsCoderStorage: NSCoderStorage
    
    init(sourceRepository: SourceRepository, coreDataStorage: CoreDataStorage, nsCoderStorage: NSCoderStorage) {
        self.sourceRepository = sourceRepository
        self.coreDataStorage = coreDataStorage
        self.nsCoderStorage = nsCoderStorage
    }
    
    
    func load() -> [Category] {
        var categories: [Category]?
        switch sourceRepository.getCurrent() {
        case .nsCoder:
            categories = nsCoderStorage.getCategories()
        case .coreData:
            categories = coreDataStorage.loadCategories()
        }
        return categories ?? []
    }
    
    func load(uuid: UUID) -> Category? {
        var category: Category?
        switch sourceRepository.getCurrent() {
        case .nsCoder:
            category = nsCoderStorage.load(uuid: uuid)
        case .coreData:
            category = coreDataStorage.load(uuid: uuid)
        }
        return category
    }
    
    func add(category: Category) -> Bool {
        var added = false
        switch sourceRepository.getCurrent() {
        case .nsCoder:
            if let currentCategories = nsCoderStorage.getCategories() {
                var newCategories = currentCategories
                newCategories.append(category)
                nsCoderStorage.saveCategories(categories: newCategories)
                added = true
            }
        case .coreData:
            coreDataStorage.saveCategory(category: category)
            added = true
        }
        return added
    }
}
