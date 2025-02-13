//
//  ContentView.swift
//  Todoey
//
//  Created by Juan Peretti on 27/01/2025.
//

import SwiftUI

struct HomeScreen: View {
    @ObservedObject var viewModel = HomeViewModel()
    
    var body: some View {
        NavigationView {
            CategoriesView(
                categories: viewModel.categories,
                destination: { categoryId in
                    TaskView(categoryId: categoryId)
                }
            )
            .toolbar{
                Group {
                    ToolbarTitle()
                    ToolbarSelectSource(
                        sourceOption: $viewModel.source,
                        onSourceChange: { newSource in
                            viewModel.selectSource(newSource: newSource)
                        },
                        onAddCategory: { newCategory in
                            viewModel.createCategory(name: newCategory)
                        }
                    )
                }
            }
            .listStyle(PlainListStyle())
            .toolbarBackground(.visible, for: .navigationBar)
        }
    }
}

struct ToolbarSelectSource: ToolbarContent {
    @Binding var sourceOption: Source
    
    @State private var showAlert = false
    @State private var name = ""
    
    var onSourceChange: ((Source) -> Void)?
    var onAddCategory: ((String) -> Void)?
    
    var body: some ToolbarContent {
        ToolbarItem(placement: .primaryAction) {
            Menu {
                Button("Add Category", systemImage: "plus") {
                    showAlert.toggle()
                }
                
                Divider()
                
                Text("Select Source")
                Picker("Source", selection: $sourceOption) {
                    ForEach(Source.allCases) { option in
                        Text(option.rawValue).tag(option)
                    }
                }
            } label: {
                Image(systemName: "ellipsis.circle")
            }.onChange(of: sourceOption) { oldValue, newValue in
                onSourceChange?(newValue)
            }.alert("Add Todoey Category", isPresented: $showAlert) {
                TextField("Enter Category", text: $name)
                Button("OK", role: .cancel) {
                    onAddCategory?(name)
                }
            }
        }
    }
}


struct CategoriesView<Destination: View>: View {
    let categories: [Category]
    let destination: (UUID) -> Destination
    
    init(categories: [Category], destination: @escaping (UUID) -> Destination) {
        self.categories = categories
        self.destination = destination
    }
    
    var body: some View {
        List {
            ForEach(categories) { category in
                NavigationLink(destination: destination(category.id)) {
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

#Preview {
    HomeScreen()
}
