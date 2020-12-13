package com.example.demo.view

import com.example.demo.app.Styles
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*
import java.time.LocalDate

class ListeErstellenFenster : View("Liste erstellen") {
    val model = ViewModel()
    val name= model.bind{SimpleStringProperty()}
    private val dateProperty = SimpleObjectProperty<LocalDate>()

    override val root = form {
        style{
            padding = box(10.px)
            fontSize = 15.px
            backgroundColor=multi(c(colorString="black"))
            textFill= Color.LIGHTGREY
            alignment = Pos.CENTER
        }

        hbox {
            paddingTop=10
            paddingBottom=10
            paddingRight=20
            paddingLeft=20
            alignment = Pos.CENTER

            vbox (20) {
                vbox(spacing = 20) {
                    hbox {
                        button("< ") {
                            font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 20.0)
                            style {
                                backgroundColor = multi(c(colorString = "black"))
                                textFill = c(colorString = "#777678")
                            }
                            action {
                                replaceWith(UeberblickFenster::class)
                                name.value = ""
                                //sollte reloaded werden --> Kathi fragen!!
                            } //ende action
                        } //ende button zurück

                        label("Neue Liste:") {
                            font = Font.font("Segoe UI", FontWeight.BOLD, 30.0)
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
                    datepicker(dateProperty) {
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
                        val dateValue = dateProperty.value
                        val todaysDate = LocalDate.now()
                        val listename = name.value
                        var userid:Int = loginController.userId

                        if(dateValue < todaysDate){
                            name.value = "Fälligkeitsd. darf nicht kleiner als heutiges Datum sein!"
                        }
                        else{
                            listeErstellenController.listehinzufügen(listename, userid, dateValue, todaysDate)
                            if(!listeErstellenController.erstellt){
                                name.value = "Liste konnte nicht erstellt werden!"
                            }
                            else{
                                name.value = ""
                            }
                        }
                    }
                }
            }
        }
    }

}