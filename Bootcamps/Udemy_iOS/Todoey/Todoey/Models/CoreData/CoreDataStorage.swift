//
//  CoreDataStorage.swift
//  Todoey
//
//  Created by Juan Peretti on 07/02/2025.
//

import Foundation
import CoreData

class CoreDataStorage {
    
    // This is for CoreData
    private let container = NSPersistentContainer(name: "DataModel")
    
    init() {
        container.loadPersistentStores { description, error in
            if let error = error {
                print("Core data failed to load: \(error.localizedDescription)")
            }
        }
    }
    
    func saveTask(task: Task) {
        task.toDataEntity(context: container.viewContext).save(context: container.viewContext)
    }
    
    func loadAll() -> [Task]? {
        var tasks: [Task]?
        let request: NSFetchRequest<TaskEntity> = TaskEntity.fetchRequest()
        do {
            try tasks = container.viewContext.fetch(request).map({ entity in
                entity.toDomainTask()
            })
        } catch {
            print("Error retrieving tasks \(error)")
        }
        return tasks
    }
    
    func update(task: Task) -> Bool {
        if let storedTask = getWith(id: task.id) {
            storedTask.setValue(task.id, forKey: "id")
            storedTask.setValue(task.title, forKey: "title")
            storedTask.setValue(task.isSelected, forKey: "isSelected")
            storedTask.save(context: container.viewContext)
            return true
        } else {
            return false
        }
    }
    
    func delete(task: Task) -> Bool {
        if let storedTask = getWith(id: task.id) {
            storedTask.delete(context: container.viewContext)
            return true
        } else {
            return false
        }
    }
    
    
    private func getWith(id: String) -> TaskEntity? {
        let request: NSFetchRequest<TaskEntity> = TaskEntity.fetchRequest()
        request.predicate = NSPredicate(format: "id = %@", id)
        let result =  try? container.viewContext.fetch(request)
        if result?.count == 1 {
            return result![0]
        } else {
            return nil
        }
    }
    
}

private extension Task {
    func toDataEntity(context: NSManagedObjectContext) -> TaskEntity {
        let entity = TaskEntity(context: context)
        entity.id = self.id
        entity.title = self.title
        entity.isSelected = self.isSelected
        return entity
    }
}

private extension TaskEntity {
    func toDomainTask() -> Task {
        return Task(id: self.id ?? "Unknown", title: self.title ?? "Unknown" , isSelected: self.isSelected)
    }
    
    func save(context: NSManagedObjectContext) {
        do {
            try context.save()
        } catch {
            print("Error saving context \(error)")
        }
    }
    
    func delete(context: NSManagedObjectContext) {
        do {
            context.delete(self)
            try context.save()
        } catch {
            print("Error deleting context \(error)")
        }
    }
}
