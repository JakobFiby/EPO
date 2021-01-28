package com.example.demo.app

import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*


class Styles2 : Stylesheet() {
    companion object {
        val heading by cssclass()
        val label by cssclass()
        val allbuttons by cssclass()
    }

    init{
        label and heading {
            padding = box(10.px)
            backgroundColor=multi(c(colorString="white"))
            textFill= c(colorString="black")
        }
    }
    init{
        allbuttons{
            backgroundColor = multi(c(colorString = "lightgrey"))
            textFill= Color.WHITE
        }
    }
}

