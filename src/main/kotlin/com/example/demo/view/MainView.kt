package com.example.demo.view

import com.example.demo.app.Styles
import javafx.geometry.Pos
import javafx.scene.control.Label
import tornadofx.*
import javax.swing.text.html.ImageView
import javafx.scene.image.Image
import javafx.scene.paint.Color
import javafx.stage.Stage

class MainView : View("EPO") {

    override val root = hbox {
        style{
            fontSize = 20.px
            backgroundColor=multi(c(colorString="black"))
        }
        alignment = Pos.CENTER
        vbox(50,Pos.CENTER){
            setPrefSize(250.0, 250.0)
            imageview("/logo.png", lazyload = false) {
                fitHeightProperty().bind(parent.prefHeight(600.0).toProperty())
                fitWidthProperty().bind(parent.prefWidth(600.0).toProperty())
            }

            button("Login >") {
                style{
                    backgroundColor = multi(c(colorString = "black"))
                    textFill= c(colorString = "#4c2dc6")
                    borderColor= multi(box(
                            top=c(colorString = "#4c2dc6"),
                            bottom = c(colorString = "#4c2dc6"),
                            right= c(colorString = "#4c2dc6"),
                            left=c(colorString = "#4c2dc6")
                    ))
                }
                isDefaultButton = true
                useMaxHeight = true
                action {
                    LoginFenster().openWindow()
                }
            }
        }
    }
}
