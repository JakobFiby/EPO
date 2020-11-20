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
import java.util.*
import javax.swing.text.Position
import javax.xml.soap.Node
import kotlin.collections.ArrayList

class UeberblickFenster : View ("Easy Project Organisation")
{
    public var lid = ArrayList<Int>()
    public var lna = ArrayList<String>()

    override val root = form {
        style{
            padding = box(10.px)
            fontSize = 15.px
            backgroundColor=multi(c(colorString="black"))
            textFill= javafx.scene.paint.Color.WHITE
        }

        var username = login.username
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
                            backgroundColor = multi(c("#F98E01"))
                            textFill = javafx.scene.paint.Color.BLACK
                        }
                        action{

                        }
                    }
                }
            }
        }
        listenQuery.connection()
        lid = listenQuery.listenid
        lna = listenQuery.listenname

        for (la in lna) {
            button("* $la")
            {
                style{
                    backgroundColor = multi(c(colorString = "black"))
                    textFill= javafx.scene.paint.Color.WHITE
                }
                action {
                    println("ok")
                }
            }
            label("")
        }

        button("+")
        {
            font = Font.font("Segoe UI", FontWeight.BOLD, 14.0)
            shape = Circle(15.0)
            setMaxSize(15.0*2, 15.0*2)
            setMinSize(15.0*2, 15.0*2)
            style{
                backgroundColor = multi(c("#05B90A"))
                textFill = javafx.scene.paint.Color.BLACK
            }
            action{
                ListeErstellenFenster().openWindow()
            }
        }
    }
}