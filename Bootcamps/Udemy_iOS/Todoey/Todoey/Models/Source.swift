//
//  Source.swift
//  Todoey
//
//  Created by Juan Peretti on 07/02/2025.
//

import Foundation
enum Source : String, CaseIterable, Identifiable {
    case nsCoder = "NSCoder"
    case coreData = "Core Data"
    
    var id: String { self.rawValue }
}
