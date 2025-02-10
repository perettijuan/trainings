//
//  TodoListManager.swift
//  Todoey
//
//  Created by Juan Peretti on 04/02/2025.
//

import Foundation


class TodoListManager : ObservableObject {
    
    static let shared = TodoListManager()
    
    @Published var items = [Task]()
    @Published var source: Source
    
    private let coreDataStorage = CoreDataStorage()
    private let nsCoderStorage = NSCoderStorage()
    
    private let userDefaults = UserDefaults.standard
    
    
    private init() {
        if let storedSelectedSource = userDefaults.string(forKey: "storedSource") {
            source = storedSelectedSource.toSource()
        } else {
            source = Source.nsCoder
        }
        print("Loaded source \(source)")
    }
    
    func initialize() {
        loadTasks()
    }
    
    func selectSource(newSource: Source) {
        source = newSource
        userDefaults.setValue(newSource.id, forKey: "storedSource")
        loadTasks()
    }
    
    func addTask(task: Task) {
        items.append(task)
        switch source {
        case .nsCoder:
            nsCoderStorage.saveAll(tasks: items)
        case .coreData:
            coreDataStorage.saveTask(task: task)
        }
    }
    
    func selectTask(task: Task) {
        if let index = items.firstIndex(where: { $0.id == task.id }) {
            let updatedTask = Task(id: task.id, title: task.title, isSelected: !task.isSelected)
            switch source {
            case .nsCoder:
                nsCoderStorage.saveAll(tasks: items)
                items[index] = updatedTask
            case .coreData:
                if coreDataStorage.update(task: updatedTask) {
                    print("Task Updated")
                    items[index] = updatedTask
                } else {
                    print("Failed to select task")
                }
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
            switch source {
            case .nsCoder:
                items.remove(at: index)
                nsCoderStorage.saveAll(tasks: items)
            case .coreData:
                let taskToDelete = items[index]
                if coreDataStorage.delete(task: taskToDelete) {
                    items.remove(at: index)
                    print("Task Deleted")
                } else {
                    print("Failed to delete task")
                }
            }
        }
    }
    
    
    private func loadTasks() {
        switch source {
        case .nsCoder:
            if let safeTasks = nsCoderStorage.getAll() {
                items = safeTasks
            }
        case .coreData:
            if let safeTasks = coreDataStorage.loadAll() {
                items = safeTasks
            }
        }
    }
}

private extension String {
    func toSource() -> Source {
        switch self {
        case Source.nsCoder.id:
            Source.nsCoder
        default:
            Source.coreData
        }
    }
}
