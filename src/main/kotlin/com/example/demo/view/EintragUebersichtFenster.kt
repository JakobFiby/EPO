package com.example.demo.view

import javafx.scene.paint.Color
import tornadofx.*

class EintragUebersichtFenster : View("Einträge Übersicht") {

    var einträge = eintraegeQuery.eintraege

    override val root = form {
        style{
            padding = box(10.px)
            fontSize = 15.px
            backgroundColor=multi(c(colorString="black"))
            textFill= javafx.scene.paint.Color.WHITE
        }

        for (e in einträge) {
            button("* $e")
            {
                style{
                    backgroundColor = multi(c(colorString = "black"))
                    textFill= javafx.scene.paint.Color.WHITE
                }
                action {
                    println("ok")
                }
            }
            label("")
        }
    }
}
