package com.example.demo.view

import javafx.scene.shape.Circle
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*
import kotlin.collections.ArrayList
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import com.example.demo.view.EinstellungenFenster

class UeberblickFenster : View ("E.P.O")
{
    var lid = ArrayList<Int>()
    var lna = ArrayList<String>()
    var lfd = ArrayList<String>()

    override val root = form {

        style{
            padding = box(10.px)
            fontSize = 15.px
            backgroundColor=multi(c(colorString="black"))
            textFill= javafx.scene.paint.Color.WHITE
        }//ende style

        val username = loginController.username
        val userid:Int = loginController.userId

        hbox {
            paddingTop = 10
            paddingBottom = 10
            paddingRight = 20
            paddingLeft = 20

            vbox(spacing = 20) {
                hbox {
                    label("Willkommen $username:") {
                        font = Font.font("Segoe UI", FontWeight.BOLD, 25.0)
                        textFill= c("#4C2DC6")
                    }//ende label willkommen

                    label("    ")

                    button("Einstellungen")
                    {
                        font = Font.font("Segoe UI", FontWeight.NORMAL, 15.0)
                        shape = Circle(15.0)
                        setMaxSize(15.0*2, 15.0*2)
                        setMinSize(15.0*2, 15.0*2)
                        style{
                            backgroundColor = multi(c("#777678"))
                            textFill = javafx.scene.paint.Color.BLACK
                        }//ende style
                        action{
                            einstellungenController.profil("", "", false)
                            replaceWith(EinstellungenFenster())
                        }//ende action
                    }//ende button Einstellungen
                }//ende hbox
            }//ende vbox
        }//ende hbox

        listenController.connection(userid)
        lna = listenController.listenname
        lfd = listenController.listenFaelligkeitsDatum

        var lf:String
        var zz = 0

        vbox {
            style{
                backgroundColor = multi(c("#111111"))
            }//ende style
            for (la in lna) {
                hbox {
                    button("o $la") {
                        style {
                            font = Font.font("Segoe UI", FontWeight.NORMAL, 13.0)
                            backgroundColor = multi(c("#111111"))
                            textFill = javafx.scene.paint.Color.WHITE
                        }//ende style
                        action {
                            eintraegeController.eintraege.clear()
                            eintraegeController.connection(la)
                            lna.clear()
                            lid.clear()
                            lfd.clear()
                            replaceWith(EintragUebersichtFenster())
                        }//ende action
                    }//ende button listename

                    button("..."){
                        style{
                            font = Font.font("Segoe UI", FontWeight.NORMAL, 15.0)
                            backgroundColor = multi(c("#111111"))
                            textFill = c(colorString = "#4c2dc6")
                        }//ende style
                        action {
                            ListeBearbeitenController.getName(la)
                            replaceWith(ListeBearbeiten())
                        }//ende action
                    }//ende button ...
                }//ende hbox

                lf = lfd[zz]
                val todaysDate = LocalDate.now()
                val date = LocalDate.parse(lf, DateTimeFormatter.ISO_DATE)

                label("       $lf")
                {
                    style {
                        textFill = javafx.scene.paint.Color.LIGHTGREY
                    }//ende style

                    if(todaysDate>date){
                        style{
                            textFill = javafx.scene.paint.Color.RED
                        }//ende style
                    }//ende if ob überfällig
                }//ende label fälligkeitsdatum

                label("")
                zz++
            }//ende for
        }//ende vbox

        hbox{
            button("+")
            {
                font = Font.font("Segoe UI", FontWeight.BOLD, 14.0)
                shape = Circle(15.0)
                setMaxSize(15.0 * 2, 15.0 * 2)
                setMinSize(15.0 * 2, 15.0 * 2)

                style {
                    backgroundColor = multi(c("#4C2DC6"))
                    textFill = javafx.scene.paint.Color.BLACK
                }//ende style
                action {
                    replaceWith(ListeErstellenFenster())
                    lna.clear()
                    lid.clear()
                    lfd.clear()
                }//ende action
            }//ende button +
        }//ende hbox
    }//ende root
}//ende class