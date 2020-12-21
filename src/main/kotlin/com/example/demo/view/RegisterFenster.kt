package com.example.demo.view

import com.example.demo.app.Styles
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*
import com.example.demo.view.LoginFenster

class RegisterFenster : View("Registrieren") {
    val model = ViewModel()
    val nutzernameR= model.bind{SimpleStringProperty()}
    val vornameR= model.bind{SimpleStringProperty()}
    val nachnameR= model.bind{SimpleStringProperty()}
    val emailR= model.bind{SimpleStringProperty()}
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

            vbox(20) {
                vbox(20) {
                    hbox() {
                        button("< ") {
                            font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 30.0)
                            style {
                                backgroundColor = multi(c(colorString = "black"))
                                textFill = c(colorString = "#777678")
                            }
                            action {
                                replaceWith(LoginFenster::class)
                            } //ende action
                        } //ende button zurück

                        label("Registrierung") {
                            font = Font.font("Segoe UI", FontWeight.BOLD, 30.0)
                            addClass(Styles.heading)
                            style {
                                textFill = c("#4C2DC6")
                            }
                        }
                    }
                }
                fieldset(labelPosition = Orientation.VERTICAL) {
                    label("NUTZERNAME"){
                        font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 15.0)
                        addClass(Styles.heading)
                    }
                        textfield(nutzernameR).required()
                        addClass(Styles.heading)

                    label("VORNAME"){
                        font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 15.0)
                        addClass(Styles.heading)
                    }
                        textfield(vornameR).required()
                        addClass(Styles.heading)

                    label("NACHNAME"){
                        font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 15.0)
                        addClass(Styles.heading)
                    }
                        textfield(nachnameR).required()
                        addClass(Styles.heading)

                    label("EMAIL"){
                        font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 15.0)
                        addClass(Styles.heading)
                    }
                        textfield(emailR).required()
                        addClass(Styles.heading)

                    label("PASSWORT"){
                        font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 15.0)
                        addClass(Styles.heading)
                    }
                        passwordfield(passwortR).required()
                        addClass(Styles.heading)

                    label()

                    vbox(0, Pos.TOP_LEFT) {
                        alignment = Pos.CENTER
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
                                    registration.anmelden(nutzernameR.value, vornameR.value, nachnameR.value, emailR.value, passwortR.value)
                                    if(registration.funktioniert==true){
                                        replaceWith(LoginFenster::class, sizeToScene = false, centerOnScreen = true)
                                        onDock()
                                        //LoginFenster().onDock()
                                    }
                                    else{
                                        registration.funktioniert = true
                                    }
                                } //ende action
                            }//ende button Registrieren
                        } //ende vbox button
                    }
                } //ende vbox
            } //ende hbox
        } //ende form
    }
    override fun onDock() {
        nutzernameR.value=""
        vornameR.value=""
        nachnameR.value=""
        emailR.value=""
        passwortR.value=""
        model.clearDecorators()
    }
}
