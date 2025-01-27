//
//  PostData.swift
//  Hacekr-News
//
//  Created by Juan Peretti on 27/01/2025.
//

import Foundation


struct Results: Decodable {
    let hits: [Post]
}

struct Post : Decodable, Identifiable {
    var id: String  {
        return objectID
    }
    let objectID: String
    let points: Int
    let title: String
    let url: String?
}
