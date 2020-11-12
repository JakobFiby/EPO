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
    val vorname= model.bind{SimpleStringProperty()}
    val nachname= model.bind{SimpleStringProperty()}
    val email= model.bind{SimpleStringProperty()}
    val passwort= model.bind{SimpleStringProperty()}


    override val root = form {
        style{
            padding = box(10.px)
            fontSize = 15.px
            backgroundColor=multi(c(colorString="black"))
            textFill=Color.LIGHTGREY
        }
        hbox{
            paddingTop=10
            paddingBottom=10
            paddingRight=20
            paddingLeft=20


            vbox(spacing=20){

                fieldset(title, labelPosition = Orientation.VERTICAL) {
                    fieldset("Vorname") {
                        textfield(vorname).required()
                    }
                    fieldset("Nachname") {
                        textfield(nachname).required()
                    }
                    fieldset("Email") {
                        textfield(email).required()
                    }
                    fieldset("Passwort") {
                        passwordfield(passwort).required()
                    }

                    vbox(0,Pos.TOP_LEFT){
                        button("Registrieren"){
                            enableWhen(model.valid)
                            style{
                                backgroundColor = multi(c(colorString = "lightgrey"))
                                textFill= Color.BLACK
                            }
                            isDefaultButton = true
                            useMaxHeight = true
                            action {
                                runAsyncWithProgress {
                                    LoginFenster().openWindow()
                                }

                            } //ende action
                        }//ende button Registrieren
                    } //ende vbox button
                } //ende fieldset
            } //ende vbox
        } //ende hbox
    } //ende form

    override fun onDock() {
        vorname.value=""
        nachname.value=""
        email.value=""
        passwort.value=""
        model.clearDecorators()
    }
}
