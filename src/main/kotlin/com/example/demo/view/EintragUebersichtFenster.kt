package com.example.demo.view

import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*
import java.sql.Date

class EintragUebersichtFenster : View("Einträge Übersicht") {

    var einträge = eintraegeQuery.eintraege
    var liste:String = eintraegeQuery.liste
    public var bg:String = ""

    override val root = form {
        style{
            padding = box(10.px)
            fontSize = 15.px
            backgroundColor=multi(c(colorString="black"))
            textFill= javafx.scene.paint.Color.WHITE
        }

        label("Einträge der Liste '$liste':") {
            font = Font.font("Segoe UI", FontWeight.BOLD, 25.0)
            textFill= c("#4C2DC6")
        }

        label()

        for (e in einträge) {
            hbox {
                checkbox() {}
                button("$e")
                {
                    style {
                        backgroundColor = multi(c(colorString = "black"))
                        textFill = javafx.scene.paint.Color.WHITE
                    }
                    action {
                        eintraegeBeschreibungQuery.connection(e)
                    }
                }
            }
            label()
        }

        button("+")
        {
            font = Font.font("Segoe UI", FontWeight.BOLD, 14.0)
            shape = Circle(15.0)
            setMaxSize(15.0*2, 15.0*2)
            setMinSize(15.0*2, 15.0*2)
            style{
                backgroundColor = multi(c("#05B90A"))
                textFill = javafx.scene.paint.Color.BLACK
            }
            action{
                EintragErstellenFenster().openWindow()
            }
        }
    }
}
