//
//  HomeViewModel.swift
//  Todoey
//
//  Created by Juan Peretti on 10/02/2025.
//

import Foundation

class HomeViewModel : ObservableObject {
    
    @Published var source: Source
    @Published var categories: [Category]
    
    private let sourceRepository = DependencyProvider.shared.sourceRepository
    private let categoryRepository = DependencyProvider.shared.categoryRepository
    
    init() {
        source = sourceRepository.getCurrent()
        categories = categoryRepository.load()
    }
    
    func selectSource(newSource: Source) {
        sourceRepository.setCurrent(source: newSource)
    }
    
    func createCategory(name: String) {
        let category = Category(categoryTitle: name)
        if categoryRepository.add(category: category) {
            categories = categoryRepository.load()
        } else {
            print("Failed to add category")
        }
    }
}
