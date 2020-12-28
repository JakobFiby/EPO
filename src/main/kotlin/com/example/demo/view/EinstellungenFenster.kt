package com.example.demo.view

import com.example.demo.app.Styles
import com.sun.org.apache.bcel.internal.Repository.addClass
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.layout.*
import javafx.scene.layout.Border
import javafx.scene.paint.Color
import javax.swing.border.*
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import javafx.stage.Stage
import tornadofx.*
import com.example.demo.view.UeberblickFenster
import com.example.demo.view.LoginFenster
import com.example.demo.view.einstellungenController

class EinstellungenFenster : View("Einstellungen") {

    override val root = form {
        style {
            fontSize = 15.px
            backgroundColor = multi(c(colorString = "black"))
            textFill = c(colorString = "#FFFFFF")
        }

        var nutzername=einstellungenController.nn
        var vorname=einstellungenController.vn
        var nachname=einstellungenController.nachn
        var email=einstellungenController.email
        var passwort=einstellungenController.pw
        //println(nutzername+vorname+nachname+email)

        hbox {
            paddingTop = 25
            paddingBottom = 25
            paddingRight = 50
            paddingLeft = 50

            vbox(spacing = 20) {
                vbox(0) {
                    //Profilbild

                        label("Profil") {
                            font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 20.0)
                            addClass(Styles.heading)
                            style{
                                textFill = c("#4C2DC6")
                            }
                        }

                        hbox{
                        vbox(spacing=20){
                            label("NUTZERNAME:") {
                                font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                                addClass(Styles.heading)
                            }
                            label("VORNAME:") {
                                font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                                addClass(Styles.heading)
                            }
                            label("NACHNAME:") {
                                font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                                addClass(Styles.heading)
                            }
                            label("EMAIL:") {
                                font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                                addClass(Styles.heading)
                            }
                        } // ende vbox Überschriften
                        vbox(spacing=20){
                            label(nutzername) {
                                font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                                addClass(Styles.heading)
                            }
                            label(vorname) {
                                font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                                addClass(Styles.heading)
                            }
                            label(nachname) {
                                font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                                addClass(Styles.heading)
                            }
                            label(email) {
                                font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                                addClass(Styles.heading)
                            }
                        } // ende vbox eingelesenes Profil
                        }


                        vbox(10) {
                            fieldset(labelPosition = Orientation.VERTICAL) {
                                label("Optionen") {
                                    font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 20.0)
                                    addClass(Styles.heading)
                                    style{
                                        textFill = c("#4C2DC6")
                                    }
                                }

                        button("Mitteilungen") {
                            style {
                                backgroundColor = multi(c(colorString = "black"))
                                textFill = c(colorString = "#FFFFFF")
                            }
                            action{

                            }

                        }

                        button("Nachtmodus") {
                            style {
                                backgroundColor = multi(c(colorString = "black"))
                                textFill = c(colorString = "#FFFFFF")
                            }
                            action{

                            }

                        }

                            button("Abmelden") {
                                style {
                                    backgroundColor = multi(c(colorString = "black"))
                                    textFill = c(colorString = "#FFFFFF")
                                }
                                action{
                                    close()
                                }

                        }
                }
            }

                }
            }

        }
    }
    override fun onDock() {

    }
}