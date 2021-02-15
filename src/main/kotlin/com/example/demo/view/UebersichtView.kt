package com.example.demo.view

import javafx.scene.shape.Circle
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*
import kotlin.collections.ArrayList
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class UebersichtView : View ("") {
    var lid = ArrayList<Int>()
    var lna = ArrayList<String>()
    var lfd = ArrayList<String>()
    var username = ""

    override val root = form {

        style {
            padding = box(10.px)
            fontSize = 15.px
            backgroundColor = multi(c(colorString = "black"))
            textFill = javafx.scene.paint.Color.WHITE
        }//ende style

        username = LoginController.username
        val userid: Int = LoginController.userId

        hbox {
            paddingTop = 10
            paddingBottom = 10
            paddingRight = 20
            paddingLeft = 20

            vbox(spacing = 20) {
                hbox {
                    label("Hallo $username:") {
                        font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 25.0)
                        textFill = c("#4C2DC6")
                    }//ende label willkommen

                    label("    ")

                    button("...")
                    {
                        font = Font.font("Adobe Gothic Std B", FontWeight.NORMAL, 15.0)
                        shape = Circle(15.0)
                        setMaxSize(15.0 * 2, 15.0 * 2)
                        setMinSize(15.0 * 2, 15.0 * 2)
                        style {
                            backgroundColor = multi(c("#777678"))
                            textFill = javafx.scene.paint.Color.BLACK
                        }//ende style
                        action {
                            EinstellungenController.profil("", "", false)
                            replaceWith(EinstellungenView())
                        }//ende action
                    }//ende button Einstellungen
                }//ende hbox
            }//ende vbox
        }//ende hbox gesamt

        ListenController.connection(userid)
        lna = ListenController.listenname
        lfd = ListenController.listenFaelligkeitsDatum

        var lf: String
        var zz = 0

        vbox {
            style {
                backgroundColor = multi(c("#111111"))
            }//ende style
            for (la in lna) {
                hbox {
                    button("o $la") {
                        style {
                            font = Font.font("Adobe Gothic Std B", FontWeight.NORMAL, 13.0)
                            backgroundColor = multi(c("#111111"))
                            textFill = javafx.scene.paint.Color.WHITE
                        }//ende style
                        action {
                            EintraegeController.eintraege.clear()
                            EintraegeController.connection(la)
                            lna.clear()
                            lid.clear()
                            lfd.clear()
                            replaceWith(EintraegeUebersichtView())
                        }//ende action
                    }//ende button listename

                    button("...") {
                        style {
                            font = Font.font("Adobe Gothic Std B", FontWeight.NORMAL, 15.0)
                            backgroundColor = multi(c("#111111"))
                            textFill = c(colorString = "#4c2dc6")
                        }//ende style
                        action {
                            ListeBearbeitenController.getName(la)
                            replaceWith(ListeBearbeitenView())
                        }//ende action
                    }//ende button Einstellungen
                }//ende hbox

                lf = lfd[zz]
                val todaysDate = LocalDate.now()
                val date = LocalDate.parse(lf, DateTimeFormatter.ISO_DATE)

                label("       $lf")
                {
                    style {
                        textFill = javafx.scene.paint.Color.LIGHTGREY
                    }//ende style

                    if (todaysDate > date) {
                        style {
                            textFill = javafx.scene.paint.Color.RED
                        }//ende style
                    }//ende if ob überfällig
                }//ende label fälligkeitsdatum

                label("")
                zz++
            }//ende for
        }//ende vbox

        hbox {
            button("+")
            {
                font = Font.font("Adobe Gothic Std B", FontWeight.BOLD, 14.0)
                shape = Circle(15.0)
                setMaxSize(15.0 * 2, 15.0 * 2)
                setMinSize(15.0 * 2, 15.0 * 2)

                style {
                    backgroundColor = multi(c("#4C2DC6"))
                    textFill = javafx.scene.paint.Color.BLACK
                }//ende style
                action {
                    replaceWith(ListeErstellenView())
                    lna.clear()
                    lid.clear()
                    lfd.clear()
                }//ende action
            }//ende button +
        }//ende hbox
    }//ende root
}