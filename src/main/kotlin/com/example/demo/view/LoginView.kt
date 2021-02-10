package com.example.demo.view

import com.example.demo.app.Styles
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*

class LoginView : View("") {

    val model = ViewModel()
    val nutzername = model.bind { SimpleStringProperty() }
    val passwort = model.bind { SimpleStringProperty() }

    override val root = form {

        style {
            fontSize = 15.px
            backgroundColor = multi(c(colorString = "black"))
            textFill= c(colorString="#FFFFFF")
        } //ende style

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
                    setPrefSize(110.0, 90.0)
                    imageview("/logoNEU.png", lazyload = false) {
                        fitHeightProperty().bind(parent.prefHeight(300.0).toProperty())
                        fitWidthProperty().bind(parent.prefWidth(400.0).toProperty())
                    } // ende image
                } //ende vbox Titel

                label("Easy Project Organisation") {
                    font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 15.0)
                    addClass(Styles.heading)
                }//ende label Easy Project Organisation

                vbox(0, Pos.CENTER) {
                    //val fontIcon=FontIcon()
                    //fontIcon.iconLiteral="gmi-mail-outline"
                    fieldset(labelPosition = Orientation.VERTICAL) {

                        label("NUTZERNAME"){
                            font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 15.0)
                            addClass(Styles.heading)
                        }//ende label nn
                        textfield(nutzername).required()

                        label("PASSWORT"){
                            font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 15.0)
                            addClass(Styles.heading)
                        }//ende label pw
                            passwordfield(passwort).required()

                    }//ende fieldset
                    button("Anmelden") {
                        enableWhen(model.valid)
                        style {
                            backgroundColor = multi(c(colorString = "black"))
                            textFill = c(colorString = "#4c2dc6")
                            borderColor = multi(box(
                                    top = c(colorString = "#4c2dc6"),
                                    bottom = c(colorString = "#4c2dc6"),
                                    right = c(colorString = "#4c2dc6"),
                                    left = c(colorString = "#4c2dc6")))
                        }//ende style
                            isDefaultButton = true
                            useMaxHeight = true
                            useMaxWidth = true

                            action {
                                LoginController.login(nutzername.value, passwort.value)
                                if(!LoginController.login){
                                    nutzername.value = "Daten nicht korrekt!"
                                    passwort.value = ""
                                }
                                if(LoginController.working) {
                                    EinstellungenController.anmelden()
                                    replaceWith(UebersichtView())
                                }//ende if
                            }//ende action
                    } //ende button Anmelden

                    vbox(10, Pos.CENTER) {
                        button("Noch nicht registriert?") {
                            //addClass(Styles.button)
                            style {
                                backgroundColor = multi(c(colorString = "black"))
                                textFill = c(colorString = "#FFFFFF")
                            }//ende style
                            action {
                                replaceWith(RegisterView())
                            } //ende action
                        } //ende button noch nicht registriert
                    } //ende vbox noch nicht registriert
                } //ende vbox labels und buttons
            } //ende vbox gesamt
        } //ende hbox gesamt
    }//ende root
}
