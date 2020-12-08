package com.example.demo.view

import com.example.demo.app.Styles
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.geometry.Pos
import javafx.scene.control.ComboBox
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*


class EintragErstellenFenster : View("Liste erstellen") {
    val model = ViewModel()
    val eName= model.bind{SimpleStringProperty()}
    val eBeschreibung= model.bind{SimpleStringProperty()}
    val items = listOf("low", "medium", "high")
    val selectedItem = SimpleStringProperty(items.first())

    override val root = form {
        style{
            padding = box(10.px)
            fontSize = 15.px
            backgroundColor = multi(c(colorString="black"))
            textFill = Color.LIGHTGREY
        }

        hbox {
            paddingTop=10
            paddingBottom=10
            paddingRight=20
            paddingLeft=20

            vbox (spacing=20) {
                vbox(spacing = 20) {
                    hbox {
                        label("Neuen Eintrag erstellen:") {
                            font = Font.font("Segoe UI", FontWeight.BOLD, 25.0)
                            textFill = c("#4c2dc6")
                            alignment = Pos.CENTER
                        }
                    }
                }
                label("NAME"){
                    font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 15.0)
                    addClass(Styles.heading)
                }
                    textfield(eName).required()

                label("BESCHREIBUNG"){
                    font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 15.0)
                    addClass(Styles.heading)
                }
                    textfield(eBeschreibung).required()

                label("WICHTIGKEIT"){
                    font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 15.0)
                    addClass(Styles.heading)
                }
                    combobox(selectedItem, items) {
                        setMaxSize(420.0, 03.0)
                        cellFormat {
                            text = it
                        }
                    }


                vbox(0,Pos.TOP_CENTER) {
                    button("Erstellen") {
                        enableWhen(model.valid)
                        isDefaultButton = true
                        useMaxHeight = true
                        setPrefSize(300.0, 10.0)
                        style{
                            backgroundColor = multi(c("black"))
                            textFill = c("#4c2dc6")
                            borderColor = multi(box(
                                    top = c("#4c2dc6"),
                                    bottom = c("#4c2dc6"),
                                    right = c("#4c2dc6"),
                                    left = c("#4c2dc6")))
                        }
                        action {

                        }
                    }
                }
            }
        }
    }

}