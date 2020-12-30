package com.example.demo.view

import javafx.beans.property.SimpleStringProperty
import com.example.demo.view.LoginFenster
import com.example.demo.view.loginController
import com.example.demo.view.EinstellungenFenster
import com.example.demo.view.UeberblickFenster
import com.example.demo.view.UserModel
import tornadofx.*
import com.example.demo.view.User
import com.example.demo.view.loginController.sha256
import com.google.gson.Gson
import netscape.javascript.JSObject
import org.json.JSONObject
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.SQLException
import javax.json.JsonObject

object einstellungenController {

    var nnTest: String = ""
    var nn: String = ""
    var pw: String = ""
    var id: String = ""
    var vn: String = ""
    var nachn: String = ""
    var email: String = ""
    var abmelden: String = ""
    var farbschemaid: String = ""
    var userId: Int = 0
    var profilopt: String = ""
    var andernaufruf:String=""
    var andernJaNein: Boolean = false

    fun profil(profil: String, andern: String, JaNein: Boolean){

        try {
            userId=loginController.userId
            profilopt =profil
            andernaufruf=andern
            andernJaNein=JaNein

            val r = khttp.get("http://localhost/api/public/index.php/benutzer")
            val json = r.jsonArray
            println(json)
            for (ja in json) {
                val jo = ja as JSONObject
                nnTest = jo.get("nutzername").toString()
                if(nnTest.equals(loginController.username)){
                    //println(nnTest)
                    nn = jo.get("nutzername").toString()
                    vn = jo.get("vorname").toString()
                    nachn = jo.get("nachname").toString()
                    email = jo.get("email").toString()
                    pw = jo.get("passwort").toString()
                    id = jo.get("userid").toString()
                    farbschemaid=jo.get("farbschemaid").toString()
                    abmelden=jo.get("abmelden").toString()
                    //println(nn)
                }
            }

            if(andernJaNein==true){
                println("Änderung erfolgt")
                if(profil.equals("Nutzername")){
                    val pro = khttp.put("http://localhost/api/public/index.php/updateUser?userid=${userId}&nutzername=${andernaufruf}&vorname=${vn}&nachname=${nachn}&email=${email}&abmelden=${abmelden}&farbschemaid=${farbschemaid}")
                    nn= andernaufruf
                }
                if(profil.equals("Vorname")){
                    val pro = khttp.put("http://localhost/api/public/index.php/updateUser?userid=${userId}&nutzername=${nn}&vorname=${andernaufruf}&nachname=${nachn}&email=${email}&abmelden=${abmelden}&farbschemaid=${farbschemaid}")
                    vn= andernaufruf
                }
                if(profil.equals("Nachname")){
                    val pro = khttp.put("http://localhost/api/public/index.php/updateUser?userid=${userId}&nutzername=${nn}&vorname=${vn}&nachname=${andernaufruf}&email=${email}&abmelden=${abmelden}&farbschemaid=${farbschemaid}")
                    nachn= andernaufruf
                }
                if(profil.equals("Email")){
                    val pro = khttp.put("http://localhost/api/public/index.php/updateUser?userid=${userId}&nutzername=${nn}&vorname=${vn}&nachname=${nachn}&email=${andernaufruf}&abmelden=${abmelden}&farbschemaid=${farbschemaid}")
                    email= andernaufruf
                }
            }
            andernJaNein=false
            /*EinstellungenFenster.nutzername=nn
            EinstellungenFenster.vorname=vn
            EinstellungenFenster.nachname=nachn
            EinstellungenFenster.email=email*/
        }
        catch (e: SQLException){
            e.printStackTrace()
        }
    }
}