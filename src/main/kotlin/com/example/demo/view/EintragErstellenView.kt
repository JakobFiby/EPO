package com.example.demo.view

import com.example.demo.app.Styles
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*


class EintragErstellenView : View("") {
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
        }//ende style

        hbox {
            paddingTop=10
            paddingBottom=10
            paddingRight=20
            paddingLeft=20

            vbox (spacing=20) {
                vbox(spacing = 20) {
                    hbox {
                        button("< ") {
                            font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 20.0)
                            style {
                                backgroundColor = multi(c(colorString = "black"))
                                textFill = c(colorString = "#777678")
                            }//ende style
                            action {
                                replaceWith(EintraegeUebersichtView())
                            } //ende action
                        } //ende button zurück

                        label("Neuer Eintrag:") {
                            font = Font.font("Segoe UI", FontWeight.BOLD, 30.0)
                            textFill = c("#4c2dc6")
                            alignment = Pos.CENTER
                        }//ende label 'neuer Eintrag'
                    }//ende hbox
                }//ende vbox
                label("NAME"){
                    font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 15.0)
                    addClass(Styles.heading)
                }//ende label name
                    textfield(eName).required()

                label("BESCHREIBUNG"){
                    font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 15.0)
                    addClass(Styles.heading)
                }//ende label beschreibung
                    textfield(eBeschreibung).required()

                label("WICHTIGKEIT"){
                    font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 15.0)
                    addClass(Styles.heading)
                }//ende label Wichtigkeit
                    combobox(selectedItem, items) {
                        setMaxSize(420.0, 03.0)
                        cellFormat {
                            text = it
                        }
                    }//ende combobox


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
                        }//ende style
                        action {
                            val name = eName.value
                            val beschreibung = eBeschreibung.value
                            val erledigt = 0
                            val wichtigkeit = selectedItem.value
                            val listeid = EintraegeController.listeid.toInt()
                            EintragErstellenController.eintraghinzufügen(name, beschreibung, erledigt, wichtigkeit, listeid)

                            if(EintragErstellenController.erstellt){
                                eName.value = ""
                            }
                            else{
                                eName.value = "Eintrag konnte nicht erstellt werden!"
                            }
                            eBeschreibung.value = ""
                            selectedItem.value = items.first()
                        }//ende action
                    }//ende button Erstellen
                }//ende vbox button Erstellen
            }//ende vbox gesamt
        }//ende hbox gesamt
    }//ende root
}