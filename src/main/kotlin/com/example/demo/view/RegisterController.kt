package com.example.demo.view

import tornadofx.*
import javafx.scene.control.Label
import org.json.JSONObject
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.SQLException


object RegisterController {

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
    var passwortLaenge: Boolean = true
    var nutzernameVorhanden: Boolean = true
    var emailRichtig: Boolean = true

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

            val request = khttp.get("http://digbizmistelbach.at/epo/api/public/index.php/benutzer")
            val json = request.jsonArray

            for (ja in json) {
                val jo = ja as JSONObject
                nn = jo.get("nutzername").toString()
                if(nutzername.equals(nn)){
                    funktioniert=false
                    nutzernameVorhanden=false
                }
            }

            if(email.contains("@"))
            {
            }
            else{
                funktioniert=false
                emailRichtig=false
            }

            if(funktioniert==true)
            {
                if(passwortR.length>=6) {
                  val request2 = khttp.post("http://digbizmistelbach.at/epo/api/public/index.php/registrieren" +
                            "?nutzername=$nutzername&passwort=$passwort&mitteilungen=$mitteilungen&abmelden=$abmelden&vorname=$vorname&nachname=$nachname&email=$email&farbschemaid=$farbschemaid&profilbildid=$profilbildid")
                }
                else
                {
                    passwortLaenge=false
                    funktioniert=false
                }
            }
        }//ende try
        catch (e: SQLException){
            e.printStackTrace()
        }//ende catch
    }//ende anmelden()

    //Hashen
    fun String.sha256(): String {
        val md = MessageDigest.getInstance("SHA-256")
        return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
    }//ende sha256()
}