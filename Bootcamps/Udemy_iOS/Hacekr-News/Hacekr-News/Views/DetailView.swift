//
//  DetailView.swift
//  Hacekr-News
//
//  Created by Juan Peretti on 27/01/2025.
//

import SwiftUI


struct DetailView: View {
    
    let url: String?
    
    var body: some View {
        WebView(urlString: url)
    }
}

#Preview {
    DetailView(url: "https://www.google.com")
}



