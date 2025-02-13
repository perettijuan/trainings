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
    
    func saveCategory(category: Category) {
        category
            .toDataEntity(context: container.viewContext)
            .save(context: container.viewContext)
    }
    
    func loadCategories() -> [Category]? {
        var categories: [Category]?
        let request: NSFetchRequest<CategoryEntity> = CategoryEntity.fetchRequest()
        do {
            try categories = container.viewContext.fetch(request).map({ category in
                category.toDomain()
            })
        } catch {
            print("Error retrieving categories \(error)")
        }
        return categories
    }
    
    func load(uuid: UUID) -> Category? {
        let request: NSFetchRequest<CategoryEntity> = CategoryEntity.fetchRequest()
        request.predicate = NSPredicate(format: "id = %@", uuid.uuidString)
        let result =  try? container.viewContext.fetch(request)
        if result?.count == 1 {
            return result![0].toDomain()
        } else {
            return nil
        }
    }
    
    func saveTask(task: Task) {
        task
            .toDataEntity(context: container.viewContext)
            .save(context: container.viewContext)
    }
    
    func loadTasks() -> [Task]? {
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
    
    func updateTask(task: Task) -> Bool {
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

private extension Category {
    func toDataEntity(context: NSManagedObjectContext) -> CategoryEntity {
        let category = CategoryEntity(context: context)
        category.id = self.id.uuidString
        category.name = self.categoryTitle
        return category
    }
}

private extension CategoryEntity {
    func toDomain() -> Category {
        let mappedId = if let safeId = id {
            UUID(uuidString: safeId)
        } else {
            UUID()
        }
        
        return Category(id: mappedId!, categoryTitle: self.name ?? "Unknown")
    }
    
    
    func save(context: NSManagedObjectContext) {
        do {
            try context.save()
        } catch {
            print("Error saving context \(error)")
        }
    }
}
