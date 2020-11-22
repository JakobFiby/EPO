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

            logoepo=label()
            logoepo.graphic=imageview("../logo.png", lazyload = true){
                fitHeight=200.0
                fitWidth=200.0
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
