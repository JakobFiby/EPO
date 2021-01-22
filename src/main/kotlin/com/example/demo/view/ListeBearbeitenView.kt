package com.example.demo.view

import com.example.demo.app.Styles
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*

class ListeBearbeitenView : View("") {
    val model = ViewModel()
    val name= model.bind{ SimpleStringProperty() }
    var ename:String = ""

    override val root = form{
        style{
            padding = box(10.px)
            fontSize = 15.px
            backgroundColor=multi(c(colorString="black"))
            textFill= javafx.scene.paint.Color.WHITE
            alignment = Pos.CENTER
            setPrefSize(360.0, 600.0)
        }//ende style

            vbox(0, Pos.CENTER) {
                hbox {
                    button("< ") {
                        font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 20.0)
                        style {
                            backgroundColor = multi(c(colorString = "black"))
                            textFill = c(colorString = "#777678")
                        }//ende style
                        action {
                            name.value = ""
                            replaceWith(UebersichtView())
                        } //ende action
                    } //ende button zurück

                    label("Bearbeiten:") {
                        font = Font.font("Segoe UI", FontWeight.BOLD, 30.0)
                        textFill = c("#4c2dc6")
                        alignment = Pos.CENTER
                    }//ende label bearbeiten
                }//ende hbox

                label("USERNAME"){
                    font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 15.0)
                    addClass(Styles.heading)
                }//ende label username
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
                                left = c("#4c2dc6")))
                    }//ende style
                    action {
                        ename = name.value
                        ListeBearbeitenController.userhinzufügen(ename)

                        if(ListeBearbeitenController.text == 0){
                            name.value = "User nicht gefunden!"
                        }
                        else if(ListeBearbeitenController.text == 1){
                            name.value = "User bereits hinzugefügt!"
                        }
                        else if(ListeBearbeitenController.text == 2){
                            name.value = "User erfolgreich hinzugefügt!"
                        }
                    }//ende action
                }//ende  button hinzufuegen

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
                                left = c("#c63229")))
                    }//ende style
                    action {
                        ListeBearbeitenController.listeloeschen()
                        replaceWith(UebersichtView())
                    }//ende action
                }//ende button löschen
            }//ende vbox gesamt
    }//ende root
}
