package com.example.demo.view

import com.example.demo.app.Styles
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.shape.Circle
import javafx.scene.shape.TriangleMesh
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*
import java.awt.Color
import java.awt.Image
import java.sql.Date
import java.util.*
import javax.swing.text.Position
import javax.xml.soap.Node
import javax.xml.stream.Location
import kotlin.collections.ArrayList
import com.example.demo.view.UserModel
import com.example.demo.view.loginController

class UeberblickFenster : View ("E.P.O")
{
    public var lid = ArrayList<Int>()
    public var lna = ArrayList<String>()
    public var lfd = ArrayList<Date>()
    public var ausgewählteListe:String = ""

    override val root = form {

        style{
            padding = box(10.px)
            fontSize = 15.px
            backgroundColor=multi(c(colorString="black"))
            textFill= javafx.scene.paint.Color.WHITE
            //setPrefSize(360.0, 600.0)
        }

        var username = loginController.username
        //println(username + "*")

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

                        }
                    }
                }
            }
        }
        /*
        listenQuery.connection()
        lid = listenQuery.listenid
        lna = listenQuery.listenname
        lfd = listenQuery.listenFaelligkeitsDatum
        */
        var lf:Date
        var zz:Int = 0

        vbox {
            style{
                backgroundColor = multi(c("#111111"))
            }
            for (la in lna) {
                button("o $la")
                {
                    style {
                        font = Font.font("Segoe UI", FontWeight.NORMAL, 13.0)
                        backgroundColor = multi(c("#111111"))
                        textFill = javafx.scene.paint.Color.WHITE
                    }
                    action {
                        eintraegeQuery.eintraege.clear()
                        eintraegeQuery.connection(la)
                        lna.clear()
                        lid.clear()
                        lfd.clear()
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
                    ListeErstellenFenster().openWindow()
                    lna.clear()
                    lid.clear()
                    lfd.clear()
                }
            }
        }
    }
}