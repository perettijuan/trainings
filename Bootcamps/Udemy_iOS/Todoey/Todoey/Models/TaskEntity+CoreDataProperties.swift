//
//  TaskEntity+CoreDataProperties.swift
//  Todoey
//
//  Created by Juan Peretti on 07/02/2025.
//
//

import Foundation
import CoreData


extension TaskEntity {

    @nonobjc public class func fetchRequest() -> NSFetchRequest<TaskEntity> {
        return NSFetchRequest<TaskEntity>(entityName: "TaskEntity")
    }

    @NSManaged public var id: String?
    @NSManaged public var isSelected: Bool
    @NSManaged public var title: String?

}

extension TaskEntity : Identifiable {

}
