//
//  InfoView.swift
//  PersonalCard
//
//  Created by Juan Peretti on 24/01/2025.
//

import SwiftUI

struct InfoView: View {
    let text: String
    let imageName: String
    
    var body: some View {
        RoundedRectangle(cornerRadius: 25.0)
            .fill(Color.white)
            .frame(height: 50)
            .overlay(HStack {
                Image(systemName: imageName)
                    .foregroundColor(.blue)
                Text(text)
            })
            .padding(.all)
    }
}

#Preview {
    InfoView(text: "peretti.juan@gmail.com", imageName: "envelope.fill")
        .previewLayout(.sizeThatFits)
}
