//
//  ToolbarExtensions.swift
//  Todoey
//
//  Created by Juan Peretti on 10/02/2025.
//

import SwiftUI

struct ToolbarTitle: ToolbarContent {
    var label: Binding<String> = Binding.constant("Todoey")
    
    var body: some ToolbarContent {
        ToolbarItem(placement: .principal) {
            VStack {
                Text(label.wrappedValue)
                    .foregroundColor(.blue)
                    .font(.title)
            }
        }
    }
}


#Preview {
    struct PreviewWrapper: View {
        @State private var subtitle = "Subtitle"
        
        var body: some View {
            NavigationView {
                Text("Content")
                    .toolbar {
                        ToolbarTitle(label: $subtitle)
                    }
            }
        }
    }
    
    return PreviewWrapper()
}
