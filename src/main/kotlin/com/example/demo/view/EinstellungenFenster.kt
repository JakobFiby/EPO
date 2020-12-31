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

    var nutzername=einstellungenController.nn
    var vorname=einstellungenController.vn
    var nachname=einstellungenController.nachn
    var email=einstellungenController.email
    var passwort=einstellungenController.pw

    override val root = form {
        style {
            fontSize = 15.px
            backgroundColor = multi(c(colorString = "black"))
            textFill = c(colorString = "#FFFFFF")
        }

        //println(nutzername+vorname+nachname+email)

        hbox {
            paddingTop = 25
            paddingBottom = 25
            paddingRight = 50
            paddingLeft = 50
            alignment=Pos.TOP_LEFT

            vbox(spacing = 10){
            hbox{
            button("< ") {
                font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 15.0)
                style {
                    backgroundColor = multi(c(colorString = "black"))
                    textFill = c(colorString = "#777678")
                }
                action {
                    replaceWith(UeberblickFenster::class)
                } //ende action
            } //ende button zurück
                label("Einstellungen") {
                    font = Font.font("Segoe UI", FontWeight.BOLD, 25.0)
                    textFill = c("#4C2DC6")
                }
            }
        }
        }
            vbox() {
                vbox(10) {
                    //Profilbild

                        label("Profil") {
                            font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 20.0)
                            addClass(Styles.heading)
                            style{
                                textFill = c("#4C2DC6")
                            }
                        }

                        hbox {
                            style {
                                backgroundColor = multi(c("#111111"))
                            }//ende style
                            vbox(spacing = 0) {
                                label("NUTZERNAME:") {
                                    style {
                                        backgroundColor = multi(c("#111111"))
                                    }
                                    font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                                    addClass(Styles.heading)
                                }
                                label("VORNAME:") {
                                    style {
                                        backgroundColor = multi(c("#111111"))
                                    }
                                    font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                                    addClass(Styles.heading)
                                }
                                label("NACHNAME:") {
                                    style {
                                        backgroundColor = multi(c("#111111"))
                                    }
                                    font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                                    addClass(Styles.heading)
                                }
                                label("EMAIL:") {
                                    style {
                                        backgroundColor = multi(c("#111111"))
                                    }
                                    font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                                    addClass(Styles.heading)
                                }
                            } // ende vbox Überschriften
                            vbox(spacing = 13) {
                                button(nutzername) {
                                    font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                                    addClass(Styles.heading)
                                    //paddingBottom = 25
                                    style {
                                        backgroundColor = multi(c("#111111"))
                                        textFill = c(colorString = "#FFFFFF")
                                    }
                                    action {
                                        einstellungenController.profil("Nutzername", nutzername, false)
                                        replaceWith(ProfilFenster())
                                    }
                                }
                                button(vorname) {
                                    font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                                    addClass(Styles.heading)
                                    style {
                                        backgroundColor = multi(c("#111111"))
                                        textFill = c(colorString = "#FFFFFF")
                                    }
                                    action {
                                        einstellungenController.profil("Vorname", vorname, false)
                                        replaceWith(ProfilFenster())
                                    }
                                }
                                button(nachname) {
                                    font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                                    addClass(Styles.heading)
                                    style {
                                        backgroundColor = multi(c("#111111"))
                                        textFill = c(colorString = "#FFFFFF")
                                    }
                                    action {
                                        einstellungenController.profil("Nachname", nachname, false)
                                        replaceWith(ProfilFenster())
                                    }
                                }
                                button(email) {
                                    font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                                    addClass(Styles.heading)
                                    style {
                                        backgroundColor = multi(c("#111111"))
                                        textFill = c(colorString = "#FFFFFF")
                                    }
                                    action {
                                        einstellungenController.profil("Email", email, false)
                                        replaceWith(ProfilFenster())
                                    }
                                }
                            } // ende vbox eingelesenes Profil
                        }
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
                        vbox(){
                            style{
                                backgroundColor = multi(c("#111111"))
                            }//ende style
                        button("Mitteilungen") {
                            style {
                                backgroundColor = multi(c("#111111"))
                                textFill = c(colorString = "#FFFFFF")
                            }
                            action{

                            }

                        }

                        button("Nachtmodus") {
                            style {
                                backgroundColor = multi(c("#111111"))
                                textFill = c(colorString = "#FFFFFF")
                            }
                            action{

                            }

                        }

                            button("Abmelden") {
                                style {
                                    backgroundColor = multi(c("#111111"))
                                    textFill = c(colorString = "#FFFFFF")
                                }
                                action{
                                    einstellungenController.abmelden()
                                    close()
                                }

                        }
                }
            }
                        }
                }
            }


    }


