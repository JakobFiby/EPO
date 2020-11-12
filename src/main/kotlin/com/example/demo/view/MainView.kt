package com.example.demo.view

import com.example.demo.app.Styles
import javafx.scene.paint.Color
import tornadofx.*

class MainView : View("Willkommen") {
    override val root = hbox {
        label(title) {
            addClass(Styles.heading)
        }
        button("Login"){
            isDefaultButton = true
            useMaxHeight = true
            action {
                LoginFenster().openWindow()
            }
        }
    }
}