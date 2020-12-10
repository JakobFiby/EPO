package com.example.demo.view

import com.example.demo.app.Styles
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*
import java.awt.event.ActionListener
import java.sql.Date
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class ListeErstellenFenster : View("Liste erstellen") {
    val model = ViewModel()
    val name= model.bind{SimpleStringProperty()}
    //val fdatum = model.bind{SimpleDateFormat()} //wie vereinbare ich diese Variable?

    override val root = form {
        style{
            padding = box(10.px)
            fontSize = 15.px
            backgroundColor=multi(c(colorString="black"))
            textFill= Color.LIGHTGREY
        }

        hbox {
            paddingTop=10
            paddingBottom=10
            paddingRight=20
            paddingLeft=20

            vbox (20) {
                vbox(spacing = 20) {
                    hbox {
                        label("Neue Liste erstellen:") {
                            font = Font.font("Segoe UI", FontWeight.BOLD, 25.0)
                            textFill = c("#4c2dc6")
                            alignment = Pos.CENTER
                        }
                    }
                }
                label("LISTENNAME"){
                    font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 15.0)
                    addClass(Styles.heading)
                }
                    textfield(name).required()
                    setMaxSize(212.0, 03.0)

                label("FÄLLIGKEITSDATUM"){
                    font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 15.0)
                    addClass(Styles.heading)
                }
                    datepicker() {
                        value = LocalDate.now()
                    }
                    //wie kann ich das required setzen --> wär mega nice


                button("Erstellen") {
                    enableWhen(model.valid)
                    isDefaultButton = true
                    setPrefSize(212.0, 10.0)
                    useMaxHeight = true
                    style {
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