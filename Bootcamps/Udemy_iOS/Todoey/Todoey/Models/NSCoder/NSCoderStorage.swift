//
//  NSCoderStorage.swift
//  Todoey
//
//  Created by Juan Peretti on 07/02/2025.
//

import Foundation

class NSCoderStorage {
    
    private let dataFilePath = FileManager.default.urls(for: .documentDirectory, in: .userDomainMask).first?.appendingPathComponent("Items.plist")
    
    
    func saveAll(tasks: [Task]) {
        let encoder = PropertyListEncoder()
        do {
            let data = try encoder.encode(tasks)
            try data.write(to: dataFilePath!)
        } catch {
            print("Error encoding item array \(error)")
        }
    }
    
    func getAll() -> [Task]? {
        if let data = try? Data(contentsOf: dataFilePath!) {
            let decoder = PropertyListDecoder()
            do {
                return try decoder.decode([Task].self, from: data)
            } catch {
                print("Error decpding item array \(error)")
                return nil
            }
        } else {
            return nil
        }
    }
    
}
