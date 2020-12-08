package com.example.demo.view

import tornadofx.*

class EintraegeBeschreibung : View("Beschreibung") {

    var beschreibung = eintraegeBeschreibungController.beschreibung

    override val root = form {
        style{
            padding = box(10.px)
            fontSize = 15.px
            backgroundColor=multi(c(colorString="black"))
            textFill= javafx.scene.paint.Color.WHITE
        }

        label("Beschreibung der Aufgabe:")
        {
            style{
                fontSize = 20.px
                textFill= javafx.scene.paint.Color.WHITE
            }
        }

        label("$beschreibung")
        {
            style{
                textFill= javafx.scene.paint.Color.WHITE
            }
        }
    }
}
