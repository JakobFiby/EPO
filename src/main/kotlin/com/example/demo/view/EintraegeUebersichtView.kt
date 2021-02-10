package com.example.demo.view

import javafx.scene.shape.Circle
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*

class EintraegeUebersichtView : View("") {

    var einträge = ArrayList<String>()
    var liste = ""

    override val root = form {

        einträge = EintraegeController.eintraege
        liste = EintraegeController.liste

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
                    EintraegeController.wichtigkeit.clear()
                    EintraegeController.erledigt.clear()
                    replaceWith(UebersichtView())
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
            val wichtigkeit = EintraegeController.wichtigkeit
            val erledigt = EintraegeController.erledigt

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
                            EintragFertigController.connection(e)

                            if(EintragFertigController.fertig){
                                style{
                                    font = Font.font("Segoe UI", FontWeight.NORMAL, 13.0)
                                    backgroundColor = multi(c("#111111"))
                                    textFill = c("#777678")
                                }//ende style
                            }//ende if
                            else{
                                if(EintragFertigController.wichtigkeit.equals("low")){
                                    style{
                                        font = Font.font("Segoe UI", FontWeight.NORMAL, 13.0)
                                        backgroundColor = multi(c("#111111"))
                                        textFill = c("#ffd700")
                                    }//ende style
                                }//ende if low
                                else if(EintragFertigController.wichtigkeit.equals("medium")){
                                    style{
                                        font = Font.font("Segoe UI", FontWeight.NORMAL, 13.0)
                                        backgroundColor = multi(c("#111111"))
                                        textFill = c("#cd950c")
                                    }//ende style
                                }//ende if medium
                                else if(EintragFertigController.wichtigkeit.equals("high")){
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
                            EintraegeBeschreibungController.beschreibung(e)
                            replaceWith(EintraegeBeschreibungView())
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
                EintraegeController.wichtigkeit.clear()
                EintraegeController.erledigt.clear()
                replaceWith(EintragErstellenView())
            }//ende action
        }//ende button +
    }//ende init
}//ende class

