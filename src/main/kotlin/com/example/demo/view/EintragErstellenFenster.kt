package com.example.demo.view

import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*
import java.awt.event.ActionListener
import java.text.SimpleDateFormat

class EintragErstellenFenster : View("Liste erstellen") {
    val model = ViewModel()
    val eName= model.bind{SimpleStringProperty()}
    val eBeschreibung= model.bind{SimpleStringProperty()}

    override val root = form {
        hbox {
            paddingTop=10
            paddingBottom=10
            paddingRight=20
            paddingLeft=20

            vbox (spacing=20) {
                vbox(spacing = 20) {
                    hbox {
                        label("Neuen Eintrag erstellen!") {
                            font = Font.font("Segoe UI", FontWeight.BOLD, 25.0)
                        }
                    }
                }
                fieldset("Name") {
                    textfield(eName).required()
                }
                fieldset("Beschreibung") {
                    textfield(eBeschreibung).required()
                }
                fieldset("Wichtigkeit") {
                    //combobox {  }
                }

                vbox(0,Pos.TOP_CENTER) {
                    button("Erstellen") {
                        enableWhen(model.valid)
                        isDefaultButton = true
                        useMaxHeight = true
                        action {

                        }
                    }
                }
            }
        }
    }

}