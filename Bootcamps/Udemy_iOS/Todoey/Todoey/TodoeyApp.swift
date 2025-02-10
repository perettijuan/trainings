//
//  TodoeyApp.swift
//  Todoey
//
//  Created by Juan Peretti on 27/01/2025.
//

import SwiftUI

@main
struct TodoeyApp: App {
    
    @UIApplicationDelegateAdaptor private var appDeleggate: SwiftUIAppDelegate
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
