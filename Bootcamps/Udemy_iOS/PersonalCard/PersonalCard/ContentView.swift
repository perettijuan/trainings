//
//  ContentView.swift
//  PersonalCard
//
//  Created by Juan Peretti on 24/01/2025.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        ZStack {
            Color(red: 0.09, green: 0.63, blue: 0.52)
                .edgesIgnoringSafeArea(.all)
            VStack {
                Image("juan")
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: 150.0, height: 150.0)
                    .clipShape(Circle())
                    .overlay(Circle().stroke(Color.white, lineWidth: 5))
                Text("Juan Peretti")
                    .font(Font.custom("Montserrat-VariableFont_wght", size:40))
                    .bold()
                    .foregroundColor(.white)
                Text("Software Engineer")
                    .font(.system(size: 25))
                    .foregroundColor(.white)
                Divider()
                InfoView(text: "+351 882782927", imageName: "phone.fill")
                InfoView(text: "peretti.juan@gmail.com", imageName: "envelope.fill")
            }
        }
    }
}

#Preview {
    ContentView()
}
