//
//  SourceRepository.swift
//  Todoey
//
//  Created by Juan Peretti on 10/02/2025.
//

import Foundation


protocol SourceRepository {
    func getCurrent() -> Source
    func setCurrent(source: Source)
}
