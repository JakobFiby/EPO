package com.example.demo.view

import com.google.gson.Gson
import org.json.JSONObject
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.SQLException

object loginController{

    var nn: String = ""
    var pw: String = ""
    var id: String = ""
    var nnB: Boolean = false
    var pwB: Boolean = false
    var userId: Int = 0
    var abmelden:String =""
    var username: String = ""
    var working: Boolean = false

    fun eingeloggt(){
        val u = khttp.get("http://digbizmistelbach.at/epo/api/public/index.php/benutzer")
        val json = u.jsonArray
        for (ja in json) {
            val jo = ja as JSONObject
            abmelden = jo.get("abmelden").toString()
        }
    }

    fun login(nutzername: String, passwort: String) {
        try {
            val r = khttp.get("http://digbizmistelbach.at/epo/api/public/index.php/benutzer")
            val string: String = r.toString()
            val json = r.jsonArray
            val eins = json[0].toString()
            val gson = Gson()

            for (ja in json) {
                val jo = ja as JSONObject
                nn = jo.get("nutzername").toString()
                pw = jo.get("passwort").toString()
                id = jo.get("userid").toString()

                //Passwort hashen
                var pwhash = passwort.sha256()
                if (pwhash.length == 63) {
                    pwhash = "0" + pwhash
                }

                //Login-Überprüfung
                //Nutzername überprüfen
                if (nn.equals(nutzername)) {
                    nnB = true
                    userId = id.toInt()
                    username = nn
                } else {
                    //println("Nutzername ist falsch")
                }

                //Passwort überprüfen
                if (pw.equals(pwhash)) {
                    pwB = true
                } else {
                    //println("Passwort ist falsch")
                }

            }

            if (pwB == true && nnB == true) {
                //println("Login funktioniert")
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

