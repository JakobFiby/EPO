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
        style{
            padding = box(10.px)
            fontSize = 15.px
            backgroundColor=multi(c(colorString="black"))
            textFill=c(colorString="#FFFFFF")
        }
        hbox{
            paddingTop=10
            paddingBottom=10
            paddingRight=20
            paddingLeft=20


            vbox(spacing=20){

                fieldset(title, labelPosition = Orientation.VERTICAL){
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

                    vbox(0,Pos.TOP_LEFT){
                        button("Registrieren"){
                            enableWhen(model.valid)
                            addClass(Styles.allbuttons)
                            isDefaultButton = true
                            useMaxHeight = true
                            action {
                                runAsyncWithProgress {
                                    register.anmelden(nutzernameR.value, vorname.value, nachname.value, email.value, passwortR.value)
                                    //LoginFenster().openWindow()
                                }

                            } //ende action
                        }//ende button Registrieren
                    } //ende vbox button
                } //ende fieldset
            } //ende vbox
        } //ende hbox
    } //ende form

    override fun onDock() {
        nutzernameR.value=""
        vorname.value=""
        nachname.value=""
        email.value=""
        passwortR.value=""
        model.clearDecorators()
    }
}
