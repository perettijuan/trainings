//
//  WeatherData.swift
//  Clima
//
//  Created by Juan Peretti on 15/01/2025.
//  Copyright © 2025 App Brewery. All rights reserved.
//

import Foundation


class WeatherData : Codable {
    let name: String
    let main: Main
    let weather: [Weather]
}

struct Main: Codable {
    let temp: Double
}

struct Weather: Codable {
    let id: Int
    let description: String
}
