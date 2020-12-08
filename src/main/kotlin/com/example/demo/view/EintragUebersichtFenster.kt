package com.example.demo.view

import javafx.scene.shape.Circle
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*

class EintragUebersichtFenster : View("Einträge Übersicht") {

    var einträge = eintraegeController.eintraege
    var liste:String = eintraegeController.liste
    public var bg:String = ""

    override val root = form {
        style{
            padding = box(10.px)
            fontSize = 15.px
            backgroundColor=multi(c(colorString="black"))
            textFill= javafx.scene.paint.Color.WHITE
            setPrefSize(360.0, 600.0)
        }

        label("Einträge der Liste '$liste':") {
            font = Font.font("Segoe UI", FontWeight.BOLD, 25.0)
            textFill= c("#4C2DC6")
        }

        label()

        vbox {
            style{
                backgroundColor = multi(c("#111111"))
            }
            for (e in einträge) {
                hbox {
                    checkbox() {}
                    button("$e")
                    {
                        style {
                            font = Font.font("Segoe UI", FontWeight.NORMAL, 13.0)
                            backgroundColor = multi(c("#111111"))
                            textFill = javafx.scene.paint.Color.WHITE
                        }
                        action {
                            eintraegeBeschreibungController.connection(e)
                        }
                    }
                }
                label()
            }
        }

            button("+")
            {
                font = Font.font("Segoe UI", FontWeight.BOLD, 14.0)
                shape = Circle(15.0)
                setMaxSize(15.0 * 2, 15.0 * 2)
                setMinSize(15.0 * 2, 15.0 * 2)
                style {
                    backgroundColor = multi(c("#4C2DC6"))
                    textFill = javafx.scene.paint.Color.BLACK
                }
                action {
                    EintragErstellenFenster().openWindow()
                }
            }

    }
}
