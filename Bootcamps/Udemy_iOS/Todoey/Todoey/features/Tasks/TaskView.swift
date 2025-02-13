//
//  TaskView.swift
//  Todoey
//
//  Created by Juan Peretti on 10/02/2025.
//

import SwiftUI

struct TaskView: View {
    @ObservedObject var viewModel = TasksViewModel()
    
    private let categoryId: UUID
    
    init(viewModel: TasksViewModel = TasksViewModel(), categoryId: UUID) {
        self.viewModel = viewModel
        self.categoryId = categoryId
    }
    
    var body: some View {
        List {
            ForEach(viewModel.filteredTasks) { item in
                ItemView(task: item)
                    .onTapGesture {
                        self.viewModel.selectTask(task: item)
                    }
            }.onDelete(perform: deleteTask)
        }.toolbar{
            Group {
                ToolbarTitle(label: $viewModel.categoryLabel)
                ToolbarAddAction(
                    onAdd: { newItemName in
                        if !newItemName.isEmpty {
                            let newId = Int.random(in: 0...500)
                            let newTask = Task(id: String(newId), title: newItemName, isSelected: false)
                            viewModel.addTask(task: newTask)
                        }
                    }
                )
            }
        }
        .listStyle(PlainListStyle())
        .searchable(text: $viewModel.searchQuery, prompt: "Search tasks")
        .toolbarBackground(.visible, for: .navigationBar)
        .onAppear {
            viewModel.initialize(categoryId: categoryId)
        }
    }
    
    func deleteTask(at offsets: IndexSet) {
        offsets.forEach { index in
            self.viewModel.deleteTask(at: index)
        }
    }
}

struct ToolbarAddAction: ToolbarContent {
    @State private var showAlert = false
    @State private var name = ""
    
    var onAdd: ((String) -> Void)?
    
    var body: some ToolbarContent {
        ToolbarItem(placement: .primaryAction) {
            Menu {
                Button("Add Item", systemImage: "plus") {
                    showAlert.toggle()
                }
            } label: {
                Image(systemName: "ellipsis.circle")
            }.alert("Add Todoey Item", isPresented: $showAlert) {
                TextField("Enter item", text: $name)
                Button("OK", role: .cancel) {
                    onAdd?(name)
                }
            }
        }
    }
}


struct ItemView: View {
    var task: Task
    
    var body: some View {
        HStack {
            Text(task.title)
            Spacer()
            Image(systemName: task.isSelected ? "checkmark.circle.fill" : "circle")
        }.contentShape(Rectangle()) // Makes the entire row tap
    }
}

#Preview {
    TaskView(categoryId: UUID())
}
