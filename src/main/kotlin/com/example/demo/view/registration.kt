package com.example.demo.view

import javafx.beans.property.SimpleStringProperty
import com.example.demo.view.LoginFenster
import com.example.demo.view.UeberblickFenster
import com.example.demo.view.RegisterFenster
import tornadofx.*
import com.google.gson.Gson
import javafx.scene.control.Label
import khttp.put
import khttp.request
import netscape.javascript.JSObject
import org.json.JSONObject
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.SQLException
import javax.json.JsonObject


object registration {

    var userph: Label by singleAssign()

    var nutzername: String = ""
    var passwort: String = ""
    var mitteilungen: Int = 1
    var abmelden: Int = 0
    var vorname: String = ""
    var nachname: String = ""
    var email: String = ""
    var farbschemaid: Int = 1
    var profilbildid: Int = 1
    var nn: String = ""
    var funktioniert: Boolean = true
    var passwortRichtig: Boolean = true

    fun anmelden(nutzernameR:String, vornameR:String, nachnameR:String, emailR:String, passwortR:String) {
        try {
            //Variablen zuordnen
            nutzername=nutzernameR

            passwort = passwortR.sha256()
            if (passwort.length == 63) {
                    passwort = "0" + passwort
            }

            mitteilungen=1
            abmelden=0
            vorname=vornameR

            vorname=vorname.substring(0,1).toUpperCase()+vorname.substring(1)

            nachname=nachnameR
            nachname=nachname.substring(0,1).toUpperCase()+nachname.substring(1)

            email= emailR
            farbschemaid=1
            profilbildid=1

            val r = khttp.get("http://digbizmistelbach.at/epo/api/public/index.php/benutzer")
            val json = r.jsonArray

            for (ja in json) {
                val jo = ja as JSONObject
                nn = jo.get("nutzername").toString()
                if(nutzername.equals(nn)){
                    println("Nutzername $nutzername schon vorhanden")
                    funktioniert=false
                }
            }

            if(funktioniert==true)
            {
                if(passwortR.length>=6) {
                  val request = khttp.post("http://digbizmistelbach.at/epo/api/public/index.php/registrieren" +
                            "?nutzername=$nutzername&passwort=$passwort&mitteilungen=$mitteilungen&abmelden=$abmelden&vorname=$vorname&nachname=$nachname&email=$email&farbschemaid=$farbschemaid&profilbildid=$profilbildid")
                }
                else
                {
                    println("Passwort zu kurz")
                    funktioniert=false
                    passwortRichtig=false
                }
            }

        }
        catch (e: SQLException){
            e.printStackTrace()
        }
    }

    //Hashen
    fun String.sha256(): String {
        val md = MessageDigest.getInstance("SHA-256")
        return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
    }
}