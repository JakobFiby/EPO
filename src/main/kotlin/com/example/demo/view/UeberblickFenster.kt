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
import java.util.*
import javax.swing.text.Position

class UeberblickFenster : View ("Easy Project Organisation")
{
    override val root = form {
        hbox {
            paddingTop = 10
            paddingBottom = 10
            paddingRight = 20
            paddingLeft = 20

            vbox(spacing = 20) {
                hbox {
                    label("Listenübersicht!") {
                        font = Font.font("Segoe UI", FontWeight.BOLD, 25.0)
                    }
                        label("    ")

                    button("Einstellungen")
                    {
                        font = Font.font("Segoe UI", FontWeight.NORMAL, 15.0)
                        shape = Circle(15.0)
                        setMaxSize(15.0*2, 15.0*2)
                        setMinSize(15.0*2, 15.0*2)
                    }
                }
            }
        }
    }
}