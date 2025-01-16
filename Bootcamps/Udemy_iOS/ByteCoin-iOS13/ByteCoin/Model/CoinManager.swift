//
//  CoinManager.swift
//  ByteCoin
//
//  Created by Angela Yu on 11/09/2019.
//  Copyright © 2019 The App Brewery. All rights reserved.
//

import Foundation

protocol CoinManagerDelegate {
    func didLoadCoinPrice(_ coinManager: CoinManager, coin: CoinModel)
    func didFailWithError(error: Error)
}

class CoinManager {
    
    let baseURL = "https://rest.coinapi.io/v1/exchangerate/BTC"
    let apiKey = "3c2fb8b2-9901-4f53-a435-cda2afe7075f"
    
    let currencyArray = ["AUD", "BRL","CAD","CNY","EUR","GBP","HKD","IDR","ILS","INR","JPY","MXN","NOK","NZD","PLN","RON","RUB","SEK","SGD","USD","ZAR"]

    var delegate: CoinManagerDelegate?
    
    func getCoinPrice(for currency: String) {
        let urlString = "\(baseURL)/\(currency)?apiKey=\(apiKey)"
        performRequest(with: urlString, for: currency)
    }
    
    private func performRequest(with urlString: String, for currency: String) {
        if let url = URL(string: urlString) {
            let session = URLSession(configuration: .default)
            let task = session.dataTask(with: url) { (data, response, error) in
                if let safeError = error {
                    self.delegate?.didFailWithError(error: safeError)
                    return
                }
                
                if let safeData = data {
                    let model = self.parseJson(safeData, currency)
                    if let coin = model {
                        self.delegate?.didLoadCoinPrice(self, coin: coin)
                    }
                }
            }
            task.resume()
        }
    }
    
    private func parseJson(_ coinData: Data, _ currency: String) -> CoinModel? {
        let decoder = JSONDecoder()
        do {
            let decodedData = try decoder.decode(CoinData.self, from: coinData)
            return CoinModel(rate: String(format: "%.1f" , decodedData.rate), currency: currency)
        } catch {
            self.delegate?.didFailWithError(error: error)
            return nil
        }
    }
}
