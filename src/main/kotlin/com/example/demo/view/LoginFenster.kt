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

class LoginFenster : View("Login") {

    val model = ViewModel()
    val nutzername = model.bind { SimpleStringProperty() }
    val passwort = model.bind { SimpleStringProperty() }
    
    override val root = form {

        style {
            fontSize = 15.px
            backgroundColor = multi(c(colorString = "black"))
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
            // hoffentlich funktioniert des jetzt
                vbox(spacing = 20, Pos.CENTER) {
                    label("EPO") {
                        font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 40.0)
                        addClass(Styles.heading)
                    }
                } //ende vbox Titel

                vbox(0, Pos.CENTER) {
                    fieldset(labelPosition = Orientation.VERTICAL) {
                        style {
                            textFill = c(colorString = "#FFFFFF")
                        }
                        fieldset("NUTZERNAME") {
                            textfield(nutzername).required()
                        }
                        fieldset("PASSWORT") {
                            passwordfield(passwort).required()
                            style {
                                textFill = c(colorString = "#FFFFFF")
                            }
                        }
                    }
                    button("            Anmelden            ") {
                        enableWhen(model.valid)
                        addClass(Styles.allbuttons)
                        isDefaultButton = true
                        useMaxHeight = true

                        action {
                            login.ueberpruefen(nutzername.value, passwort.value)
                        }
                    }
                } //ende vbox
                vbox(10, Pos.CENTER) {
                    button("Noch nicht registriert?") {
                        //addClass(Styles.button)
                        style {
                            backgroundColor = multi(c(colorString = "black"))
                            textFill = c(colorString = "#FFFFFF")
                        }
                        action {
                            RegisterFenster().openWindow()
                        } //ende action
                    } //ende button noch nicht registriert
                } //ende vbox noch nicht registriert
            } //ende vbox gesamt
        } //ende hbox gesamt
    }

    override fun onDock() {
        nutzername.value = "jakob"
        passwort.value = "1234"
        model.clearDecorators()
    }
}
