package com.example.demo.view

import javafx.beans.property.SimpleStringProperty
import com.example.demo.view.LoginFenster
import com.example.demo.view.UeberblickFenster
import com.example.demo.view.UserModel
import tornadofx.*
import com.example.demo.view.User
import com.google.gson.Gson
import netscape.javascript.JSObject
import org.json.JSONObject
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.SQLException
import javax.json.JsonObject

object loginController{

    var nn: String = ""
    var pw: String = ""
    var id: String = ""
    var nnB: Boolean = false
    var pwB: Boolean = false
    var userId: Int = 0
    public var username: String = ""
    public var working: Boolean = false

    fun login(nutzername: String, passwort: String) {

        try {
            val r = khttp.get("http://localhost/api/public/index.php/benutzer")
            val string: String = r.toString()
            val json = r.jsonArray
            //println(json)
            val eins = json[0].toString()
            //println(eins)
            val gson = Gson()

            for (ja in json) {
                val jo = ja as JSONObject
                nn = jo.get("nutzername").toString()
                pw = jo.get("passwort").toString()
                id = jo.get("userid").toString()
                //println(nn)

                //Passwort hashen
                var pwhash = passwort.sha256()
                if (pwhash.length == 63) {
                    pwhash = "0" + pwhash
                    //println("computed sha256 value is $pwhash")
                }

                //Login-Überprüfung
                //Nutzername überprüfen
                if (nn.equals(nutzername)) {
                    nnB = true
                    userId = id.toInt()
                    username = nn
                    //println(nnB)
                } else {
                    //println("Nutzername ist falsch")
                }

                //Passwort überprüfen
                if (pw.equals(pwhash)) {
                    pwB = true
                    //println(pwB)
                } else {
                    //println("Passwort ist falsch")
                }

            }

            if (pwB == true && nnB == true) {
                println("Login funktioniert")
                working = true
            } else {
                println("Nutzername und/oder Passwort sind nicht richtig")
                LoginFenster().onDock()
            }
        }
        catch (e: SQLException){
            e.printStackTrace()
        }
        //println("Login = "+ working+pwB+nnB)
    }

    //Hashen
    fun String.sha256(): String {
        val md = MessageDigest.getInstance("SHA-256")
        return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
    }

}

