//
//  TaskRepositoryImpl.swift
//  Todoey
//
//  Created by Juan Peretti on 10/02/2025.
//

import Foundation


class TaskRepositoryImpl : TaskRepository {
    
    // Ideally, this dependency should not exists, just for simplification
    private let sourceRepository: SourceRepository
    
    private let coreDataStorage: CoreDataStorage
    private let nsCoderStorage: NSCoderStorage
    
    init(sourceRepository: SourceRepository, coreDataStorage: CoreDataStorage, nsCoderStorage: NSCoderStorage) {
        self.sourceRepository = sourceRepository
        self.coreDataStorage = coreDataStorage
        self.nsCoderStorage = nsCoderStorage
    }
    
    func load(for category: Category) -> [Task] {
        var tasks: [Task]?
        switch sourceRepository.getCurrent() {
        case .nsCoder:
            tasks = nsCoderStorage.getTasks(for: category)
        case .coreData:
            tasks = coreDataStorage.loadTasks()
        }
        return tasks ?? []
    }
    
    func add(task: Task, to: Category) -> Bool {
        var added = false
        switch sourceRepository.getCurrent() {
        case .nsCoder:
            if let currentTasks = nsCoderStorage.getTasks(for: to) {
                var newTasks = currentTasks
                newTasks.append(task)
                nsCoderStorage.saveTasks(tasks: newTasks)
                added = true
            }
        case .coreData:
            coreDataStorage.saveTask(task: task)
            added = true
        }
        return added
    }
    
    func update(task: Task) -> Bool {
        var updated = false
        switch sourceRepository.getCurrent() {
        case .nsCoder:
            if let currentTasks = nsCoderStorage.getTasks() {
                if let index = currentTasks.firstIndex(where: { $0.id == task.id }) {
                    var updatedTasks = currentTasks
                    updatedTasks[index] = task
                    nsCoderStorage.saveTasks(tasks: updatedTasks)
                    updated = true
                }
            }
        case .coreData:
            updated = coreDataStorage.updateTask(task: task)
        }
        return updated
    }
    
    func delete(task: Task) -> Bool {
        var deleted = false
        switch sourceRepository.getCurrent() {
        case .nsCoder:
            if let currentTasks = nsCoderStorage.getTasks() {
                if let index = currentTasks.firstIndex(where: { $0.id == task.id }) {
                    var updatedTasks = currentTasks
                    updatedTasks.remove(at: index)
                    nsCoderStorage.saveTasks(tasks: updatedTasks)
                    deleted = true
                }
            }
        case .coreData:
            deleted = coreDataStorage.delete(task: task)
        }
        return deleted
    }
    
}
