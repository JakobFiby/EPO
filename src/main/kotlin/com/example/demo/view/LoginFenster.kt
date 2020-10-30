package com.example.demo.view

import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*
import java.awt.event.ActionListener


class LoginFenster : View("Login") {
    val model = ViewModel()
    val nutzername= model.bind{SimpleStringProperty()}
    val passwort= model.bind{SimpleStringProperty()}

    override val root = form {
    hbox{
        paddingTop=10
        paddingBottom=10
        paddingRight=20
        paddingLeft=20

        vbox(spacing=20){
            vbox(spacing=20) {
            hbox{
                label("EPO"){
                    font= Font.font("Segoe UI", FontWeight.BOLD, 30.0)
                }
                label(" - Easy Project Organisation"){
                    font= Font.font("Segoe UI", FontWeight.NORMAL, 20.0)
                }
            }
            }
        fieldset(title, labelPosition = Orientation.VERTICAL) {
            fieldset("Nutzername") {
                textfield(nutzername).required()
            }
            fieldset("Passwort") {
                passwordfield(passwort).required()
            }

            vbox(0,Pos.TOP_RIGHT){
                button("Anmelden"){
                    enableWhen(model.valid)
                    isDefaultButton = true
                    useMaxHeight = true
                    action {
                        UeberblickFenster().openWindow()
                }
            }
        }
        }
        }
        }
}
}



