package com.example.demo.view

import com.example.demo.app.Styles
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*

class RegisterFenster : View("Registrieren") {
    val model = ViewModel()
    val nutzernameR= model.bind{SimpleStringProperty()}
    val vorname= model.bind{SimpleStringProperty()}
    val nachname= model.bind{SimpleStringProperty()}
    val email= model.bind{SimpleStringProperty()}
    val passwortR= model.bind{SimpleStringProperty()}


    override val root = form {
        style {
            padding = box(10.px)
            fontSize = 15.px
            backgroundColor = multi(c(colorString = "black"))
            textFill = c(colorString = "#FFFFFF")
        }
        hbox {
            paddingTop = 10
            paddingBottom = 10
            paddingRight = 20
            paddingLeft = 20
            alignment = Pos.CENTER

            vbox(spacing = 20) {
                label("Registrieren") {
                    font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 15.0)
                    style {
                        textFill = c(colorString = "#FFFFFF")
                    }
                }
                fieldset(labelPosition = Orientation.VERTICAL) {
                    fieldset("Nutzername") {
                        textfield(nutzernameR).required()
                        addClass(Styles.heading)
                    }
                    fieldset("Vorname") {
                        textfield(vorname).required()
                        addClass(Styles.heading)
                    }
                    fieldset("Nachname") {
                        textfield(nachname).required()
                        addClass(Styles.heading)
                    }
                    fieldset("Email") {
                        textfield(email).required()
                        addClass(Styles.heading)
                    }
                    fieldset("Passwort") {
                        passwordfield(passwortR).required()
                        addClass(Styles.heading)
                    }

                    vbox(0, Pos.TOP_LEFT) {
                        button("Registrieren") {
                            enableWhen(model.valid)
                            style {
                                backgroundColor = multi(c(colorString = "black"))
                                textFill = c(colorString = "#4c2dc6")
                                borderColor = multi(box(
                                        top = c(colorString = "#4c2dc6"),
                                        bottom = c(colorString = "#4c2dc6"),
                                        right = c(colorString = "#4c2dc6"),
                                        left = c(colorString = "#4c2dc6")
                                ))
                                isDefaultButton = true
                                useMaxHeight = true
                                useMaxWidth = true
                                action {
                                    runAsyncWithProgress {
                                        register.anmelden(nutzernameR.value, vorname.value, nachname.value, email.value, passwortR.value)
                                        replaceWith(LoginFenster::class, sizeToScene = false, centerOnScreen = true)
                                    }
                                } //ende action
                            }//ende button Registrieren
                        } //ende vbox button
                    } //ende fieldset
                } //ende vbox
            } //ende hbox
        } //ende form
    }
    override fun onDock() {
        nutzernameR.value=""
        vorname.value=""
        nachname.value=""
        email.value=""
        passwortR.value=""
        model.clearDecorators()
    }
}
