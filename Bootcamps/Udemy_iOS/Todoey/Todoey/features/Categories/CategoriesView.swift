//
//  CategoriesView.swift
//  Todoey
//
//  Created by Juan Peretti on 10/02/2025.
//

import SwiftUI

struct CategoriesView: View {
    let categories = [
        CaregoryItem(categoryTitle: "Category1"),
        CaregoryItem(categoryTitle: "Category2"),
        CaregoryItem(categoryTitle: "Category3")
    ]
    
    
    var body: some View {
        List {
            ForEach(categories) { category in
                NavigationLink(destination: TaskView()) {
                    CategoryItemView(title: category.categoryTitle)
                }
            }
        }
    }
}

struct CategoryItemView: View {
    
    var title: String
    
    var body: some View {
        Text(title)
    }
}


// Identifiable is mandatory for ForEach
struct CaregoryItem: Identifiable {
    let id = UUID()
    var categoryTitle: String
    
}

#Preview {
    CategoriesView()
}
