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
import com.example.demo.view.UeberblickFenster
import com.example.demo.view.LoginFenster
import com.example.demo.view.einstellungenController
import javafx.scene.shape.Circle

class ProfilFenster : View("Profil bearbeiten") {

    override val root = form {
        style {
            fontSize = 15.px
            backgroundColor = multi(c(colorString = "black"))
            textFill = c(colorString = "#FFFFFF")
        }

        val model = ViewModel()
        var aenderung = model.bind { SimpleStringProperty() }

        hbox {
            paddingTop = 25
            paddingBottom = 25
            paddingRight = 50
            paddingLeft = 50
            alignment = Pos.TOP_LEFT

            aenderung.value =einstellungenController.andernaufruf

            vbox(spacing = 10) {
                hbox {
                    button("< ") {
                        font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 10.0)
                        style {
                            backgroundColor = multi(c(colorString = "black"))
                            textFill = c(colorString = "#777678")
                        }
                        action {
                            replaceWith(EinstellungenFenster())
                        } //ende action
                    } //ende button zurück
                    label("Profil bearbeiten") {
                        font = Font.font("Segoe UI", FontWeight.BOLD, 20.0)
                        textFill = c("#4C2DC6")
                    }
                }
            }
        }
        vbox() {
            vbox(10) {

                label(einstellungenController.profilopt) {
                    font = Font.font("Adobe Gothic Std B", FontWeight.LIGHT, 20.0)
                    addClass(Styles.heading)
                }

                textfield(aenderung).required()


            }
        }

        label()

        hbox{
            button("")
            {
                font = Font.font("Segoe UI", FontWeight.BOLD, 14.0)
                shape = Circle(15.0)
                setMaxSize(15.0 * 2, 15.0 * 2)
                setMinSize(15.0 * 2, 15.0 * 2)

                style {
                    backgroundColor = multi(c("#4C2DC6"))
                    textFill = javafx.scene.paint.Color.BLACK
                }
                action {
                    replaceWith(EinstellungenFenster())
                }
            }
        }
    }
}