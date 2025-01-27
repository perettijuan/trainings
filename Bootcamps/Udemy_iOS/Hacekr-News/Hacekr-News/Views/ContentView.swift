//
//  ContentView.swift
//  Hacekr-News
//
//  Created by Juan Peretti on 27/01/2025.
//

import SwiftUI

struct ContentView: View {
    
    @ObservedObject var networkManager = NetworkManager()
    
    var body: some View {
        NavigationView {
            List(networkManager.posts) { post in
                NavigationLink(destination: DetailView(url: post.url)) {
                    HStack {
                        Text(String(post.points))
                        Text(post.title)
                    }
                }                
            }.navigationBarTitle("Hacker news")
        }
        .onAppear(perform: {
            self.networkManager.fetchData()
        })
    }
}


#Preview {
    ContentView()
}
