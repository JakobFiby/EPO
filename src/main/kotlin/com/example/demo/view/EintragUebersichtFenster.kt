package com.example.demo.view

import javafx.scene.shape.Circle
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*

class EintragUebersichtFenster : View("Einträge Übersicht") {

    var einträge = ArrayList<String>()
    var liste = ""

    override val root = form {

        einträge = eintraegeController.eintraege
        liste = eintraegeController.liste

        style{
            padding = box(10.px)
            fontSize = 15.px
            backgroundColor=multi(c(colorString="black"))
            textFill= javafx.scene.paint.Color.WHITE
            setPrefSize(360.0, 600.0)
        }//ende style
    }//ende root

    init {
        hbox {
            button("< ") {
                font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 20.0)
                style {
                    backgroundColor = multi(c(colorString = "black"))
                    textFill = c(colorString = "#777678")
                }//ende style
                action {
                    eintraegeController.wichtigkeit.clear()
                    eintraegeController.erledigt.clear()
                    replaceWith(UeberblickFenster())
                } //ende action
            } //ende button zurück

            label("$liste:") {
                font = Font.font("Segoe UI", FontWeight.BOLD, 30.0)
                textFill = c("#4C2DC6")
            }//ende label listename
        }//ende hbox

        label()

        vbox {
            style{
                backgroundColor = multi(c("#111111"))
            }//ende style

            var zz = 0
            val wichtigkeit = eintraegeController.wichtigkeit
            val erledigt = eintraegeController.erledigt

            for (e in einträge) {
                hbox {
                    button("o $e")
                    {
                        style {
                            font = Font.font("Segoe UI", FontWeight.NORMAL, 13.0)
                            backgroundColor = multi(c("#111111"))
                            textFill = javafx.scene.paint.Color.WHITE
                        }//style
                        action {
                            eintragFertigController.connection(e)

                            if(eintragFertigController.fertig){
                                style{
                                    font = Font.font("Segoe UI", FontWeight.NORMAL, 13.0)
                                    backgroundColor = multi(c("#111111"))
                                    textFill = c("#777678")
                                }//ende style
                            }//ende if
                            else{
                                if(eintragFertigController.wichtigkeit.equals("low")){
                                    style{
                                        font = Font.font("Segoe UI", FontWeight.NORMAL, 13.0)
                                        backgroundColor = multi(c("#111111"))
                                        textFill = c("#ffd700")
                                    }//ende style
                                }//ende if low
                                else if(eintragFertigController.wichtigkeit.equals("medium")){
                                    style{
                                        font = Font.font("Segoe UI", FontWeight.NORMAL, 13.0)
                                        backgroundColor = multi(c("#111111"))
                                        textFill = c("#cd950c")
                                    }//ende style
                                }//ende if medium
                                else if(eintragFertigController.wichtigkeit.equals("high")){
                                    style{
                                        font = Font.font("Segoe UI", FontWeight.NORMAL, 13.0)
                                        backgroundColor = multi(c("#111111"))
                                        textFill = c("cd3700")
                                    }//ende style
                                }//ende if high
                            }//ende else
                        }//ende action

                        if(wichtigkeit[zz].equals("low")){
                            style{
                                font = Font.font("Segoe UI", FontWeight.NORMAL, 13.0)
                                backgroundColor = multi(c("#111111"))
                                textFill = c("#ffd700")
                            }//ende style
                        }//ende if low
                        else if(wichtigkeit[zz].equals("medium")){
                            style{
                                font = Font.font("Segoe UI", FontWeight.NORMAL, 13.0)
                                backgroundColor = multi(c("#111111"))
                                textFill = c("#cd950c")
                            }//ende style
                        }//ende if medium
                        else if(wichtigkeit[zz].equals("high")){
                            style{
                                font = Font.font("Segoe UI", FontWeight.NORMAL, 13.0)
                                backgroundColor = multi(c("#111111"))
                                textFill = c("cd3700")
                            }//ende style
                        }//ende if high

                        if(erledigt[zz].equals("1")){
                            style{
                                font = Font.font("Segoe UI", FontWeight.NORMAL, 13.0)
                                backgroundColor = multi(c("#111111"))
                                textFill = c("#777678")
                            }//ende style
                        }//ende if erledigt

                        zz++
                    }//ende button Eintrag

                    button("...") {
                        style {
                            font = Font.font("Segoe UI", FontWeight.NORMAL, 15.0)
                            backgroundColor = multi(c("#111111"))
                            textFill = c(colorString = "#4c2dc6")
                        }//ende style
                        action {
                            eintraegeBeschreibungController.beschreibung(e)
                            replaceWith(EintraegeBeschreibung())
                        }//ende action
                    }//ende button Bearbeiten
                }//ende hbox
                label()
            }//ende for
        }//ende vbox

        button("+") {
            font = Font.font("Segoe UI", FontWeight.BOLD, 14.0)
            shape = Circle(15.0)
            setMaxSize(15.0 * 2, 15.0 * 2)
            setMinSize(15.0 * 2, 15.0 * 2)
            style {
                backgroundColor = multi(c("#4C2DC6"))
                textFill = javafx.scene.paint.Color.BLACK
            }//ende style
            action {
                replaceWith(EintragErstellenFenster())
            }//ende action
        }//ende button +
    }//ende init
}//ende class

