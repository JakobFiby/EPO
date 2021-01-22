package com.example.demo.view

import com.example.demo.app.Styles
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*

class ProfilView : View("") {

    override val root = form {
        style {
            fontSize = 15.px
            backgroundColor = multi(c(colorString = "black"))
            textFill = c(colorString = "#FFFFFF")
        }//ende style

        val model = ViewModel()
        var aenderung = model.bind { SimpleStringProperty() }

        hbox {
            paddingTop = 25
            paddingBottom = 25
            paddingRight = 50
            paddingLeft = 50
            alignment = Pos.TOP_LEFT

            aenderung.value =EinstellungenController.andernaufruf

            vbox(spacing = 10) {
                hbox {
                    button("< ") {
                        font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 13.0)
                        style {
                            backgroundColor = multi(c(colorString = "black"))
                            textFill = c(colorString = "#777678")
                        }//ende style
                        action {
                            replaceWith(EinstellungenView())
                        } //ende action
                    } //ende button zurück
                    label("Profil bearbeiten") {
                        font = Font.font("Segoe UI", FontWeight.BOLD, 23.0)
                        textFill = c("#4C2DC6")
                    }//ende label Profil bearbeiten
                }//ende hbox
            }//ende vbox
        }
        vbox {
            vbox(10) {
                label(EinstellungenController.profilopt) {
                    font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 20.0)
                    addClass(Styles.heading)
                }
                textfield(aenderung).required()
            }//ende vbox 2
        }//ende vbox 1

        label()

        hbox{
            button("Fertig") {
                font = Font.font("Segoe UI", FontWeight.LIGHT, 15.0)
                style {
                    backgroundColor = multi(c("#4C2DC6"))
                    textFill = javafx.scene.paint.Color.BLACK
                }//ende style
                action {
                    if(aenderung.value != EinstellungenController.andernaufruf && aenderung.value != "Nutzername bereits vorhanden!"){
                        EinstellungenController.profil(EinstellungenController.profilopt, aenderung.value, true)
                    }//ende if

                    if(EinstellungenController.nnvorhanden){
                        EinstellungenController.profil("", "", false)
                        aenderung.value = "Nutzername bereits vorhanden!"
                    }
                    else {
                        EinstellungenController.profil("", "", false)
                        replaceWith(EinstellungenView())
                    }
                }//ende action
            }//ende button Fertig
        }//ende hbox
    }//ende root
}