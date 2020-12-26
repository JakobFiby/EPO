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

    val model = ViewModel()
    val nutzername = model.bind { SimpleStringProperty() }
    val vorname = model.bind { SimpleStringProperty() }
    val nachname = model.bind { SimpleStringProperty() }
    val email = model.bind { SimpleStringProperty() }
    val passwort = model.bind { SimpleStringProperty() }

    override val root = form {

        style {
            fontSize = 15.px
            backgroundColor = multi(c(colorString = "black"))
            textFill = c(colorString = "#FFFFFF")
        }

        hbox {

            addClass(Styles.heading)
            paddingTop = 25
            paddingBottom = 25
            paddingRight = 50
            paddingLeft = 50
            alignment = Pos.CENTER
            spacing = 30.0

            vbox(spacing = 20) {
                vbox(10, Pos.CENTER) {
                    //Profilbild

                    fieldset(labelPosition = Orientation.VERTICAL) {
                        label("Profil") {
                            font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 20.0)
                            addClass(Styles.heading)
                            style{
                                textFill = c("#4C2DC6")
                            }
                        }
                        label("NUTZERNAME") {
                            font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                            addClass(Styles.heading)
                        }
                        label() {
                            font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                            addClass(Styles.heading)
                        }

                        label("VORNAME") {
                            font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                            addClass(Styles.heading)
                        }
                        textfield(vorname).required()

                        label("NACHNAME") {
                            font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                            addClass(Styles.heading)
                        }
                        textfield(nachname).required()

                        label("EMAIL") {
                            font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 15.0)
                            addClass(Styles.heading)
                        }
                        textfield(email).required()


                        vbox(10, Pos.CENTER) {
                            fieldset(labelPosition = Orientation.VERTICAL) {
                                label("Optionen") {
                                    font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 20.0)
                                    addClass(Styles.heading)
                                    style{
                                        textFill = c("#4C2DC6")
                                    }
                                }
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
        nutzername.value = ""
        passwort.value = "1234"
        model.clearDecorators()
    }
}