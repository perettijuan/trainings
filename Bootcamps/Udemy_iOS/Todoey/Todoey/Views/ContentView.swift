//
//  ContentView.swift
//  Todoey
//
//  Created by Juan Peretti on 27/01/2025.
//

import SwiftUI

struct ContentView: View {
    @ObservedObject var manager = TodoListManager.shared
    
    var body: some View {
        NavigationView {
            List {
                ForEach(manager.items) { item in
                    ItemView(task: item)
                        .onTapGesture {
                            self.manager.selectTask(task: item)
                        }
                }.onDelete(perform: deleteTask)
            }.toolbar{
                Group {
                    ToolbarTitle()
                    ToolbarAddAction(
                        sourceOption: $manager.source,
                        onAdd: { newItemName in
                            if !newItemName.isEmpty {
                                let newId = Int.random(in: 0...500)
                                let newTask = Task(id: String(newId), title: newItemName, isSelected: false)
                                manager.addTask(task: newTask)
                            }
                        },
                        onSourceChange: { source in
                            manager.selectSource(newSource: source)
                        }
                    )
                }
            }
            .listStyle(PlainListStyle())
            .toolbarBackground(.blue, for: .navigationBar)
            .toolbarBackground(.visible, for: .navigationBar)
        }
    }
    
    func deleteTask(at offsets: IndexSet) {
        offsets.forEach { index in
            self.manager.deleteTask(at: index)
        }
    }
}

struct ItemView: View {
    var task: Task
    
    var body: some View {
        HStack {
            Text(task.title)
            Spacer()
            Image(systemName: task.isSelected ? "checkmark.circle.fill" : "circle")
        }.contentShape(Rectangle()) // Makes the entire row tap
    }
}

struct ToolbarTitle: ToolbarContent {
    var body: some ToolbarContent {
        ToolbarItem(placement: .principal) {
            Text("Todoey")
                .foregroundColor(.white)
                .font(.title)
        }
    }
}


struct ToolbarAddAction: ToolbarContent {
    @State private var showAlert = false
    @State private var name = ""
    
    @Binding var sourceOption: Source
    
    var onAdd: ((String) -> Void)?
    var onSourceChange: ((Source) -> Void)?
    
    var body: some ToolbarContent {
        ToolbarItem(placement: .primaryAction) {
            Menu {
                Button("Add Item", systemImage: "plus") {
                    showAlert.toggle()
                }
                
                Divider()
                
                Picker("Sort by", selection: $sourceOption) {
                    ForEach(Source.allCases) { option in
                        Text(option.rawValue).tag(option)
                    }
                }
            } label: {
                Image(systemName: "ellipsis.circle").tint(.white)
            }.alert("Add Todoey Item", isPresented: $showAlert) {
                TextField("Enter item", text: $name)
                Button("OK", role: .cancel) {
                    onAdd?(name)
                }
            }.onChange(of: sourceOption) { oldValue, newValue in
                onSourceChange?(newValue)
            }
        }
    }
}

#Preview {
    ContentView()
}
