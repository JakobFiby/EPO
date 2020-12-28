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
        var profil=""
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
                        vbox(spacing=32){
                            button(nutzername) {
                                font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                                addClass(Styles.heading)
                                profil="Nutzername"
                                //paddingBottom = 25
                                style {
                                    backgroundColor = multi(c(colorString = "black"))
                                    textFill = c(colorString = "#FFFFFF")
                                }
                                action {
                                    einstellungenController.profil(profil)
                                    replaceWith(ProfilFenster())
                                }
                            }
                            button(vorname) {
                                font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                                addClass(Styles.heading)
                                profil="Vorname"
                                style {
                                    backgroundColor = multi(c(colorString = "black"))
                                    textFill = c(colorString = "#FFFFFF")
                                }
                                action {
                                    einstellungenController.profil(profil)
                                    replaceWith(ProfilFenster())
                                }
                            }
                            button(nachname) {
                                font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                                addClass(Styles.heading)
                                profil="Nachname"
                                style {
                                    backgroundColor = multi(c(colorString = "black"))
                                    textFill = c(colorString = "#FFFFFF")
                                }
                                action {
                                    einstellungenController.profil(profil)
                                    replaceWith(ProfilFenster())
                                }
                            }
                            button(email) {
                                font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                                addClass(Styles.heading)
                                profil="Email"
                                style {
                                    backgroundColor = multi(c(colorString = "black"))
                                    textFill = c(colorString = "#FFFFFF")
                                }
                                action {
                                    einstellungenController.profil(profil)
                                    replaceWith(ProfilFenster())
                                }
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
    override fun onDock() {

    }
}