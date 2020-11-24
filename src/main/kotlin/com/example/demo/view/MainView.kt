package com.example.demo.view

import com.example.demo.app.Styles
import javafx.scene.control.Label
import tornadofx.*
import javax.swing.text.html.ImageView
import javafx.scene.image.Image
import javafx.stage.Stage

class MainView : View("Willkommen") {
    var logoepo: Label by singleAssign()

    override val root = hbox {

        vbox(spacing = 20){
            label(title) {
                addClass(Styles.heading)
            }

            setPrefSize(100.0, 100.0)
            imageview("/logo.png", lazyload = false) {
                fitHeightProperty().bind(parent.prefHeight(100.0).toProperty())
                fitWidthProperty().bind(parent.prefWidth(100.0).toProperty())
            }

            button("Login") {
                isDefaultButton = true
                useMaxHeight = true
                action {
                    LoginFenster().openWindow()
                }
            }

        }
    }

    }
