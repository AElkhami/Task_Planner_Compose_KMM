//
//  ComposeView.swift
//  iosApp
//
//  Created by Ahmed Elkhami on 14/07/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared

struct ComposeView: UIViewControllerRepresentable {
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context){}
    func makeUIViewController(context: Context) -> some UIViewController {
         HomeControllerKt.MainViewController()
     }
}
