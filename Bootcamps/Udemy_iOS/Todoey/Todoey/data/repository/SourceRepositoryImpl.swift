//
//  SourceRepositoryImpl.swift
//  Todoey
//
//  Created by Juan Peretti on 10/02/2025.
//

import Foundation

class SourceRepositoryImpl : SourceRepository {
    
    private let userDefaults = UserDefaults.standard
    
    func getCurrent() -> Source {
        if let storedSelectedSource = userDefaults.string(forKey: "storedSource") {
            return storedSelectedSource.toSource()
        } else {
            return Source.nsCoder
        }
    }
    
    func setCurrent(source: Source) {
        userDefaults.setValue(source.id, forKey: "storedSource")
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
