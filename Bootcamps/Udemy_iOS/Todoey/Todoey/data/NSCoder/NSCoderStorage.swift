//
//  NSCoderStorage.swift
//  Todoey
//
//  Created by Juan Peretti on 07/02/2025.
//

import Foundation

class NSCoderStorage {
    
    private let categoriesFilePath = FileManager.default.urls(for: .documentDirectory, in: .userDomainMask).first?.appendingPathComponent("Categories.plist")
    private let tasksFilePath = FileManager.default.urls(for: .documentDirectory, in: .userDomainMask).first?.appendingPathComponent("Items.plist")
    
    
    func save(category: Category) {
        let encoder = PropertyListEncoder()
        do {
            var nsCategories = getNSCategories() ?? []
            let nsCategory = category.toNSCategory()
            
            if let existingCategory = nsCategories.first(where: { nsCat in
                nsCat.id == category.id
            }) {
                // is an update
                nsCategory.tasks = 
                
                nsCategories.removeAll { toUpdate in
                    toUpdate.id == category.id
                }
            }
            
            
            
            nsCategories.append(category.toNSCategory())
            let data = try encoder.encode(nsCategories)
            try data.write(to: categoriesFilePath!)
        } catch {
            print("Error encoding categories \(error.localizedDescription)")
        }
    }
    
    func load(uuid: UUID) -> Category? {
        return getCategories()?.first(where: { category in
            category.id == uuid
        })
    }
    
    func getCategories() -> [Category]? {
        return getNSCategories()?.map { nsCategory in
            nsCategory.toCategory()
        }
    }
    
    
    func saveTasks(task: Task, to: Category) {
        if let storedCategory = getNSCategories()?.first(where: { nsCategory in
                nsCategory.id == to.id
            })  {
                let encoder = PropertyListEncoder()
                do {
                    storedCategory.tasks.append(task.toNSTask())
                    let data = try encoder.encode(tasks)
                    try data.write(to: tasksFilePath!)
            } catch {
                print("Error encoding item array \(error)")
            }
        }
    }
    
    func getTasks(for category: Category) -> [Task]? {
        if let data = try? Data(contentsOf: tasksFilePath!) {
            let decoder = PropertyListDecoder()
            do {
                return try decoder.decode([Task].self, from: data)
            } catch {
                print("Error decpding item array \(error)")
                return nil
            }
        } else {
            return []
        }
    }
    
    
    private func getNSCategories() -> [NSCategory]? {
        if let data = try? Data(contentsOf: categoriesFilePath!) {
            let decoder = PropertyListDecoder()
            do {
                return try decoder
                    .decode([NSCategory].self, from: data)
            } catch {
                print("Error decpding item array \(error)")
                return nil
            }
        } else {
            return []
        }
    }
    
}

private extension Task {
    func toNSTask() -> NSTask {
        return NSTask(id: self.title, title: self.title, isSelected: self.isSelected)
    }
}

private extension Category {
    func toNSCategory() -> NSCategory {
        return NSCategory(id: self.id, categoryTitle: self.categoryTitle, tasks: [])
    }
}


private extension NSTask {
    func toTask() -> Task {
        return Task(id: self.id, title: self.title, isSelected: self.isSelected)
    }
}

private extension NSCategory {
    func toCategory() -> Category {
        return Category(id: self.id, categoryTitle: self.categoryTitle)
    }
}
