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
    val nutzername= model.bind{SimpleStringProperty()}
    val passwort= model.bind{SimpleStringProperty()}

    override val root = form {

        style{
            fontSize = 15.px
            backgroundColor=multi(c(colorString="black"))
            setPrefSize(360.0, 600.0)
        }

    hbox{
        addClass(Styles.heading)
        paddingTop=25
        paddingBottom=25
        paddingRight=50
        paddingLeft=50
        alignment= Pos.CENTER
        spacing =30.0

        vbox(spacing=20){

            vbox(20, Pos.CENTER) {
            hbox{
                label("EPO"){
                    font= Font.font("Segoe UI", FontWeight.BOLD, 40.0)
                    addClass(Styles.heading)
                }
            } //ende hbox Titel
            } //ende vbox Titel

            vbox(0,Pos.CENTER){
                fieldset(labelPosition = Orientation.VERTICAL) {
                fieldset("Nutzername") {
                textfield(nutzername).required()
                }
                fieldset("Passwort") {
                passwordfield(passwort).required()
                addClass(Styles.heading)
                }

                button("Anmelden"){
                    enableWhen(model.valid)
                    addClass(Styles.allbuttons)
                    isDefaultButton = true
                    useMaxHeight = true
                    style{
                        backgroundColor = multi(c(colorString = "black"))
                        textFill= c(colorString = "#4c2dc6")
                        borderColor= multi(box(
                                top=c(colorString = "#4c2dc6"),
                                bottom = c(colorString = "#4c2dc6"),
                                right= c(colorString = "#4c2dc6"),
                                left=c(colorString = "#4c2dc6")
                        ))
                    }
                    action {
                        login.ueberpruefen(nutzername.value, passwort.value)
                    }
                }
            }
            vbox(10,Pos.CENTER) {
                button("Noch nicht registriert?") {
                    //addClass(Styles.button)
                    style {
                        backgroundColor = multi(c(colorString = "black"))
                        textFill= c(colorString="#FFFFFF")
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
        passwort.value="1234"
        model.clearDecorators()
    }

}
