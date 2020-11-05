package com.example.demo.app

import javafx.scene.text.FontWeight
import tornadofx.*
import java.awt.Color
import java.awt.Paint

class Styles : Stylesheet() {
    companion object {
        val heading by cssclass()
    }

    init {
        label and heading {
            padding = box(10.px)
            fontSize = 20.px
            fontWeight = FontWeight.BOLD
        }
    }
}