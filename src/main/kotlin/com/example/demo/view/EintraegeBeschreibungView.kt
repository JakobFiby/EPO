package com.example.demo.view

import javafx.geometry.Pos
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*

class EintraegeBeschreibungView : View("") {

    var beschreibung = EintraegeBeschreibungController.beschreibung

    override val root = form {
        style{
            padding = box(10.px)
            fontSize = 15.px
            backgroundColor=multi(c(colorString="black"))
            textFill= javafx.scene.paint.Color.WHITE
            alignment = Pos.CENTER
        }//ende style

        vbox(0, Pos.CENTER) {
            hbox {
                button("< ") {
                    font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 20.0)
                    style {
                        backgroundColor = multi(c(colorString = "black"))
                        textFill = c(colorString = "#777678")
                    }//ende style
                    action {
                        replaceWith(EintraegeUebersichtView())
                    } //ende action
                } //ende button zurück
                label("Beschreibung:")
                {
                    font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 30.0)
                    textFill = c("#4C2DC6")
                    alignment = Pos.CENTER
                }//ende label beschreibung
            }//ende hbox Titel

            label()

            label("$beschreibung") {
                style {
                    textFill = javafx.scene.paint.Color.WHITE
                    wrapText = true
                    alignment = Pos.BOTTOM_RIGHT
                }//ende style
            }//ende label beschreibung

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
                }//ende style
                action {
                    EintraegeBeschreibungController.eintragLoeschen()
                    replaceWith(EintraegeUebersichtView())
                }//ende action
            }//ende button loeschen
        }//ende vbox gesamt
    }//ende root
}
