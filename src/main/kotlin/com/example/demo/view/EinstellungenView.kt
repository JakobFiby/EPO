package com.example.demo.view

import com.example.demo.app.Styles
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*

class EinstellungenView : View("") {

    var nutzername=EinstellungenController.nn
    var vorname=EinstellungenController.vn
    var nachname=EinstellungenController.nachn
    var email=EinstellungenController.email
    var passwort=EinstellungenController.pw
    var farbmodus=EinstellungenController.farbmodus


    override val root = form {
        style {
            fontSize = 15.px
            backgroundColor = multi(c(colorString = "black"))
            textFill = c(colorString = "#FFFFFF")
        }//ende style
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
                }//ende style
                action {
                    replaceWith(UebersichtView())
                } //ende action
            } //ende button zurück
                label("Einstellungen") {
                    font = Font.font("Segoe UI", FontWeight.BOLD, 25.0)
                    textFill = c("#4C2DC6")
                }//ende label Einstellungen
            }//ende hbox Titel
        }//ende vbox Titel
        }//ende hbox
            vbox {
                vbox(10) {
                    //Profilbild

                        label("Profil") {
                            font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 20.0)
                            addClass(Styles.heading)
                            style{
                                textFill = c("#4C2DC6")
                            }//ende style
                        }//ende label profil

                        hbox {
                            style {
                                backgroundColor = multi(c("#111111"))
                            }//ende style
                            vbox(spacing = 0) {
                                label("NUTZERNAME:") {
                                    style {
                                        backgroundColor = multi(c("#111111"))
                                    }//ende style
                                    font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                                    addClass(Styles.heading)
                                }//ende label nutzername
                                label("VORNAME:") {
                                    style {
                                        backgroundColor = multi(c("#111111"))
                                    }//ende style
                                    font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                                    addClass(Styles.heading)
                                }//ende label vorname
                                label("NACHNAME:") {
                                    style {
                                        backgroundColor = multi(c("#111111"))
                                    }//ende style
                                    font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                                    addClass(Styles.heading)
                                }//ende label nachname
                                label("EMAIL:") {
                                    style {
                                        backgroundColor = multi(c("#111111"))
                                    }//ende style
                                    font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                                    addClass(Styles.heading)
                                }//ende label email
                            } // ende vbox Überschriften


                            vbox(spacing = 13) {
                                button(nutzername) {
                                    font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                                    addClass(Styles.heading)
                                    style {
                                        backgroundColor = multi(c("#111111"))
                                        textFill = c(colorString = "#FFFFFF")
                                    }//ende style
                                    action {
                                        EinstellungenController.profil("Nutzername", nutzername, false)
                                        replaceWith(ProfilView())
                                    }//ende action
                                }//ende button nutzername
                                button(vorname) {
                                    font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                                    addClass(Styles.heading)
                                    style {
                                        backgroundColor = multi(c("#111111"))
                                        textFill = c(colorString = "#FFFFFF")
                                    }//ende style
                                    action {
                                        EinstellungenController.profil("Vorname", vorname, false)
                                        replaceWith(ProfilView())
                                    }//ende action
                                }//ende button vorname
                                button(nachname) {
                                    font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                                    addClass(Styles.heading)
                                    style {
                                        backgroundColor = multi(c("#111111"))
                                        textFill = c(colorString = "#FFFFFF")
                                    }//ende style
                                    action {
                                        EinstellungenController.profil("Nachname", nachname, false)
                                        replaceWith(ProfilView())
                                    }//ende action
                                }//ende button nachname
                                button(email) {
                                    font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                                    addClass(Styles.heading)
                                    style {
                                        backgroundColor = multi(c("#111111"))
                                        textFill = c(colorString = "#FFFFFF")
                                    }//ende style
                                    action {
                                        EinstellungenController.profil("Email", email, false)
                                        replaceWith(ProfilView())
                                    }//ende action
                                }//ende button email
                            } // ende vbox eingelesenes Profil
                        }//ende hbox Profil labels und buttons
                        }//ende vbox Profil


                        vbox(10) {
                            fieldset(labelPosition = Orientation.VERTICAL) {
                                label("Optionen") {
                                    font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 20.0)
                                    addClass(Styles.heading)
                                    style{
                                        textFill = c("#4C2DC6")
                                    }//ende style
                                }//ende label Optionen
                        vbox(10){
                            style{
                                backgroundColor = multi(c("#111111"))
                            }//ende style

                            hbox(10){
                                radiobutton(farbmodus){
                                    style {
                                        backgroundColor = multi(c("#111111"))
                                        textFill = c(colorString = "#FFFFFF")
                                    }//ende style
                                    action {
                                        //println(farbmodus)
                                        EinstellungenController.farbschemaaendern(farbmodus)
                                        replaceWith(EinstellungenView())
                                    }//ende action
                                }//ende radiobutton farbmodus
                            }//ende hbox farbmodus

                            hbox(10) {
                                button("Abmelden") {
                                    style {
                                        backgroundColor = multi(c("#111111"))
                                        textFill = c("#4C2DC6")
                                    }//ende style
                                    action {
                                        EinstellungenController.abmelden()
                                        close()
                                    }//ende action
                                }//ende button Abmelden
                            }//ende hbox Abmelden
                            }//ende vbox Optionen Unterkategorien
                            }//ende fieldset Optionen
                        }//ende vbox Optionen
                }//ende vbox gesamt
            }//ende root
    }


