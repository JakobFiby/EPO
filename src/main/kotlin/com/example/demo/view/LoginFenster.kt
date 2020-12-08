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
import com.example.demo.view.loginController

class LoginFenster : View("Login") {

    val model = ViewModel()
    val nutzername = model.bind { SimpleStringProperty() }
    val passwort = model.bind { SimpleStringProperty() }
    //val loginController: loginController by inject()

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

                vbox(20, Pos.CENTER) {
                    label("EPO") {
                        font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 40.0)
                        addClass(Styles.heading)
                        style{
                            textFill = c("#4C2DC6")
                        }
                    }
                    label("Easy Project Organisation") {
                        font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 15.0)
                        style{
                            textFill= c(colorString="#FFFFFF")
                        }
                    }
                } //ende vbox Titel

                vbox(0, Pos.CENTER) {
                    //val fontIcon=FontIcon()
                    //fontIcon.iconLiteral="gmi-mail-outline"
                    fieldset(labelPosition = Orientation.VERTICAL) {
                        style {
                            textFill=Color.web("#CECED0")
                        }
                        fieldset("NUTZERNAME") {
                            textfield(nutzername).required()
                        }
                        fieldset("PASSWORT") {
                            passwordfield(passwort).required()
                        }
                    }
                    button("Anmelden") {
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
                        }
                            isDefaultButton = true
                            useMaxHeight = true
                            useMaxWidth = true

                            action {
                                loginController.login(nutzername.value, passwort.value)
                                //println("Login = "+ loginController.working+loginController.pwB+loginController.nnB)
                                if(loginController.working==true)
                                {
                                    replaceWith(UeberblickFenster::class, sizeToScene = false, centerOnScreen = true)
                                }
                            }
                    } //ende button


                    vbox(10, Pos.CENTER) {
                        button("Noch nicht registriert?") {
                            //addClass(Styles.button)
                            style {
                                backgroundColor = multi(c(colorString = "black"))
                                textFill = c(colorString = "#FFFFFF")
                            }
                            action {
                                replaceWith(RegisterFenster::class)
                            } //ende action
                        } //ende button noch nicht registriert
                    } //ende vbox noch nicht registriert
                } //ende vbox gesamt

            } //ende hbox gesamt
        }
    }
        override fun onDock() {
            nutzername.value = "jakob"
            passwort.value = "1234"
            model.clearDecorators()
        }

}
