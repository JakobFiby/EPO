package com.example.demo.view

import com.example.demo.app.Styles
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*

class ListeBearbeiten : View("Bearbeiten") {
    val model = ViewModel()
    val name= model.bind{ SimpleStringProperty() }

    override val root = form{
        style{
            padding = box(10.px)
            fontSize = 15.px
            backgroundColor=multi(c(colorString="black"))
            textFill= javafx.scene.paint.Color.WHITE
            alignment = Pos.CENTER
            setPrefSize(360.0, 600.0)
        }

            vbox(0, Pos.CENTER) {
                hbox {
                    button("< ") {
                        font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 20.0)
                        style {
                            backgroundColor = multi(c(colorString = "black"))
                            textFill = c(colorString = "#777678")
                        }
                        action {
                            replaceWith(UeberblickFenster::class)
                        } //ende action
                    } //ende button zurück

                    label("Bearbeiten:") {
                        font = Font.font("Segoe UI", FontWeight.BOLD, 30.0)
                        textFill = c("#4c2dc6")
                        alignment = Pos.CENTER
                    }
                }

                label("USERNAME"){
                    font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 15.0)
                    addClass(Styles.heading)
                }
                    textfield(name).required()
                    setMaxSize(212.0, 03.0)

                label()

                button("HINZUFÜGEN") {
                    enableWhen(model.valid)
                    isDefaultButton = true
                    setPrefSize(200.0, 10.0)
                    useMaxHeight = true
                    style {
                        backgroundColor = multi(c("black"))
                        textFill = c("#4c2dc6")
                        borderColor = multi(box(
                                top = c("#4c2dc6"),
                                bottom = c("#4c2dc6"),
                                right = c("#4c2dc6"),
                                left = c("#4c2dc6")
                        ))
                    }
                    action {
                        name.value = ""
                    }
                }

                label()

                button("LÖSCHEN") {
                    isDefaultButton = true
                    setPrefSize(200.0, 10.0)
                    useMaxHeight = true
                    style {
                        backgroundColor = multi(c("black"))
                        textFill = c("#c63229")
                        borderColor = multi(box(
                                top = c("#c63229"),
                                bottom = c("#c63229"),
                                right = c("#c63229"),
                                left = c("#c63229")
                        ))
                    }
                    action {
                        name.value = ""
                    }
                }
            }

    }
}
