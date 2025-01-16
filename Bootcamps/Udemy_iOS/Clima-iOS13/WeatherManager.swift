//
//  WeatherManager.swift
//  Clima
//
//  Created by Juan Peretti on 15/01/2025.
//  Copyright © 2025 App Brewery. All rights reserved.
//

import Foundation
import CoreLocation

protocol WeatherManagerDelegate {
    func didUpdateWeather(_ weatherManager: WeatherManager, weather: WeatherModel)
    func didFailWithError(error: Error)
}

class WeatherManager {
    private let weatherURL = "https://api.openweathermap.org/data/2.5/weather?appid=7bc5575176a27cedde78433a71a7f899&units=metric"
    
    var delegate: WeatherManagerDelegate?
    
    func fetchWeather(cityName: String) {
        let urlString = "\(weatherURL)&q=\(cityName)"
        performRequest(with: urlString)
    }
    
    func fetchWeather(latitude: CLLocationDegrees, longitude: CLLocationDegrees) {
        let urlString = "\(weatherURL)&lat=\(latitude)&lon=\(longitude)"
        performRequest(with: urlString)
    }
    
    private func performRequest(with urlString : String) {
        // 1. Create a URL
        if let url = URL(string: urlString) {
            // 2. Create a URLSession
            let urlSession = URLSession(configuration: .default)
            // 3. Give the session a task
            let task = urlSession.dataTask(with: url) { (data, response, error) in
                if let safeError = error {
                    self.delegate?.didFailWithError(error: safeError)
                    return
                }
                
                if let safeData = data {                    
                    if let weather = self.parseJson(safeData) {
                        self.delegate?.didUpdateWeather(self, weather: weather)
                    }
                }
            }
            // 4. Start the task
            task.resume()
        }
    }
    
    private func parseJson(_ weatherData: Data) -> WeatherModel? {
        let decoder = JSONDecoder()
        do {
            let decodedData = try decoder.decode(WeatherData.self, from: weatherData)
            let id = decodedData.weather[0].id
            let temp = decodedData.main.temp
            let name = decodedData.name
            let weather = WeatherModel(conditionId: id, cityName: name, temperature: temp)
            return weather
        } catch {
            self.delegate?.didFailWithError(error: error)
            return nil
        }
    }
    
    
}
