package com.example.demo.view

import javafx.geometry.Pos
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*

class EintraegeBeschreibung : View("Beschreibung") {

    var beschreibung = eintraegeBeschreibungController.beschreibung

    override val root = form {
        style{
            padding = box(10.px)
            fontSize = 15.px
            backgroundColor=multi(c(colorString="black"))
            textFill= javafx.scene.paint.Color.WHITE
            alignment = Pos.CENTER
        }
        vbox(0, Pos.CENTER) {
            hbox {
                button("< ") {
                    font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 20.0)
                    style {
                        backgroundColor = multi(c(colorString = "black"))
                        textFill = c(colorString = "#777678")
                    }
                    action {
                        replaceWith(EintragUebersichtFenster())
                    } //ende action
                } //ende button zurück
                label("Beschreibung:")
                {
                    font = Font.font("Segoe UI", FontWeight.BOLD, 30.0)
                    textFill = c("#4C2DC6")
                    alignment = Pos.CENTER
                }
            }

            label()

            label("$beschreibung")
                {
                    style {
                        textFill = javafx.scene.paint.Color.WHITE
                    }
                }

            label()

            button("LÖSCHEN") {
                isDefaultButton = true
                setPrefSize(200.0, 10.0)
                useMaxHeight = true
                style {
                    backgroundColor = multi(c("black"))
                    textFill = c("#c63229")
                    borderColor = multi(box(
                            top = c("#c63229"),
                            bottom = c("#c63229"),
                            right = c("#c63229"),
                            left = c("#c63229")))
                }
                action {
                    eintraegeBeschreibungController.eintragLoeschen()
                    replaceWith(EintragUebersichtFenster())
                }
            }
        }
    }
}
