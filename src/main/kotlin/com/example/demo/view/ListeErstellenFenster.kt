package com.example.demo.view

import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*
import java.awt.event.ActionListener
import java.text.SimpleDateFormat

class ListeErstellenFenster : View("Liste erstellen") {
    val model = ViewModel()
    val name= model.bind{SimpleStringProperty()}
    //val fdatum = model.{SimpleDateFormat()} wie vereinbare ich diese Variable?

    override val root = form {
        hbox {
            paddingTop=10
            paddingBottom=10
            paddingRight=20
            paddingLeft=20

            vbox (spacing=20) {
                vbox(spacing = 20) {
                    hbox {
                        label("Neue Liste erstellen!") {
                            font = Font.font("Segoe UI", FontWeight.BOLD, 25.0)
                        }
                    }
                }
                fieldset("Listenname") {
                    textfield(name).required()
                    setMaxSize(212.0, 03.0)
                }
                fieldset("Fälligkeitsdatum") {
                    datepicker().showingProperty()
                    //wie kann ich das required setzen --> wär mega nice
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