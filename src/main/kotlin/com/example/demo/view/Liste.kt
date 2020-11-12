package com.example.demo.view

import javafx.scene.paint.Color
import tornadofx.*

class Liste : View("Liste") {
    override val root = borderpane {
        style{
            padding = box(10.px)
            fontSize = 15.px
            backgroundColor=multi(c(colorString="black"))
            textFill= Color.LIGHTGREY
        }
    }
}