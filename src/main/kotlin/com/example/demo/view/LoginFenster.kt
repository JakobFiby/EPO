package com.example.demo.view

import com.example.demo.app.Styles
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*
import java.sql.DriverManager
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.*
import java.util.Properties
import javax.swing.text.Position


class LoginFenster : View("Login") {
    val model = ViewModel()
    val nutzername= model.bind{SimpleStringProperty()}
    val passwort= model.bind{SimpleStringProperty()}
    val loginController: LoginController by inject()
    //var verbunden =false

    override val root = form {
    hbox{
        paddingTop=10
        paddingBottom=10
        paddingRight=20
        paddingLeft=20

        vbox(spacing=20){
            vbox(spacing=20) {
            hbox{
                label("EPO"){
                    font= Font.font("Segoe UI", FontWeight.BOLD, 30.0)
                }
                label(" - Easy Project Organisation"){
                    font= Font.font("Segoe UI", FontWeight.NORMAL, 20.0)
                }
            }
            }
        fieldset(title, labelPosition = Orientation.VERTICAL) {
            fieldset("Nutzername") {
                textfield(nutzername).required()
            }
            fieldset("Passwort") {
                passwordfield(passwort).required()
            }

            vbox(0,Pos.TOP_CENTER){
                button("Anmelden"){
                    enableWhen(model.valid)
                    isDefaultButton = true
                    useMaxHeight = true
                    action {
                        runAsyncWithProgress {
                            loginController.login(nutzername.value,passwort.value)
                            //connection()
                            UeberblickFenster().openWindow()
                        }


                }
            }
        }
        }
        }
        label(loginController.statusProperty){
            style{
                paddingTop=10
                fontWeight= FontWeight.BOLD
            }
        }
        }
}
    override fun onDock() {
        nutzername.value=""
        passwort.value=""
        model.clearDecorators()
    }

    /*fun connection(){
        if(!verbunden)
        try {
            val c = DriverManager.getConnection(
                    "jdbc:mysql://sql516.your-server.de:3306/epofgs",
                    "epofgs",
                    "Digbiz2018#@")
            //println("Ok")
            verbunden=true
            val s=c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
            val r =s.executeQuery("SELECT `userid`, `nutzername`, `passwort`, `mitteilungen`, `abmelden`, `profilbild`, `vorname`, `nachname`, `email`, `farbschemaid` FROM `user`")
        }
        catch(e: SQLException){
            e.printStackTrace()
        }
        catch(e: Exception){
            e.printStackTrace()
        }
    }*/
}
