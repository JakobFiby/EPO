package com.example.demo.view

import com.example.demo.app.Styles
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.layout.*
import javafx.scene.layout.Border
import javafx.scene.paint.Color
import javax.swing.border.*
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*

class LoginFenster : View("Login") {

    val model = ViewModel()
    val nutzername= model.bind{SimpleStringProperty()}
    val passwort= model.bind{SimpleStringProperty()}

    override val root = form {
        style{
            padding = box(10.px)
            fontSize = 15.px
            backgroundColor=multi(c(colorString="black"))
            textFill=Color.LIGHTGREY
        }
    hbox{
        addClass(Styles.heading)
        paddingTop=10
        paddingBottom=10
        paddingRight=20
        paddingLeft=20
        alignment= Pos.CENTER
        spacing =10.0

        vbox(spacing=20){

            vbox(spacing=20) {
            hbox{
                label("EPO"){
                    font= Font.font("Segoe UI", FontWeight.BOLD, 30.0)
                }
                label(" - Easy Project Organisation"){
                    font= Font.font("Segoe UI", FontWeight.NORMAL, 20.0)
                }
            } //ende hbox Titel
            } //ende vbox Titel
        fieldset(title, labelPosition = Orientation.VERTICAL) {
            fieldset("Nutzername") {
                textfield(nutzername).required()
            }
            fieldset("Passwort") {
                passwordfield(passwort).required()
            }

            vbox(0,Pos.TOP_LEFT){
                button("Anmelden"){
                    enableWhen(model.valid)
                    addClass(Styles.allbuttons)
                    isDefaultButton = true
                    useMaxHeight = true
                    action {
                        login.test(nutzername.value, passwort.value)
                    }
                }
            }
            vbox(0,Pos.TOP_RIGHT) {
                button("Noch nicht registriert?") {
                    //addClass(Styles.button)
                    style {
                        backgroundColor = multi(c(colorString = "black"))
                    }
                    action {
                        RegisterFenster().openWindow()
                    } //ende action
                } //ende button noch nicht registriert
            } //ende vbox noch nicht registriert
        } //ende fieldset
        } //ende vbox gesamt
        } //ende hbox gesamt
    }

    override fun onDock() {
        nutzername.value="jakob"
        passwort.value="*A4B6157319038724E3560894F7F932C8886EBFCF"
        model.clearDecorators()
    }
}
