package com.example.demo.view

import javafx.scene.shape.Circle
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*
import kotlin.collections.ArrayList
import com.example.demo.view.EintragUebersichtFenster
import com.example.demo.view.EinstellungenFenster
import com.example.demo.view.einstellungenController

class UeberblickFenster : View ("E.P.O")
{
    var lid = ArrayList<Int>()
    var lna = ArrayList<String>()
    var lfd = ArrayList<String>()
    var ausgewählteListe:String = ""

    override val root = form {

        style{
            padding = box(10.px)
            fontSize = 15.px
            backgroundColor=multi(c(colorString="black"))
            textFill= javafx.scene.paint.Color.WHITE

            //setPrefSize(360.0, 600.0)
        }

        var username = loginController.username
        var userid:Int = loginController.userId

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
                    }

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
                        }
                        action{
                            einstellungenController.profil("", "", false)
                            replaceWith(EinstellungenFenster::class, sizeToScene = false, centerOnScreen = true)
                        }
                    }
                }
            }
        }

        listenController.connection(userid)
        lna = listenController.listenname
        lfd = listenController.listenFaelligkeitsDatum

        var lf:String
        var zz = 0

        vbox {
            style{
                backgroundColor = multi(c("#111111"))
            }
            for (la in lna) {
                hbox {
                    button("o $la") {
                        style {
                            font = Font.font("Segoe UI", FontWeight.NORMAL, 13.0)
                            backgroundColor = multi(c("#111111"))
                            textFill = javafx.scene.paint.Color.WHITE
                        }
                        action {
                            eintraegeController.eintraege.clear()
                            eintraegeController.connection(la)
                            lna.clear()
                            lid.clear()
                            lfd.clear()
                            /*val a = EintragUebersichtFenster()
                            replaceWith(a)*/
                            replaceWith(EintragUebersichtFenster())
                        }
                    }

                    button("..."){
                        style{
                            font = Font.font("Segoe UI", FontWeight.NORMAL, 15.0)
                            backgroundColor = multi(c("#111111"))
                            textFill = c(colorString = "#4c2dc6")
                        }
                        action {
                            ListeBearbeitenController.getName(la)
                            replaceWith(ListeBearbeiten())
                        }
                    }
                }

                lf = lfd[zz]

                label("       $lf")
                {
                    style {
                        textFill = javafx.scene.paint.Color.LIGHTGREY
                    }
                }

                label("")
                zz++
            }
        }

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
                }
                action {
                    replaceWith(ListeErstellenFenster::class, sizeToScene = false, centerOnScreen = true)
                    lna.clear()
                    lid.clear()
                    lfd.clear()
                }
            }
        }
    }
}