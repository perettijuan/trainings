//
//  TodoListManager.swift
//  Todoey
//
//  Created by Juan Peretti on 04/02/2025.
//

import Foundation


class TasksViewModel : ObservableObject {
    
    @Published var items = [Task]()
    @Published var searchQuery: String = ""
    @Published var categoryLabel: String = ""

    
    private let taskRepository = DependencyProvider.shared.taskRepository
    private let categoriesRepository = DependencyProvider.shared.categoryRepository
    
    var filteredTasks: [Task] {
        guard !searchQuery.isEmpty else { return items }
        return items.filter { task in
            task.title.lowercased().contains(searchQuery.lowercased())
        }
    }
    
    func initialize(categoryId: UUID) {
        if let category = categoriesRepository.load(uuid: categoryId) {
            categoryLabel = category.categoryTitle
            items = taskRepository.load(for: category)
        }
    }
    
    func addTask(task: Task) {
        if taskRepository.add(task: task) {
            items.append(task)
        }
    }
    
    func selectTask(task: Task) {
        if let index = items.firstIndex(where: { $0.id == task.id }) {
            let updatedTask = Task(id: task.id, title: task.title, isSelected: !task.isSelected)
            if taskRepository.update(task: task) {
                items[index] = updatedTask
            } else {
                print("Failed to update task")
            }
        }
    }
    
    func deleteTask(at index: Int) {
        if index > 0 && index < items.endIndex {
            let taskToDelete = items[index]
            deleteTask(task: taskToDelete)
        }
    }
    
    
    func deleteTask(task: Task) {
        if let index = items.firstIndex(where: {$0.id == task.id}) {
            if taskRepository.delete(task: task) {
                items.remove(at: index)
            } else {
                print("Failed to delete task")
            }
        }
    }
}


