package com.example.demo.app

import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

class Styles : Stylesheet() {
    companion object {
        val heading by cssclass()
        public val label by cssclass()
        val allbuttons by cssclass()
    }

    init{
        label and heading {
            padding = box(10.px)
            backgroundColor=multi(c(colorString="black"))
            textFill= c(colorString="#FFFFFF")
        }
    }
    init{
        allbuttons{
            backgroundColor = multi(c(colorString = "lightgrey"))
            textFill= Color.BLACK
        }
    }
}

