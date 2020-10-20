package com.example.demo.view

import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import tornadofx.*

class LoginFenster : View("Login") {
    val model = ViewModel()
    val nutzername= model.bind{SimpleStringProperty()}
    val passwort= model.bind{SimpleStringProperty()}

    override val root = form {
        fieldset(title, labelPosition = Orientation.VERTICAL){
            fieldset("Nutzername"){
                textfield(nutzername).required()
            }
            fieldset("Passwort"){
                passwordfield(passwort).required()
            }
            button("Anmelden"){
                enableWhen(model.valid)
                isDefaultButton=true
                useMaxHeight=true
                action{
                    runAsyncWithProgress {

                    }
                }
            }

        }

    }
}
