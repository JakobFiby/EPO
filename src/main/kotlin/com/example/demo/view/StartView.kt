package com.example.demo.view

import javafx.geometry.Pos
import tornadofx.*

class StartView : View("") {

    override val root = hbox {
        style{
            fontSize = 20.px
            backgroundColor=multi(c(colorString="black"))
        }
        alignment = Pos.CENTER

        vbox(50,Pos.CENTER){
            setPrefSize(250.0, 250.0)
            imageview("/logoNEU.png", lazyload = false) {
                fitHeightProperty().bind(parent.prefHeight(600.0).toProperty())
                fitWidthProperty().bind(parent.prefWidth(800.0).toProperty())
            } // ende image

            button("Login >") {
                style{
                    backgroundColor = multi(c(colorString = "black"))
                    textFill= c(colorString = "#4c2dc6")
                    borderColor= multi(box(
                            top=c(colorString = "#4c2dc6"),
                            bottom = c(colorString = "#4c2dc6"),
                            right= c(colorString = "#4c2dc6"),
                            left=c(colorString = "#4c2dc6")))
                }//ende style
                isDefaultButton = true
                useMaxHeight = true
                action {
                    replaceWith(LoginView())
                }//ende action
            } //ende btn Login
        } //ende vbox
    }//ende root
}
